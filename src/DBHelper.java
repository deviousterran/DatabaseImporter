import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBHelper extends DBrouteContract{
		Connection conn = null;
        private final String url = "jdbc:mysql://balecoud.ciu3dd4pz46k.us-west-2.rds.amazonaws.com:3306/charpro";
        
	public void connect() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
        try {
        	Class.forName ("com.mysql.jdbc.Driver").newInstance ();
            conn = DriverManager.getConnection(url,"bale","YDClnd03");
            System.out.println("Connection to MYSQL has been established.");  
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
