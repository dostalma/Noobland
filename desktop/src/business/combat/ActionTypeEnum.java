/**
 * 
 */
package business.combat;

/**
 * @author Martin Dostál
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
		switch (name) {
		case "standard": return STANDARD;
		case "move": return MOVE;
		case "minor": return MINOR;
		case "free": return FREE;

		default:
			return null;
		}
	}
}
