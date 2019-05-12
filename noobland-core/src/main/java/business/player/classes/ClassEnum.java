/**
 * 
 */
package business.player.classes;

/**
 * @author Martin Dostal
 * Adventurer's class enumeration
 */
public enum ClassEnum {

	FIGHTER("Fighter"),
	ROGUE("Rogue"),
	WIZARD("Wizard"),
	CLERIC("Cleric");
	
	protected String name;
	
	private ClassEnum(String name) {
		this.name = name;
	}
	
	/**
	 * Get classEnum by its name
	 * @param name String name of ClassEnum
	 * @return ClassEnum object
	 */
	public static ClassEnum getClassByName(String name) {
		if ("Fighter".equalsIgnoreCase(name)) return FIGHTER;
		if ("Rogue".equalsIgnoreCase(name)) return ROGUE;
		if ("Wizard".equalsIgnoreCase(name)) return WIZARD;
		if ("Cleric".equalsIgnoreCase(name)) return CLERIC;
		return null;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
