package project;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	public void addUser(User user) {
		Connection connection = new JdbcUtilities().getConnection();

		try {
			Statement statement = connection.createStatement();
			String sql = "insert into base.T_USER ('name') values ('" + user.getName() + "')";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
