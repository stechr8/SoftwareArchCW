package objects;

//product details held in Inventory Database

public class Product {
	
	private int ProductID;
	private String ProductName;
	private double Price;
	private int StockLevel;
	
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getStockLevel() {
		return StockLevel;
	}
	public void setStockLevel(int stockLevel) {
		StockLevel = stockLevel;
	}
	

}
