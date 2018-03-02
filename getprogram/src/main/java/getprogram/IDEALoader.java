package getprogram;

import initial.DriverExtractor;
import initial.Initialiser;
import installer.WindowsInstaller;
import installer.LinuxInstaller;
import trash.DLoader;

import java.io.FileNotFoundException;
import java.io.IOException;

import deleter.ExeDeleter;
import deleter.InstalFileDeleter;
import deleter.LinDeleter;
import deleter.WinDeleter;
import dovnloaders.ChromeDownloader;
import dovnloaders.Download;
import dovnloaders.Downloader;



public class IDEALoader {


	Download dLoader;
	static String OSname = System.getProperty("os.name").toLowerCase().substring(0, 3);
	FileChecker fileChecker = new FileChecker();
	LinuxInstaller installer;
	Initialiser initialiser;
	InstalFileDeleter insDeleter;
	ExeDeleter exeDeleter;
	
	public static void main(String[] args)   {
		
		//TODO
		
		
		
		
		IDEALoader loader = new IDEALoader();

			loader.initialiser = new Initialiser(args, OSname);
		
			
		System.out.println("Initial");
		
//		loader.insDeleter = new LinDeleter(loader.initialiser.getProgramName());
//		
//			try {
//				loader.insDeleter.delete();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	
		
		
		try {
			loader.dLoader = new Download(loader.initialiser.getDriver(),  loader.initialiser.getUrl(), loader.OSname, loader.initialiser.getDriverName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("loader create");
		loader.dLoader.download();
         System.out.println("load start");
		
//		boolean noFile = true;
//		while(noFile){
//			System.out.println("into while");
//			noFile = loader.fileChecker.checkAndSleep(loader.initialiser.getProgramName());
//		}
//		loader.dLoader.getDownloader().closeBrowser();
		
//		loader.installer = new LinuxInstaller(loader.initialiser.getProgramName());
//		try {
//			loader.installer.goInstall();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
		
//		loader.exeDeleter = new ExeDeleter(loader.initialiser.getProgramName());
//		try {
//			loader.exeDeleter.goExeDelet();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		

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