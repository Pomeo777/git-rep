package system.ua.roman.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import system.ua.roman.configure.DBConnector;
import system.ua.roman.entity.Disease;
import system.ua.roman.entity.Walker;

@Service
public class DBWalker implements Walker {
	// private String diaseName;
	// private String diaseContext;

	private Disease disease;

	private Connection connection;

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

	@Override
	public Disease walk(String diase) throws Exception {

		try (Statement statement = this.connection.createStatement()) {
			disease = new Disease();
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
				throw new Exception("There is not that Diases in BD");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return disease;
	}

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
	
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
