package businessLayer;

import javax.swing.JOptionPane;

import org.slf4j.LoggerFactory;

import applicationLayer.InvAddFrame;
import dataLayer.InventoryDatabaseCommands;
import objects.Product;

public class InventoryManagement {
	
	private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(InventoryManagement.class);

	static InventoryDatabaseCommands invDB = new InventoryDatabaseCommands();

	public boolean addProduct(int productID, String productName, double price, int stock,
			boolean threeForTwo, boolean bogof, boolean freeDel, InvAddFrame frame) throws Exception {

		Product product = getProduct(productID);

		//if product already exists with this ID
		if(product.getProductName() != null) {

			return false;

		}else {

			//attempt add
			invDB.addProduct(productID, productName, price, stock, threeForTwo, bogof, freeDel);

			//try to retrieve product to test add success
			product = getProduct(productID);

			//if added return true
			if(product.getProductName() != null) {

				try {
					stockCheck(product);
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(frame, ex.getMessage());
				}

				return true;
			}

			//in any other case return false (not added)
			return false;

		}

	}

	public Product getProduct(int productID) {

		Product product = invDB.getProduct(productID);

		return product;

	}

	public void UpdateProduct(int productID, String productName, double price, int stock, 
			boolean threeForTwo, boolean bogof, boolean freeDel) throws Exception {
			
			invDB.UpdateProduct(productID, productName, price, stock, threeForTwo, bogof, freeDel);

			Product product = new Product(productID, productName, price, stock, threeForTwo, bogof, freeDel);

			try {
				stockCheck(product);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}

	}

	public boolean RemoveProduct(int productID) {

		Product product = getProduct(productID);

		//if product does not exist to begin with
		if(product.getProductName() == null) {

			return false;

		}else {

			//attempt removal
			invDB.RemoveProduct(productID);

			//try to retrieve product to test removal success
			product = getProduct(productID);

			//if removed return true
			if(product.getProductName() == null) {

				return true;
			}

			//in any other case return false (not removed)
			return false;

		}
	}

	private void stockCheck(Product product) throws Exception {
		
		try {
			if(product.getStockLevel() <= 5) {
			EmailFunctionality emFunc = new EmailFunctionality();
			emFunc.sendStockEmail(product.getProductID(), product.getProductName(), product.getStockLevel());
		}
		}
		catch(Exception ex) {
			LOGGER.error(ex.getMessage());
			throw new Exception("An issue occurred in sending a stock alert email");
		}

		

	}


}
