/**
 * 
 */
package presentation.factory;

import java.util.Properties;

import business.Config;
import presentation.UserInteractionService;
import presentation.console.ConsoleUIService;

/**
 * @author Martin Dostál
 * Factory creating user interaction services based on current configuration
 */
public class PresentationServiceFactory {

	protected static PresentationServiceFactory instance = null;
	protected Properties appProperties = null;
	
	/**
	 * 
	 */
	protected PresentationServiceFactory() {
		appProperties = Config.getInstance().getApplicationProperties();
	}
	
	/**
	 * Get an instance of this class
	 * @return Instance of this class
	 */
	public static PresentationServiceFactory getInstance() {
		if (instance == null) {
			instance = new PresentationServiceFactory();
		}
		return instance;
	}

	/**
	 * Get User Interaction service based on the current configuration
	 * @return Chosen UI Service
	 */
	public UserInteractionService createUIService() {
		switch (appProperties.getProperty("presentationService")) {
		case "console":
			return new ConsoleUIService();
		// @TODO other presentation methods
		default:
			System.out.println("Error: Unsupported Presentation Service method");
		}
		return null;
	}
}
