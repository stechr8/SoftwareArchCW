package applicationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLayer.InventoryManagement;
import objects.Product;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUpdate = new JButton("Update Product");
		btnUpdate.setBounds(291, 93, 119, 23);
		contentPane.add(btnUpdate);
		
		JButton btnRemove = new JButton("Remove Product");
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
				    
				    txtName.setText(product.getProductName());
				    txtPrice.setText(Double.toString(product.getPrice()));
				    txtStock.setText(Integer.toString(product.getStockLevel()));
				    
				}catch (NumberFormatException ex) {
				    System.out.println("Not an int");
				}
				
			}
		});
		btnSearch.setBounds(291, 59, 119, 23);
		contentPane.add(btnSearch);
		
	}
}
