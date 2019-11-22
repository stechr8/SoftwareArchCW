package applicationLayer;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import businessLayer.InventoryManagement;
import objects.Product;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InvManageFrame extends JFrame {

	private JPanel contentPane;
	static InventoryManagement invManage;

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
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HomeFrame homeFrame = new HomeFrame();
				homeFrame.setVisible(true);
				InvManageFrame.this.setVisible(false);
			}
		});
		btnBack.setBounds(10, 227, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnSearchProduct = new JButton("Search Product");
		btnSearchProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				InvEditFrame invEditFrame = new InvEditFrame();
				invEditFrame.setVisible(true);
				
			}
		});
		
		btnSearchProduct.setBounds(154, 32, 119, 23);
		contentPane.add(btnSearchProduct);
		
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InvAddFrame invAddFrame = new InvAddFrame();
				invAddFrame.setVisible(true);
				
			}
		});
		btnAddProduct.setBounds(154, 66, 119, 23);
		contentPane.add(btnAddProduct);
	}
}
