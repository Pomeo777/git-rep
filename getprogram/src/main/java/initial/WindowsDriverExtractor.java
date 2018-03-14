package initial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WindowsDriverExtractor implements DriverExtractor{

	private static final Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	
	@Override
	public  void extract(String drivername) {
		String filePath = "";

		//ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		log.debug("Browser is {} ", drivername);
		switch(drivername.toLowerCase().substring(0, 3)){
		
		case("chr"):
		//	filePath = classloader.getResource("Drivers/chromedriver.exe").getFile();
			filePath = "./Drivers/chromedriver.exe";
		    System.setProperty("webdriver.chrome.driver", filePath);
		    log.debug("SystemProperties was set with {} ", filePath);
	    break;
		case("moz"):
			filePath = "./Drivers/geckodriver.exe";
		    System.setProperty("webdriver.gecko.driver", filePath);
		    log.debug("SystemProperties was set with {} ", filePath);
	    break;
		case("fir"):
			filePath = "./Drivers/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", filePath);
			log.debug("SystemProperties was set with {} ", filePath);
	    break;
		}
		
	}

	
}
