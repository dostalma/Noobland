/**
 * 
 */
package business.player;

import business.items.Equipable;

/**
 * @author Martin Dostal
 * Interface which defines operations for equipment slots
 */
public abstract class EquipmentSlot {

	protected Equipable equipedItem;
	
	/**
	 * Check if an item is valid to this slot
	 * @param item Item to check
	 * @return True if can be equip, false if not
	 */
	public abstract boolean canEquip(Equipable item);
	
	/**
	 * Attempt to equip a new item to the slot
	 * @param item Item to equip
	 * @return Previously equipped item or null if slot was empty or could not equip this new item
	 */
	public abstract Equipable equip(Equipable item); 
	
	/**
	 * Unequip an attached item and return it.
	 * @return Previously equipped item or null if slot was empty
	 */
	public abstract Equipable unequip();
	
	/**
	 * Get the item that is equipped to this slot
	 * @return Equipped item or null if slot is empty
	 */
	public Equipable getEquippedItem() {
		return equipedItem;
	}
}
