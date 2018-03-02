package dovnloaders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChromeDownloader implements Downloader{

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
