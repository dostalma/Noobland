/**
 * 
 */
package business.player.classes;

/**
 * @author Martin Dostál
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
		switch (name) {
		case "Fighter": return FIGHTER;
		case "Rogue": return ROGUE;
		case "Wizard": return WIZARD;
		case "Cleric": return CLERIC;
		}
		return null;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
