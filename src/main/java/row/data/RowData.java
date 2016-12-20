package row.data;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RowData {
	private String firstName;
	private String lastName;
	private String birthDate;
	private String phoneNumber;
	private String email;
	private int id;
	
	private String errMsg;
	
	public RowData() {
		
	}
	
	public RowData(String firstName, String lastName, 
			String birthDate, String phoneNum, String email, int id){
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNum;
		this.email = email;
		this.id = id;
	}
	
	public void validateInput(String firstName,
							String lastName,
							String date,
							String number,
							String email){
		
		this.errMsg = "";
		
		if(firstName.matches("[a-zA-Z]+")){
			this.firstName = firstName;
		} else {
			this.errMsg = this.errMsg + " First name,";
		}
		
		if(lastName.matches("[a-zA-Z]+")){
			this.lastName = lastName;
		} else {
			this.errMsg = this.errMsg + " Last name,";
		}
		
		if(email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
			this.email = email;
		} else {
			this.errMsg = this.errMsg + " Email,";
		}
		
		if(number.matches("[0-9]+")){
			this.phoneNumber = number;
		} else {
			this.errMsg = this.errMsg + " Phone number,";
		}
		
		if(date.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$")){
			this.birthDate = date;
		} else {
			this.errMsg = this.errMsg + " Date of birth,";
		}
		
		if(this.errMsg.equals(""))
		{
			this.errMsg = null;
		} else {
			this.errMsg = "Error:" + this.errMsg;
		}
	}
	
	public String validationError(){
		if (this.errMsg == null) {
			return "";
		}
		
		return this.errMsg;
	}
	
	public static void main(String arg[]){
		RowData test = new RowData();
		test.validateInput("teodor", "todorov", "1987-06-02", "01", "tazz123@a123.asd");
		System.out.println(test.validationError());
	}
}
