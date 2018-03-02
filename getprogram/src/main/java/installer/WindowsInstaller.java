package installer;


import getprogram.FileChecker;

import java.io.IOException;


public class WindowsInstaller implements Installer{
private String programName;
private FileChecker fileChecker = new FileChecker();

public WindowsInstaller(String programName){
	this.programName = programName;
	
}

@Override
	public void goInstall() throws Exception{
		String path = fileChecker.findFile(programName);
		ProcessBuilder processBuilder = new ProcessBuilder(path);
	
	try {
		Process process = processBuilder.start();
		process.waitFor();


	} catch (IOException | InterruptedException e) {


		e.printStackTrace();
	}
	
	}
	
	
}
