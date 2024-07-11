package Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import MainPackage.DBConnection;

public class AdminStatus {
	private int ID;
	private String Status;
	private String AppoimentDate;
	
	public AdminStatus(int ID, String Status, String AppoimentDate) {
		this.ID = ID;
		this.Status = Status;
		this.AppoimentDate = AppoimentDate;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	public String getAppoimentDate() {
		return AppoimentDate;
	}

	public void setAppoimentDate(String appoimentDate) {
		AppoimentDate = appoimentDate;
	}
	
	public void InsertStatus(int ID, String Status, String AppoimentDate) {
		DBConnection db = new DBConnection();
		Connection conn = db.connectDB();
		
		try {
			String sql = "INSERT INTO Application_Status (ID, Application_Status, AppoimentDate) VALUES (?, ?, ?)";
	
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, ID); 
			statement.setString(2, Status);
			statement.setString(3, AppoimentDate);
			
			
			int rowsInserted  = statement.executeUpdate();
			
			if (rowsInserted > 0) {
				System.out.println("Data inserted successfully!");
				JOptionPane.showMessageDialog(null, "Data inserted successfully!");

				}
				else {
					System.out.println("Data insertion Failed!");
					JOptionPane.showMessageDialog(null, "Data insertion Failed!");			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}
}
