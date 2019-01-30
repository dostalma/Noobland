package business.creature;

import java.util.HashMap;

/**
 * @author Martin Dostál
 * Race enumeration
 */
public enum Race {
	
	HUMAN("Human"),
	MOUNTAIN_DWARF("Mountain Dwarf"),
	HIGH_ELF("High Elf"),
	WOOD_ELF("Wood Elf"),
	LIGHTFOOT_HALFLING("Lightfoor Halfling");
	
	protected String name;
	
	private Race(String name) {
		this.name = name;
	}
	
	/**
	 * Get race by name
	 * @param name of race
	 * @return Race enum object
	 */
	public static Race getRaceByName(String name) {
		switch (name) {
		case "Human": return Race.HUMAN;
		case "Mountain Dwarf": return Race.MOUNTAIN_DWARF;
		case "High Elf": return Race.HIGH_ELF;
		case "Wood Elf": return Race.WOOD_ELF;
		case "Lightfoor Halfling": return Race.LIGHTFOOT_HALFLING;
		}
		return null;
	}
	
	/**
	 * Get race by index
	 * @param index Index of race enum
	 * @return Race enum object
	 */
	public static Race getRaceByIndex(int index) {
		switch (index) {
		case 1: return Race.HUMAN;
		case 2: return Race.MOUNTAIN_DWARF;
		case 3: return Race.HIGH_ELF;
		case 4: return Race.WOOD_ELF;
		case 5: return Race.LIGHTFOOT_HALFLING;
		}
		return null;
	}
	
	/**
	 * Adjust ability scores based on the race chosen
	 * @param abilities Collection of abilities
	 * @param race Chosen race collection of abilities
	 * @return adjusted 
	 */
	public static HashMap<Ability, AbilityScore> adjustAbilityScores(HashMap<Ability, AbilityScore> abilities, Race race) {
		switch (race) {
			case HUMAN:
				abilities.get(Ability.STRENGTH).setTotalValue(abilities.get(Ability.STRENGTH).getBaseValue() + 1);
				abilities.get(Ability.DEXTERITY).setTotalValue(abilities.get(Ability.DEXTERITY).getBaseValue() + 1);
				abilities.get(Ability.CONSTITUTION).setTotalValue(abilities.get(Ability.CONSTITUTION).getBaseValue() + 1);
				abilities.get(Ability.INTELLIGENCE).setTotalValue(abilities.get(Ability.INTELLIGENCE).getBaseValue() + 1);
				abilities.get(Ability.WISDOM).setTotalValue(abilities.get(Ability.WISDOM).getBaseValue() + 1);
				abilities.get(Ability.CHARISMA).setTotalValue(abilities.get(Ability.CHARISMA).getBaseValue() + 1);
				break;
			
			case MOUNTAIN_DWARF:
				abilities.get(Ability.STRENGTH).setTotalValue(abilities.get(Ability.STRENGTH).getBaseValue() + 2);
				abilities.get(Ability.CONSTITUTION).setTotalValue(abilities.get(Ability.CONSTITUTION).getBaseValue() + 2);
				break;
				
			case HIGH_ELF:
				abilities.get(Ability.DEXTERITY).setTotalValue(abilities.get(Ability.DEXTERITY).getBaseValue() + 2);
				abilities.get(Ability.INTELLIGENCE).setTotalValue(abilities.get(Ability.INTELLIGENCE).getBaseValue() + 1);
				break;
			
			case WOOD_ELF:
				abilities.get(Ability.DEXTERITY).setTotalValue(abilities.get(Ability.DEXTERITY).getBaseValue() + 2);
				abilities.get(Ability.WISDOM).setTotalValue(abilities.get(Ability.WISDOM).getBaseValue() + 1);
				break;
				
			case LIGHTFOOT_HALFLING:
				abilities.get(Ability.DEXTERITY).setTotalValue(abilities.get(Ability.DEXTERITY).getBaseValue() + 2);
				abilities.get(Ability.CHARISMA).setTotalValue(abilities.get(Ability.CHARISMA).getBaseValue() + 1);
				break;
				
			default:
				break;
		}
		return abilities;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
