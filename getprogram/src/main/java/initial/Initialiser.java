package initial;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Initialiser {

	private DriverMaker driverMaker;
	private ExtractDriver extractDriver;
	private String  driverName, programName, url, OSname; 
	private String[] args; 
	private Properties properties;
	
	public Initialiser(String[] args, String OSname){
		this.args = args;
		this.OSname = OSname;
		//this.driverExtractor = driverExtractor;
		getProperties();	
	}
	

	public void getProperties(){
		try{
			properties = new Properties();
		
			properties.load(new FileReader(this.getClass().getClassLoader().getResource("driver.properties").getFile()));

	if(args.length == 1 ){
			driverName = properties.getProperty("drivername");
			programName = args[0].toLowerCase().substring(0, 3);
			url = properties.getProperty(programName);
			
	}else if(args.length == 2){
		driverName = args[1];
	
		properties.setProperty("drivername", driverName);
		properties.store(new FileWriter(this.getClass().getClassLoader().getResource("driver.properties").getFile()), null);
		
		programName = args[0].toLowerCase().substring(0, 3);

		url = properties.getProperty(programName);

		}
	else{
		throw new IllegalArgumentException("Writte name of program and, if it first time, your browser");
	}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WebDriver getDriver() throws IOException{
		driverMaker = new DriverMaker();
//		if(OSname.equals("win")){
//			driverExtractor = new WindowsDriverExtractor();
//		}else if(OSname.equals("lin")) {
//			driverExtractor = new LinuxDriverExtractor();
//		}
//		driverExtractor.extract(driverName);
		extractDriver = new ExtractDriver(OSname, driverName);
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
