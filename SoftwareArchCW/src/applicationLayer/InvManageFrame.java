package applicationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InvManageFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvManageFrame frame = new InvManageFrame();
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
	public InvManageFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSearchProduct = new JButton("Search Product");
		btnSearchProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		
		btnSearchProduct.setBounds(154, 32, 119, 23);
		contentPane.add(btnSearchProduct);
		
		JButton btnUpdateProduct = new JButton("Update Product");
		btnUpdateProduct.setBounds(154, 134, 119, 23);
		contentPane.add(btnUpdateProduct);
		
		JButton btnRemoveProduct = new JButton("Remove Product");
		btnRemoveProduct.setBounds(154, 100, 119, 23);
		contentPane.add(btnRemoveProduct);
		
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InvAddFrame invAddFrame = new InvAddFrame();
				invAddFrame.setVisible(true);
				InvManageFrame.this.setVisible(false);
				
			}
		});
		btnAddProduct.setBounds(154, 66, 119, 23);
		contentPane.add(btnAddProduct);
	}
}
