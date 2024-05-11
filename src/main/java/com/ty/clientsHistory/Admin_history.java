package com.ty.clientsHistory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Admin_history extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String URL = "jdbc:mysql://localhost:3306/register";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM info");

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            // Generate the HTML response
            out.println("<html>");
            out.println("<head><title>Client's Sample History</title>");
            out.println("<link href='https://fonts.googleapis.com/css?family=Merienda' rel='stylesheet'>");
            out.println("<style>");
            out.println("a { text-decoration: none; color: black; }");
            out.println("body { font-family: Merienda; background-image:url('http://hdwallpapers2013.com/wp-content/uploads/2013/01/Light-Blue-Windows-7-Wallpaper.jpg'); background-size: cover; background-repeat: no-repeat; background-position: bottom; height: 140vh; }");
            out.println("h1 { text-align: center; margin-top: 20px; color: black; }");
            out.println("table { margin: auto; border-collapse: collapse; width: 80%; background-color: #fff; }");
            out.println("th, td { padding: 10px; text-align: center; border: 1px solid #ddd; }");
            out.println("th { background-color: #2F3C7E; color: white; }");
            out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Client's Sample History</h1>");
            out.println("<table>");
            out.println("<tr><th>Username</th><th>Fabric Type</th><th>Sample Quantity</th><th>Contact</th><th>Date</th></tr>");

            // Process the ResultSet and populate the infoList
            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getString("username") + "</td>");
                out.println("<td>" + resultSet.getString("fabric_type") + "</td>");
                out.println("<td>" + resultSet.getInt("sample_quantity") + "</td>");
                out.println("<td>" + resultSet.getLong("contact") + "</td>");
                out.println("<td>" + resultSet.getDate("date") + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

            out.close();

        } catch (SQLException e) {
            e.printStackTrace();
            // In case of database errors, you might handle the error here or redirect to an error page.
        }
    }
}
