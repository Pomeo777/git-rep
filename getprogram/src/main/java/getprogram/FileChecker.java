package getprogram;

import java.io.File;
import java.io.FileNotFoundException;

public class FileChecker {

	String filedir = System.getProperty("user.home")+File.separator+"Downloads"+File.separator;
	
	public boolean check(String programName){
		boolean check = false;

		File dir = new File(filedir);
		System.out.println(filedir);
		File[] dirCont = dir.listFiles();
		
		for(int i = 0; i<dirCont.length; i++){
	
			if(dirCont[i].getName().toLowerCase().contains(programName) && 
					!(dirCont[i].getName().toLowerCase().contains("crdown") | dirCont[i].getName().toLowerCase().contains("part"))){
				check = true;
				break;
			}
		}
		return check;
	}
	
	
	public boolean checkAndSleep(String programName){
		boolean contains = true;
		for(int i = 0; i<50; i++){
			System.out.println("Into for ");
			if(!check(programName)){
				try {
					System.out.println("Thread sleep" );
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				contains = false;
				break;
			}			
		}
		System.out.println("File is");
		return contains;
	}


public String findFile(String programName) throws Exception{
	String fileName = null;
	
	File dir = new File(filedir);
	
	File[] dirCont = dir.listFiles();

	for(int i = 0; i<dirCont.length; i++){

		
		if(dirCont[i].getName().toLowerCase().startsWith(programName)){

			fileName = dirCont[i].getAbsolutePath();
			System.out.println(fileName);
			break;
		}
	}
	 if(fileName==null){
		 throw new FileNotFoundException("File not found");
	 }
	return fileName;
	
}
}