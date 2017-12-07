package system.ua.roman.configure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBConnector {

	private static final  DBConnector DBINSTANS= new DBConnector();
	
	private final Properties propertie = new Properties();
	
	private DBConnector() {
		
		try {
			propertie.load(new FileInputStream(this.getClass().getClassLoader().getResource("connection.properties").getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static DBConnector getInstanse() {
		return DBINSTANS;
	}
	
	
	public String value(String key) {
		return this.propertie.getProperty(key);
		}
}
