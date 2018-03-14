package deleter;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WinDeleter extends InstalFileDeleter{


	private String path = "C:\\Program Files\\JetBrains";
	private String uninstal = "uninstal";
	private static final Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	
	public WinDeleter(String programName){
		super(programName);
	}
	
	public String checkProgram() {
		log.debug("into method checkProgram in Windeleter class");
	String fullPathName = null;
		log.debug("searching folder with programs in - {}", path);
		fullPathName =  getFiles(path, programName);
		log.debug("fullpathname folder is {}", fullPathName);
		
		if(fullPathName != null) {
			fullPathName = fullPathName + "\\bin\\";
			log.debug("fullPathName is  {}", fullPathName);
			fullPathName = getFiles(fullPathName, uninstal);
			log.debug("fullPathName is  {}", fullPathName);
		}
		return fullPathName;
	}
	

	public void delete() {
		log.debug("Searching uninstal file...");;
		String fileName = checkProgram();
		
		if(fileName != null){
			log.debug("File for uninstal -  {} ", fileName);
	//	ProcessBuilder processBuilder = new ProcessBuilder(fileName);
		
		try {
		//	Process process = processBuilder.start();
			log.debug("Try run {} ", fileName);
			 Process process = Runtime.getRuntime().exec(fileName);
			process.waitFor();
			log.info("Uninstaling...");
		} catch (IOException  e) {
			log.error("IOException", e);
		} catch (InterruptedException e) {
			log.error("Exeption in process of uninstalation");
		}
		
		}else {
			log.info("Program wasn't installed");
		}
		

	}
	
	
	
//	public String getFiles(String dirName, String name) throws FileNotFoundException{
//		String filePath = null;
//		File dir = new File(dirName);
//		File[] dirCont = dir.listFiles();
//		for(int i = 0; i<dirCont.length; i++){
//			if(dirCont[i].getName().toLowerCase().startsWith(name)){
//				filePath = dirCont[i].getAbsolutePath();
//				break;
//			}
//		}
//		 if(filePath == null){
//			 throw new FileNotFoundException("File not found");
//		 }
//		return filePath;
//	}
	
	
}
