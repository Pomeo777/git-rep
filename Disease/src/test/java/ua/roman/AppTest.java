package ua.roman;

import org.junit.Test;

import system.ua.roman.configure.DBConnector;
import system.ua.roman.controller.DBWalker;
import system.ua.roman.entity.Disease;

/**
 * Unit test for simple App.
 */
public class AppTest {

	
	

	@Test
	public void run() throws Exception{
		
		DBConnector c = DBConnector.getInstanse();
		
		DBWalker walk = new DBWalker();
		
		Disease d = new Disease();
		
		d = walk.walk("colitis");
		System.out.println(d);
	}
}
