package dataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import objects.Customer;

public class CustomerDatabaseCommands implements CustomerDBInterface {
	
	@Override
	public void addCustomer(int customerID, String customerName, boolean hasLoyaltyCard, String email) {
		
		try
		{
			// Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			// First we need to establish a connection to the database
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost/Customer?user=Java&password=Java");
			
			// Create a new SQL statement
			Statement statement = conn.createStatement();
			
			//change boolean value to integer for db
			int hasLoyaltyCardInt = 0;
			
			if(hasLoyaltyCard) {
				hasLoyaltyCardInt = 1;
			}
			
			// Create the INSERT statement
			String update = "INSERT INTO CustomerTable (CustomerID, CustomerName, LoyaltyCard, Email) " +
							"VALUES ('" + customerID + "', '" + customerName + "', '" + hasLoyaltyCardInt + "', '" + email + "')";
			// Execute the statement
			statement.executeUpdate(update);
			// Release resources held by the statement
			statement.close();
			// Release resources held by the connection.  This also ensures that the INSERT completes
			conn.close();
		}
		catch (ClassNotFoundException cnf)
		{
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
			System.exit(-1);
		}
		catch (SQLException sqe)
		{
			System.err.println("Error performing SQL Update");
			System.err.println(sqe.getMessage());
			System.exit(-1);
		}
		
	}
	
	@Override
	public Customer getCustomer(int customerID) {
		
		Customer customer = new Customer();
		
		try
		{
			// Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Establish connection to the database
			Connection conn = DriverManager
			          .getConnection("jdbc:mysql://localhost/Customer?user=Java&password=Java");
			
			// Connect to DB
			Statement statement = conn.createStatement();
			
			// Create query to get the customer from the database matching the customer id
			String query = "SELECT * FROM CustomerTable WHERE CustomerID = '" + customerID + "'";
			
			// And then get the results from executing the query
			ResultSet results = statement.executeQuery(query);
			
			//take the first row
			results.first();
			
			customer.setCustomerID(results.getInt("CustomerID"));
			customer.setCustomerName(results.getString("CustomerName"));
			
			//change boolean value to integer for db			
			if(results.getInt("LoyaltyCard") == 0){
				
				customer.setHasLoyaltyCard(false);
			}
			else {
				customer.setHasLoyaltyCard(true);
			}
			
			customer.setEmail(results.getString("Email"));

			
			// Release resources held by statement
			statement.close();
			// Release resources held by DB connection
			conn.close();
			
		}
		catch (ClassNotFoundException cnf)
		{
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
			System.exit(-1);
		}
		catch (SQLException sqe)
		{
			System.out.println("Error performing SQL Query");
			System.out.println(sqe.getMessage());
			System.exit(-1);
		}
		
		return customer;

	}
	
	@Override
	public void RemoveCustomer(int customerID) {
		
		try
		{
			// Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Establish connection to the database
			Connection conn = DriverManager
			          .getConnection("jdbc:mysql://localhost/Customer?user=Java&password=Java");
			
			// Connect to DB
			Statement statement = conn.createStatement();
			
			// Create query to get the customer from the database matching the customer name
			String query = "DELETE * FROM CustomerTable WHERE CustomerID = '" + customerID + "'";
			
			// Release resources held by statement
			statement.close();
			// Release resources held by DB connection
			conn.close();
			
		}
		catch (ClassNotFoundException cnf)
		{
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
			System.exit(-1);
		}
		catch (SQLException sqe)
		{
			System.out.println("Error performing SQL Query");
			System.out.println(sqe.getMessage());
			System.exit(-1);
		}

	}
	
	@Override
	public void UpdateCustomer(int customerID, String customerName, boolean hasLoyaltyCard, String email) {
		
		try {
			
			// Load the driver
			Class.forName("com.mysql.jdbc.Driver");

			//Establish connection to the database
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost/Customer?user=Java&password=Java");

			//Create connection with scrolling enabled
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,	ResultSet.CONCUR_UPDATABLE);
			
			// Create query string
			String query = "SELECT * FROM CustomerTable WHERE CustomerID = '" + customerID + "'";
			
			// Get results from query
			ResultSet results = statement.executeQuery(query);
			
			// Check for results
			if (results.next()) {
				
				//take the first row
				results.first();
				
				//change boolean value to integer for db
				int hasLoyaltyCardInt = 0;
				
				if(hasLoyaltyCard) {
					hasLoyaltyCardInt = 1;
				}

				// Update the relevant columns in the DB
				results.updateInt("CustomerID", customerID);
				results.updateString("CustomerName", customerName);
				results.updateInt("LoyaltyCard", hasLoyaltyCardInt);
				results.updateString("Email", email);
				
				// Update the row in the DB
				results.updateRow();

			} else {
				// No matching records. Display message
				System.out.println("Record does not exist");
			}
			// Free statement resources
			statement.close();
			// Free connection resources and commit updates
			conn.close();
			
		} catch (ClassNotFoundException cnf) {
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
			System.exit(-1);
		} catch (SQLException sqe) {
			System.err.println("Error in SQL Update");
			System.err.println(sqe.getMessage());
			System.exit(-1);
		}
		
	}

	
}
