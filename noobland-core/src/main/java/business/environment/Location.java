/**
 * 
 */
package business.environment;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author Martin Dostal
 * Location in the game
 */
public class Location {

	protected final String code;
	protected final String name;
	protected final HashMap<UUID, Localizable> objects;
	protected final PlaceEnum placeType;
	
	/**
	 * 
	 */
	public Location(String code, String name, PlaceEnum placeType) {
		objects = new HashMap<UUID, Localizable>();
		this.code = code;
		this.name = name;
		this.placeType = placeType;
	}
	
	/**
	 * Move an object to this location
	 * @param object Object to add
	 */
	public void moveIn(Localizable object) {
		objects.put(object.getUID(), object);
		object.setLocation(this);
	}
	
	/**
	 * Remove an object from this location and move it to the destination
	 * @param object Localizable object to move
	 */
	public void moveOut(Localizable object, Location destination) {
		objects.remove(object.getUID());
		destination.moveIn(object);
	}

	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public PlaceEnum getPlaceType() {
		return placeType;
	}

	public HashMap<UUID, Localizable> getObjects() {
		return objects;
	}
}
