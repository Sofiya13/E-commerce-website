import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Admin_challan")
public class Admin_challan extends HttpServlet {
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
            String on = request.getParameter("username");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM challan  WHERE username='" + on + "'");

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head><title>Admin side</title>");
            out.println("<link href='https://fonts.googleapis.com/css?family=Merienda' rel='stylesheet'>");
            out.println("<style>");
            out.println("a { text-decoration: none; color: black; }");
            out.println("body { font-family: Merienda;  background-image:url('https://wallpaperaccess.com/full/1152359.jpg'); background-size: cover; background-repeat: no-repeat;}");
            out.println("h1 { text-align: center; margin-top: 20px; color: black; }");
            out.println("h2 { text-align: center; margin-top: 10px; color: #333; }");
            out.println("table { margin: auto; border-collapse: collapse; width: 80%; background-color: #fff; }");
            out.println("th, td { padding: 10px; text-align: center; border: 3px solid #ddd; }");
            out.println("th { background-color: #2F3C7E; color: white; }");
            out.println("tr:nth-child(even) { background-color: #f2f2f2; }");

            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Client Sent's Challan</h1>");
            out.println("<h2>Your sample is successfully approved by the client and below is the order challan details.</h2>");
            out.println("<table>");
            out.println("<tr><th>From</th><th>To</th><th>Quantity</th><th>Product Details</th><th>Challan Number</th><th>Rate</th><th>Final Amount</th><th>Date</th></tr>");

            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getString("from_location") + "</td>");
                out.println("<td>" + resultSet.getString("to_location") + "</td>");
                out.println("<td>" + resultSet.getInt("quantity") + "</td>");
                out.println("<td>" + resultSet.getString("product_details") + "</td>");
                out.println("<td>" + resultSet.getObject("challan_number") + "</td>");
                out.println("<td>" + resultSet.getDouble("rate") + "</td>");                    
                out.println("<td>" + resultSet.getDouble("final_amount") + "</td>");
                out.println("<td>" + resultSet.getObject("date") + "</td>");

                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

            out.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
