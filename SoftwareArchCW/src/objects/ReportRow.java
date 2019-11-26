package objects;

public class ReportRow {
	
	private String month;
	private int sales;
	
	public ReportRow() {}
	
	public ReportRow(String month, int sales) {
		
		this.month = month;
		this.sales = sales;
		
	}
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	

}
