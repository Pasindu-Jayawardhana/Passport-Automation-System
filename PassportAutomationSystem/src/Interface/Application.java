package Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import MainPackage.DBConnection;

public class Application {
	private int ID;
	private String FristName;
	private String MiddleName;
	private String LastName;
	private String DOB;
	private String Address;
	private String Gender;
	private Long IDNumber;
	private int PhoneNumber;
	private String Email;
	
	public Application(int ID, String FristName, String MiddleName, String LastName, String DOB, String Address, String Gender, Long IDNumber, int PhoneNumber, String Email) {
		this.ID = ID;
		this.FristName = FristName;
		this.MiddleName = MiddleName;
		this.LastName = LastName;
		this.DOB = DOB;
		this.Address = Address;
		this.Gender = Gender;
		this.IDNumber = IDNumber;
		this.PhoneNumber = PhoneNumber;
		this.Email = Email;
	}
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID= ID;
	}
	
	public String getFristName() {
		return FristName;
	}
	public void setFristName(String FristName) {
		this.FristName= FristName;
	}
	
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String MiddleName) {
		this.MiddleName= MiddleName;
	}
	
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String LastName) {
		this.LastName= LastName;
	}
	
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String DOB) {
		this.DOB= DOB;
	}
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address= Address;
	}
	
	public String getGender() {
		return Gender;
	}
	public void setGender(String Gender) {
		this.Gender= Gender;
	}
	
	public Long getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(Long IDNumber) {
		this.IDNumber= IDNumber;
	}
	
	public int getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(int PhoneNumber) {
		this.PhoneNumber= PhoneNumber;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email= Email;
	}
	
	public void ApplyApplicant(int ID, String FristName, String MiddleName, String LastName, String DOB, String Address, String Gender, Long IDNumber, int PhoneNumber, String Email) {
		DBConnection db = new DBConnection();
		Connection conn = db.connectDB();
		
		try {
			String sql = "INSERT INTO Applicant (ID, FristName, MiddleName, LastName, DOB, Address, Gender, IDNumber, PhoneNumber, Email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, ID); 
			statement.setString(2, FristName);
			statement.setString(3, MiddleName);
			statement.setString(4, LastName);
			statement.setString(5, DOB);
			statement.setString(6, Address);
			statement.setString(7, Gender);
			statement.setLong(8, IDNumber); 
			statement.setInt(9, PhoneNumber); 
			statement.setString(10, Email);
			
			int rowsInserted  = statement.executeUpdate();
			
			if (rowsInserted > 0) {
				System.out.println("Data inserted successfully!");
				JOptionPane.showMessageDialog(null, "Data inserted successfully       Application ID: " + ID);

				}
				else {
				System.out.println("Data insertion Failed!");
				JOptionPane.showMessageDialog(null, "Data insertion failed!");
				}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}
}
