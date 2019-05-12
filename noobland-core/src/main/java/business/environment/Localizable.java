/**
 * 
 */
package business.environment;

import java.util.UUID;

/**
 * @author Martin Dostal
 * This interfaces marks the possibility of objects to be localized in Location objects.
 */
public interface Localizable {

	/**
	 * Get uid of this object so it can be identified by location
	 * @return
	 */
	public UUID getUID();
		
	/**
	 * Set location of this object
	 */
	public void setLocation(Location location);
	
}
