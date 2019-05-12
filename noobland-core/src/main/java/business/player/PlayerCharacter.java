/**
 * 
 */
package business.player;

import java.util.HashMap;
import java.util.UUID;

import business.creature.Ability;
import business.creature.AbilityScore;
import business.creature.Hitpoints;
import business.creature.Race;
import business.environment.Localizable;
import business.environment.Location;
import business.player.classes.ClassFeature;

/**
 * @author Martin Dostal
 * PlayerCharacter contains all the important defining information about business.player's character
 * like inventory and class with skills and abilities
 */
public class PlayerCharacter implements Localizable {

	protected final UUID uid;
	
	protected final String name;
	protected final Race race;
	protected final ClassFeature characterClass;
	protected final HashMap<Ability, AbilityScore> abilities;
	protected final Inventory inventory;	
	protected final Hitpoints hitpoints;
	
	protected int level;
	protected Location location = null;
	
	/**
	 * Constructor with all the information needed to define a character.
	 * Creates new character UID.
	 */
	public PlayerCharacter(String name, Race race, ClassFeature charClass, int level,
						   HashMap<Ability, AbilityScore> abilities, Hitpoints hitpoints) {
		this.name = name;
		this.race = race;
		this.characterClass = charClass;
		this.level = level;
		this.abilities = abilities;
		this.inventory = new Inventory();		
		this.hitpoints = hitpoints;
		
		this.uid = UUID.randomUUID();
	}
	
	/**
	 * Constructor with already created UID
	 */
	public PlayerCharacter(String name, Race race, ClassFeature charClass, int level,
			   HashMap<Ability, AbilityScore> abilities, Hitpoints hitpoints, UUID uid) {
		this.name = name;
		this.race = race;
		this.characterClass = charClass;
		this.level = level;
		this.abilities = abilities;
		this.inventory = new Inventory();		
		this.hitpoints = hitpoints;
		
		this.uid = uid;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public Race getRace() {
		return race;
	}

	public HashMap<Ability, AbilityScore> getAbilities() {
		return abilities;
	}

	public Hitpoints getHitpoints() {
		return hitpoints;
	}

	public ClassFeature getCharacterClass() {
		return characterClass;
	}
	
	public UUID getUID() {
		return uid;
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Character " + name + "\n");
		sb.append(race.toString() + " " + characterClass.toString() + ", level " + level + "\n");
		sb.append("Abilities: \n");
		sb.append("	Strenght:  " + abilities.get(Ability.STRENGTH).getTotalValue() + "\n");
		sb.append("	Dexterity:  " + abilities.get(Ability.DEXTERITY).getTotalValue() + "\n");
		sb.append("	Constitution:  " + abilities.get(Ability.CONSTITUTION).getTotalValue() + "\n");
		sb.append("	Inteligence:  " + abilities.get(Ability.INTELLIGENCE).getTotalValue() + "\n");
		sb.append("	Wisdom:  " + abilities.get(Ability.WISDOM).getTotalValue() + "\n");
		sb.append("	Charisma:  " + abilities.get(Ability.CHARISMA).getTotalValue() + "\n");
		
		return sb.toString();
	}
}
