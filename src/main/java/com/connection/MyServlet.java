package com.connection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
		ResultSet res = dbcon.getAllDataUnsorted();
		List<String> tableContent = new ArrayList<String>();
		
		try {
			while(res.next()){
				String temp =    "<tr>"
								+ "<td>" + res.getString(1) + "</td>"
								+ "<td>" + res.getString(2) + "</td>"
								+ "<td>" + res.getDate(3) + "</td>"
								+ "<td>" + res.getString(4) + "</td>"
								+ "<td>" + res.getString(5) + "</td>"
								+ "<td>edit</td>"
								+ "<td>delete</td>"
								+ "</tr>";
				tableContent.add(temp);						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("tableContent", tableContent);		
		dbcon.closeConnection();
		
		request.getRequestDispatcher("/WEB-INF/views/simple.jsp").forward(request, response);
	}
}
