package initial;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DriverMaker {



	private WebDriver driver;
	
	


	public WebDriver getDriver() {
		return driver;
	}

	

public WebDriver setDriver(String driverName){

	FirefoxProfile profile = new FirefoxProfile();
	profile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
		    "binary/octet-stream"); 
 
	profile.setPreference( "browser.download.manager.showWhenStarting", false );
	profile.setPreference( "pdfjs.disabled", true );
	
	FirefoxOptions fOptions = new FirefoxOptions();
	fOptions.setProfile(profile);
	
	switch(driverName.toLowerCase().substring(0, 3)){
	case("chr"): 
      HashMap<String, Object> chromePrefs = new HashMap<>();
      chromePrefs.put("profile.default_content_settings.popups", 0);
      chromePrefs.put("download.prompt_for_download", "false");
      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.setExperimentalOption("prefs", chromePrefs);
		driver = new ChromeDriver(chromeOptions);
		break;
	case("fir"):
		driver = new FirefoxDriver(fOptions);

		break;
	case("moz"):
		
		driver = new FirefoxDriver(fOptions);
		break;		
	}
	
	return driver;
}
	
	
}
