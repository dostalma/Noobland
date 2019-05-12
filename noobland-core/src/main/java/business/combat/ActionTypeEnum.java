/**
 * 
 */
package business.combat;

/**
 * @author Martin Dostal
 * Enumeration of action types
 */
public enum ActionTypeEnum {

	STANDARD,
	MOVE,
	MINOR,
	FREE;
	
	/**
	 * Get ActionTypeEnum by it's action type name
	 * @param name Name of action type
	 * @return Relevant ActionTypeEnum to the name 
	 */
	public static ActionTypeEnum getActionTypeByName(String name) {
		if ("standard".equalsIgnoreCase(name)) return STANDARD;
		if ("move".equalsIgnoreCase(name)) return MOVE;
		if ("minor".equalsIgnoreCase(name)) return MINOR;
		if ("free".equalsIgnoreCase(name)) return FREE;
		return null;
	}
}
