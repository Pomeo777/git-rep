package system.ua.roman.configure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



/**
 * @author Pomeo
 *  it is class for download information about DB from properties file
 *  properties file: "connection.properties" is in src/main/resources
 *  used Singleton pattern
 */
public class DBConnector {

	// class instance
	private static final  DBConnector DBINSTANS = new DBConnector();
	

	private final Properties propertie = new Properties();
	
	// call of constructor load information from properties file in Properties object 
	private DBConnector() {
		
		try {
			propertie.load(new FileInputStream(this.getClass().getClassLoader().getResource("connection.properties").getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// method returning class instance
	public static DBConnector getInstanse() {
		return DBINSTANS;
	}
	
	
	// method which gets information from properties file used key - String parameter
	public String value(String key) {
		return this.propertie.getProperty(key);
		}
}
