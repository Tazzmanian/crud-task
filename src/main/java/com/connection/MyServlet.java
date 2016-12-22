package com.connection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
					dbcon.addPerson(request.getParameter("firstname"),
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
				// only read and fill the fields and set the button
				// TODO: Select
				ResultSet res = dbcon.getPersonByID(paramName.replaceAll("\\D+", ""));
				
				try {
					res.next();
					request.setAttribute("firstname", res.getString(1));
					request.setAttribute("lastname", res.getString(2));
					request.setAttribute("birthdate", res.getDate(3));
					request.setAttribute("number", res.getString(4));
					request.setAttribute("email", res.getString(5));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.setAttribute("addEditValue", "Edit");
				request.setAttribute("addEditName", ("change" + paramName.replaceAll("\\D+", "")));
				System.out.println("edit");
			} else if(paramName.matches("^change[0-9]+$")) {
				// change person's info
				RowData rowData = new RowData();
				rowData.validateInput(request.getParameter("firstname"),
									  request.getParameter("lastname"), 
									  request.getParameter("birthdate"), 
									  request.getParameter("number"), 
									  request.getParameter("email"));
				
				if(rowData.validationError() == null) {
					request.setAttribute("errMsg", "");
					dbcon.editPerson(request.getParameter("firstname"),
									request.getParameter("lastname"),
									request.getParameter("birthdate"), 
									request.getParameter("email"), 
									request.getParameter("number"),
									paramName.replaceAll("\\D+", ""));
					// TODO: params are in  the url after this. Need to remove them
				} else {
					request.setAttribute("errMsg", rowData.validationError());
					//System.out.println(rowData.validationError());
					request.setAttribute("firstname", request.getParameter("firstname"));
					request.setAttribute("lastname", request.getParameter("lastname"));
					request.setAttribute("birthdate", request.getParameter("birthdate"));
					request.setAttribute("number", request.getParameter("number"));
					request.setAttribute("email", request.getParameter("email"));
					request.setAttribute("addEditValue", "Edit");
					request.setAttribute("addEditName", paramName);
				}
			} else if(paramName.matches("^delete[0-9]+$")) {
				// TODO: delete the person
				dbcon.deletePerson(paramName.replaceAll("\\D+", ""));
				System.out.println("delete");
			} else if(paramName.matches("search")) {
				// TODO: should make 2 combobox for last name and date of birth with 3 values "", "a-z", "z-a"
				//System.out.println(request.getParameter("sortLastName"));
				//System.out.println(request.getParameter("sortDate"));
			}
	    }
		
		ResultSet res;
		
		if(false){
			
		} else {
			res = dbcon.getAllDataUnsorted();
		}
		
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
