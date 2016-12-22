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
	
	public ResultSet getPersonByID(String id){
		try {
			rs = stmt.executeQuery("SELECT * FROM person WHERE id=" + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//System.out.println(result);
		
		return rs;
	}
	
	public ResultSet search(String str, String sortLastName, String sortDate){
		boolean comma = false;
		String query = "SELECT * FROM person WHERE first_name LIKE '%" + str + "%' "
				+ "OR last_name LIKE '%" + str + "%' "
				+ "OR birth_date LIKE '%" + str + "%' "
				+ "OR email LIKE '%" + str + "%' "
				+ "OR phone LIKE '%" + str + "%' ";
		
		if(!sortLastName.matches("non") || !sortDate.matches("non")) {
			query += "ORDER BY";
		}
		
		if(sortLastName.matches("asc")) {
			query += " last_name ASC";
			comma = true;
		} else if (sortLastName.matches("des")) {
			query += " last_name DESC";
			comma = true;
		}
		
		if(sortDate.matches("asc")) {
			query = comma ? (query + ",") : query;
			query += " birth_date ASC";
			comma = true;
		} else if (sortDate.matches("des")) {
			query = comma ? (query + ",") : query;
			query += " birth_date DESC";
			comma = true;
		}
		
		System.out.println(query);
		
		try {
			rs = stmt.executeQuery(query);
			//while(rs.next()){
			//	System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getDate(3) 
			//			+ " " + rs.getString(4) + " " + rs.getString(5));
				//RowData temp = new RowData(rs.getString(1), rs.getString(2), rs.getString(3),
				//		rs.getString(4), rs.getString(5), rs.getInt(6));
			//}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//System.out.println(result);
		
		return rs;
	}
	
	public void addPerson(String firstName,
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
	
	public void editPerson(String firstName,
			String lastName,
			String date,
			String email,
			String phone,
			String id) {

		try {
			//stmt.executeUpdate("UPDATE person SET first_name='test', last_name='test1', birth_date='1921-12-01', phone='1238976321', email='test@test1.com' WHERE id=1");
			stmt.executeUpdate("UPDATE person "
					+ "SET first_name='" + firstName +"', "
					+ "last_name='" + lastName + "', "
					+ "birth_date='" + date + "', "
					+ "phone='" + phone + "', "
					+ "email='" + email + "' "
					+ "WHERE id=" + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deletePerson(String id) {
		try {
			stmt.executeUpdate("DELETE FROM person WHERE id=" + id);
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
		//dbcon.EditPerson("test", "test", "1978-12-12", "email@eamil.com", "0123456789", "3");
		//dbcon.deletePerson("1");
		dbcon.search("0123", "", "");
		dbcon.closeConnection();
	}
}
