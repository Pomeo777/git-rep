package getprogram;


import initial.Initialiser;
import installer.Installer;
import installer.LinuxInstaller;
import installer.WindowsInstaller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import deleter.ExeDeleter;
import deleter.InstalFileDeleter;
import deleter.LinDeleter;
import deleter.WinDeleter;
import dovnloaders.Download;




public class IDEALoader {

	static String OSname = System.getProperty("os.name").toLowerCase().substring(0, 3);
	Download dLoader;
	FileChecker fileChecker = new FileChecker();
	Installer installer;
	Initialiser initialiser;
	InstalFileDeleter insDeleter;
	ExeDeleter exeDeleter;

	private static final Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	
	public static void main(String[] args) throws IOException   {
		
	
		IDEALoader loader = new IDEALoader();
			log.info("Initialisation...");
			loader.initialiser = new Initialiser(args, OSname);
			log.info("Iniatialisation was done");

		if(OSname.equals("lin")){
			log.debug("Create Linux deleter installed program");
			 loader.insDeleter = new LinDeleter(loader.initialiser.getProgramName());
			 log.debug("Create Linux installer program");
			loader.installer = new LinuxInstaller(loader.initialiser.getProgramName());
		}else if(OSname.equals("win")){
			log.debug("Create Windows deleter installed program");
			 loader.insDeleter = new WinDeleter(loader.initialiser.getProgramName());
			 log.debug("Create Windows installer program");
			loader.installer = new WindowsInstaller(loader.initialiser.getProgramName());
		}
			log.info("try to delet installed program... " );
	    loader.insDeleter.delete();
	    	
	    
		
			log.debug("Creating Download class ");
			loader.dLoader = new Download(loader.initialiser.getDriver(),  loader.initialiser.getUrl(), loader.OSname, loader.initialiser.getDriverName());
			log.debug("Download class was created");
		
		log.info("Try to start Downloading");
		loader.dLoader.download();
         
		//TODO 
		boolean noFile = true;
		
		while(noFile){
			log.info("Into cycle while");
			noFile = loader.fileChecker.checkAndSleep(loader.initialiser.getProgramName());
		}
		loader.dLoader.getDownloader().closeBrowser();
		

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
	
	
	

}