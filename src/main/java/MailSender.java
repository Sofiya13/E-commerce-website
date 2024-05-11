import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@WebServlet("/MailSender")
public class MailSender extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String URL = "jdbc:mysql://localhost:3306/register";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public MailSender() {
        super();
    
    }
    String username1 ;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	username1= request.getParameter("username");
        String to = null;
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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM regist where username='" + username1 + "'");
            while (resultSet.next()) {
                to = resultSet.getString("email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

      sendEmail(to, from, host, eusername, password);

response.sendRedirect("Alert.jsp");
    }

    private void updateOtpInDatabase(String username1, int otp) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            String sql = "UPDATE regist SET otp = ? WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, otp);
            preparedStatement.setString(2, username1);
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

   

    private void sendEmail(String to, String from, String host, String username, String password) {
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
            message.setSubject("PASSWORD RECOVERY");

            int otp = generateRandom4DigitNumber();
            System.out.println(otp);
            updateOtpInDatabase(username1, otp);
            message.setText("OTP TO VERIFY: " + otp);
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    private int generateRandom4DigitNumber() {
        Random rand = new Random();
        int min = 1000;
        int max = 9999;
        int ret = rand.nextInt(max - min + 1) + min;
        return ret;
    }
}
