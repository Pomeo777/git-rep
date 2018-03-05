package initial;

public class WindowsDriverExtractor implements DriverExtractor{

	@Override
	public  void extract(String drivername) {
		String filePath = "";

		//ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		
		switch(drivername.toLowerCase().substring(0, 3)){
		case("chr"):
		//	filePath = classloader.getResource("Drivers/chromedriver.exe").getFile();
			filePath = "./Drivers/chromedriver.exe";
		    System.setProperty("webdriver.chrome.driver", filePath);
	    break;
		case("moz"):
			filePath = "./Drivers/geckodriver.exe";
		    System.setProperty("webdriver.gecko.driver", filePath);
	    break;
		case("fir"):
			filePath = "./Drivers/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", filePath);
	    break;
		}
		
	}

	
}
