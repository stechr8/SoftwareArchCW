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
		
		btnInvManage.setBounds(134, 92, 144, 23);
		contentPane.add(btnInvManage);
		
		JButton btnCustControl = new JButton("Customer Controls");
		btnCustControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CustomerSendEmailFrame custFrame = new CustomerSendEmailFrame();
				custFrame.setVisible(true);
				HomeFrame.this.setVisible(false);
				
			}
		});
		btnCustControl.setBounds(134, 146, 144, 23);
		contentPane.add(btnCustControl);
	}

}
