/**
 * 
 */
package business.combat;

/**
 * @author Martin Dostal
 * Represents a participant in a combat
 */
public abstract class Combatant implements Comparable<Combatant> {

	protected int initiative = -666;
	
	/**
	 * 
	 */
	protected Combatant() {
		// TODO Auto-generated constructor stub
	}
	
	//public abstract boolean chooseAction();
	
	/**
	 * Method enabling the comparison of combatants
	 */
	public int compareTo(Combatant anotherInstance) {
		return anotherInstance.getInitiative() - this.getInitiative();
	}
	
	/**
	 * Get name of this combatant
	 * @return String name of combatant
	 */
	public abstract String getName();
	
	/**
	 * Get initiative of this combatant
	 * @return Integer value representing combatant's initiative
	 */
	protected abstract int getInitiative();
}