package getprogram;

import initial.Initialiser;
import installer.Installer;

import java.io.FileNotFoundException;

import deleter.ExeDeleter;
import deleter.WinDeleter;
import dovnloaders.DLoader;



public class IDEALoader {

//	DriverExtractor driverExtractor = new DriverExtractor();
	DLoader dLoader;
	String OSname = System.getProperty("os.name").toLowerCase();
//	String driverName, programName, url;
//	Properties properties = new Properties();
	//String[] parameters;
	FileChecker fileChecker = new FileChecker();
//	DriverMaker driverMaker = new DriverMaker();
//	WebDriver webDriver;
//	ExeFinder exeFinder;
	Installer installer;
	Initialiser initialiser;
	WinDeleter winDeleter;
	ExeDeleter exeDeleter;
	public static void main(String[] args)   {
		
		//TODO
		
		
	//	System.setProperty("webdriver.firefox.marionette", "???????????");
		
		
		IDEALoader loader = new IDEALoader();
	//	System.out.println(loader.driverExtractor.extract());
		
//		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//		String res = classLoader.getResource("Drivers/chromedriver.exe").getFile();
		
	//	System.setProperty("webdriver.chrome.driver", loader.driverExtractor.extract());
		
	
		
		


//		loader.getParametrs(loader.parameters);
//		loader.driverMaker.setDriver(loader.driverName);
//		loader.webDriver = loader.driverMaker.getDriver();

		
		loader.initialiser = new Initialiser(args);
		
			
		System.out.println("Initial");
		
		loader.winDeleter = new WinDeleter(loader.initialiser.getProgramName());
		
		try {
			System.out.println(loader.winDeleter.delete());
		} catch (FileNotFoundException e) {
			System.out.println("Program is not insts");
		}
		
		
		loader.dLoader = new DLoader(loader.initialiser.getDriver(), loader.OSname, loader.initialiser.getUrl());
		System.out.println("loader create");
		try {
			loader.dLoader.download();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
         System.out.println("load start");
		
		boolean noFile = true;
		while(noFile){
			System.out.println("into while");
			noFile = loader.fileChecker.checkAndSleep(loader.initialiser.getProgramName());
		}
		loader.dLoader.closeBrowser();
		loader.installer = new Installer(loader.initialiser.getProgramName());
		try {
			loader.installer.goInstall();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		loader.exeDeleter = new ExeDeleter(loader.initialiser.getProgramName());
		try {
			loader.exeDeleter.goExeDelet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	
	
//	public void getParametrs(String[] parameters){
//		
//		if(parameters.length == 1 ){
//		try {
//			properties.load(new FileInputStream(this.getClass().getClassLoader().getResource("driver.properties").getFile()));
//			driverName = properties.getProperty("drivername");
//			programName = parameters[0].toLowerCase().substring(0, 3);
//			url = properties.getProperty(programName);
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}			
//	}else if(parameters.length == 2){
//		driverName = parameters[0];
//		properties.setProperty("drivername", driverName);
//		programName = parameters[1].toLowerCase().substring(0, 3);
//		url = properties.getProperty(programName);
//		}
//	else{
//		throw new IllegalArgumentException("Writte name of program and, if it first time, your browser");
//	}
//	}
	

	
//	public Downloader checkProgram(String programName){
//		Downloader downloader = null;
//	String swit = programName;
//	System.out.println(swit);
//	switch(swit){
//	case("gol"): 
//		downloader = new GoDownloader(webDriver, OSname);
//	break;
//	case("cli"):
//		downloader = new CLionDownloader(webDriver, OSname);
//	break;
//	case("dat"):
//		downloader = new DataGreapDownloader(webDriver, OSname);
//	break;
//	case("php"):
//		downloader = new PhpStormDownloader(webDriver, OSname);
//	break;
//	case("pyc"):
//		downloader = new PyCharmDownloader(webDriver, OSname);
//	break;
//	case("rub"):
//		downloader = new RubiMineDownloader(webDriver, OSname);
//	break;
//	}
//
//		return downloader;
//	}
}