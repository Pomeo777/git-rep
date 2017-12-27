package system.ua.roman.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import system.ua.roman.configure.DBConnector;
import system.ua.roman.entity.Disease;
import system.ua.roman.entity.NoInformationException;
import system.ua.roman.entity.Walker;

/**
 * @author Pomeo
 *
 * class for getting information  of Disease from  DB
 *
 * class is Spring bean 
 */


@Component
public class DBWalker implements Walker {

	@Autowired
	private Disease disease;

	private Connection connection;

	// call of constructor creates DB connection used JDBC 
	public DBWalker() {
		DBConnector connector = DBConnector.getInstanse();
		System.out.println("connector is create");
		try {
			Class.forName(connector.value("jdbc.driver_class"));
			this.connection = DriverManager.getConnection(connector.value("jdbc.url"), connector.value("jdbc.username"),
					connector.value("jdbc.password"));
			System.out.println("connection is create");
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	
	/* 
	*  parameter diase - a title of the Disease, the  information about which  we  want to get
	*  method gets information from table  "disease" in DB.
	*  the console outputs are  for control
	*  
	*   when there isn't information in table method casts an exception, it must be processed in the calling method
	*/

	@Override
	public Disease walk(String diase) throws NoInformationException {
	//	Disease disease = new Disease();
		try (Statement statement = this.connection.createStatement()) {
			System.out.println("create dis in method walk");
			System.out.println("statement is create");
			ResultSet rs = statement
					.executeQuery("SELECT disease.context FROM disease WHERE disease.name = '" + diase + "'");
			System.out.println("rs is with: " + diase);
			System.out.println(rs.isBeforeFirst());

			if (rs.isBeforeFirst()) {
				while (rs.next()) {

					disease.setContext(rs.getString("context"));
					disease.setDiseas(diase);
				}
			} else {
				throw new NoInformationException();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return disease;
	}

	//method returns   List of titles of  diseases that are in DB  table  
	public List<String> allDisease(){
		List<String> list  = new ArrayList<String>();
		try (Statement statement = this.connection.createStatement()){
			ResultSet rs = statement.executeQuery("SELECT disease.name FROM disease");
			while(rs.next()) {
				list.add(rs.getString("name"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// close DB connection
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
