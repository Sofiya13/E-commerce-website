import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Otp_verifying")
public class Otp_verifying extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String URL = "jdbc:mysql://localhost:3306/register";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	String username;

	public boolean checkOTP(int otp1, int otp2) {
		if (otp1 == otp2) {
			return true;
		}
		else {
			return false;
		}
		
	}

	private void sendEmail(String to, String userpass, String from, String host, String username, String password) {
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("PASSWORD");

			message.setText("YOUR PASSWORD IS " + userpass);
			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		username = req.getParameter("username");
		int otp1 = Integer.parseInt(req.getParameter("otp"));
		System.out.println(otp1);
		int otp2 = 0;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM regist where username='" + username + "'");
			System.out.println(username);
			while (resultSet.next()) {
				otp2 = resultSet.getInt("otp");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean flag = checkOTP(otp1, otp2);
		if (otp1 == otp2) {
			String to = null;
			String pass = null;
			String from = "sofiyashaikh2420@gmail.com";
			String host = "smtp.gmail.com";
			String eusername = "sofiyashaikh2420@gmail.com";
			String password = "ysrvobmikehtczjv";

			try {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM regist where username='" + username + "'");
				while (resultSet.next()) {
					to = resultSet.getString("email");
					pass = resultSet.getString("password");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sendEmail(to, pass, from, host, eusername, password);

		}
	}

}
