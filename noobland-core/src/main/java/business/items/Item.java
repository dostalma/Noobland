/**
 * 
 */
package business.items;

import java.util.UUID;

/**
 * @author Martin Dostal
 * Parent to all item classes
 */
public class Item implements Placeable {

	protected UUID uid;
	protected String name;
	protected Container location;
	
	/**
	 * Constructor with UID, name and location parameters
	 * @param UID of the item
	 * @param name Name of the item
	 * @param location Container where is the item currently located
	 */
	public Item(UUID uid, String name, Container location) {
		super();
		this.name = name;
		this.location = location;
		this.uid = uid;
	}
	
	/**
	 * Constructor with name and location parameters. Creates new UID for teh item.
	 * @param name Name of the item
	 * @param location Container where is the item currently located
	 */
	public Item(String name, Container location) {
		super();
		this.name = name;
		this.location = location;
		this.uid = UUID.randomUUID();
	}

	/* (non-Javadoc)
	 * @see business.items.Placeable#put(business.items.Container)
	 */
	@Override
	public boolean put(Container container) {		
		location = container;
		container.getContent().put(this.getUID(), this);
		return true;
	}

	public String getName() {
		return name;
	}

	public Container getLocation() {
		return location;
	}

	@Override
	public UUID getUID() {
		return uid;
	}
}
