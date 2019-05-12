/**
 * 
 */
package business.items;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author Martin Dostal
 * Parent to all container classes
 * Uses ArrayList as Collection.
 */
public abstract class Container {

	protected final HashMap<UUID, Placeable> content;
	
	/**
	 * 
	 */
	protected Container() {
		content = new HashMap<UUID, Placeable>();
	}
	
	public HashMap<UUID, Placeable> getContent() {
		return content;
	}

	public abstract boolean canContain(Placeable item);
}
