import java.sql.SQLException;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
	
		//there was a routes1, but i killed it...  with malice
		ArrayList<Route> routes = new ArrayList<Route>();
		//this class handles the database stuff with the route object
		DBRoute rte = new DBRoute();
		
		String username = System.getProperty("user.name");
		System.out.println(username);
		
		for(int i = 2; i < 16; i++){
			routes.clear();
			//filename and path for the excel file.  currently the path is added as a working directory
			String excelFile = "C:\\Users\\dan\\Desktop\\Input Sheets\\upload week " + i + ".xlsx";
			//pulls all the route info from the Excel File
			System.out.println("Excel Parsing has begun for " + excelFile);
			routes.addAll(ExcelReading.readExcel(excelFile));
			System.out.println("Excel Parsing has finished");
			//now we trigger the upload
			long startime = System.currentTimeMillis();
			rte.batchUpload(routes);
			long endtime = System.currentTimeMillis();
			long duration = (endtime - startime);
			System.out.println("time to execute: " + (duration / 1000) + " Seconds");
			}	
		System.out.println("Total number of records written: " + rte.totalRecordsWritten);
		System.out.println("Total number of records sent: " + rte.totalRecordsSent);
	}
	
	void RouteUpload(int num){

	}
	
	void ParseStructure(){
		
	}
	
	void insertStructre(){
		
	}
	
	

}
