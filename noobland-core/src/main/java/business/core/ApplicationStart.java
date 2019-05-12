/**
 * 
 */
package business.core;

import java.util.Properties;

import business.Config;

/**
 * @author Martin
 *
 */
public class ApplicationStart {

	/**
	 * Application start point
	 * @param args
	 */
	public static void main(String[] args) {
		Properties appProperties = Config.getInstance().getApplicationProperties();
				
		System.out.println("Welcome to " + appProperties.getProperty("appname"));
		
		SinglePlayerManager gm = new SinglePlayerManager();
		gm.start();
		
		
		System.out.println("Noobland app finished");
	}

}
