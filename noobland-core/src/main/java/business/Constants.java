/**
 * 
 */
package business;

/**
 * @author Martin Dostal
 * Class containing constants
 */
public final class Constants {

	// XML DOCUMENT CONSTANTS
	// NODES
	public static String CHARACTER_ROOT_NODE = "characterInfo";
	public static String CHARACTER_NODE = "character";
	public static String CLASS_NODE = "class";
	public static String ABILITIES_NODE = "abilities";
	public static String ABILITY_NODE = "ability";
	public static String HITPOINTS_NODE = "hitpoints";
	public static String INVENTORY_NODE = "inventory";
	public static String WEAPONS_ROOT_NODE = "weapons";
	public static String WEAPON_NODE = "weapon";
	public static String MONSTERS_ROOT_NODE = "monsters";
	public static String MONSTER_NODE = "monster";
	public static String ATTACK_NODE = "attack";
	
	// GENERAL ATTRIBUTES
	public static String NAME_ATTRIBUTE = "name";
	public static String UID_ATTRIBUTE = "uid";
	
	// CHARACTER ATTRIBUTES
	public static String BASE_ATTRIBUTE = "base";
	public static String RACE_ATTRIBUTE = "race";
	public static String LEVEL_ATTRIBUTE = "level";	
	public static String CURRENT_ATTRIBUTE = "current";
	
	// ITEM ATTRIBUTES
	public static String WEIGHT_ATTRIBUTE = "weight";
	public static String PRICE_ATTRIBUTE = "price";
	public static String PROFICIENCY_ATTRIBUTE = "proficiency";	
	
	// ABILITY ATTRIBUTES
	public static String STRENGTH_ATTRIBUTE = "str";
	public static String DEXTERITY_ATTRIBUTE = "dex";
	public static String CONSTITUTION_ATTRIBUTE = "con";
	public static String WISDOM_ATTRIBUTE = "wis";	
	public static String INTELLIGENCE_ATTRIBUTE = "int";
	public static String CHARISMA_ATTRIBUTE = "cha";
	
	// MONSTER ATTRIBUTES
	public static String ROLE_ATTRIBUTE = "role";
	public static String XP_REWARD_ATTRIBUTE = "xp";
	public static String INITIATIVE_ATTRIBUTE = "initiative";
	public static String BLOODIED_ATTRIBUTE = "bloodied";
	public static String ARMOR_CLASS_ATTRIBUTE = "AC";
	public static String FORTITUDE_ATTRIBUTE = "fortitude";
	public static String REFLEX_ATTRIBUTE = "reflex";
	public static String WILL_ATTRIBUTE = "will";
	public static String SPEED_ATTRIBUTE = "speed";
	
	// ATTACK ATTRIBUTES
	public static String HIT_ATTRIBUTE = "hit";
	public static String DAMAGE_ATTRIBUTE = "damage";
	public static String TYPE_ATTRIBUTE = "type";
	public static String USAGE_ATTRIBUTE = "usage";
	
	/**
	 * 
	 */
	private Constants() {
		// TODO Auto-generated constructor stub
	}

}
