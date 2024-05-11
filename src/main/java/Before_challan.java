import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Before_challan")
public class Before_challan extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
		String jdbcUrl = "jdbc:mysql://localhost:3306/register";
        String dbUsername = "root";
        String dbPassword = "root";
    	 try {
             Class.forName("com.mysql.cj.jdbc.Driver");
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
    	  int id = Integer.parseInt(request.getParameter("id"));
        
              try {
            	  Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
                  PreparedStatement statement = connection.prepareStatement("UPDATE sample SET status = ? WHERE id = ?");
                  statement.setString(1, "YES");
                  statement.setInt(2, id);
                  statement.executeUpdate();
                 
                  response.sendRedirect("Client_challan.jsp?username=" +request.getParameter("username"));
                  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
 
         
    }

	
}
