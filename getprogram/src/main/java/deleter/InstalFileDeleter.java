package deleter;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class InstalFileDeleter {
	 String programName;
	 private static final Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	 
	public InstalFileDeleter(String programName) {
		this.programName = programName;
	}
	
	public abstract void  delete() throws IOException;
	
	
	public String getFiles(String dirName, String progname) {

		String filePath = null;
		
		File dir = new File(dirName);
		log.debug("AbsoluteDirPath  is {} ", dirName);

		if(dir.exists()) {
			log.debug("Dir exist...");
		File[] dirCont = dir.listFiles();
		for(int i = 0; i<dirCont.length; i++){
			
			if(dirCont[i].getName().toLowerCase().startsWith(progname)){
				log.debug("Found folder with programs...");
				filePath = dirCont[i].getAbsolutePath();
				log.debug("AbsoluteFolderPath : {}", filePath);
				break;
			}
		}
		}
		log.debug("returned filePath from method 'getFiles' is {}", filePath);
		return filePath;
	}
}
