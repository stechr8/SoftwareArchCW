package dataLayer;

import objects.Product;

public interface InventoryDBInterface {

	void UpdateProduct(int productID, String productName, double price, int stock);
	
	void addProduct(int productID, String productName, double price, int stock);
	
	Product getProduct(int productID);
	
	void RemoveProduct(int productID);

}