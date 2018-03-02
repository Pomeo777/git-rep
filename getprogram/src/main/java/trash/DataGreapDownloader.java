package trash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dovnloaders.Downloader;

public class DataGreapDownloader  implements Download{

	private WebDriver driver;
	private String OSname;

	
	
public DataGreapDownloader(WebDriver webDriver, String OSname) {
			this.driver = webDriver;
			this.OSname = OSname;
	}
	



	@Override
	public void download(){
		driver.get("https://www.jetbrains.com/datagrip/whatsnew/");
		
		WebElement downloadElement = driver.findElement(By.linkText("DOWNLOAD"));
		downloadElement.click();	
	
	}
	@Override
	public void closeBrowser(){
		
		driver.close();
	}




	@Override
	public String checkSystem(String OSname) {
		// TODO Auto-generated method stub
		return null;
	}

}
