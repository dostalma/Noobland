/**
 * 
 */
package business.player.classes;

import java.util.HashMap;

import business.creature.Ability;
import business.creature.AbilityScore;

/**
 * @author Martin Dostal
 * Fighter class feature
 */
public class Fighter extends ClassFeature {

	/**
	 * 
	 */
	public Fighter() {
		classType = ClassEnum.FIGHTER;
		hpDieSides = 10;
	}

	@Override
	public HashMap<Ability, AbilityScore> getBaseAbilityScoreTemplate() {
		return super.createBaseAbilityScoreTemplate(10, 10, 10, 8, 10, 10);
	}

}
