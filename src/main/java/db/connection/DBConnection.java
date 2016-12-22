package db.connection;

import java.sql.*;

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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//System.out.println(result);
		
		return rs;
	}
	
	public void AddPerson(String firstName,
						String lastName,
						String date,
						String email,
						String phone) {
		
		try {
			stmt.executeUpdate("INSERT INTO person(first_name, last_name, birth_date, phone, email) "
							+ "VALUE('" + firstName + "','"
										+ lastName + "','"
										+ date + "','"
										+ phone +"','"
										+ email + "')");
			//stmt.executeUpdate("INSERT INTO person(first_name, last_name, birth_date, phone, email) "
			//		+ "VALUE('test','test','1999-12-12','0123456789','test@test.test')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		//dbcon.getAllDataUnsorted();
		dbcon.AddPerson("test", "test", "1978-12-12", "email@eamil.com", "0123456789");
		dbcon.closeConnection();
	}
}
