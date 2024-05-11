import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Sample_details extends HttpServlet {
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

        String status = request.getParameter("status");
        String idParam = request.getParameter("id");
        int id = 0; // Initialize to some default value
        if (idParam != null) {
            try {
                id = Integer.parseInt(idParam);
            } catch (NumberFormatException e) {
                // Handle the case where the id parameter is not a valid integer
                e.printStackTrace();
            }
        }

        if (status != null && id != 0) {
            // Handle the "Accept" action here
            // Update the database with status = "yes" for the given id
            updateStatusInDatabase(status, id);
        }

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM info where status='yes'");

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            // Generate the HTML response
            out.println("<html>");
            out.println("<head><title> Request Details</title>");
            out.println("<link href='https://fonts.googleapis.com/css?family=Merienda' rel='stylesheet'>");
            out.println("<style>");
            out.println("body { font-family: Merienda; text-align: center; background-image:url('https://images.unsplash.com/photo-1517495306984-f84210f9daa8?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80'); background-size: cover; background-repeat: no-repeat; }");
            out.println("h1 { text-align: center; margin-top: 20px; }");
            out.println("table { border-collapse: collapse; margin: 20px auto; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); border-radius: 22px; }"); // Added border-radius
            out.println("th, td { padding: 10px 20px; text-align: center; border: 2px solid #ddd; }");
            out.println("th { background-color: #2F3C7E; color: white; }");
            out.println("tr:nth-child(even) { background-color: #fbe7f6; }");
            out.println("a { text-decoration: none; color: #E9EBE0; }");
            out.println("button { background-color: #2F3C7E; color: #FBEAEB; border: none; padding: 5px 10px; cursor: pointer; }");
            out.println("a:hover {  color:black;}");
            out.println("button:hover{background-color: #E9EBE0;}");            
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>All details of Sample</h1>");
            out.println("<table>");
            out.println("<tr><th>Username</th><th>Fabric Type</th><th>Sample Quantity</th><th>Price</th><th>Contact</th><th>Color Hexcode</th><th>Design Image</th><th>Date</th><th>Upload Sample</th><th>View Challan</th></tr>");

            // Process the ResultSet and populate the infoList
            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getString("username") + "</td>");
                out.println("<td>" + resultSet.getString("fabric_type") + "</td>");
                out.println("<td>" + resultSet.getInt("sample_quantity") + "</td>");
                out.println("<td>" + resultSet.getInt("price") + "</td>");
                out.println("<td>" + resultSet.getLong("contact") + "</td>");
                out.println("<td style=\"text-align: center; vertical-align: middle;\"> <div style=\"height: 50px; width: 70px; background-color: " + resultSet.getString("color") + "; margin: auto;\"></div></td>");
                out.println("<td><img src='" + request.getContextPath() + "/images/" + resultSet.getString("imgName") + "' width='100' height='100'></td>");
                out.println("<td>" + resultSet.getDate("date") + "</td>");
                out.println("<td>");
                out.println("<button><a href=\"Admin_sample.jsp?username=" + resultSet.getString("username") + "\">Upload Sample</a></button>");
                out.println("</td>");
                out.println("<td>");
                out.println("<button><a href=\"Admin_challan?username=" + resultSet.getString("username") + "\">View Challan</a></button>");
                out.println("</td>");
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

    private void updateStatusInDatabase(String status, int userId) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("UPDATE info SET status = ? WHERE id = ?")) {

            statement.setString(1, status);
            statement.setInt(2, userId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors
        }
    }
}
