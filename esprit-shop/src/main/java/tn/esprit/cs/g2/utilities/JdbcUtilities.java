package tn.esprit.cs.g2.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtilities {
	private static Connection connection;
	private static Statement statement;
	private static String url = "jdbc:mysql://localhost:3306/base";
	private static String user = "root";
	private static String password = "";
	private static JdbcUtilities instance;

	private JdbcUtilities() {
	}

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");

			connection = DriverManager.getConnection(url, user, password);
			System.out.println("connection configured");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static Statement getStatement() {
		try {
			statement = getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}

	public static JdbcUtilities getInstance() {
		if (instance == null) {
			instance = new JdbcUtilities();
		}
		return instance;
	}
}
