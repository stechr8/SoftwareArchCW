package dataLayer;

import objects.Customer;

public interface CustomerDBInterface {

	void addCustomer(int customerID, String customerName, boolean hasLoyaltyCard);

	Customer getCustomer(int customerID);

	void RemoveCustomer(int customerID);

	void UpdateCustomer(int customerID, String customerName, boolean hasLoyaltyCard);

}