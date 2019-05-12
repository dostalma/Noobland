/**
 * 
 */
package business;

import java.util.Random;

import presentation.UserInteractionService;
import presentation.factory.PresentationServiceFactory;

/**
 * @author Martin Dostal
 * Dice to roll with
 */
public class Dice {

	protected int sides;
	protected String pattern;
	
	protected static UserInteractionService ui = PresentationServiceFactory.getInstance().createUIService();
	
	/**
	 * Constructor with number of sides parameter
	 * @param sides The number of sides to roll with
	 */
	public Dice(int sides) {
		this.sides = sides;
		this.pattern = "1D" + sides;
	}
	
	/**
	 * Constructor with pattern to calculate some number
	 * @param pattern
	 */
	public Dice(String pattern) {
		this.pattern = pattern; 
	}
	
	/**
	 * Roll a dice and get the result number in the range of sides of this dice
	 * @return The random number result
	 */
	public int roll() {
		return calculateThrow();
	}
	
	protected int simpleRoll() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(sides) + 1; // Adjust the numbers to start with 1 instead of 0
	}
	
	/**
	 * Attempt to calculate a throw of a String dice roll code
	 * @return Result of the throw
	 */
	protected int calculateThrow() {
		int result = 0;
		
		try {
			String dicePart = pattern.split(" ")[0].trim();
			int throwCount = Integer.parseInt(dicePart.split("D")[0]);
			int diceSides = Integer.parseInt(dicePart.split("D")[1]);
			int addition = 0;
			
			if(pattern.contains(" ")) {
				addition = Integer.parseInt(pattern.split(" ")[2].trim());
			}
						
			Dice dice = new Dice(diceSides);
			for (int i = 0; i < throwCount; i++) {
				result += dice.simpleRoll();
			}
			result += addition;
			System.out.println("Rolled: " + result);
			
		} catch (Exception ex) {
			ui.print("Error parsing dice throw");
			ex.printStackTrace();
		}
		
		return result;
	}

	@Override
	public String toString() {
		return pattern;
	}
	
	
}
