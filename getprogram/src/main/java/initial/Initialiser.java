package initial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Initialiser {

	private DriverMaker driverMaker;
	private ExtractDriver extractDriver;
	private String  driverName, programName, url, OSname; 
	private String[] args; 
	private Properties properties;
	
	private static final Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	
	public Initialiser(String[] args, String OSname){
		this.args = args;
		log.info("Initialisation with parameters {} , {} ", args[0], args[1]);
		this.OSname = OSname;
		log.info("OS is {}", OSname);
		//this.driverExtractor = driverExtractor;
		log.debug("Get properties...");
		getProperties();	
		log.debug("Properties is received");
	}
	

	public void getProperties(){
		try{
			properties = new Properties();
		
			//properties.load(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("./driver.properties")));
			log.debug("try to load properties from file");
			properties.load(new FileInputStream("./driver.properties"));
			log.info("properties is loaded");
	if(args.length == 1 ){
		log.info("request only with program name");
			driverName = properties.getProperty("drivername");
			log.info("Driver name -  {} ", driverName );
			programName = args[0].toLowerCase().substring(0, 3);
			log.info("programe - {} ", programName);
			url = properties.getProperty(programName);
			log.info("URL for download this program - {} ", url);
	}else if(args.length >= 2){
		log.info("request  with program name and driver name");
		driverName = args[1];
		log.info("Driver name -  {} ", driverName );
		log.debug("set driver into properties");
		properties.setProperty("drivername", driverName);
		properties.store(new FileOutputStream("./driver.properties"), null);
		log.debug("settings is success");
		programName = args[0].toLowerCase().substring(0, 3);
		log.info("programe - {} ", programName);
		url = properties.getProperty(programName);
		url = properties.getProperty(programName);
		}
	else{
		log.error("There is no parameters. Writte name of program and, if it first time, your browser");
		throw new IllegalArgumentException("Writte name of program and, if it first time, your browser");
		
	}	
		} catch (FileNotFoundException e) {
			log.error("File driver.properties is not found", e);
		} catch (IOException e) {
			log.error("Can't read properties frome 'driver.properties'", e);
		}
	}

	public WebDriver getDriver() throws IOException{
		driverMaker = new DriverMaker();
		log.debug("Created DriverMaker " );
		extractDriver = new ExtractDriver(OSname, driverName);
		log.debug("Created  ExtractDriver");
		log.info("try Setting parameters web browsers...");
		driverMaker.setDriver(driverName);
		
		return driverMaker.getDriver();
	}
	
	
	public String getProgramName() {
		return programName;
	}

	public String getUrl() {
		return url;
	}
	public String getDriverName() {
		return driverName;
	}
	
}
