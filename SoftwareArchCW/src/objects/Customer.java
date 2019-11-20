package objects;

public class Customer {
	
	private int customerID;
	private String customerName;
	private boolean hasLoyaltyCard;
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public boolean isHasLoyaltyCard() {
		return hasLoyaltyCard;
	}
	public void setHasLoyaltyCard(boolean hasLoyaltyCard) {
		this.hasLoyaltyCard = hasLoyaltyCard;
	}
	

}
