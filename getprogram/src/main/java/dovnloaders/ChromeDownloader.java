package dovnloaders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChromeDownloader implements Downloader{
	private static final Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	private WebDriver driver;
	private String url;
	private String OSname;
	
	public ChromeDownloader(WebDriver webDriver, String OSname, String url) {
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
		log.debug("Give url to WebDriver");
		try {
			log.debug("Thread sleep 5000 ");
			Thread.sleep(5000);
			log.debug("Thread wake up");
		} catch (InterruptedException e) {
		log.warn("Trhead can't sleep", e);

		}
		
		WebElement element = driver.findElement(By.linkText("DOWNLOAD"));
		log.debug("WebElement was found");
		
		element.click();
		log.debug("Click on webElement");
	}

	
}
