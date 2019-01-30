/**
 * 
 */
package business.core;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Properties;

import business.Config;
import business.creature.Ability;
import business.creature.AbilityScore;
import business.creature.Hitpoints;
import business.creature.Race;
import business.player.PlayerCharacter;
import business.player.classes.ClassFeature;
import business.player.classes.Fighter;
import business.validator.InputParser;
import presentation.UserInteractionService;
import presentation.factory.PresentationServiceFactory;

/**
 * @author Martin
 * Parent to all game modes
 */
public abstract class GameManager {
	
	protected Properties applicationProperties;
	protected Properties generalProperties;
	protected Properties messages;
	protected InputParser inputParser;
	protected UserInteractionService ui;
	
	/**
	 * Empty constructor called by specialized game modes
	 */
	protected GameManager() {
		init();
	}
	
	/**
	 * Load initial configuration
	 */
	protected void init() {
		Config config = Config.getInstance();
		applicationProperties = config.getApplicationProperties();
		generalProperties = config.getGeneralProperties();
		messages = config.getMessages();
		inputParser = InputParser.getInstance();
		ui = PresentationServiceFactory.getInstance().createUIService();
	}
	
	/**
	 * Start the game
	 */
	public abstract void start();
	
	/**
	 * Method invokes series of steps to create a new character
	 * @return
	 */
	public PlayerCharacter createCharacter() {
		ui.print("Creating new character");
		
		String name = "";
		ClassFeature cf = null;
		Race race = null;
		HashMap<Ability, AbilityScore> abilities = new HashMap<Ability, AbilityScore>();
		Hitpoints hitpoints = null;
		
		String input = "";
		
		// 1. Name the character ===========================================
		ui.print("Type the name of your character");
		name = ui.read();
		ui.print("Your character's name is " + name);
		
		// 2. Select Race ==================================================
		ui.print(messages.getProperty("gm.createcharacter.race"));	
		do {
			race = Race.getRaceByIndex(ui.readInt());
			if (race == null) {
				ui.print(messages.getProperty("er.unsupported.p1"));
			}
		} while (race == null);
		ui.print("You have selected: " + race.toString());
		
		// 3. Select Class =================================================
		ui.print(messages.getProperty("gm.createcharacter.class"));		
		boolean finished = false;	
		finished = false;
		do {
			switch (ui.readInt()) {
			case 1:
				cf = new Fighter();
				finished = true;
				break;

			default:
				ui.print(messages.getProperty("er.unsupported.p1"));
				break;
			}
		} while (!finished);
		ui.print("You have selected: " + cf.getClassType().toString() + "\n");
		
		// 4. Distribute Ability Points =================================================
		HashMap<Ability, AbilityScore> abilTemplate = cf.getBaseAbilityScoreTemplate();
		int baseAPCount = Integer.parseInt(generalProperties.getProperty("base_ap_count"));
		
		String templStr = "STR " + abilTemplate.get(Ability.STRENGTH).getBaseValue();
		templStr += ", DEX " + abilTemplate.get(Ability.DEXTERITY).getBaseValue();
		templStr += ", CON " + abilTemplate.get(Ability.CONSTITUTION).getBaseValue();
		templStr += ", INT " + abilTemplate.get(Ability.INTELLIGENCE).getBaseValue();
		templStr += ", WIS " + abilTemplate.get(Ability.WISDOM).getBaseValue();
		templStr += ", CHA " + abilTemplate.get(Ability.CHARISMA).getBaseValue();
		
		String msg = messages.getProperty("gm.createcharacter.redistribute");
		msg = MessageFormat.format(msg, String.valueOf(baseAPCount), templStr);
		ui.print(msg);
		while (baseAPCount > 0 || abilities.size() < 6) {
			input = ui.read();
			
			AbilityScore ability = inputParser.validateAbilityScoreInput(input);
			if (ability == null) { // check if there was a parsing error
				ui.print(messages.getProperty("er.unsupported.p1"));
				continue;
			}
						
			// check if user does not attempt to reduce ability below specified minimum
			if (ability.getBaseValue() < abilTemplate.get(ability.getAbility()).getBaseValue()) {
				ui.print(messages.getProperty("er.createcharacter.p2"));
				continue;
			}
			
			// Check conditions of ability cost value
			int currentCost = AbilityScore.getCostByValue(ability.getBaseValue(), abilTemplate.get(ability.getAbility()).getBaseValue());
			if (abilities.containsKey(ability.getAbility())) { // Look if user attempts to replace already chosen ability 
				int previousCost =  AbilityScore.getCostByValue(abilities.get(ability.getAbility()).getBaseValue(), 
																abilTemplate.get(ability.getAbility()).getBaseValue());
				int remainingAP = baseAPCount + previousCost - currentCost;
				if (remainingAP < 0) {
					ui.print(messages.getProperty("er.createcharacter.p1"));
					continue;
				}
				baseAPCount = remainingAP;
			} else if (currentCost > baseAPCount) {
				ui.print(messages.getProperty("er.createcharacter.p1"));
				continue;
			} else {
				baseAPCount -= currentCost;
			}
			abilities.put(ability.getAbility(), ability);
			msg = messages.getProperty("gm.createcharacter.p1");
			msg = MessageFormat.format(msg, ability.getAbility().toString(), String.valueOf(ability.getBaseValue()), String.valueOf(baseAPCount));
			ui.print(msg);
		}
		
		msg = messages.getProperty("gm.createcharacter.p2");
		msg = MessageFormat.format(msg, String.valueOf(abilities.get(Ability.STRENGTH).getTotalValue()), 
										String.valueOf(abilities.get(Ability.DEXTERITY).getTotalValue()),
										String.valueOf(abilities.get(Ability.CONSTITUTION).getTotalValue()), 
										String.valueOf(abilities.get(Ability.INTELLIGENCE).getTotalValue()),
										String.valueOf(abilities.get(Ability.WISDOM).getTotalValue()), 
										String.valueOf(abilities.get(Ability.CHARISMA).getTotalValue()));
		ui.print(msg);
		// 5. adjust abilities by chosen race ============================================
		abilities = Race.adjustAbilityScores(abilities, race);
		msg = messages.getProperty("gm.createcharacter.p2");
		msg = MessageFormat.format(msg, String.valueOf(abilities.get(Ability.STRENGTH).getTotalValue()), 
										String.valueOf(abilities.get(Ability.DEXTERITY).getTotalValue()),
										String.valueOf(abilities.get(Ability.CONSTITUTION).getTotalValue()), 
										String.valueOf(abilities.get(Ability.INTELLIGENCE).getTotalValue()),
										String.valueOf(abilities.get(Ability.WISDOM).getTotalValue()), 
										String.valueOf(abilities.get(Ability.CHARISMA).getTotalValue()));
		ui.print(msg);
		
		// 6. Hitpoints ==================================================================
		hitpoints = cf.calculateHitpoints(1, abilities.get(Ability.CONSTITUTION).getModifier(), 0, false);
		hitpoints.setCurrentHP(hitpoints.getTotalHP());
		
		// Finish ========================================================================
		PlayerCharacter character = new PlayerCharacter(name, race, cf, 1, abilities, hitpoints);
		return character;
	}	
}
