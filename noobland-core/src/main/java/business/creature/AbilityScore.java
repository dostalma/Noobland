/**
 * 
 */
package business.creature;

/**
 * @author Martin Dostal
 * ClassEnum describing an ability of an adventurer
 */
public class AbilityScore {

	protected Ability ability;
	protected int baseValue = 0;
	protected int totalValue = 0;
	
	/**
	 * 
	 */
	public AbilityScore(Ability ability) {
		this.ability = ability;
	}
	
	/**
	 * Constructor with ability type and base value
	 * @param ability
	 * @param baseValue
	 */
	public AbilityScore(Ability ability, int baseValue) {
		this.ability = ability;
		this.baseValue = baseValue;
	}

	/**
	 * Get ability score cost by chosen value. Used during character creation.
	 * @param value Chosen value of ability
	 * @return cost of the chosen value
	 */
	public static int getCostByValue(int value, int minimum) {
		switch (value) {
		case 8: return 0;
		case 9: return (minimum < 9) ? 9 - minimum : 0;
		case 10: return (minimum < 10) ? 10 - minimum : 0;  			
		case 11: return 1;
		case 12: return 2;
		case 13: return 3;
		case 14: return 5;
		case 15: return 7;
		case 16: return 9;
		case 17: return 12;
		case 18: return 16;
		default:
			return -1; // Error return code
		}
	}
	
	/**
	 * Get modifier of this ability's value
	 * @return Modifier of value of this ability
	 */
	public int getModifier() {
		return getModifierByValue(totalValue);
	}
	
	/**
	 * Get modifier of specific Ability value
	 * @param value Value of ability
	 * @return Modifier corresponding to specific value
	 */
	public static int getModifierByValue(int value) {
		switch (value) {
		case 1: return -5;
		case 2: case 3: return -4;
		case 4: case 5: return -3;
		case 6: case 7: return -2;
		case 8: case 9: return -1;
		case 10: case 11: return 0;
		case 12: case 13: return 1;
		case 14: case 15: return 2;
		case 16: case 17: return 3;
		case 18: case 19: return 4;
		case 20: case 21: return 5;
		case 22: case 23: return 6;
		case 24: case 25: return 7;
		case 26: case 27: return 8;
		case 28: case 29: return 9;
		case 30: return 10;
		
		default:
			return -1; // Error value
		}
	}
	
	public int getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(int baseValue) {
		this.baseValue = baseValue;
	}

	public int getTotalValue() {
		if (totalValue == 0)
			totalValue = baseValue;
		return totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}

	public Ability getAbility() {
		return ability;
	}
}
