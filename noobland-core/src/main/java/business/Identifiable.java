/**
 * 
 */
package business;

import java.util.UUID;

/**
 * @author Martin Dostal
 * Implementing class must have an UID to be identified with
 */
public interface Identifiable {

	/**
	 * Get UID of this object
	 * @return UUID of this object
	 */
	public UUID getUID();
}
