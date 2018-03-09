package initial;

import java.io.IOException;

public class LinuxDriverExtractor implements DriverExtractor{



	@Override
	public void extract(String drivername) throws IOException {
		String filePath = "";


		switch(drivername.toLowerCase().substring(0, 3)){
		case("chr"):
			filePath = "./Drivers/chromedriver";
			Runtime.getRuntime().exec("chmod +x "+filePath);
		    System.setProperty("webdriver.chrome.driver", filePath);
	    break;
		case("moz"):
			filePath = "./Drivers/geckodriver";
			Runtime.getRuntime().exec("chmod +x "+filePath);
		    System.setProperty("webdriver.gecko.driver", filePath);
	    break;
		case("fir"):
			filePath = "./Drivers/geckodriver";
			Runtime.getRuntime().exec("chmod +x "+filePath);
			System.setProperty("webdriver.gecko.driver", filePath);
	    break;
	}
	}
}
