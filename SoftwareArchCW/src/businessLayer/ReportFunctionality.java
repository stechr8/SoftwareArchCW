package businessLayer;

import java.util.ArrayList;

import dataLayer.ReportDatabaseCommands;
import objects.ReportRow;

public class ReportFunctionality {
	
	ReportDatabaseCommands rptDB = new ReportDatabaseCommands();
	
	public ArrayList<ReportRow> getStats() throws Exception{
		
		ArrayList<ReportRow> statsList = rptDB.getStats();
		
		if(statsList.isEmpty()) {
			throw new Exception("Data not available");
		}
		
		return statsList;
		
	}

}
