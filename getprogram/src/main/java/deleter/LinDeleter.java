package deleter;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class LinDeleter extends InstalFileDeleter{

	
	private String programsDirPath = System.getProperty("user.home")+File.separator+"Programs"+File.separator;
	
	public LinDeleter(String programName) {
		super(programName);
	}
	
	
	public void delete() throws IOException {
		
		String dirPath = getFiles(programsDirPath, programName);
		if(dirPath!=null) {
			
			File dir = new File(dirPath);
			FileUtils.deleteDirectory(dir);
			
		}
		
	}
	
	
}
