/**
 * 
 */
package business;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

/**
 * @author Martin
 * Configuration component
 */
public class Config {

	protected static Config instance = null;
	protected Properties applicationProperties = null;
	protected Properties generalProperties = null;
	protected Properties messages = null;
	protected Locale currentLocale = null;
	private String contextRootPath = "";
	
	// Protected constructor for singleton pattern
	protected Config() { 
		// load basic app properties		
		try {
			currentLocale = new Locale("en", "US");
			applicationProperties = new Properties();
			generalProperties = new Properties();
			messages = new Properties();
			InputStream input = null;
			contextRootPath = System.getProperty("user.dir") + "/noobland-core/";

			String filename = contextRootPath + "resources/app.properties";
			input = new FileInputStream(filename);
			applicationProperties.load(input);
			
			filename = contextRootPath + "resources/general.properties";
			input = new FileInputStream(filename);
			generalProperties.load(input);
			
			filename = contextRootPath + "resources/messages.properties";
			input = new FileInputStream(filename);
			messages.load(input);
			
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	
	// Return an instance of this class
	public static Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}
	
	/**
	 * Get loaded application properties defining the application system parameters
	 * @return Properties file
	 */
	public Properties getApplicationProperties() {
		return applicationProperties;
	}
	
	/**
	 * Get loaded general properties with properties specific for each game instance
	 * @return Properties file
	 */
	public Properties getGeneralProperties() {
		return generalProperties;
	}
	
	/**
	 * Get loaded messages in default language
	 * @return Properties file
	 */
	public Properties getMessages() {
		return messages;
	}
	
	/**
	 * Get current language locale
	 * @return Locale
	 */
	public Locale getLocale() {
		return currentLocale;
	}

	/**
	 * Get context root path
	 * @return String value of contet root path
	 */
	public String getContextRootPath() {
		return contextRootPath;
	}
}
