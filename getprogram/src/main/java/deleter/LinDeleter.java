package deleter;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinDeleter extends InstalFileDeleter{

	private static final Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	
	private String programsDirPath = System.getProperty("user.home")+File.separator+"Programs"+File.separator;
	
	public LinDeleter(String programName) {
		super(programName);
	}
	
	
	public void delete() throws IOException {
		log.debug("The dir with program  {} must be into {} ", programName, programsDirPath);
		log.debug("Searching programFolder used 'getFile' method superClase's");
		String dirPath = getFiles(programsDirPath, programName);
		log.info("program folderPath is  {} ", dirPath);
		if(dirPath!=null) {
			
			File dir = new File(dirPath);
			log.info("Deleting folder with programs...");
			FileUtils.deleteDirectory(dir);
			log.info("Folder was deleted.");
			
		}else {
			log.info("Programm was'n installed");
		}
		
	}
	
	
}
