/**
 * 
 */
package business.creature;

/**
 * @author Martin Dostal
 * HitPoints of character
 */
public class Hitpoints {

	protected int basicHP;
	protected int totalHP;
	protected int currentHP;
	
	/**
	 * Empty constructor
	 */
	public Hitpoints() {
		this.basicHP = 0;
		this.totalHP = 0;
		this.currentHP = 0;
	}
	
	/**
	 * Constructor with base and current HP.
	 * @param basicHP
	 * @param currentHP
	 */
	public Hitpoints(int basicHP, int totalHP, int currentHP) {
		this.basicHP = basicHP;
		this.totalHP = totalHP;
		if (totalHP == 0) this.totalHP = basicHP;
		this.currentHP = currentHP;
		if (currentHP == 0) this.currentHP = basicHP;
	}

	public int getBasicHP() {
		return basicHP;
	}

	public void setBasicHP(int basicHP) {
		this.basicHP = basicHP;
	}

	public int getTotalHP() {
		return totalHP;
	}

	public void setTotalHP(int totalHP) {
		this.totalHP = totalHP;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	@Override
	public String toString() {
		return "Hitpoints [basicHP=" + basicHP + ", totalHP=" + totalHP + ", currentHP=" + currentHP + "]";
	}
}
