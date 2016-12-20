package com.connection;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.connection.DBConnection;


@WebServlet(urlPatterns = "/index.html")
public class MyServlet  extends HttpServlet {	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		DBConnection dbcon = new DBConnection();
		dbcon.getAllDataUnsorted();
		dbcon.closeConnection();
		
		request.getRequestDispatcher("/WEB-INF/views/simple.jsp").forward(request, response);
	}
}
