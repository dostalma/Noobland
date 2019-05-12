/**
 * 
 */
package business.validator;

import business.creature.Ability;
import business.creature.AbilityScore;

/**
 * @author Martin Dostal
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
		Ability chosenAbility = Ability.getAbilityByCode(tokens[0]);

		if (chosenAbility != null) {
		
			int value = 0;
			try {
				value = Integer.parseInt(tokens[1]);
			} catch (IndexOutOfBoundsException ex) {
				return null;
			} catch (NumberFormatException ex) {
				return null;
			}
			if (value >= 8 && value <= 18) {
				return new AbilityScore(chosenAbility, value);
			}
		}
		
		return null;
	}
}
