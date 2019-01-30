/**
 * 
 */
package business.items;

import business.Identifiable;
import business.player.EquipmentSlot;

/**
 * @author Martin Dost�l
 * Marks the ability to equip/unequip the implementing class objects
 */
public interface Equipable extends Identifiable {
	
	/**
	 * Equip this object
	 * @return
	 */
	public boolean equip(EquipmentSlot slot);
	
	/*
	 * Unequip this object
	 */
	public boolean unequip();
	
}
