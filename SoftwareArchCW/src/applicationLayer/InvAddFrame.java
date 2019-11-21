package applicationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dataLayer.InventoryDatabaseCommands;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InvAddFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtProductID;
	private JTextField txtProductName;
	private JTextField txtPrice;
	private JTextField txtStock;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvAddFrame frame = new InvAddFrame();
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
	public InvAddFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtProductID = new JTextField();
		txtProductID.setToolTipText("");
		txtProductID.setBounds(171, 24, 86, 20);
		contentPane.add(txtProductID);
		txtProductID.setColumns(10);
		
		JLabel label = new JLabel("Product ID:");
		label.setBounds(89, 24, 60, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Product Name:");
		label_1.setBounds(78, 55, 71, 14);
		contentPane.add(label_1);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(119, 86, 34, 14);
		contentPane.add(lblPrice);
		
		JLabel lblStockLevel = new JLabel("Stock Level:");
		lblStockLevel.setBounds(90, 117, 71, 14);
		contentPane.add(lblStockLevel);
		
		txtProductName = new JTextField();
		txtProductName.setToolTipText("");
		txtProductName.setColumns(10);
		txtProductName.setBounds(171, 52, 86, 20);
		contentPane.add(txtProductName);
		
		txtPrice = new JTextField();
		txtPrice.setToolTipText("");
		txtPrice.setColumns(10);
		txtPrice.setBounds(171, 83, 86, 20);
		contentPane.add(txtPrice);
		
		txtStock = new JTextField();
		txtStock.setToolTipText("");
		txtStock.setColumns(10);
		txtStock.setBounds(171, 114, 86, 20);
		contentPane.add(txtStock);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//read in input data
				int id = Integer.parseInt(txtProductID.getText());
				String productName = txtProductName.getText();
				double price = Double.parseDouble(txtPrice.getText());
				int stock = Integer.parseInt(txtStock.getText());
				
				InventoryDatabaseCommands invDB = new InventoryDatabaseCommands();
				
				invDB.addProduct(id, productName, price, stock);
				
				clear();
				
				JOptionPane.showMessageDialog(InvAddFrame.this, productName + " Added");
				
			}
		});
		btnAdd.setBounds(168, 145, 89, 23);
		contentPane.add(btnAdd);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				InvManageFrame invManageFrame = new InvManageFrame();
				invManageFrame.setVisible(true);
				InvAddFrame.this.setVisible(false);
				
			}
		});
		btnBack.setBounds(10, 227, 89, 23);
		contentPane.add(btnBack);
	}
	
	public void clear() {
		txtProductID.setText("");
		txtProductName.setText("");
		txtPrice.setText("");
		txtStock.setText("");
	}
}
