import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBRoute extends DBrouteContract{
	Route local;
	DBHelper db;
	PreparedStatement ps;

	
	DBRoute(){
		db = new DBHelper();
		local = new Route();
		 
	}
	
	//interesting fact here, can't insert NULL into a setInt() or setDouble()..  so i wonder if i use a setNull, what the values will be in the DB??
	public void insertPreparedStatement(Route r) throws SQLException{
		ps.setObject(1,r.mWarehouse,java.sql.Types.INTEGER);
		ps.setObject(2, r.mCustomerNumber,java.sql.Types.INTEGER);
		ps.setString(3, r.mSalesRep);
		ps.setString(4, r.mRoute);
		ps.setString(6, r.mCreditOrder);
		ps.setObject(7, r.mInvoiceNumber,java.sql.Types.INTEGER);
		ps.setString(8, r.mInvoiceDate);
		ps.setObject(9, r.mInvoiceAmount,java.sql.Types.DOUBLE);
		ps.setObject(10, r.mQuantityOrdered,java.sql.Types.DOUBLE);
		ps.setObject(11, r.mCube,java.sql.Types.DOUBLE);
		ps.setObject(12, r.mWeight,java.sql.Types.DOUBLE);
		ps.setString(13, r.mTimeOfOrder);
		ps.setString(14, r.mShipDate);
		ps.setString(15, r.mOrderDate);
		ps.setObject(16, r.mQuantityShipped,java.sql.Types.INTEGER);
		ps.setObject(17, r.mNetSales,java.sql.Types.DOUBLE);
		ps.setObject(18, r.mActualCost,java.sql.Types.DOUBLE);
		ps.setObject(19, r.mProfit,java.sql.Types.DOUBLE);
		ps.setObject(20, r.mProfit,java.sql.Types.DOUBLE);
		ps.addBatch();
	}
	void checkForTableExistance() throws SQLException{
		Statement stmt = db.conn.createStatement();
		stmt.execute(CREATE_TABLE_IF_NOT_EXISTS);
		
	}
	
	
	public void executeBatch() throws SQLException{
		db.conn.commit();
	}
	void singleUpload(Route r) throws SQLException{
		
		db.connect();
		checkForTableExistance();
		DatabaseMetaData md = db.conn.getMetaData();
		ResultSet rs = md.getTables(null, null, "%", null);
		while (rs.next()){
			System.out.println(rs.getString(3));
		}
		String sql = "INSERT IGNORE INTO "+ TABLE_NAME +  " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ps = db.conn.prepareStatement(sql);
		insertPreparedStatement(r); 
		int[] rowsAffected;
		rowsAffected = ps.executeBatch();
		System.out.println("number of records written: " + rowsAffected.length);
		
		db.conn.commit();
		db.conn.setAutoCommit(true);
		db.conn.close();
	}
	
	
	void batchUpload(ArrayList<Route> data) throws SQLException{
		db.connect();
		checkForTableExistance();
		DatabaseMetaData md = db.conn.getMetaData();
		ResultSet rs = md.getTables(null, null, "%", null);
		while (rs.next()){
			System.out.println(rs.getString(3));
		}
		db.conn.setAutoCommit(false);
		String sql = "INSERT INTO "+ TABLE_NAME +  " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ps = db.conn.prepareStatement(sql);

		for(int i = 0;i< data.size();i++){
			insertPreparedStatement(data.get(i));
		}
		int[] rowsAffected;
		rowsAffected = ps.executeBatch();

		System.out.println("number of records written: " + rowsAffected.length);
		
		db.conn.commit();
		db.conn.setAutoCommit(true);
		db.conn.close();
	}
	
	
}
