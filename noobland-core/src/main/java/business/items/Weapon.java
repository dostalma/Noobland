package business.items;

import business.Dice;

/**
 * 
 * @author Martin Dostal
 * ClassEnum representing weapon item
 */
public class Weapon extends Gear {
	
	protected final int proficiency;
	protected final Dice damage;
	
	/**
	 * Constructor with all the parameters
	 * @param name
	 * @param location
	 * @param weight
	 * @param price
	 * @param proficiency
	 * @param damage
	 */
	public Weapon(String name, Container location, int weight, int price, int proficiency, String damage) {
		super(name, location, weight, price);
		this.proficiency = proficiency;
		this.damage = new Dice(damage);
	}

	/**
	 * Constructor with weapon schema and location
	 * @param schema
	 * @param location
	 */
	public Weapon(Weapon schema, Container location) {
		super(schema.getName(), location, schema.getWeight(), schema.getPrice());
		this.proficiency = schema.getProficiency();
		this.damage = schema.getDamage();
	}
	
	public int getProficiency() {
		return proficiency;
	}

	public Dice getDamage() {
		return damage;
	}

	@Override
	public String toString() {
		return "Weapon [proficiency=" + proficiency + ", damage=" + damage + "]";
	}	
}
