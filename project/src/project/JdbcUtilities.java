package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtilities {
	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/base";
	private String user = "root";
	private String password = "";

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");

			connection = DriverManager.getConnection(url, user, password);
			System.out.println("connection configured");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
}
