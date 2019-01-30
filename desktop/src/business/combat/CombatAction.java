/**
 * 
 */
package business.combat;

/**
 * @author Martin Dostál
 * Class representing in general a creature's attack
 */
public class CombatAction {

	protected final String name;
	protected final String hit;
	protected final String damage;

	/**
	 * Constructor with parameters
	 * @param name Name of attack
	 * @param hit Hit pattern containing hit value and defensive attribute
	 * @param damage Damage pattern of the attack
	 */
	public CombatAction(String name, String hit, String damage) {
		this.name = name;
		this.hit = hit;
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public String getHit() {
		return hit;
	}

	public String getDamage() {
		return damage;
	}

	@Override
	public String toString() {
		return " - CombatAction [name=" + name + ", hit=" + hit + ", damage=" + damage + "]";
	}

}
