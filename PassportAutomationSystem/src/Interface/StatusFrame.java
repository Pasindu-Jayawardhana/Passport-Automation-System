package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import MainPackage.DBConnection;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class StatusFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatusFrame frame = new StatusFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public StatusFrame() {
		
		setTitle("Status & Appointment Date");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Status & Appointment Date");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(250, 50, 500, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Applicent ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(150, 200, 120, 20);
		contentPane.add(lblNewLabel_1);
		
		txtSearch = new JTextField();
		txtSearch.setBackground(new Color(204, 204, 204));
		txtSearch.setBounds(300, 200, 550, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(240, 240, 240));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String SID = txtSearch.getText();
//				int intSID = Integer.parseInt(SID);
//				
//				Status ob = new Status(intSID);
//				ob.SearchStatus(intSID);
//				
//				txtSearch.setText("");
				
				String ID = txtSearch.getText();

                // Convert identityNumberStr to long
                int intID = Integer.parseInt(ID);

                try {
                	DBConnection db = new DBConnection();
            		Connection conn = db.connectDB();

                    // SQL query to select status and appointment date based on identity number
                    String sql = "SELECT ID, Application_Status, AppoimentDate FROM Application_Status WHERE ID = ?";
                    
                    PreparedStatement statement = conn.prepareStatement(sql);
                    
                    statement.setLong(1, intID);
                    
                    ResultSet resultSet = statement.executeQuery();

                    // Create a DefaultTableModel to hold the query result
                    DefaultTableModel model = new DefaultTableModel();

                    // Add the column names to the table model
                    model.addColumn("Status ID");
                    model.addColumn("Passport Status");
                    model.addColumn("Appoiment Date");

                    // Add the query result to the table model
                    if (resultSet.next()) {
                    	String StatusID = resultSet.getString("ID");
                        String passportStatus = resultSet.getString("Application_Status");
                        String AppoimentDate = resultSet.getString("AppoimentDate");
                        model.addRow(new Object[]{StatusID, passportStatus, AppoimentDate});
                    } else {
                        // No record found for the provided identity number
                        model.addRow(new Object[]{"Record Not Found", "Record Not Found", "Record Not Found"});
                    }

                    // Set the model to the table
                    table.setModel(model);

                    // Close the resources
                    resultSet.close();
                    statement.close();
                    conn.close();
                } 
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
                txtSearch.setText("");
            }
			
			
		});
		btnSearch.setBounds(200, 475, 200, 50);
		contentPane.add(btnSearch);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new HomeFrame().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(600, 475, 200, 50);
		contentPane.add(btnNewButton_1);
		
		table = new JTable();
		table.setBounds(150, 250, 700, 150);
		contentPane.add(table);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ASD\\eclipse-workspace\\PassportAutomationSystem\\src\\wallpaperflare.com_wallpaper (2).jpg"));
		lblNewLabel_2.setBounds(0, 0, 986, 575);
		contentPane.add(lblNewLabel_2);
	}
}
