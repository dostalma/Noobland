/**
 * 
 */
package business;

import java.util.HashMap;
import java.util.List;

import business.creature.Monster;
import business.items.Weapon;
import data.persistence.PersistenceService;
import data.persistence.factory.PersistenceServiceFactory;

/**
 * @author Martin Dostal
 * Class containing schemas of adjustable elements like weapons, armors etc.
 * Singleton
 */
public class SchemaCollection {

	protected static SchemaCollection instance = null;
	
	protected HashMap<String, Weapon> weaponSchemas = new HashMap<String, Weapon>();
	//protected List<Armor> armorSchemas = null;
	protected HashMap<String, Monster> monsterSchemas = new HashMap<String, Monster>();
	
	/**
	 * Protected singleton constructor
	 */
	protected SchemaCollection() {
		PersistenceService ps = PersistenceServiceFactory.getInstance().createPersistenceService();
		
		List<Weapon> weaponList = ps.loadWeapons();
		for (int i = 0; i < weaponList.size(); i++) {
			weaponSchemas.put(weaponList.get(i).getName(), weaponList.get(i));
		}
		
		List<Monster> monsterList = ps.loadMonsters();
		for (int i = 0; i < monsterList.size(); i++) {
			monsterSchemas.put(monsterList.get(i).getName(), monsterList.get(i));
		}
	}

	/**
	 * Get instance of this class
	 * @return
	 */
	public static SchemaCollection getInstance() {
		if (instance == null) {
			instance = new SchemaCollection();
		}
		return instance;
	}

	public HashMap<String, Weapon> getWeaponSchemas() {
		return weaponSchemas;
	}

	/*
	public List<Armor> getArmorSchemas() {
		return armorSchemas;
	}
	*/
	
	public HashMap<String, Monster> getMonsterSchemas() {
		return monsterSchemas;
	}
}