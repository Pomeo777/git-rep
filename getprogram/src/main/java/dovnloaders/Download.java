package dovnloaders;

import org.openqa.selenium.WebDriver;

public class Download {

	private WebDriver driver;
	private String url;
	private String OSname;
	private String driverName;
	private Downloader downloader;
	
	public Download(WebDriver driver, String url, String OSname, String driverName) {
		this.driver = driver;
		this.url = url;
		this.OSname = OSname;
		this.driverName = driverName.toLowerCase().substring(0, 3);

	}
	
	public void download() {
		if(driverName.equals("chr")) {
			downloader = new ChromeDownloader(driver, OSname, url);
			downloader.download();
		}else if(driverName.equals("fir")) {
			downloader = new FirefoxDownloader(driver, OSname, url);
			downloader.download();
		}else if(driverName.equals("moz")) {
			downloader = new FirefoxDownloader(driver, OSname, url);
			downloader.download();
		
	}else {
		System.out.println("We dont nave browser witch you use");
	}
	}
	
	public Downloader getDownloader() {
		
		return this.downloader;
	}
}
