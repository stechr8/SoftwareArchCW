package businessLayer;

import dataLayer.InventoryDBInterface;
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

}
