package com.ty.userLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    private final static String jdbcUrl = "jdbc:mysql://localhost:3306/register";
    private final static String usernam = "root";
    private final static String password = "root";

    public static UserLogin getUserByUsername(String username) {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn = DriverManager.getConnection(jdbcUrl, usernam, password);
        	String query = "SELECT * FROM regist WHERE username = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String password = resultSet.getString("password");
                
                return new UserLogin(username, password );
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle any potential exceptions here
        }

        return null;
    }
}
