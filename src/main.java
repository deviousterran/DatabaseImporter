import java.sql.SQLException;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) throws SQLException {
	
		//there was a routes1, but i killed it...  with malice
		ArrayList<Route> routes = new ArrayList<Route>();
		//this calss handles the database stuff with teh route object
		DBRoute rte = new DBRoute();
		
		for(int i = 2; i < 16; i++){
			routes.clear();
			//filename and path for the excel file.  currently the path is added as a working directory
			String excelFile = "upload week " + i + ".xlsx";
			//pulls all the route info from the Excel File
			System.out.println("Excel Parsing has begun for " + excelFile);
			routes.addAll(ExcelReading.readExcel(excelFile));
			System.out.println("Excel Parsing has finished");
			//now we trigger the upload
			rte.batchUpload(routes);
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
