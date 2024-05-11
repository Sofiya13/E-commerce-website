
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Client_view")
public class Client_view extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String URL = "jdbc:mysql://localhost:3306/register";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private List<Integer> excludedRecordIds = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String username = request.getParameter("username");
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sample WHERE username = '" + username + "' and (status != 'YES' OR status IS NULL)");

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            // Generate the HTML response
            out.println("<html>");
            out.println("<head><title>Admin Sample Data</title>");
            out.println("<link href='https://fonts.googleapis.com/css?family=Merienda' rel='stylesheet'>");
            out.println("<style>");
            out.println("body { font-family:'Merienda'; text-align: center;  background-image:url('http://www.pixelstalk.net/wp-content/uploads/2016/06/Photos-Light-Blue-HD-Backgrounds.jpg'); background-size: cover; background-repeat: no-repeat;}");
            out.println("table { border-collapse: collapse; margin: 20px auto; box-shadow: 0 0 30px rgba(0, 0, 0, 0.1); }");
            out.println("th, td { padding: 10px 20px; text-align: center; border: 2px solid #ddd; }");
            out.println("th { background-color: #2F3C7E; color: white; }");
            out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
            out.println("a { text-decoration: none; color: #E9EBE0; }");
            out.println("h1{ color: black;}");
            out.println("button { background-color: #2F3C7E; color: #FBEAEB; border: none; padding: 5px 10px; cursor: pointer; }");
            out.println("a:hover {  color:black;}");
            out.println("button:hover{background-color: #E9EBE0;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Admin Sample Data</h1>");
            out.println("<table>");
            out.println("<tr><th>Design</th><th>Color</th><th>Price</th><th>Date</th><th>Decision</th></tr>");

            // Process the ResultSet and populate the infoList
            while (resultSet.next()) {
                int recordId = resultSet.getInt("id");
                
                // Check if the record ID should be excluded
                if (excludedRecordIds.contains(recordId)) {
                    continue; // Skip this record
                }
                
                out.println("<tr>");
                out.println("<td><img src='" + request.getContextPath() + "/images/" + resultSet.getString("imgName") + "' width='100' height='100'></td>");
                out.println("<td style=\"text-align: center; vertical-align: middle;\"> <div style=\"height: 50px; width: 70px; background-color: " + resultSet.getString("color") + "; margin: auto;\"></div></td>");
                out.println("<td>" + resultSet.getInt("price") + "</td>");
                out.println("<td>" + resultSet.getDate("date") + "</td>");
                out.println("<td>");
                out.println("<button><a href='Before_challan?username=" + username +"&id=" + resultSet.getInt("id") +"'>Accept</a></button>" +
                	    "<button><a href='Client_view?username=" + username + "&delete=" + recordId + "'>Reject</a></button>");
                out.println("</td>");
                out.println("</tr>");
                
                // Check if the "delete" parameter is present in the request
                String deleteParam = request.getParameter("delete");
                if (deleteParam != null) {
                    int recordToDelete = Integer.parseInt(deleteParam);
                    // Exclude the record from being displayed
                    excludedRecordIds.add(recordToDelete);
                }
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

        } catch (SQLException e) {
            e.printStackTrace();
            // In case of database errors, you might handle the error here or redirect to an error page.
            return;
        }
    }
}