package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AdminStatusFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField T1;
	private JTextField T2;
	private JTextField T3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStatusFrame frame = new AdminStatusFrame();
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
	public AdminStatusFrame() {
		setTitle("Admin panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Panel");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(350, 50, 300, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Application ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(150, 200, 150, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Application Status");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(150, 250, 150, 20);
		contentPane.add(lblNewLabel_2);
		
		T1 = new JTextField();
		T1.setBackground(new Color(204, 204, 204));
		T1.setBounds(300, 200, 550, 20);
		contentPane.add(T1);
		T1.setColumns(10);
		
		T2 = new JTextField();
		T2.setBackground(new Color(204, 204, 204));
		T2.setBounds(300, 250, 550, 20);
		contentPane.add(T2);
		T2.setColumns(10);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = T1.getText();
				int intID = Integer.parseInt(ID);
				String Status = T2.getText();
				String AppoimentDate = T3.getText();
				
				
				AdminStatus ob = new AdminStatus(intID, Status, AppoimentDate);
				ob.InsertStatus(intID, Status, AppoimentDate);
				
				T1.setText("");
				T2.setText("");
				T3.setText("");
			}
		});
		btnNewButton.setBounds(200, 475, 200, 50);
		contentPane.add(btnNewButton);
		
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
		
		JLabel lblNewLabel_4 = new JLabel("Appoiment Date");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(150, 300, 150, 20);
		contentPane.add(lblNewLabel_4);
		
		T3 = new JTextField();
		T3.setBackground(new Color(204, 204, 204));
		T3.setBounds(300, 300, 550, 20);
		contentPane.add(T3);
		T3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\ASD\\eclipse-workspace\\PassportAutomationSystem\\src\\wallpaperflare.com_wallpaper (2).jpg"));
		lblNewLabel_3.setBounds(0, 0, 986, 575);
		contentPane.add(lblNewLabel_3);
	}
}
