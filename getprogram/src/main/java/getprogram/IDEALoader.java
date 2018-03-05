package getprogram;


import initial.Initialiser;
import installer.Installer;
import installer.LinuxInstaller;
import installer.WindowsInstaller;

import java.io.IOException;

import deleter.ExeDeleter;
import deleter.InstalFileDeleter;
import deleter.LinDeleter;
import deleter.WinDeleter;
import dovnloaders.Download;




public class IDEALoader {


	Download dLoader;
	static String OSname = System.getProperty("os.name").toLowerCase().substring(0, 3);
	FileChecker fileChecker = new FileChecker();

	Installer installer;

	Initialiser initialiser;
	InstalFileDeleter insDeleter;
	ExeDeleter exeDeleter;
	

	public static void main(String[] args) throws IOException   {

		
		//TODO
		
		
		
		
		IDEALoader loader = new IDEALoader();

			loader.initialiser = new Initialiser(args, OSname);
		
			
		System.out.println(OSname);
		

		if(OSname.equals("lin")){
			 loader.insDeleter = new LinDeleter(loader.initialiser.getProgramName());
			loader.installer = new LinuxInstaller(loader.initialiser.getProgramName());
		}else if(OSname.equals("win")){
			 loader.insDeleter = new WinDeleter(loader.initialiser.getProgramName());
			loader.installer = new WindowsInstaller(loader.initialiser.getProgramName());
		}

	    loader.insDeleter.delete();

	
		
		
		try {
			loader.dLoader = new Download(loader.initialiser.getDriver(),  loader.initialiser.getUrl(), loader.OSname, loader.initialiser.getDriverName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("loader create");
		loader.dLoader.download();
//         System.out.println("load start");
//		
//		boolean noFile = true;
//		while(noFile){
//			System.out.println("into while");
//			noFile = loader.fileChecker.checkAndSleep(loader.initialiser.getProgramName());
//		}
//		loader.dLoader.getDownloader().closeBrowser();
//		
//
//		try {
//			loader.installer.goInstall();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//		
//		loader.exeDeleter = new ExeDeleter(loader.initialiser.getProgramName());
//		try {
//			loader.exeDeleter.goExeDelet();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		

	}
	
	
	

}