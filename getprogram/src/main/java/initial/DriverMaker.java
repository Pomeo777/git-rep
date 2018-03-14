package initial;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverMaker {

	private WebDriver driver;
	private static final Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebDriver setDriver(String driverName) {

		FirefoxProfile profile = new FirefoxProfile();
		log.debug("Created FirefoxProfile");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"binary/octet-stream");
		profile.setPreference("browser.download.manager.showWhenStarting",
				false);
		profile.setPreference("pdfjs.disabled", true);
		log.debug("Preferensies was set into FireProfile");
		
		FirefoxOptions fOptions = new FirefoxOptions();
		log.debug("Created FirefoxOptions");
		fOptions.setProfile(profile);
		log.debug("set FProfile into FOptions");
		log.info("Try create SeleniumWebDriver... Driver name is {} ", driverName);
		switch (driverName.toLowerCase().substring(0, 3)) {
		case ("chr"):
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.prompt_for_download", "false");
			chromePrefs.put("safebrowsing.enabled", "true");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(chromeOptions);
			log.info("Created ChromeDriver");
			break;
		case ("fir"):
			driver = new FirefoxDriver(fOptions);
		log.info("Created FireFoxDriver");
			break;
		case ("moz"):
			driver = new FirefoxDriver(fOptions);
		log.info("Created FireFoxDriver");
			break;
		}


		return driver;


	}

}
