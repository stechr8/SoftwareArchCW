package businessLayer;

import dataLayer.CustomerDatabaseCommands;
import objects.Customer;

public class CustomerControl {

	static CustomerDatabaseCommands custDB = new CustomerDatabaseCommands();

	public Customer getCustomer(int customerID) throws Exception{

			Customer customer = custDB.getCustomer(customerID);
			
			if(customer.getCustomerName().equals("")) {
				throw new Exception("Customer does not exist");
			}

			if(customer.isHasLoyaltyCard()) {
				return customer;
			}
			else {
				throw new Exception("This customer does not have a loyalty card");
			}

		}
	
	public void sendLoyaltyEmail(int id, String name) throws Exception {
	
		try{
			Customer customer = custDB.getCustomer(id);

			String email = customer.getEmail();
			
			EmailFunctionality emFunc = new EmailFunctionality();
			
			emFunc.sendLoyaltyEmail(name, email);
		}
		catch(Exception ex) {
			throw new Exception("An issue occurred in sending this email.");
		}
		
	}
	
	}
