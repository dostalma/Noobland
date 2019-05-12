/**
 * 
 */
package business.player.classes;

import java.util.HashMap;

import business.Dice;
import business.creature.Ability;
import business.creature.AbilityScore;
import business.creature.Hitpoints;

/**
 * @author Martin Dostal
 * Parent class to all classes
 */
public abstract class ClassFeature {

	protected ClassEnum classType;
	protected int hpDieSides;
	
	/**
	 * 
	 */
	protected ClassFeature() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Calculate hitpoints based on the current level, constitution and previous HP value
	 * @param level Level of character
	 * @param constitutionModifier Constitution to count HP with
	 * @param currentBaseHP Current base HP
	 * @param newLevel TODO
	 * @return Hitpoints object containing new values
	 */
	public Hitpoints calculateHitpoints(int level, int constitutionModifier, int currentBaseHP, boolean newLevel) {
		Hitpoints hp = new Hitpoints();
		
		if (level == 1) {
			hp.setBasicHP(hpDieSides);
			hp.setTotalHP(hpDieSides + constitutionModifier);
		} else {
			int rolled = 0; 
			if (newLevel) 
				rolled = new Dice(hpDieSides).roll();
			hp.setBasicHP(currentBaseHP + rolled);
			hp.setTotalHP(hp.getBasicHP() + level * constitutionModifier);
		}
		return hp;
	}
	
	public abstract HashMap<Ability, AbilityScore> getBaseAbilityScoreTemplate();
	
	/**
	 * Create base ability score template with presented values
	 * @param str Strength base value
	 * @param dex Dexterity base value
	 * @param con Constitution base value
	 * @param intel Intelligence base value
	 * @param wis Wisdom base value
	 * @param cha Charisma base value
	 * @return
	 */
	protected HashMap<Ability, AbilityScore> createBaseAbilityScoreTemplate(int str, int dex, int con, int intel, int wis, int cha) {
		HashMap<Ability, AbilityScore> abilities = new HashMap<Ability, AbilityScore>();
		
		abilities.put(Ability.STRENGTH, new AbilityScore(Ability.STRENGTH, str));
		abilities.put(Ability.DEXTERITY, new AbilityScore(Ability.DEXTERITY, dex));
		abilities.put(Ability.CONSTITUTION, new AbilityScore(Ability.CONSTITUTION, con));
		abilities.put(Ability.INTELLIGENCE, new AbilityScore(Ability.INTELLIGENCE, intel));
		abilities.put(Ability.WISDOM, new AbilityScore(Ability.WISDOM, wis));
		abilities.put(Ability.CHARISMA, new AbilityScore(Ability.CHARISMA, cha));
		
		return abilities;
	}
	
	/**
	 * Get class type
	 * @return ClassEnum enum
	 */
	public ClassEnum getClassType() {
		return classType;
	}
	
	@Override
	public String toString() {
		return classType.toString();
	}
}
