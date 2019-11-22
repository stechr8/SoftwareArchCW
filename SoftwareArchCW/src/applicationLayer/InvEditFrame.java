package applicationLayer;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.DynAnyPackage.InvalidValue;

import businessLayer.InventoryManagement;
import objects.Product;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class InvEditFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtStock;

	static InventoryManagement invManage = new InventoryManagement();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvEditFrame frame = new InvEditFrame();
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
	public InvEditFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JCheckBox chckbx3f2 = new JCheckBox("3 for 2");
		chckbx3f2.setBounds(37, 221, 97, 23);
		contentPane.add(chckbx3f2);
		
		JCheckBox chckbxBogof = new JCheckBox("BOGOF");
		chckbxBogof.setBounds(130, 221, 97, 23);
		contentPane.add(chckbxBogof);
		
		JCheckBox chckbxFreeDelivery = new JCheckBox("Free Delivery");
		chckbxFreeDelivery.setBounds(229, 221, 97, 23);
		contentPane.add(chckbxFreeDelivery);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtID.setText("");
				txtName.setText("");
				txtPrice.setText("");
				txtStock.setText("");
				chckbx3f2.setSelected(false);
				chckbxBogof.setSelected(false);
				chckbxFreeDelivery.setSelected(false);

			}
		});
		btnClear.setBounds(130, 171, 89, 23);
		contentPane.add(btnClear);

		JButton btnUpdate = new JButton("Update Product");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					if(txtName.getText().equals("") || txtPrice.getText().equals("") || txtStock.getText().equals("")) {
						throw new Exception("Please fill out all fields");
					}

					int id = Integer.parseInt(txtID.getText());
					String name = txtName.getText();
					double price = Double.parseDouble(txtPrice.getText());
					int stock = Integer.parseInt(txtStock.getText());
					
					boolean threeForTwo = chckbx3f2.isSelected();
					boolean bogof = chckbxBogof.isSelected();
					boolean freeDel = chckbxFreeDelivery.isSelected();

					invManage.UpdateProduct(id, name, price, stock, threeForTwo, bogof, freeDel);

					btnClear.doClick();

					JOptionPane.showMessageDialog(InvEditFrame.this, name + " Updated successfully");


				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(InvEditFrame.this, "Please enter valid details");
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(InvEditFrame.this, ex.getMessage());
				}


			}
		});
		btnUpdate.setBounds(291, 93, 119, 23);
		contentPane.add(btnUpdate);

		JButton btnRemove = new JButton("Remove Product");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
					int id = Integer.parseInt(txtID.getText());

					boolean removed = invManage.RemoveProduct(id);

					if(removed) {

						btnClear.doClick();

						JOptionPane.showMessageDialog(InvEditFrame.this, "Product with ID: " + id + " successfully removed");

					}
					else{
						
						JOptionPane.showMessageDialog(InvEditFrame.this, "Product either does not exist or has failed to be removed");
						
					}

				}catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(InvEditFrame.this, "Please enter an integer value into the ID box");
				}

			}
		});
		btnRemove.setBounds(291, 127, 119, 23);
		contentPane.add(btnRemove);

		txtID = new JTextField();
		txtID.setToolTipText("");
		txtID.setColumns(10);
		txtID.setBounds(130, 50, 86, 20);
		contentPane.add(txtID);

		JLabel label = new JLabel("Product ID:");
		label.setBounds(48, 50, 60, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Product Name:");
		label_1.setBounds(37, 81, 71, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Price:");
		label_2.setBounds(78, 112, 34, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Stock Level:");
		label_3.setBounds(49, 143, 71, 14);
		contentPane.add(label_3);

		txtName = new JTextField();
		txtName.setToolTipText("");
		txtName.setColumns(10);
		txtName.setBounds(130, 78, 86, 20);
		contentPane.add(txtName);

		txtPrice = new JTextField();
		txtPrice.setToolTipText("");
		txtPrice.setColumns(10);
		txtPrice.setBounds(130, 109, 86, 20);
		contentPane.add(txtPrice);

		txtStock = new JTextField();
		txtStock.setToolTipText("");
		txtStock.setColumns(10);
		txtStock.setBounds(130, 140, 86, 20);
		contentPane.add(txtStock);

		JButton btnSearch = new JButton("Search Product");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
					int id = Integer.parseInt(txtID.getText());

					Product product = invManage.getProduct(id);

					if(product.getProductName().equals("")) {
						throw new Exception();
					}

					txtName.setText(product.getProductName());
					txtPrice.setText(Double.toString(product.getPrice()));
					txtStock.setText(Integer.toString(product.getStockLevel()));
					chckbx3f2.setSelected(product.isThreeForTwo());
					chckbxBogof.setSelected(product.isBogof());
					chckbxFreeDelivery.setSelected(product.isFreeDel());

				}catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(InvEditFrame.this, "Please enter an integer value into the ID box");
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(InvEditFrame.this, "No product with this ID");
				}

			}
		});
		btnSearch.setBounds(291, 59, 119, 23);
		contentPane.add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InvManageFrame invFrame = new InvManageFrame();
				invFrame.setVisible(true);
				InvEditFrame.this.setVisible(false);
			}
		});
		btnBack.setBounds(10, 313, 89, 23);
		contentPane.add(btnBack);

	}
}
