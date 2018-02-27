package initial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverMaker {



	private WebDriver driver;
	
	


	public WebDriver getDriver() {
		return driver;
	}

	

public WebDriver setDriver(String driverName){

	switch(driverName.toLowerCase().substring(0, 3)){
	case("chr"): 
		driver = new ChromeDriver();
		break;
	case("fir"):
		driver = new FirefoxDriver();
		break;
	case("moz"):
		driver = new FirefoxDriver();
		break;		
	}
	
	return driver;
}
	
	
}
