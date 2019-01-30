/**
 * 
 */
package business.validator;

import business.creature.Ability;
import business.creature.AbilityScore;

/**
 * @author Martin Dostál
 * Tool to parse and validate several input methods
 */
public class InputParser {

	protected static InputParser instance = null;
	
	/**
	 * 
	 */
	private InputParser() {
		
	}

	public static InputParser getInstance() {
		if (instance == null) {
			instance = new InputParser();
		}
		return instance;
	}
	
	/**
	 * Validate input and return matched ability score or null if there is error
	 * @param input Input to validate
	 * @return Ability score or null
	 */
	public AbilityScore validateAbilityScoreInput(String input) {
		String[] tokens = input.split(" ");
		Ability chosenAbility = null;
		
		switch (tokens[0]) {
		case "STR":
			chosenAbility = Ability.STRENGTH;
			break;
			
		case "DEX":
			chosenAbility = Ability.DEXTERITY;
			break;
			
		case "CON":
			chosenAbility = Ability.CONSTITUTION;
			break;
			
		case "INT":
			chosenAbility = Ability.INTELLIGENCE;		
			break;
			
		case "WIS":
			chosenAbility = Ability.WISDOM;
			break;
	
		case "CHA":
			chosenAbility = Ability.CHARISMA;
			break;
		default:
			break;
		}
		
		if (chosenAbility != null) {
		
			int value = 0;
			try {
				value = Integer.parseInt(tokens[1]);
			} catch (IndexOutOfBoundsException | NumberFormatException ex) {
				return null;
			}
			if (value >= 8 && value <= 18) {
				return new AbilityScore(chosenAbility, value);
			}
		}
		
		return null;
	}
}
