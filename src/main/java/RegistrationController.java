
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistrationController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO; // Assuming you have a UserDAO implementation

	@Override
	public void init() throws ServletException {
		
		userDAO = new UserDAO();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String contact = request.getParameter("contact");

		
		User newUser = new User(username, password, email, fullname, contact);

		
		boolean flag = userDAO.addUser(newUser);

		
		if (flag) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else {
			System.out.println("error.jsp");
		}
	}
}
