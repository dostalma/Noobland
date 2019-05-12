/**
 * 
 */
package business.creature;

/**
 * @author Martin Dostal
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
		if ("artillery".equalsIgnoreCase(name)) return MonsterRoleEnum.ARTILLERY;
		if ("brute".equalsIgnoreCase(name)) return MonsterRoleEnum.BRUTE;
		if ("controller".equalsIgnoreCase(name)) return MonsterRoleEnum.CONTROLLER;
		if ("lurker".equalsIgnoreCase(name)) return MonsterRoleEnum.LURKER;
		if ("minion".equalsIgnoreCase(name)) return MonsterRoleEnum.MINION;
		if ("skirmisher".equalsIgnoreCase(name)) return MonsterRoleEnum.SKIRMISHER;
		if ("soldier".equalsIgnoreCase(name)) return MonsterRoleEnum.SOLDIER;
		if ("elite monster".equalsIgnoreCase(name)) return MonsterRoleEnum.ELITE_MONSTER;
		if ("solo monste".equalsIgnoreCase(name)) return MonsterRoleEnum.SOLO_MONSTER;
		if ("leader".equalsIgnoreCase(name)) return MonsterRoleEnum.LEADER;
		return null;
	}
	
}
