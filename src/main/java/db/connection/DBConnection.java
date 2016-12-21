package db.connection;

import java.util.List;
import java.sql.*;
import row.data.*;

public class DBConnection {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;	
	
	public DBConnection() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/person_schema", "teodor", "admin");
			stmt = con.createStatement();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public ResultSet getAllDataUnsorted(){
		try {
			rs = stmt.executeQuery("select * from person");
			
			//while(rs.next()){
				//System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getDate(3) 
				//		+ " " + rs.getString(4) + " " + rs.getString(5));
				//RowData temp = new RowData(rs.getString(1), rs.getString(2), rs.getString(3),
				//		rs.getString(4), rs.getString(5), rs.getInt(6));
			//}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//System.out.println(result);
		
		return rs;
	}

	public void closeConnection() {
		try{
			con.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String arg[]){
		DBConnection dbcon = new DBConnection();
		dbcon.getAllDataUnsorted();
		dbcon.closeConnection();
	}
}
