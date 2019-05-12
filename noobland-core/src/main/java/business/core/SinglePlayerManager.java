/**
 * 
 */
package business.core;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import business.Config;
import business.Dice;
import business.SchemaCollection;
import business.combat.CombatManager;
import business.creature.Monster;
import business.environment.Localizable;
import business.environment.Location;
import business.environment.PlaceEnum;
import business.items.Currency;
import business.items.Weapon;
import business.player.PlayerCharacter;
import data.persistence.PersistenceService;
import data.persistence.factory.PersistenceServiceFactory;

/**
 * @author Martin Dostal
 * Mode for single business.player
 */
public class SinglePlayerManager extends GameManager {

	Config config = Config.getInstance();

	/**
	 * 
	 */
	public SinglePlayerManager() {
		super();
	}

	/**
	 * Test some new shit
	 */
	protected void testingGround() {
		

		PersistenceService ps = PersistenceServiceFactory.getInstance().createPersistenceService();
		PlayerCharacter character = null;
				
		// Test save character
		if ( false ) {
			character = createCharacter();
			ps.saveCharacter(character);
		}
		
		// Test load character
		if ( true ) {
			character = ps.loadCharacter();
			ui.print(character.toString());
		}
		
		Location location = new Location("a0-1", "Training area 1", PlaceEnum.NATURE);
		location.moveIn(character);
		System.out.println("Current location: " + character.getLocation().getName());
		
		location = new Location("a0-2", "Training area 2", PlaceEnum.NATURE);
		location.moveIn(character);
		System.out.println("Current location: " + character.getLocation().getName() + "\n");
		
		// Test create and equip weapon
		HashMap<String, Weapon> weapons = SchemaCollection.getInstance().getWeaponSchemas();
		for (Weapon weapon : weapons.values()) {
			System.out.println(weapon.toString());
		}
		if (weapons.size() > 0) {
			Weapon weapon = weapons.get("Longsword");
			character.getInventory().add(weapon);
			character.getInventory().equipMainHand(weapon.getUID());
			
			System.out.println(character.getInventory().getMainHandWeapon().toString());
		}
		
		// Test create monster
		HashMap<String, Monster> monsters = SchemaCollection.getInstance().getMonsterSchemas();
		for (Monster monster : monsters.values()) {
			System.out.println(monster.toString());
		}
		if (monsters.size() > 0) {
			Monster monster = new Monster(monsters.get("Decrepit Skeleton"));
			System.out.println(monster.toString());
			location.moveIn(monster);
		}
		
		// Objects in location
		for (Localizable object : location.getObjects().values()) {			
			if (object instanceof PlayerCharacter) {
				System.out.println("Found in this location: " + ((PlayerCharacter) object).getName());
				System.out.println(((PlayerCharacter) object).getHitpoints().toString());
			} else if (object instanceof Monster) {
				System.out.println("Found in this location: " + ((Monster) object).getName());
				System.out.println(((Monster) object).getHitpoints().toString());
			}
		}

		// @TODO lets do combat later

		CombatManager cm = new CombatManager();
		cm.startCombat(location);

	}
	
	@Override
	public void start() {
		
		ui.print("Single Player game started\n");
		
		testingGround();
	}

}
