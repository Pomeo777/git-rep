package trash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dovnloaders.Downloader;

public class GoDownloader implements Downloader{

	private WebDriver driver;
	private String OSname;

	
	
public GoDownloader(WebDriver webDriver, String OSname) {
			this.driver = webDriver;
			this.OSname = OSname;
	}
	



	@Override
	public void download(){
		driver.get("https://www.jetbrains.com/go/download/#section="+checkSystem(OSname));
		
		WebElement downloadElement = driver.findElement(By.linkText("DOWNLOAD"));
		downloadElement.click();	
	
	}
	@Override
	public void closeBrowser(){
		
		driver.close();
	}
	
	public String checkSystem(String OSname){
		String systemname = "";
		if(OSname.indexOf("win")>=0){
			systemname = "windows";
		}else if(OSname.indexOf("nix") >= 0 || OSname.indexOf("nux") >= 0 || OSname.indexOf("aix") > 0){
			systemname = "linux";
		
		}else if(OSname.indexOf("mac") >= 0){
			systemname = "mac";
		}
		return systemname;
	}






}
