/**
 * 
 */
package business.items;

import business.player.EquipmentSlot;

/**
 * @author Martin Dostal
 *
 */
public class Gear extends Item implements Equipable {

	protected final int weight;
	protected final int price;
	
	protected boolean equiped;
	protected EquipmentSlot slot;
	
	/**
	 * @param name
	 * @param location
	 */
	public Gear(String name, Container location, int weight, int price) {
		super(name, location);
		equiped = false;
		this.weight = weight;
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see business.items.Equipable#equip()
	 */
	@Override
	public boolean equip(EquipmentSlot slot) {
		if (slot.canEquip(this)) {
			equiped = true;
			slot.equip(this);
			return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see business.items.Equipable#unequip()
	 */
	@Override
	public boolean unequip() {
		if (slot == null) {
			return false;
		}
		slot.unequip();
		equiped = false;
		return true;
	}

	public boolean isEquiped() {
		return equiped;
	}

	public int getWeight() {
		return weight;
	}

	public int getPrice() {
		return price;
	}

	public EquipmentSlot getSlot() {
		return slot;
	}
}
