/**
 * 
 */
package business.creature;

/**
 * @author Martin Dostál
 * Enumeration for monster roles
 */
public enum MonsterRoleEnum {

	ARTILLERY,
	BRUTE,
	CONTROLLER,
	LURKER,
	MINION,
	SKIRMISHER,
	SOLDIER,
	ELITE_MONSTER,
	SOLO_MONSTER,
	LEADER;
	
	public static MonsterRoleEnum getRoleByName(String name) {
		switch (name) {
		case "artillery": return MonsterRoleEnum.ARTILLERY;
		case "brute": return MonsterRoleEnum.BRUTE;
		case "controller": return MonsterRoleEnum.CONTROLLER;
		case "lurker": return MonsterRoleEnum.LURKER;
		case "minion": return MonsterRoleEnum.MINION;
		case "skirmisher": return MonsterRoleEnum.SKIRMISHER;
		case "soldier": return MonsterRoleEnum.SOLDIER;
		case "elite monster": return MonsterRoleEnum.ELITE_MONSTER;
		case "solo monste": return MonsterRoleEnum.SOLO_MONSTER;
		case "leader": return MonsterRoleEnum.LEADER;
		
		default:
			System.out.println("Unrecognized monster role name");
			return null;
		}
	}
	
}
