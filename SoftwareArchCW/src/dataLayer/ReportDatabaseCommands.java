package dataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import objects.ReportRow;

public class ReportDatabaseCommands {
	
public ArrayList<ReportRow> getStats() {
	
	ArrayList<ReportRow> statsList = new ArrayList<ReportRow>();
		
		try
		{
			// Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Establish connection to the database
			Connection conn = DriverManager
			          .getConnection("jdbc:mysql://localhost/accounting?user=Java&password=Java");
			
			// Connect to DB
			Statement statement = conn.createStatement();
			
			// Create query to get the product from the database matching the product id
			String query = "SELECT * FROM accountingtable";
			
			// And then get the results from executing the query
			ResultSet results = statement.executeQuery(query);
			
			while (results.next()) {
				
				ReportRow repRow = new ReportRow(results.getString("Month"), Integer.parseInt(results.getString("Sales")));
				
				statsList.add(repRow);
				
		    }
			
			// Release resources held by statement
			statement.close();
			// Release resources held by DB connection
			conn.close();
			
		}
		catch (ClassNotFoundException cnf)
		{
			System.err.println("Could not load driver");
			System.err.println(cnf.getMessage());
		}
		catch (SQLException sqe)
		{
			System.out.println("Error performing SQL Query");
			System.out.println(sqe.getMessage());
		}

		return statsList;
		
	}

}
