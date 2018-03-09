package initial;

import java.io.IOException;

public class ExtractDriver {

	private DriverExtractor driverExtractor;
	private String OSname, driverName;
	
	
	public ExtractDriver(String OSname, String driverName) throws IOException {
		this.OSname = OSname;
		this.driverName = driverName;
		extracting();
	}
	
	private  void extracting() throws IOException {
		if(OSname.equals("win")){
			driverExtractor = new WindowsDriverExtractor();
			
		}else if(OSname.equals("lin")) {
			driverExtractor = new LinuxDriverExtractor();
		}
		driverExtractor.extract(driverName);
	}
}
