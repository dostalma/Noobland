/**
 * 
 */
package business.player;

import business.items.Equipable;
import business.items.Armor;

/**
 * @author Martin Dostal
 * Armor slot
 */
public class ArmorSlot extends EquipmentSlot {
	
	/**
	 * Empty constructor
	 */
	public ArmorSlot() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see business.player.EquipmentSlot#canEquip(business.items.Equipable)
	 */
	@Override
	public boolean canEquip(Equipable item) {
		return item instanceof Armor ? true : false;
	}

	/* (non-Javadoc)
	 * @see business.player.EquipmentSlot#equip(business.items.Equipable)
	 */
	@Override
	public Equipable equip(Equipable item) {
		Equipable tmp = null;
		if (item instanceof Armor) {
			tmp = equipedItem;
			equipedItem = item;
		}
		return tmp;
	}

	/* (non-Javadoc)
	 * @see business.player.EquipmentSlot#unequip()
	 */
	@Override
	public Equipable unequip() {
		Equipable tmp = equipedItem;
		equipedItem = null;
		return tmp;
	}
}
