package initial;

public class WindowsDriverExtractor implements DriverExtractor{

	@Override
	public  void extract(String drivername) {
		String filePath = "";

		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		
		switch(drivername.toLowerCase().substring(0, 3)){
		case("chr"):
			filePath = classloader.getResource("Drivers/chromedriver.exe").getFile();
		    System.setProperty("webdriver.chrome.driver", filePath);
	    break;
		case("moz"):
			filePath = classloader.getResource("Drivers/geckodriver.exe").getFile();
		    System.setProperty("webdriver.gecko.driver", filePath);
	    break;
		case("fir"):
			filePath = classloader.getResource("Drivers/geckodriver.exe").getFile();
			System.setProperty("webdriver.gecko.driver", filePath);
	    break;
		}
		
	}

	
}
