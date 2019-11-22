package businessLayer;

import dataLayer.InventoryDatabaseCommands;
import objects.Product;

public class InventoryManagement {
	
	static InventoryDatabaseCommands invDB = new InventoryDatabaseCommands();
	
	public void addProduct(int productID, String productName, double price, int stock) {
		
		invDB.addProduct(productID, productName, price, stock);
		
	}
	
	public Product getProduct(int productID) {
		
		Product product = invDB.getProduct(productID);
		
		return product;
		
	}
	
	public void UpdateProduct(int productID, String productName, double price, int stock) {
		
		invDB.UpdateProduct(productID, productName, price, stock);
		
	}

}
