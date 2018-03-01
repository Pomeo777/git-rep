package dovnloaders;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDownloader implements Downloader{

	private WebDriver driver;
	private String url;
	private String OSname;
	
	public ChromeDownloader(WebDriver webDriver, String OSname, String url) {
		this.driver = webDriver;
		this.OSname = OSname;
		this.url = url;
}
	
	@Override
	public void closeBrowser() {

		driver.close();
	}

	@Override
	public void download() {
//		if(OSname.equals("win")) {
//        HashMap<String, Object> chromePrefs = new HashMap<>();
//        chromePrefs.put("profile.default_content_settings.popups", 0);
//        chromePrefs.put("download.prompt_for_download", "false");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setExperimentalOption("prefs", chromePrefs);
//		}
		driver.get(url);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
		WebElement element = driver.findElement(By.linkText("DOWNLOAD"));
		element.click();
		
	}

	
}
