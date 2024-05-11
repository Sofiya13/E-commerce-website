import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Admin_sampleDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/register";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_USER_SQL = "INSERT INTO sample (date, imgName, username, color, price) VALUES (?, ?, ?, ?, ?)";

    public Admin_sampleDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertUser(Admin_sample user) {
        try (Connection connection = getConnection();
        	       PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
           
            preparedStatement.setDate(1, new java.sql.Date(user.getDate().getTime()));
            preparedStatement.setString(2, user.getImageFileName());
            preparedStatement.setString(3,user.getUsername());
            preparedStatement.setString(4, user.getHexValue());
            preparedStatement.setInt(5, user.getPrice());
System.out.println(user.getPrice());
           int row= preparedStatement.executeUpdate();
           
           if (row>0)
           {
           System.out.println("Image added into database successfully.");
           }
           else
           {
           System.out.println("Failed to upload image.");
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
