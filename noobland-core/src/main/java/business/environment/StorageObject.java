/**
 * 
 */
package business.environment;

import java.util.UUID;

import business.items.Container;
import business.items.Placeable;

/**
 * @author Martin Dostal
 * Objects which can contain items and be present in locations
 */
public class StorageObject extends Container implements Localizable {

	protected final UUID uid;
	protected Location location = null;
	
	/**
	 * 
	 */
	public StorageObject() {
		this.uid = UUID.randomUUID();
	}

	/* (non-Javadoc)
	 * @see business.items.Container#canContain(business.items.Placeable)
	 */
	@Override
	public boolean canContain(Placeable item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UUID getUID() {
		return uid;
	}
	
	@Override
	public void setLocation(Location location) {
		this.location = location;
	}

}
