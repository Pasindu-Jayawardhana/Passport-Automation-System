package Interface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ApplicationFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField A1;
	private JTextField A2;
	private JTextField A3;
	private JTextField A4;
	private JTextField A5;
	private JTextField A6;
	private JTextField A7;
	private JTextField A8;
	private JTextField A9;
	private JTextField A10;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationFrame frame = new ApplicationFrame();
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
	public ApplicationFrame() {
		setTitle("Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Application Form");
		lblNewLabel.setBounds(350, 50, 300, 40);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Frist Name");
		lblNewLabel_1.setBounds(150, 160, 120, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Birth Date");
		lblNewLabel_2.setBounds(150, 250, 120, 20);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(150, 280, 120, 20);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setBounds(150, 310, 120, 20);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ID Number");
		lblNewLabel_5.setBounds(150, 340, 120, 20);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setBounds(150, 400, 120, 20);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Phone Number");
		lblNewLabel_8.setBounds(150, 370, 120, 20);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_8);
		
		A1 = new JTextField();
		A1.setBackground(new Color(204, 204, 204));
		A1.setBounds(300, 130, 550, 20);
		contentPane.add(A1);
		A1.setColumns(10);
		
		A2 = new JTextField();
		A2.setBackground(new Color(204, 204, 204));
		A2.setBounds(300, 160, 550, 20);
		contentPane.add(A2);
		A2.setColumns(10);
		
		A5 = new JTextField();
		A5.setBackground(new Color(204, 204, 204));
		A5.setBounds(300, 250, 550, 20);
		contentPane.add(A5);
		A5.setColumns(10);
		
		A6 = new JTextField();
		A6.setBackground(new Color(204, 204, 204));
		A6.setBounds(300, 280, 550, 20);
		contentPane.add(A6);
		A6.setColumns(10);
		
		A7 = new JTextField();
		A7.setBackground(new Color(204, 204, 204));
		A7.setBounds(300, 310, 550, 20);
		contentPane.add(A7);
		A7.setColumns(10);
		
		A8 = new JTextField();
		A8.setBackground(new Color(204, 204, 204));
		A8.setBounds(300, 340, 550, 20);
		contentPane.add(A8);
		A8.setColumns(10);
		
		A9 = new JTextField();
		A9.setBackground(new Color(204, 204, 204));
		A9.setBounds(300, 370, 550, 20);
		contentPane.add(A9);
		A9.setColumns(10);
		
		JButton btn1 = new JButton("Apply");
		btn1.setForeground(new Color(0, 0, 0));
		btn1.setBackground(new Color(240, 240, 240));
		btn1.setBounds(200, 475, 200, 50);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ID = A1.getText();
				int intID = Integer.parseInt(ID);
				String FristName = A2.getText();
				String MiddleName = A3.getText();
				String LastName = A4.getText();
				String DOB = A5.getText();
				String Address = A6.getText();
				String Gender = A7.getText();
				String IDNumber = A8.getText();
				Long intIDNumber = Long.parseLong(IDNumber);
				String PhoneNumber = A9.getText();
				int intPhoneNumber = Integer.parseInt(PhoneNumber);
				String Email = A10.getText();
				
				try {
	    	        Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/IDDB", "root", "1234");
	    	        
	    	        String sqlCheck = "SELECT IDNo FROM IDInfo WHERE IDNo = ?";
	    	        
	    	        PreparedStatement checkStatement = conn1.prepareStatement(sqlCheck);
	    	        
	    	        checkStatement.setLong(1, intIDNumber);
	    	        
	    	        ResultSet resultSet = checkStatement.executeQuery();
	    	        
	    	        if (!resultSet.next()) {
	    	            JOptionPane.showMessageDialog(null, "National ID not found.");

	    	            return;
	    	        }
	    	        else {
	    	        	JOptionPane.showMessageDialog(null, "National ID found. Apply successfully");
	    	        }
	    	        
	    	        checkStatement.close();
	    	        conn1.close();
				}
				catch(SQLException ex) {
					System.out.println(e);
				}
				
				Application ob = new Application(intID, FristName, MiddleName, LastName, DOB, Address, Gender, intIDNumber, intPhoneNumber, Email);
				ob.ApplyApplicant(intID, FristName, MiddleName, LastName, DOB, Address, Gender, intIDNumber, intPhoneNumber, Email);
				
				A1.setText("");
				A2.setText("");
				A3.setText("");
				A4.setText("");
				A5.setText("");
				A6.setText("");
				A7.setText("");
				A8.setText("");
				A9.setText("");
				A10.setText("");
				
				
			}
		});
		contentPane.add(btn1);
		
		JLabel lblNewLabel_6 = new JLabel("ID");
		lblNewLabel_6.setBounds(150, 130, 120, 20);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_6);
		
		A10 = new JTextField();
		A10.setBackground(new Color(204, 204, 204));
		A10.setBounds(300, 400, 550, 20);
		contentPane.add(A10);
		A10.setColumns(10);
		
		JButton btn3 = new JButton("Back");
		btn3.setBackground(new Color(240, 240, 240));
		btn3.setBounds(600, 475, 200, 50);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new HomeFrame().setVisible(true);
			}
		});
		contentPane.add(btn3);
		
		A3 = new JTextField();
		A3.setBackground(new Color(204, 204, 204));
		A3.setBounds(300, 190, 550, 20);
		contentPane.add(A3);
		A3.setColumns(10);
		
		A4 = new JTextField();
		A4.setBackground(new Color(204, 204, 204));
		A4.setBounds(300, 220, 550, 20);
		contentPane.add(A4);
		A4.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Middle Name");
		lblNewLabel_9.setBounds(150, 190, 120, 20);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Last Name");
		lblNewLabel_10.setBounds(150, 220, 120, 20);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setOpaque(true);
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\ASD\\eclipse-workspace\\PassportAutomationSystem\\src\\wallpaperflare.com_wallpaper (2).jpg"));
		lblNewLabel_11.setBounds(0, 0, 986, 575);
		contentPane.add(lblNewLabel_11);
	}
}
