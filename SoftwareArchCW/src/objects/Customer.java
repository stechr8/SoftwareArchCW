package objects;

public class Customer {
	
	private int customerID;
	private String customerName;
	private boolean hasLoyaltyCard;
	private String email;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
