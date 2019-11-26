package applicationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import businessLayer.ReportFunctionality;
import objects.ReportRow;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreReportsFrame extends JFrame {

	private JPanel contentPane;
	private JTable tblDisplay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreReportsFrame frame = new StoreReportsFrame();
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
	public StoreReportsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tblDisplay = new JTable();
		tblDisplay.setRowSelectionAllowed(false);
		tblDisplay.setBounds(10, 49, 414, 195);
		contentPane.add(tblDisplay);
		
		try {
			
			ReportFunctionality rptFunc = new ReportFunctionality();
			ArrayList<ReportRow> statsList = rptFunc.getStats();
			
			String columns[] = {"Month","Sales"};
			
			DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
			
			Object[] rowData = new Object[2];
			
			for(int i=0; i < statsList.size(); i++) {
				
				rowData[0] = statsList.get(i).getMonth();
				rowData[1] = statsList.get(i).getSales();
				
				tableModel.addRow(rowData);
				
			}
			
			tblDisplay.setModel(tableModel);
			
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(StoreReportsFrame.this, ex.getMessage());
			}
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(74, 24, 46, 14);
		contentPane.add(lblMonth);
		
		JLabel lblSales = new JLabel("Sales");
		lblSales.setBounds(286, 24, 46, 14);
		contentPane.add(lblSales);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HomeFrame hFrame = new HomeFrame();
				hFrame.setVisible(true);
				StoreReportsFrame.this.setVisible(false);
			}
		});
		btnBack.setBounds(10, 293, 89, 23);
		contentPane.add(btnBack);
		
	}
}
