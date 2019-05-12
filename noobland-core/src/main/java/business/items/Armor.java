/**
 * 
 */
package business.items;

/**
 * @author Martin Dostal
 * ClassEnum representing armor item
 */
public class Armor extends Gear {

	protected final int armorBonus;
	protected final int check;
	protected final int speed;
	
	/**
	 * @param name
	 * @param location
	 */
	public Armor(String name, Container location, int weight, int price, int armorBonus, int check, int speed) {
		super(name, location, weight, price);
		this.armorBonus = armorBonus;
		this.check = check;
		this.speed = speed;
	}

}
