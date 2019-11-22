package dataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import objects.Product;

public class InventoryDatabaseCommands implements InventoryDBInterface {
	
	public void addProduct(int productID, String productName, double price, int stock) {
		
		try
		{
			// Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			// First we need to establish a connection to the database
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost/inventory?user=Java&password=Java");
			
			// Create a new SQL statement
			Statement statement = conn.createStatement();
			
			// Create the INSERT statement
			String update = "INSERT INTO InventoryTable (ProductID, ProductName, Price, Stock) " +
							"VALUES ('" + productID + "', '" + productName + "', '" + price + "', '" + stock + "')";
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
	
	public Product getProduct(int productID) {
		
		Product product = new Product();
		
		try
		{
			// Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Establish connection to the database
			Connection conn = DriverManager
			          .getConnection("jdbc:mysql://localhost/Inventory?user=Java&password=Java");
			
			// Connect to DB
			Statement statement = conn.createStatement();
			
			// Create query to get the product from the database matching the product id
			String query = "SELECT * FROM InventoryTable WHERE ProductID = '" + productID + "'";
			
			// And then get the results from executing the query
			ResultSet results = statement.executeQuery(query);
			
			//take the first row
			results.first();
			
			product.setProductID(results.getInt("ProductID"));
			product.setProductName(results.getString("ProductName"));
			product.setPrice(results.getDouble("Price"));
			product.setStockLevel(results.getInt("Stock"));
			
			// Release resources held by statement
			statement.close();
			// Release resources held by DB connection
			conn.close();
			
		}
		catch (ClassNotFoundException cnf)
		{
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
			//System.exit(-1);
		}
		catch (SQLException sqe)
		{
			System.out.println("Error performing SQL Query");
			System.out.println(sqe.getMessage());
			//System.exit(-1);
		}
		
		return product;

	}
	
	public void RemoveProduct(int productID) {
		
		try
		{
			// Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Establish connection to the database
			Connection conn = DriverManager
			          .getConnection("jdbc:mysql://localhost/Inventory?user=Java&password=Java");
			
			// Connect to DB
			Statement statement = conn.createStatement();
			
			// Create query to get the product from the database matching the product name
			String query = "DELETE * FROM InventoryTable WHERE ProductID = '" + productID + "'";
			
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
	public void UpdateProduct(int productID, String productName, double price, int stock) {
		
		try {
			
			// Load the driver
			Class.forName("com.mysql.jdbc.Driver");

			//Establish connection to the database
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost/inventory?user=Java&password=Java");

			//Create connection with scrolling enabled
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,	ResultSet.CONCUR_UPDATABLE);
			
			// Create query string
			String query = "SELECT * FROM InventoryTable WHERE ProductID = '" + productID + "'";
			
			// Get results from query
			ResultSet results = statement.executeQuery(query);
			
			// Check for results
			if (results.next()) {
				
				//take the first row
				results.first();

				// Update the relevant columns in the DB
				results.updateInt("ProductID", productID);
				results.updateString("ProductName", productName);
				results.updateDouble("Price", price);
				results.updateInt("Stock", stock);
				
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
