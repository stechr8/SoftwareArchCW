package applicationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HomeFrame extends JFrame {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnInvManage = new JButton("Manage Inventory");
		btnInvManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InvManageFrame invFrame = new InvManageFrame();
				invFrame.setVisible(true);
				HomeFrame.this.setVisible(false);
				
			}
		});
		contentPane.setLayout(null);
		
		btnInvManage.setBounds(10, 11, 135, 23);
		contentPane.add(btnInvManage);
		
		JButton btnCustManage = new JButton("Manage Customers");
		btnCustManage.setBounds(146, 11, 144, 23);
		contentPane.add(btnCustManage);
	}

}
