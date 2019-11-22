package objects;

//product details held in Inventory Database

public class Product {
	
	private int productID;
	private String productName;
	private double price;
	private int stockLevel;
	private boolean threeForTwo;
	private boolean bogof;
	private boolean freeDel;
	
	public Product() {}
	
	public Product(int productID, String productName, double price, int stock, boolean threeForTwo, boolean bogof, boolean freeDel) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.stockLevel = stock;
		this.threeForTwo = threeForTwo;
		this.bogof = bogof;
		this.freeDel = freeDel;
	}
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStockLevel() {
		return stockLevel;
	}
	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}
	public boolean isThreeForTwo() {
		return threeForTwo;
	}

	public void setThreeForTwo(boolean threeForTwo) {
		this.threeForTwo = threeForTwo;
	}

	public boolean isBogof() {
		return bogof;
	}

	public void setBogof(boolean bogof) {
		this.bogof = bogof;
	}

	public boolean isFreeDel() {
		return freeDel;
	}

	public void setFreeDel(boolean freeDel) {
		this.freeDel = freeDel;
	}
	

}
