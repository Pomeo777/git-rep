package deleter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WinDeleter {

	private String programName;
	private String path = "C:\\Program Files\\JetBrains";
	private String uninstal = "uninstal";
;
	
	public WinDeleter(String programName){
		this.programName = programName;
	}
	
	public String checkProgram() throws FileNotFoundException{
	String fullPathName = null;
		fullPathName = getFiles(path, programName)+"\\bin\\";
		fullPathName = getFiles(fullPathName, uninstal);
		return fullPathName;
	}
	
	public boolean delete() throws FileNotFoundException{
		boolean isDelete = false;
		String fileName = checkProgram();

	//	ProcessBuilder processBuilder = new ProcessBuilder(fileName);
		
		try {
		//	Process process = processBuilder.start();
			 Process process = Runtime.getRuntime().exec(fileName);
			int p = process.waitFor();

			
			if(p == 0){
				isDelete = true;
			}
		} catch (IOException | InterruptedException e) {

			e.printStackTrace();
		}
		
		
		return isDelete;
	}
	
	
	
	public String getFiles(String dirName, String name) throws FileNotFoundException{
		String filePath = null;
		File dir = new File(dirName);
		File[] dirCont = dir.listFiles();
		for(int i = 0; i<dirCont.length; i++){
			if(dirCont[i].getName().toLowerCase().startsWith(name)){
				filePath = dirCont[i].getAbsolutePath();
				break;
			}
		}
		 if(filePath == null){
			 throw new FileNotFoundException("File not found");
		 }
		return filePath;
	}
	
	
}
