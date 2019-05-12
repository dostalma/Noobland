package business.creature;

import java.util.List;
import java.util.UUID;

import business.environment.Localizable;
import business.environment.Location;

/**
 * @author Martin Dostal
 * Abstract parent class to all types of creatures
 */
public abstract class Creature implements Localizable {

	protected final UUID uid;
	protected final String name;
	protected final List<CreatureKeywordEnum> keywords;

	protected Location location = null;
	
	/**
	 * 
	 */
	protected Creature(String name, List<CreatureKeywordEnum> keywords) {
		this.name = name;
		this.keywords = keywords;
		this.uid = UUID.randomUUID();
	}

	public String getName() {
		return name;
	}

	public List<CreatureKeywordEnum> getKeywords() {
		return keywords;
	}

	public UUID getUID() {
		return uid;
	}

	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
