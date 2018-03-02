package trash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DLoader {

	private WebDriver driver;
	private String OSname;
	private String url;

	
	
public DLoader(WebDriver webDriver, String OSname, String url) {
			this.driver = webDriver;
			this.OSname = OSname;
			this.url = url;
	}
	




	public void download() throws InterruptedException{
//		if(this.url.contains("=")){
//		driver.get(this.url+checkSystem(OSname));
//		}else{
		driver.get(url);
//		}
		Thread.sleep(5000);
		//List<WebElement> downloadElements = driver.findElements(By.linkText("Download"));
	//	WebElement element = downloadElements.get(1);
		WebElement element = driver.findElement(By.linkText("DOWNLOAD"));
		element.click();
	}

	public void closeBrowser(){
		
		driver.close();
	}
	
//	public String checkSystem(String OSname){
//		String systemname = "";
//		if(OSname.indexOf("win")>=0){
//			systemname = "windows";
//		}else if(OSname.indexOf("nix") >= 0 || OSname.indexOf("nux") >= 0 || OSname.indexOf("aix") > 0){
//			systemname = "linux";
//		
//		}else if(OSname.indexOf("mac") >= 0){
//			systemname = "mac";
//		}
//		return systemname;
//	}
	





	@Override
	public String toString() {
		return "DLoader [driver=" + driver + ", OSname=" + OSname + ", url="
				+ url + "]";
	}



	
	
}
