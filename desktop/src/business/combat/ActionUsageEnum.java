/**
 * 
 */
package business.combat;

/**
 * @author Martin Dostál
 *
 */
public enum ActionUsageEnum {

	AT_WILL,
	ENCOUNTER,
	DAILY;
	
	/**
	 * Get ActionUsageEnum by it's relevant name
	 * @param name
	 * @return
	 */
	public static ActionUsageEnum getActionUsageByName(String name) {
		switch (name) {
		case "at-will": return AT_WILL;
		case "encounter": return ENCOUNTER;
		case "daily": return DAILY;
		default:
			return null;
		}
	}
}
