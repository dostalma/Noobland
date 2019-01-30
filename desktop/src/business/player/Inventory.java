/**
 * 
 */
package business.player;

import java.util.UUID;

import business.items.Armor;
import business.items.Container;
import business.items.Equipable;
import business.items.Gear;
import business.items.Placeable;
import business.items.Weapon;

/**
 * @author Martin Dostál
 * Container which is being hold by character
 */
public class Inventory extends Container {

	protected EquipmentSlot mainHandSlot;
	protected EquipmentSlot offHandSlot;
	protected EquipmentSlot armorSlot;
	
	/**
	 * 
	 */
	public Inventory() {
		super();
		mainHandSlot = new MainHandSlot();
		offHandSlot = new OffHandSlot();
		armorSlot = new ArmorSlot();
	}

	/* (non-Javadoc)
	 * @see business.items.Container#canContain(business.items.Placeable)
	 */
	@Override
	public boolean canContain(Placeable item) {
		// @TODO add exceptions
		return true;
	}

	/**
	 * Add an item to the inventory
	 * @param item
	 */
	public boolean add(Placeable item) {
		// @TODO add some checks	
		// if ( /* CHECKS */ ) { /* SOMETHING */ }
		
		item.put(this);
		
		return true;
	}
	
	/**
	 * Attempt to remove an item from inventory
	 * @param itemUID UID of an item which should be removed
	 * @return Removed item object or null
	 */
	public Placeable remove(UUID itemUID) {
		Placeable item = null;
		if (content.containsKey(itemUID)) {
			item = content.remove(itemUID);
			if (item != null && Equipable.class.isInstance(item)) {
				if (mainHandSlot.getEquippedItem().getUID().equals(itemUID)) {
					mainHandSlot.unequip();
				} else if (offHandSlot.getEquippedItem().getUID().equals(itemUID)) {
					offHandSlot.unequip();
				} else if (armorSlot.getEquippedItem().getUID().equals(itemUID)) {
					armorSlot.unequip();
				}
			}
		}
		return item;
	}
	
	/**
	 * Attempt to equip an item to the main hand
	 * @param itemUID UID of an item to equip
	 * @return True if equip was successful or false if not
	 */
	public boolean equipMainHand(UUID itemUID) {
		Placeable item = content.get(itemUID);
		if (item == null || !Equipable.class.isInstance(item)) {
			return false;
		}
		 return mainHandSlot.equip((Equipable) item) != null;
	}
	
	/**
	 * Attempt to equip an item to the off hand
	 * @param itemUID UID of an item to equip
	 * @return True if equip was successful or false if not
	 */
	public boolean equipOffHand(UUID itemUID) {
		Placeable item = content.get(itemUID);
		if (item == null || !Equipable.class.isInstance(item)) {
			return false;
		}
		 return offHandSlot.equip((Equipable) item) != null;
	}
	
	/**
	 * Attempt to equip an item to the armor
	 * @param itemUID UID of an item to equip
	 * @return True if equip was successful or false if not
	 */
	public boolean equipArmor(UUID itemUID) {
		Placeable item = content.get(itemUID);
		if (item == null || !Equipable.class.isInstance(item)) {
			return false;
		}
		 return armorSlot.equip((Equipable) item) != null;
	}
	
	/**
	 * Get main hand weapon or null if slot is empty
	 * @return Equipped item or null
	 */
	public Weapon getMainHandWeapon() {
		Equipable item = mainHandSlot.getEquippedItem();
		return item != null ? (Weapon) item : null;
	}
	
	/**
	 * Get off hand weapon or null if slot is empty
	 * @return Equipped item or null
	 */
	public Gear getOffHandItem() {
		Equipable item = offHandSlot.getEquippedItem();
		return item != null ? (Gear) item : null;
	}
	
	/**
	 * Get equipped armor or null if slot is empty
	 * @return Equipped item or null
	 */
	public Armor getEquippedArmor() {
		Equipable item = armorSlot.getEquippedItem();
		return item != null ? (Armor) item : null;
	}
}