package initial;

public class DriverExtractor {

	public String system = System.getProperty("os.name").toLowerCase();
	public String extract(String drivername){
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
    
    
    
    
    
//	File fileDirectory = new File("Driver");
//		if(!fileDirectory.exists()){
//			fileDirectory.mkdirs();
//		}
//	
//	File driver  = new File("Driver" + File.separator + "chromedriver.exe");
//	
//		if(!driver.exists()){
//			try {
//				driver.createNewFile();
//				org.apache.commons.io.FileUtils.copyInputStreamToFile(is, driver);
//			} catch (IOException e) {
//
//				e.printStackTrace();
//			}
//		}
//		filePath = driver.getAbsolutePath();
	}
		return filePath; //  ???????????????????????????????????// не надо возвращать если сработает
	}
	
}
