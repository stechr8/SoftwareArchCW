package businessLayer;

import dataLayer.InventoryDatabaseCommands;

public class InventoryManagement {
	
	static InventoryDatabaseCommands invDB = new InventoryDatabaseCommands();
	
	public void addProduct(int productID, String productName, double price, int stock) {
		
		invDB.addProduct(productID, productName, price, stock);
		
	}

}
