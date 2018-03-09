package deleter;

import getprogram.FileChecker;

import java.io.File;

public class ExeDeleter {

	
	private String programName;
	private FileChecker fileChecker = new FileChecker();
	
	public ExeDeleter(String programName){
		this.programName = programName;
		
	}


		public void goExeDelet() throws Exception{
			String path = fileChecker.findFile(programName);

			File exe = new File(path);
			System.out.println(exe.getAbsolutePath());
			exe.delete();
			System.out.println("is deleted");
		}
	
}
