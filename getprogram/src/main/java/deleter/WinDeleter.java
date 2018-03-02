package deleter;


import java.io.IOException;

public class WinDeleter extends InstalFileDeleter{


	private String path = "C:\\Program Files\\JetBrains";
	private String uninstal = "uninstal";

	
	public WinDeleter(String programName){
		super(programName);
	}
	
	public String checkProgram() {
	String fullPathName = null;
		fullPathName =  getFiles(path, programName);
	
		if(fullPathName != null) {
			fullPathName = fullPathName + "\\bin\\";
			fullPathName = getFiles(fullPathName, uninstal);
		}
		return fullPathName;
	}
	

	public void delete() {
		
		String fileName = checkProgram();
		if(fileName != null){
	//	ProcessBuilder processBuilder = new ProcessBuilder(fileName);
		
		try {
		//	Process process = processBuilder.start();
			 Process process = Runtime.getRuntime().exec(fileName);
			process.waitFor();

		} catch (IOException  e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
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
