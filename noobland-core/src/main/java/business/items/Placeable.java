package business.items;

import business.Identifiable;

/**
 * @author Martin Dostal
 * Defines objects that can be moved between separate containers
 */
public interface Placeable extends Identifiable {
	
	/**
	 * Put this object to a container
	 * @param container Container where to put this
	 * @return Boolean if the move was successful
	 */
	public boolean put (Container container);
	
}
