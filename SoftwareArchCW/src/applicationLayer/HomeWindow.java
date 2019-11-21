package applicationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;

public class HomeWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeWindow window = new HomeWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public HomeWindow() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnInvManage = new JButton("Manage Inventory");
		btnInvManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InvManageFrame invFrame = new InvManageFrame();
				invFrame.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		
		btnInvManage.setBounds(10, 11, 135, 23);
		frame.getContentPane().add(btnInvManage);
		
		JButton btnCustManage = new JButton("Manage Customers");
		btnCustManage.setBounds(146, 11, 144, 23);
		frame.getContentPane().add(btnCustManage);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(289, 11, 135, 23);
		frame.getContentPane().add(btnNewButton_2);		
		
	}
	
}
