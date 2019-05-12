/**
 * 
 */
package data.persistence;

import java.util.List;
import java.util.UUID;

import business.creature.Monster;
import business.items.Weapon;
import business.player.PlayerCharacter;

/**
 * @author Martin Dostal
 * Service provides options to save and load data from each application instance as well as read game schemas
 */
public interface PersistenceService {

	/**
	 * Save current progress of the game
	 * @TODO create game class 
	 * @param game Game object
	 * @return Flag if save was successful
	 */
	public boolean saveGame(Object game);
	
	/**
	 * Load previously saved game
	 * @param uid Universal unique identifier of the game
	 * @return Game object @TODO create
	 */
	public Object loadGame(UUID uid);
	
	/**
	 * Save currently played character
	 * @return Flag if saved was successful
	 */
	public boolean saveCharacter(PlayerCharacter character);
	
	/**
	 * Load previously saved character
	 * @return Loaded character
	 */
	public PlayerCharacter loadCharacter();
	
	/**
	 * Load weapon records from weapon schema
	 * @return List of weapons
	 */
	public List<Weapon> loadWeapons();
	
	/**
	 * Load monster records from monster schema
	 * @return
	 */
	public List<Monster> loadMonsters();
}
