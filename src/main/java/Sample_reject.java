

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

/**
 * Servlet implementation class Reject
 */
@WebServlet("/Reject")
public class Sample_reject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	    private static final String URL = "jdbc:mysql://localhost:3306/register";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "root";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		  try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }

	      
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
	        if (id != 0) {
	            // Handle the "Accept" action here
	            // Update the database with status = "yes" for the given id
	            updateStatusInDatabase( id);
	        }
	}
	        
	        private void updateStatusInDatabase( int userId) {
	            try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	                 PreparedStatement statement = connection.prepareStatement("DELETE from info WHERE id = ?")) {

	                
	                statement.setInt(1, userId);
	                statement.executeUpdate();

	            } catch (SQLException e) {
	                e.printStackTrace();
	                // Handle database errors
	            }
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


