package businessLayer;

import dataLayer.InventoryDatabaseCommands;
import objects.Product;

public class InventoryManagement {

	static InventoryDatabaseCommands invDB = new InventoryDatabaseCommands();

	public boolean addProduct(int productID, String productName, double price, int stock) {

		Product product = getProduct(productID);

		//if product already exists with this ID
		if(product.getProductName() != null) {

			return false;

		}else {

			//attempt add
			invDB.addProduct(productID, productName, price, stock);

			//try to retrieve product to test add success
			product = getProduct(productID);

			//if added return true
			if(product.getProductName() != null) {
				
				stockCheck(product);

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

	public void UpdateProduct(int productID, String productName, double price, int stock) {

		invDB.UpdateProduct(productID, productName, price, stock);
		
		Product product = new Product(productID, productName, price, stock);
		
		stockCheck(product);

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
	
	private void stockCheck(Product product) {
		
		if(product.getStockLevel() <= 5) {
			EmailFunctionality emFunc = new EmailFunctionality();
			emFunc.sendEmail(product.getProductID(), product.getProductName(), product.getStockLevel());
		}
		
	}


}
