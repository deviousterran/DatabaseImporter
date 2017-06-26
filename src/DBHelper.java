import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBHelper extends DBrouteContract{
		Connection conn = null;
        private final String url = "jdbc:sqlite:C:/Users/dan/workspace/RouteImporter/src/Routes.db";
        
	public void connect(){
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");  
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	DBHelper(){
		
	};
	
	public void close(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
	
}
