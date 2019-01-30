/**
 * 
 */
package business.player.classes;

import java.util.HashMap;

import business.creature.Ability;
import business.creature.AbilityScore;

/**
 * @author Martin Dostál
 * Cleric class feature
 */
public class Cleric extends ClassFeature {

	/**
	 * 
	 */
	public Cleric() {
		classType = ClassEnum.CLERIC;
		hpDieSides = 8;
	}
	
	@Override
	public HashMap<Ability, AbilityScore> getBaseAbilityScoreTemplate() {
		return super.createBaseAbilityScoreTemplate(10, 8, 10, 10, 10, 10);
	}
}
