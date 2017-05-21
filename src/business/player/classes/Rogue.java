/**
 * 
 */
package business.player.classes;

import java.util.HashMap;

import business.creature.Ability;
import business.creature.AbilityScore;

/**
 * @author Martin Dostál
 * Rogue class feature
 */
public class Rogue extends ClassFeature {

	/**
	 * 
	 */
	public Rogue() {
		classType = ClassEnum.ROGUE;
		hpDieSides = 8;
	}
	
	@Override
	public HashMap<Ability, AbilityScore> getBaseAbilityScoreTemplate() {
		return super.createBaseAbilityScoreTemplate(10, 10, 10, 8, 10, 10);
	}
}
