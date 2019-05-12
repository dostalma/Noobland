/**
 * 
 */
package business.combat;

import business.Dice;
import business.creature.Ability;
import business.player.PlayerCharacter;

/**
 * @author Martin Dostal
 *
 */
public class PlayerCombatant extends Combatant {

	protected final PlayerCharacter player;
	
	/**
	 * 
	 */
	public PlayerCombatant(PlayerCharacter player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "PlayerCombatant [player=" + player + "]";
	}

	@Override
	protected int getInitiative() {
		// Check if initiative was not initialized and if so initialize it
		if (initiative == -666) {
			int rolledNumber = new Dice(20).roll(); // roll 1D20
			rolledNumber += player.getLevel() / 2; // add half of player's level
			rolledNumber += player.getAbilities().get(Ability.DEXTERITY).getModifier();
			// @TODO add bonuses and penalties
			initiative = rolledNumber;
		}
		System.out.println("Getting initiative: " + initiative);
		return initiative;
	}

	@Override
	public String getName() {
		return player.getName();
	}

}
