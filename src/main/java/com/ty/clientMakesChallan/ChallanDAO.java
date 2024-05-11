package com.ty.clientMakesChallan;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;



public class ChallanDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/register";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public boolean insertChallan(Challan challan) {
    	LocalDate currentDate = LocalDate.now();
       
    	long currentTimeMillis = System.currentTimeMillis();
   
    	 String sql = "INSERT INTO challan (from_location, to_location, quantity, product_details, rate, final_amount, date, challan_number, username) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, challan.getFrom_location());
            System.out.println(challan.getFrom_location());
            pstmt.setString(2, challan.getTo_location());
            pstmt.setInt(3, challan.getQuantity());
            pstmt.setString(4, challan.getProductDetails());
            pstmt.setDouble(5, challan.getRate());
            pstmt.setDouble(6, challan.getFinalAmount());
            pstmt.setObject(7, currentDate);
            pstmt.setObject(8, currentTimeMillis);
            pstmt.setString(9, challan.getUsername());

 System.out.println(challan.getFrom_location());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
