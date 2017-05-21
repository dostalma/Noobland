/**
 * 
 */
package presentation.console;

import java.util.Scanner;

import presentation.UserInteractionService;

/**
 * @author Martin Dostál
 *
 */
public class ConsoleUIService implements UserInteractionService {

	Scanner sc = new Scanner(System.in);
	
	/**
	 * 
	 */
	public ConsoleUIService() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see presentation.UserInteractionService#print(java.lang.String)
	 */
	@Override
	public void print(String message) {
		System.out.println(message);
	}

	/* (non-Javadoc)
	 * @see presentation.UserInteractionService#read()
	 */
	@Override
	public String read() {
		System.out.print("$: ");
		String line = sc.nextLine();
		return line;
	}

	/* (non-Javadoc)
	 * @see presentation.UserInteractionService#ReadInt()
	 */
	@Override
	public int readInt() {
		System.out.print("$: ");
		int number = -1;
		try {
			String str = sc.nextLine();
			number = Integer.parseInt(str);
		} catch (Exception ex) {
			//ex.printStackTrace();
		}
		
		return number;
	}

}
