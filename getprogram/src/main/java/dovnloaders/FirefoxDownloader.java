package dovnloaders;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirefoxDownloader implements Downloader{

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

		driver.get(url);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		List<WebElement> downloadElements = driver.findElements(By.linkText("Download"));
		WebElement element = downloadElements.get(1);

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
//		element.click();
	
	}
}
