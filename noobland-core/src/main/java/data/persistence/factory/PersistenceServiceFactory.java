/**
 * 
 */
package data.persistence.factory;

import java.util.Properties;

import business.Config;
import data.persistence.PersistenceService;
import data.persistence.xml.XMLPersistenceService;

/**
 * @author Martin Dostal
 * Class creates services for persistence based on application configuration
 */
public class PersistenceServiceFactory {

	protected static PersistenceServiceFactory instance = null;
	protected Properties applicationProperties = null;
	
	/**
	 * 
	 */
	protected PersistenceServiceFactory() {
		applicationProperties = Config.getInstance().getApplicationProperties();
	}
	
	/**
	 * Get instance of this class
	 * @return
	 */
	public static PersistenceServiceFactory getInstance() {
		if (instance == null) {
			instance = new PersistenceServiceFactory();
		}
		return instance;
	}
	
	/**
	 * Get PersistenceService specified in application configuration.
	 * Default is XML based service.
	 * @return
	 */
	public PersistenceService createPersistenceService() {
		PersistenceService pService = null;
		String str = applicationProperties.getProperty("persistenceService");
		int i = "xml".equalsIgnoreCase(str) ? 1 : 2;
		switch (i) {
		case 1:
			pService = new XMLPersistenceService();
			break;

		default: // Default is set as xml saving
			pService = new XMLPersistenceService();
			break;
		}
		return pService;
	}
}
