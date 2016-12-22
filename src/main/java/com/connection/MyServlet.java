package com.connection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import row.data.RowData;
import db.connection.DBConnection;


@WebServlet(urlPatterns = "/index.html")
public class MyServlet  extends HttpServlet {	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		DBConnection dbcon = new DBConnection();
		
		List<String> tableContent = new ArrayList<String>();
		
		Enumeration<String> params = request.getParameterNames();
		request.setAttribute("addEditValue", "Add");
		request.setAttribute("addEditName", "add");
		while (params.hasMoreElements()) {
			String paramName = params.nextElement();
			// TODO: add/edit/update delete
			if(paramName.matches("add")) {
				request.setAttribute("addEditValue", "Add");
				request.setAttribute("addEditName", "add");
				RowData rowData = new RowData();
				rowData.validateInput(request.getParameter("firstname"),
									  request.getParameter("lastname"), 
									  request.getParameter("birthdate"), 
									  request.getParameter("number"), 
									  request.getParameter("email"));
				
				if(rowData.validationError() == null) {
					request.setAttribute("errMsg", "");
					dbcon.AddPerson(request.getParameter("firstname"),
									request.getParameter("lastname"),
									request.getParameter("birthdate"), 
									request.getParameter("email"), 
									request.getParameter("number"));
					// TODO: params are in  the url after this. Need to remove them
				} else {
					request.setAttribute("errMsg", rowData.validationError());
					//System.out.println(rowData.validationError());
					request.setAttribute("firstname", request.getParameter("firstname"));
					request.setAttribute("lastname", request.getParameter("lastname"));
					request.setAttribute("birthdate", request.getParameter("birthdate"));
					request.setAttribute("number", request.getParameter("number"));
					request.setAttribute("email", request.getParameter("email"));
				}
				
				System.out.println("add");
			} else if(paramName.matches("^edit[0-9]+$")) {
				request.setAttribute("addEditValue", "Edit");
				request.setAttribute("addEditName", paramName);
				// TODO: fill the fields
				System.out.println("edit");
			} else if(paramName.matches("^delete[0-9]+$")) {
				// TODO: delete the person
				System.out.println("delete");
			}
	    }
		
		ResultSet res = dbcon.getAllDataUnsorted();
		
		try {
			while(res.next()){
				String temp =    "<tr>"
								+ "<td>" + res.getString(1) + "</td>"
								+ "<td>" + res.getString(2) + "</td>"
								+ "<td>" + res.getDate(3) + "</td>"
								+ "<td>" + res.getString(4) + "</td>"
								+ "<td>" + res.getString(5) + "</td>"
								+ "<td><input type=\"submit\" value=\"edit\" name=\"edit" + res.getInt(6) + "\"></td>"
								+ "<td><input type=\"submit\" value=\"delete\" name=\"delete" + res.getInt(6) + "\"></td>"
								+ "</tr>";
				tableContent.add(temp);						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("tableContent", tableContent);		
		//dbcon.closeConnection();
		
		request.getRequestDispatcher("/WEB-INF/views/simple.jsp").forward(request, response);
	}
}
