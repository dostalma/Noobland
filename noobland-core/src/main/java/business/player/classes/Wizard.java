/**
 * 
 */
package business.player.classes;

import java.util.HashMap;

import business.creature.Ability;
import business.creature.AbilityScore;

/**
 * @author Martin Dostal
 * Wizard class feature
 */
public class Wizard extends ClassFeature {

	/**
	 * 
	 */
	public Wizard() {
		classType = ClassEnum.WIZARD;
		hpDieSides = 6;
	}

	@Override
	public HashMap<Ability, AbilityScore> getBaseAbilityScoreTemplate() {
		return super.createBaseAbilityScoreTemplate(8, 10, 10, 10, 10, 10);
	}
}
