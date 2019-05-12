/**
 * 
 */
package business.environment;

import business.items.Container;
import business.items.Placeable;

/**
 * @author Martin Dostal
 * Static container in every location.
 * Can contain almost everything.
 */
public class Ground extends Container {

	/**
	 * 
	 */
	public Ground() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see business.items.Container#canContain(business.items.Placeable)
	 */
	@Override
	public boolean canContain(Placeable item) {
		// TODO Auto-generated method stub
		return true;
	}

}
