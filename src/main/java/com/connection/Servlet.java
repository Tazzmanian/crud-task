package com.connection;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.connection.DBConnection;


@WebServlet(urlPatterns = "/index.html")
public class Servlet  extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
		/*
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Yahoo!!!!!!!!</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("My First Servlet");
		writer.println("</body>");
		writer.println("</html>"); */
		
		//String name = request.getParameter("name");
		
		//request.setAttribute("name", name);
		
		//System.out.println(name);
		
		DBConnection dbcon = new DBConnection();
		dbcon.getAllDataUnsorted();
		dbcon.closeConnection();
		
		request.getRequestDispatcher("/WEB-INF/views/simple.jsp").forward(request, response);
	}

	/*public static void main(String arg[]){
		DBConnection dbcon = new DBConnection();
		dbcon.getAllDataUnsorted();
		dbcon.closeConnection();
	}*/
}
