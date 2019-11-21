package dataLayer;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InventoryDatabaseCommands inv = new InventoryDatabaseCommands();
		System.out.println(inv.getProduct(1).getProductName());

	}

}
