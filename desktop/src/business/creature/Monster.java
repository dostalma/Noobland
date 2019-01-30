/**
 * 
 */
package business.creature;

import java.util.HashMap;
import java.util.List;

import business.combat.CombatAction;

/**
 * @author Martin Dostál
 * Domain class representing general monster characteristics
 */
public class Monster extends Creature {

	protected final int level;
	protected final MonsterRoleEnum role;
	protected final int xpReward;
	protected final int initiative;
	protected final Hitpoints hitpoints;
	protected final int armorClass;
	protected final HashMap<Ability, AbilityScore> abilities;
	protected final List<CombatAction> combatActions;
	
	/**
	 * Constructor with obligatory parameters
	 * @param name Name of monster
	 * @param keywords Keywords of monster
	 * @param level Level of monster
	 * @param xpReward XP rewarded for slaying the monster
	 * @param initiative Initiative of monster
	 * @param hp Hitpoints of monster
	 * @param armorClass ArmorClass of monster
	 * @param actionPoints Action Points of monsters
	 * @param abilities Ability scores of monster
	 */
	public Monster(String name, List<CreatureKeywordEnum> keywords, int level, MonsterRoleEnum role, 
					int xpReward, int initiative, Hitpoints hp, int armorClass,
					HashMap<Ability, AbilityScore> abilities, List<CombatAction> combatActions) {
		super(name, keywords);
		this.level = level;
		this.role = role;
		this.xpReward = xpReward;
		this.initiative = initiative;
		this.hitpoints = hp;
		this.armorClass = armorClass;
		this.abilities = abilities;
		this.combatActions = combatActions;
	}
	
	/**
	 * Constructor from schema object
	 * @param schema Monster schema to create this instance from
	 */
	public Monster(Monster schema) {
		super(schema.getName(), schema.getKeywords());
		this.level = schema.getLevel();
		this.role = schema.getRole();
		this.xpReward = schema.getXpReward();
		this.initiative = schema.getInitiative();
		this.hitpoints = schema.getHitpoints();
		this.armorClass = schema.getArmorClass();
		this.abilities = schema.getAbilities();
		this.combatActions = schema.getAttacks();
	}

	public MonsterRoleEnum getRole() {
		return role;
	}

	public int getLevel() {
		return level;
	}

	public int getXpReward() {
		return xpReward;
	}

	public int getInitiative() {
		return initiative;
	}

	public Hitpoints getHitpoints() {
		return hitpoints;
	}

	public int getArmorClass() {
		return armorClass;
	}

	public HashMap<Ability, AbilityScore> getAbilities() {
		return abilities;
	}

	public List<CombatAction> getAttacks() {
		return combatActions;
	}

	@Override
	public String toString() {
		String report =  "Monster [name=" + name + ", level=" + level + ", role=" + role + ", xpReward=" + xpReward + ", initiative=" + initiative
				+ ", armorClass=" + armorClass + "]\n";
		for (int i = 0; i < combatActions.size(); i++) {
			report += combatActions.get(i) + "\n";
		}
		return report;
	}
}
