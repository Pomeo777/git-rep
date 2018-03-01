package deleter;

import java.io.File;
import java.io.IOException;

public abstract class InstalFileDeleter {
	 String programName;
	
	public InstalFileDeleter(String programName) {
		this.programName = programName;
	}
	
	public abstract void  delete() throws IOException;
	
	
	public String getFiles(String dirName, String progname) {
		String filePath = null;
		File dir = new File(dirName);
		if(dir.exists()) {
		File[] dirCont = dir.listFiles();
		for(int i = 0; i<dirCont.length; i++){
			if(dirCont[i].getName().toLowerCase().startsWith(progname)){
				filePath = dirCont[i].getAbsolutePath();
				break;
			}
		}
		}

		return filePath;
	}
}
