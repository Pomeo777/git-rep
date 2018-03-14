package initial;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtractDriver {

	private DriverExtractor driverExtractor;
	private String OSname, driverName;
	
	private static final Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	
	public ExtractDriver(String OSname, String driverName) throws IOException {
		this.OSname = OSname;
		log.info("Input paraameters into ExtractDriver: OS - {} ", OSname);
		this.driverName = driverName;
		log.info("Input paraameters into ExtractDriver: Driver - {} ", driverName);
		log.debug("try to extract Selenium drivers from browser...");
		extracting();
		log.info("Driver is extracted.");
	}
	
	private  void extracting() throws IOException {
		if(OSname.equals("win")){
			log.info("OS - is Windows. Create WindowsDriverExtactor");
			driverExtractor = new WindowsDriverExtractor();
			
		}else if(OSname.equals("lin")) {
			log.info("OS - is Linux. Create LinuxDriverExtactor");
			driverExtractor = new LinuxDriverExtractor();
		}
		log.debug("try to extract driver with {} ", driverExtractor.getClass().getName());
		driverExtractor.extract(driverName);
		
		
	}
}
