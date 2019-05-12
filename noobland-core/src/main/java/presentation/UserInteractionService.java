/**
 * 
 */
package presentation;

/**
 * @author Martin Dostal
 * This interface provides methods
 */
public interface UserInteractionService {
	
	/**
	 * Print message to the user
	 * @param message Message to send
	 */
	public void print(String message);
	
	/**
	 * Read and return a line of text from user
	 * @return Read line
	 */
	public String read();
	
	/**
	 * Read and return an Integer value from user
	 */
	public int readInt();
}
