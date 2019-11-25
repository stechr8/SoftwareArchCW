package applicationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLayer.CustomerControl;
import objects.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerSendEmailFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;

	static CustomerControl custControl = new CustomerControl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerSendEmailFrame frame = new CustomerSendEmailFrame();
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
	public CustomerSendEmailFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setBounds(43, 73, 71, 14);
		contentPane.add(lblCustomerId);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(71, 104, 31, 14);
		contentPane.add(lblName);

		JLabel lblShowID = new JLabel("");
		lblShowID.setBounds(124, 73, 123, 14);
		contentPane.add(lblShowID);

		JLabel lblShowName = new JLabel("");
		lblShowName.setBounds(124, 104, 123, 14);
		contentPane.add(lblShowName);

		txtSearch = new JTextField();
		txtSearch.setBounds(45, 27, 86, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSendPromotion = new JButton("Send Promotion");
		btnSendPromotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					int id = Integer.parseInt(lblShowID.getText());
					String name = lblShowName.getText();
					
					custControl.sendLoyaltyEmail(id, name);
					
					JOptionPane.showMessageDialog(CustomerSendEmailFrame.this, "Promotional E-Mail sent");
					
					btnSendPromotion.setEnabled(false);
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(CustomerSendEmailFrame.this, ex.getMessage());
				}
				
			}
		});
		btnSendPromotion.setBounds(292, 227, 132, 23);
		contentPane.add(btnSendPromotion);
		btnSendPromotion.setEnabled(false);

		JButton btnSearchId = new JButton("Search ID");
		btnSearchId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if(txtSearch.getText().equals("")) {
						throw new Exception("Please enter a customer ID");	
					}

					int customerID = Integer.parseInt(txtSearch.getText());

					Customer customer = custControl.getCustomer(customerID);

					lblShowID.setText(Integer.toString(customer.getCustomerID()));
					lblShowName.setText(customer.getCustomerName());

					btnSendPromotion.setEnabled(true);

				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(CustomerSendEmailFrame.this, ex.getMessage());
				}

			}

		});

		btnSearchId.setBounds(141, 26, 89, 23);
		contentPane.add(btnSearchId);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HomeFrame hFrame = new HomeFrame();
				hFrame.setVisible(true);
				CustomerSendEmailFrame.this.setVisible(false);
				
			}
		});
		btnBack.setBounds(10, 227, 89, 23);
		contentPane.add(btnBack);
	}
}
