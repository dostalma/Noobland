/**
 * 
 */
package business.player;

import business.items.Equipable;
import business.items.Weapon;

/**
 * @author Martin Dostál
 * Slot for holding a main weapon
 */
public class MainHandSlot extends EquipmentSlot {

	/**
	 * Empty constructor
	 */
	public MainHandSlot() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canEquip(Equipable item) {
		return item instanceof Weapon ? true : false;
	}

	@Override
	public Equipable equip(Equipable item) {
		Equipable tmp = null;
		if (item instanceof Weapon) {
			tmp = equipedItem;
			equipedItem = item;
		}
		return tmp;
	}

	@Override
	public Equipable unequip() {
		Equipable tmp = equipedItem;
		equipedItem = null;
		return tmp;
	}
}
