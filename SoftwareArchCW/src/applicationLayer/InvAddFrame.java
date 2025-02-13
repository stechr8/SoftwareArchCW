package applicationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLayer.InventoryManagement;
import dataLayer.InventoryDatabaseCommands;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class InvAddFrame extends JFrame {
	
	InventoryManagement invManage = new InventoryManagement();

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
		setBounds(100, 100, 450, 393);
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
		

		JCheckBox chckbx3for2 = new JCheckBox("3 for 2");
		chckbx3for2.setBounds(24, 192, 97, 23);
		contentPane.add(chckbx3for2);
		
		JCheckBox chckbxBogof = new JCheckBox("BOGOF");
		chckbxBogof.setBounds(160, 192, 97, 23);
		contentPane.add(chckbxBogof);
		
		JCheckBox chckbxFreeDelivery = new JCheckBox("Free Delivery");
		chckbxFreeDelivery.setBounds(293, 192, 97, 23);
		contentPane.add(chckbxFreeDelivery);
		

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtProductID.setText("");
				txtProductName.setText("");
				txtPrice.setText("");
				txtStock.setText("");
			}
		});
		btnClear.setBounds(171, 145, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {

					if(txtProductName.getText().equals("") || txtProductID.getText().equals("") 
							|| txtPrice.getText().equals("") || txtStock.getText().equals("")) {
						throw new Exception("Please fill out all fields");
					}

					int id = Integer.parseInt(txtProductID.getText());
					String name = txtProductName.getText();
					double price = Double.parseDouble(txtPrice.getText());
					int stock = Integer.parseInt(txtStock.getText());
					
					boolean threeForTwo = chckbx3for2.isSelected();
					boolean bogof = chckbxBogof.isSelected();
					boolean freeDel = chckbxFreeDelivery.isSelected();
					

					boolean added = invManage.addProduct(id, name, price, stock, threeForTwo, bogof, freeDel, InvAddFrame.this);
					
					if(added) {
						
						btnClear.doClick();
						JOptionPane.showMessageDialog(InvAddFrame.this, name + " added successfully");
					}
					else {
						
						throw new Exception("Product with this ID already exists or Product has failed to be added");
						
					}

				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(InvAddFrame.this, "Please enter valid details");
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(InvAddFrame.this, ex.getMessage());
				}
				
			}
		});
		
		btnAdd.setBounds(335, 23, 89, 23);
		contentPane.add(btnAdd);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				InvManageFrame invManageFrame = new InvManageFrame();
				invManageFrame.setVisible(true);
				InvAddFrame.this.setVisible(false);
				
			}
		});
		btnBack.setBounds(10, 320, 89, 23);
		contentPane.add(btnBack);
		
	}
}
