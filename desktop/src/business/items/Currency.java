/**
 * 
 */
package business.items;

import java.util.UUID;

import business.Config;

/**
 * @author Martin Dostál
 * Currency used in the economical aspect of the game
 */
public class Currency extends Item {

	protected int amount;
	
	/**
	 * Constructor with amount, currency name and location
	 * @param amount Amount of currency
	 * @param location Location of the item
	 */
	public Currency(int amount, Container location) {
		super(UUID.fromString(Config.getInstance().getGeneralProperties().getProperty("currencyuid")),
			  Config.getInstance().getGeneralProperties().getProperty("currency"),
			  location);
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {		
		return amount + " " + name;
	}
}
