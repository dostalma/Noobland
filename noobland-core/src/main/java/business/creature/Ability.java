package business.creature;

/**
 * Ability enumeration
 * @author Martin Dostal
 * 
 */
public enum Ability {

	STRENGTH("Strength"),
	DEXTERITY("Dexterity"),
	CONSTITUTION("Constitution"),
	INTELLIGENCE("Intelligence"),
	WISDOM("Wisdom"),
	CHARISMA("Charisma");
	
	protected String name;
	
	/**
	 * Get Ability by its name
	 * @param name Name of ability
	 * @return Ability object
	 */
	public static Ability getAbilityByName(String name) {
		if ("Strength".equalsIgnoreCase(name)) return STRENGTH;
		if ("Dexterity".equalsIgnoreCase(name)) return DEXTERITY;
		if ("Constitution".equalsIgnoreCase(name)) return CONSTITUTION;
		if ("Intelligence".equalsIgnoreCase(name)) return INTELLIGENCE;
		if ("Wisdom".equalsIgnoreCase(name)) return WISDOM;
		if ("Charisma".equalsIgnoreCase(name)) return CHARISMA;
		return null;
	}

	/**
	 * Get Ability by its code
	 * @param code Code of ability
	 * @return Ability object
	 */
	public static Ability getAbilityByCode(String code) {
		if ("STR".equalsIgnoreCase(code)) return STRENGTH;
		if ("DEX".equalsIgnoreCase(code)) return DEXTERITY;
		if ("CON".equalsIgnoreCase(code)) return CONSTITUTION;
		if ("INT".equalsIgnoreCase(code)) return INTELLIGENCE;
		if ("WIS".equalsIgnoreCase(code)) return WISDOM;
		if ("CHA".equalsIgnoreCase(code)) return CHARISMA;
		return null;
	}
	
	private Ability(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name();
	}
}
