package initial;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinuxDriverExtractor implements DriverExtractor{

	private static final Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

	@Override
	public void extract(String drivername) throws IOException {
		String filePath = "";

		log.debug("Browser is {} ", drivername);
		
		switch(drivername.toLowerCase().substring(0, 3)){
		case("chr"):
			filePath = "./Drivers/chromedriver";
			Runtime.getRuntime().exec("chmod +x "+filePath);
		    System.setProperty("webdriver.chrome.driver", filePath);
		    log.debug("SystemProperties was set with {} ", filePath);
	    break;
		case("moz"):
			filePath = "./Drivers/geckodriver";
			Runtime.getRuntime().exec("chmod +x "+filePath);
		    System.setProperty("webdriver.gecko.driver", filePath);
		    log.debug("SystemProperties was set with {} ", filePath);
	    break;
		case("fir"):
			filePath = "./Drivers/geckodriver";
			Runtime.getRuntime().exec("chmod +x "+filePath);
			System.setProperty("webdriver.gecko.driver", filePath);
			log.debug("SystemProperties was set with {} ", filePath);
	    break;
	}
	}
}
