package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class HomeFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeFrame frame = new HomeFrame();
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
	public HomeFrame() {
		setBackground(new Color(153, 204, 255));
		setTitle("Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Passport Automation System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(150, 50, 700, 75);
		contentPane.add(lblNewLabel);
		
		JButton btn10 = new JButton("Apply Passport");
		btn10.setBackground(new Color(240, 240, 240));
		btn10.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ApplicationFrame().setVisible(true);
			}
		});
		btn10.setBounds(100, 300, 200, 50);
		contentPane.add(btn10);
		
		JButton btn11 = new JButton("Check status");
		btn11.setForeground(new Color(0, 0, 0));
		btn11.setBackground(new Color(255, 255, 255));
		btn11.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new StatusFrame().setVisible(true);
			}
		});
		btn11.setBounds(700, 300, 200, 50);
		contentPane.add(btn11);
		
		JButton btnNewButton = new JButton("Admin Login");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminLoginFrame().setVisible(true);
			}
		});
		btnNewButton.setBounds(400, 300, 200, 50);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ASD\\eclipse-workspace\\PassportAutomationSystem\\src\\wallpaperflare.com_wallpaper (2).jpg"));
		lblNewLabel_1.setBounds(0, 0, 986, 575);
		contentPane.add(lblNewLabel_1);
	}

}
