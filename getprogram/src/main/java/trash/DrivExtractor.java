package trash;

import java.io.IOException;

public class DrivExtractor {

	public String system = System.getProperty("os.name").toLowerCase().substring(0, 3);
	
	public String extract(String drivername) throws IOException{
	String filePath = "";

	ClassLoader classloader = Thread.currentThread().getContextClassLoader();
	
	if(system.equals("win")) {
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
	}else if(system.equals("lin")) {
		switch(drivername.toLowerCase().substring(0, 3)){
		case("chr"):
			filePath = classloader.getResource("Drivers/chromedriver").getFile();
			Runtime.getRuntime().exec("chmod +x "+filePath);
		    System.setProperty("webdriver.chrome.driver", filePath);
	    break;
		case("moz"):
			filePath = classloader.getResource("Drivers/geckodriver").getFile();
			Runtime.getRuntime().exec("chmod +x "+filePath);
		    System.setProperty("webdriver.gecko.driver", filePath);
	    break;
		case("fir"):
			filePath = classloader.getResource("Drivers/geckodriver").getFile();
			Runtime.getRuntime().exec("chmod +x "+filePath);
			System.setProperty("webdriver.gecko.driver", filePath);
	    break;
	}
    
	}
		return filePath; //  ???????????????????????????????????// не надо возвращать если сработает
	}
	
}
