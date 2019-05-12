package business.combat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import business.Config;
import business.creature.Monster;
import business.environment.Localizable;
import business.environment.Location;
import business.player.PlayerCharacter;
import presentation.UserInteractionService;
import presentation.factory.PresentationServiceFactory;

/**
 * @author Martin Dostal
 *
 * Class for managing the combat structure and logic
 */
public class CombatManager {

	protected List<Combatant> combatants;
	protected Location location;
	
	protected UserInteractionService ui = null;
	protected Properties messages = null;
	
	protected boolean standartActionAvailable = false;
	protected boolean moveActionAvailable = false;
	protected boolean minorActionAvailable = false;
	
	/**
	 * Default empty constructor
	 */
	public CombatManager() {
		Config config = Config.getInstance();
		ui = PresentationServiceFactory.getInstance().createUIService();
		messages = config.getMessages();
	}

	/**
	 * Initiate combat encounter by locating participant and determining their positions
	 */
	protected void initiate() {
		combatants = new ArrayList<Combatant>();
		for (Localizable object : location.getObjects().values()) {
			if (object instanceof PlayerCharacter) {
				combatants.add(new PlayerCombatant((PlayerCharacter)object));
			} else if (object instanceof Monster) {
				combatants.add(new MonsterCombatant((Monster)object));
			}
		}
	}
	
	/**
	 * Determine whether any of the sides in the encounter is surprised
	 */
	protected void determineSurprise() {
		
		
		// @TODO  
	}
	
	/**
	 * Roll and determine initiative of the combatants
	 */
	protected void rollInitiative() {
		System.out.println("Combatant order:");
		for (int i = 0; i < combatants.size(); i++) {
			System.out.println(i + ": " + combatants.get(i).getName());
		}
		
		Collections.sort(combatants);
		
		System.out.println("Combatant order:");
		for (int i = 0; i < combatants.size(); i++) {
			System.out.println(i + ": " + combatants.get(i).getName());
		}
	}
	
	/**
	 * Take surprise round if any side has surprise bonus
	 * @return Result if combat has ended
	 */
	protected boolean takeSurpriseRound() {
		// @TODO
		return false;
	}
	
	/**
	 * Each combatant takes his turn in a round
	 * @return Result if combat has ended
	 */
	protected boolean takeTurns() {
		// Each combatant takes his/her turn
		for (int i = 0; i < combatants.size(); i++) {
			Combatant current = combatants.get(i);
			
			/// I. Begging of a turn
			// @TODO
			
			/// II. Take actions
			// Choose actions until finished
			boolean finished = false;
			while (!finished) {
				
				finished = true;
			}
			
			/// III. End of a turn
			// @TODO
		}
		return false;
	}
	
	/**
	 * Start combat encounter. 
	 */
	public void startCombat(Location location) {
		// Initiate
		this.location = location;
		initiate();

		// Determine initiative
		rollInitiative();
		
		boolean combatFinished = false;
		// Take surprise round - @TODO
		combatFinished = takeSurpriseRound();
		
		// Cycle rounds until encounter finishes
		while (!combatFinished) {
			combatFinished = takeTurns();
		}
	}
	
}
