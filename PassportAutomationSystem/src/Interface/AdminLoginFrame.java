package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AdminLoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UserName;
	private JPasswordField APassword;
	
	private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginFrame frame = new AdminLoginFrame();
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
	public AdminLoginFrame() {
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(350, 50, 300, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(150, 200, 120, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(150, 250, 120, 20);
		contentPane.add(lblNewLabel_2);
		
		UserName = new JTextField();
		UserName.setBackground(new Color(204, 204, 204));
		UserName.setBounds(300, 200, 550, 20);
		contentPane.add(UserName);
		UserName.setColumns(10);
		
		JButton LoginBtn = new JButton("Login");
		LoginBtn.setBackground(new Color(240, 240, 240));
		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == LoginBtn) {
		            String username = UserName.getText();
		            String password = new String(APassword.getPassword());
		            
		            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
		                JOptionPane.showMessageDialog(null, "Login successful!");
		                
		                setVisible(false);
						new AdminStatusFrame().setVisible(true);
		                
		            } else {
		                JOptionPane.showMessageDialog(null, "Login Failed!!! Invalid username or password. Please try again.");
		            }
		        }
				
			}
		});
		LoginBtn.setBounds(200, 475, 200, 50);
		contentPane.add(LoginBtn);
		
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
		
		APassword = new JPasswordField();
		APassword.setBackground(new Color(204, 204, 204));
		APassword.setBounds(300, 250, 550, 20);
		contentPane.add(APassword);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\ASD\\eclipse-workspace\\PassportAutomationSystem\\src\\wallpaperflare.com_wallpaper (2).jpg"));
		lblNewLabel_3.setBounds(0, 0, 986, 575);
		contentPane.add(lblNewLabel_3);
	}
}
