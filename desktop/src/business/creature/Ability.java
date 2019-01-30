package business.creature;

/**
 * Ability enumeration
 * @author Martin Dostál
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
		switch (name) {
		case "Strength": case "STRENGTH": return STRENGTH;
		case "Dexterity": case "DEXTERITY":  return DEXTERITY;
		case "Constitution": case "CONSTITUTION":  return CONSTITUTION;
		case "Inteligence": case "INTELLIGENCE":  return INTELLIGENCE;
		case "Wisdom": case "WISDOM":  return WISDOM;
		case "Charisma": case "CHARISMA":  return CHARISMA;
		}
		return null;
	}
	
	private Ability(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name();
	}
}
