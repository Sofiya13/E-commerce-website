package com.ty.adminSendsSample;


import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;


@MultipartConfig
@WebServlet("/Admin_sampleController")
public class Admin_sampleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Admin_sampleDAO admin_sampleDAO;

    public void init() {
    	admin_sampleDAO = new Admin_sampleDAO();
    }
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        
        Admin_sample user = new Admin_sample();
       user.setUsername(request.getParameter("username"));
        user.setDate(date);
        user.setImageFileName(imageFileName);
        user.setHexValue(hexValueStr);
        user.setPrice(price1);

        admin_sampleDAO.insertUser(user);


        response.sendRedirect("Sample_details?username="+ request.getParameter("username") ); 
    }
	 public static String convertToHex(String htmlColor) {
	        Color color = Color.decode(htmlColor);

	        int red = color.getRed();
	        int green = color.getGreen();
	        int blue = color.getBlue();

	        String hexColor = String.format("#%02X%02X%02X", red, green, blue);

	        return hexColor;
	    }
}