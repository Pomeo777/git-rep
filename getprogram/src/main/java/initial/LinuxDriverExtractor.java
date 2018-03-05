package initial;

import java.io.IOException;

public class LinuxDriverExtractor implements DriverExtractor{

//	@Override
//	public void extract(String drivername) throws IOException {
//		String filePath = "";
//
//		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//		switch(drivername.toLowerCase().substring(0, 3)){
//		case("chr"):
//			filePath = classloader.getResource("Drivers/chromedriver").getFile();
//			Runtime.getRuntime().exec("chmod +x "+filePath);
//		    System.setProperty("webdriver.chrome.driver", filePath);
//	    break;
//		case("moz"):
//			filePath = classloader.getResource("Drivers/geckodriver").getFile();
//			Runtime.getRuntime().exec("chmod +x "+filePath);
//		    System.setProperty("webdriver.gecko.driver", filePath);
//	    break;
//		case("fir"):
//			filePath = classloader.getResource("Drivers/geckodriver").getFile();
//			Runtime.getRuntime().exec("chmod +x "+filePath);
//			System.setProperty("webdriver.gecko.driver", filePath);
//	    break;
//	}
//	}

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
			filePath = "./Drivers/chromedriver";
			Runtime.getRuntime().exec("chmod +x "+filePath);
		    System.setProperty("webdriver.gecko.driver", filePath);
	    break;
		case("fir"):
			filePath = "./Drivers/chromedriver";
			Runtime.getRuntime().exec("chmod +x "+filePath);
			System.setProperty("webdriver.gecko.driver", filePath);
	    break;
	}
	}
}
