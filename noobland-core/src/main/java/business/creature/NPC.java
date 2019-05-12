/**
 * 
 */
package business.creature;

import java.util.List;

/**
 * @author Martin Dostal
 * Class for Non-player characters with some kind of interaction ability
 */
public class NPC extends Creature {

	/**
	 * 
	 */
	public NPC(String name, List<CreatureKeywordEnum> keywords) {
		super(name, keywords);
	}

}
