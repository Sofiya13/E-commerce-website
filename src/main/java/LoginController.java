
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDAO; // Assuming you have a UserDAO implementation

    @Override
    public void init() throws ServletException {
        // Initialize the UserDAO instance
    	setLoginDAO(new LoginDAO());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the form data
        String username = request.getParameter("username");
        request.setAttribute("username", username);
        String password = request.getParameter("password");
        // Get the user from the database
        UserLogin user = LoginDAO.getUserByUsername(username);
		
			

        // Check if the user exists and the password matches
        if (user != null && password.equals("root") && username.equals("sofuuu")) {

        	response.sendRedirect("admin.jsp");  	
        } 
        else if(user != null && user.getPassword().equals(password) && user.getUsername().equals(username)) {
        	response.sendRedirect("client.jsp?username="+username );
        }
        else {
        	response.sendRedirect("error.jsp");
        }
    }

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
}
