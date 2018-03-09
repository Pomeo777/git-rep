package installer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import getprogram.FileChecker;

public class LinuxInstaller implements Installer{

	private String programName;
	private FileChecker fileChecker = new FileChecker();
	
	public LinuxInstaller(String programName){
		this.programName = programName;
		
	}


		@Override
		public void goInstall() throws Exception{
			
			String fileZip = fileChecker.findFile(programName);
			
			String filedir = System.getProperty("user.home")+File.separator+"Programs"+File.separator;
			File programsDir = new File(filedir);
			if(!programsDir.exists()) {
				programsDir.mkdirs();
			}
			
			String command = "tar xf "+fileZip+" -C "+filedir;
			System.out.println(command);
			
			Process process = Runtime.getRuntime().exec(command);
			process.waitFor();
			
			
			
		    }
		
		}
	
	

