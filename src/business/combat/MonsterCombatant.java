/**
 * 
 */
package business.combat;

import business.creature.Monster;

/**
 * @author Martin Dostál
 *
 */
public class MonsterCombatant extends Combatant {

	protected final Monster monster;
	
	/**
	 * 
	 */
	public MonsterCombatant(Monster monster) {
		this.monster = monster;
	}

	@Override
	public String toString() {
		return "MonsterCombatant [monster=" + monster + "]";
	}

	@Override
	protected int getInitiative() {
		if (initiative == -666) {
			initiative = monster.getInitiative();
		}
		System.out.println("Getting initiative: " + initiative);
		return initiative;
	}

	@Override
	public String getName() {
		return monster.getName();
	}

}
