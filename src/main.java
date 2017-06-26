import java.sql.SQLException;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) throws SQLException {
		//filename and path for the excel file.  currently the path is added as a working directory
		String excelFile = "upload week 3.xlsx";
		//there was a routes1, but i killed it...  with malice
		ArrayList<Route> routes = new ArrayList<Route>();

		//this calss handles the database stuff with teh route object
		DBRoute rte = new DBRoute();
		//pulls all the route info from the Excel File
		routes.addAll(ExcelReading.readExcel(excelFile));
		
		//now we trigger the upload
		rte.batchUpload(routes);
		
		
	}
	
	void GetStructure(){
		
	}
	
	void ParseStructure(){
		
	}
	
	void insertStructre(){
		
	}
	
	

}
