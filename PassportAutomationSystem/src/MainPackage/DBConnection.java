package MainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
		public DBConnection() {
			connectDB();
		}
		public Connection connectDB() {
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PassportDB","root","1234");
				System.out.println("success");
				return conn;
			}
			catch(SQLException e) {
				System.out.println("Connection failed");
				System.out.println(e);
				Connection conn = null;
				return conn;
			}
		}
				
		
			
	}
