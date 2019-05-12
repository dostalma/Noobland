/**
 * 
 */
package business.player;

import business.items.Equipable;
import business.items.Weapon;

/**
 * @author Martin Dostal
 *
 */
public class OffHandSlot extends EquipmentSlot {

	/**
	 * Empty constructor
	 */
	public OffHandSlot() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canEquip(Equipable item) {
		return item instanceof Weapon /* @TODO implement shield */ ? true : false;
	}

	@Override
	public Equipable equip(Equipable item) {
		Equipable tmp = null;
		if (item instanceof Weapon /* @TODO implement shield */) {
			tmp = this.equipedItem;
			this.equipedItem = item;
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
