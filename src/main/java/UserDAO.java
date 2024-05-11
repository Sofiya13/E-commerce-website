import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
	private final String jdbcUrl = "jdbc:mysql://localhost:3306/register";
	private final String username = "root";
	private final String password = "root";

	public boolean addUser(User newUser) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			String query = "INSERT INTO regist (username, password, email, fullname, contact) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, newUser.getUsername());
			statement.setString(2, newUser.getPassword());
			statement.setString(3, newUser.getEmail());
			statement.setString(4, newUser.getFullname());
			statement.setString(5,newUser.getContact());

			int rs = statement.executeUpdate();
			return rs > 0;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			// Handle any potential exceptions here
		}
		return false;
	}
}
