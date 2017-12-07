package system.ua.roman.configure;

import system.ua.roman.dao_change.DAOWritter;

public class Try {

	public static void main(String[] args) {
	
		try {
			run("Инсульт");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	public static void run(String s) throws Exception{
		
		DAOWritter dw = new DAOWritter();
		
		
//		BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Tools\\Disease\\" + s+ ".txt"), Charset.forName("UTF-8")));
//		
//		while(bf.read()!=-1) {
//			String str = bf.readLine();
//			System.out.println(str);
//		}
		
		
		
		
		try {
			dw.writte("Инсульт");
			dw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
