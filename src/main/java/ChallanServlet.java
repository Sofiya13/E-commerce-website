import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ChallanServlet")
public class ChallanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String from = request.getParameter("username");
        System.out.println(from+"servlet");
        String to = "Admin";
       String user=request.getParameter("username");
       
        String quantity = request.getParameter("quantity");
        String productDetails = request.getParameter("productDetails");
        String rate = request.getParameter("rate");
        String finalAmount = request.getParameter("finalAmount");

        Challan challan = new Challan(from, to,Integer.parseInt(quantity), productDetails, Double.parseDouble(rate), Double.parseDouble(finalAmount), user);
        ChallanDAO challanDAO = new ChallanDAO();

        if (challanDAO.insertChallan(challan)) {
            response.getWriter().println("Challan inserted successfully.");
        } else {
            response.getWriter().println("Failed to insert challan.");
        }
        request.getRequestDispatcher("client.jsp").forward(request, response);
    }
}
