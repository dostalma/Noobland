/**
 * 
 */
package business.combat;

/**
 * @author Martin Dostal
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
		if ("at-will".equalsIgnoreCase(name)) return AT_WILL;
		if ("encounter".equalsIgnoreCase(name)) return AT_WILL;
		if ("daily".equalsIgnoreCase(name)) return AT_WILL;
		return null;
	}
}
