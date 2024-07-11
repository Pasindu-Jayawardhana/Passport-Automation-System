package Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import MainPackage.DBConnection;

public class Status {
	private int SID;
	
	public Status(int SID) {
		this.SID = SID;
	}

	public int getSID() {
		return SID;
	}

	public void setSID(int sID) {
		SID = sID;
	}

	public void SearchStatus(int SID) {
		DBConnection db = new DBConnection();
		Connection conn = db.connectDB();
		
		try {
			String sql = "SELECT * FROM Application_Status WHERE SID = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, SID);
			
			ResultSet resultrows = stmt.executeQuery();
			
			if(resultrows.next()) {
				int ID = resultrows.getInt("ID");
				String Status = resultrows.getString("Application_Status");
				
				System.out.println("SID: "+SID+" ID: "+ID+"Status :"+Status);
			}
			else {
				System.out.println("Invalid ID");
			}
		}
		catch(SQLException e) {
			System.out.println("Failed!");
			System.out.println(e);
		}
	
	}
	
}
