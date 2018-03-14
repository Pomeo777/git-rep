package dovnloaders;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirefoxDownloader implements Downloader{
	private static final Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	
	private WebDriver driver;
	private String url;
	private String OSname;
	
	public FirefoxDownloader(WebDriver webDriver, String OSname, String url) {
		this.driver = webDriver;
		this.OSname = OSname;
		this.url = url;
}
	

	public void closeBrowser() {

		driver.close();
	}

	
	public void download() {
		log.debug("Url for download - {}", url);
		driver.get(url);
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			log.debug("Thread sleep 5000 ");
			Thread.sleep(5000);
			log.debug("Thread wake up");
		} catch (InterruptedException e) {

			log.warn("Trhead can't sleep", e);
		}
		
		List<WebElement> downloadElements = driver.findElements(By.linkText("Download"));
		log.debug("WebElements was found");
		WebElement element = downloadElements.get(1);
		log.debug("WebElement is 2 fromlist");
log.debug("Create JSExecutor");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		log.debug("Click on webElement");

	
	}
}
