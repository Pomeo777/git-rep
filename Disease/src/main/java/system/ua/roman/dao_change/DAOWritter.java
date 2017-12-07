package system.ua.roman.dao_change;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import system.ua.roman.configure.DBConnector;

@Service
public class DAOWritter {
	
	//private String fileName;
	
	
	Connection connection;
	
	public DAOWritter() {
			DBConnector con = DBConnector.getInstanse();		
		try {
				Class.forName(con.value("jdbc.driver_class"));
				this.connection = DriverManager.getConnection(con.value("jdbc.url"), con.value("jdbc.username"),
						con.value("jdbc.password"));
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void writte( String fileName) {
		File file = new File("C:\\Tools\\Disease\\" + fileName+ ".txt");
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8"))); 
				PreparedStatement st =  this.connection.prepareStatement("INSERT INTO disease (name, context) values (?,?)")) {
			
			long size = file.length();
			System.out.println("connection");
				st.setString(1,fileName);	
				System.out.println("name");
				st.setCharacterStream(2, br, (int) size);
				st.executeUpdate();
				
				System.out.println("context");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}
	
	
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}
	
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
 