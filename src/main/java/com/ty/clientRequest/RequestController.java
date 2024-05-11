package com.ty.clientRequest;
import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;
import java.awt.Color;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

@MultipartConfig
public class RequestController extends HttpServlet {
   
	private static final long serialVersionUID = 1L;
	private RequestDAO requestDAO;

    public void init() {
    	requestDAO = new RequestDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String fabricType = request.getParameter("fabric_type");
        int sampleQuantity = Integer.parseInt(request.getParameter("sample_quantity"));
       
        String contact = request.getParameter("contact");
        Date date = null;
        Part file=request.getPart("design_image");
        int price1 = Integer.parseInt(request.getParameter("price"));
        
        String hexValueStr = request.getParameter("hexValue");
      

        String imageFileName=file.getSubmittedFileName();
       
      
       String uploadpath = "C:/Users/Shaki/git/Final/Project/src/main/webapp/images/" + imageFileName;

      
        try
        {
        FileOutputStream fos=new FileOutputStream(uploadpath);
        InputStream is=file.getInputStream();
        byte[] data=new byte[is.available()];
        is.read(data);
        fos.write(data);
        fos.close();
        
        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
        try {
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
            date = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Client_request user = new Client_request();
        user.setUsername(username);
        user.setFabricType(fabricType);
        user.setSampleQuantity(sampleQuantity);
        user.setContact(contact);
        user.setDate(date);
        user.setImageFileName(imageFileName);
        user.setHexValue(hexValueStr);
        user.setPrice(price1);

        requestDAO.insertUser(user);

      
        response.sendRedirect("client.jsp?username="+ request.getParameter("username") ); 
    }
    public static String convertToHex(String htmlColor) {
        Color color = Color.decode(htmlColor);

        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        // Convert the RGB values to a hexadecimal color code
        String hexColor = String.format("#%02X%02X%02X", red, green, blue);

        return hexColor;
    }
}
