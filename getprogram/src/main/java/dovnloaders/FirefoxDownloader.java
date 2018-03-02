package dovnloaders;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirefoxDownloader implements Downloader{

	private WebDriver driver;
	private String url;
	private String OSname;
	
	public FirefoxDownloader(WebDriver webDriver, String OSname, String url) {
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
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
//			    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"); 
//	 
//		profile.setPreference( "browser.download.manager.showWhenStarting", false );
//		profile.setPreference( "pdfjs.disabled", true );
//	
//		}
		driver.get(url);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<WebElement> downloadElements = driver.findElements(By.linkText("Download"));
		WebElement element = downloadElements.get(1);

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
//		element.click();
	
	}
}
