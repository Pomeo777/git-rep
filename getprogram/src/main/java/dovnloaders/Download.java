package dovnloaders;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jdk.nashorn.internal.runtime.Debug;

public class Download {

	private WebDriver driver;
	private String url;
	private String OSname;
	private String driverName;
	private Downloader downloader;
	
	private static final Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	
	public Download(WebDriver driver, String url, String OSname, String driverName) {
		this.driver = driver;
		this.url = url;
		this.OSname = OSname;
		this.driverName = driverName.toLowerCase().substring(0, 3);
	}
	
	public void download() {
		log.debug("Creating Downloader depending on drowser");
		if(driverName.equals("chr")) {
			downloader = new ChromeDownloader(driver, OSname, url);
			log.info("Created ChromeDriver with parameters: driver - {}, OSname - {},  url - {}", driver, OSname, url);
			log.info("try download...");
			downloader.download();
			
		}else if(driverName.equals("fir")) {
			downloader = new FirefoxDownloader(driver, OSname, url);
			log.info("Created FirefoxDriverwith parameters: driver - {}, OSname - {},  url - {}", driver, OSname, url);
			log.info("rty download...");
			downloader.download();
		}else if(driverName.equals("moz")) {
			downloader = new FirefoxDownloader(driver, OSname, url);
			log.info("Created FirefoxDriverwith parameters: driver - {}, OSname - {},  url - {}", driver, OSname, url);
			log.info("try download...");
			downloader.download();
			log.info("Download start...");
		
	}else {
		log.error("We dont nave browser witch you use");
	}
	}

	public Downloader getDownloader() {
		
		return this.downloader;
	}
}
