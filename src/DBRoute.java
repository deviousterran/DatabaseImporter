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
	int recordsSent;
	int totalRecordsSent;
	int recordsWritten;
	int totalRecordsWritten;

	
	DBRoute(){
		db = new DBHelper();
		local = new Route();
		recordsSent=0;
		totalRecordsSent=0;
		recordsWritten=0;
		totalRecordsWritten=0;
		 
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
		String sql = "INSERT OR IGNORE INTO "+ TABLE_NAME +  " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
		System.out.println("Staring Database Import");
		recordsSent = 0;
		recordsWritten = 0;
		recordsSent = data.size();
		totalRecordsSent += data.size();
		db.connect();
		checkForTableExistance();
		DatabaseMetaData md = db.conn.getMetaData();
		ResultSet rs = md.getTables(null, null, "%", null);
		while (rs.next()){
			System.out.println("writing to table:"+rs.getString(3));
		}
		db.conn.setAutoCommit(false);
		String sql = "INSERT OR IGNORE INTO "+ TABLE_NAME +  " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ps = db.conn.prepareStatement(sql);

		for(int i = 0;i< data.size();i++){
			insertPreparedStatement(data.get(i));
		}
		int[] rowsAffected;
		rowsAffected = ps.executeBatch();
		for(int j =0;j<rowsAffected.length;j++){
			recordsWritten = recordsWritten + rowsAffected[j];
		}
		totalRecordsWritten = totalRecordsWritten + recordsWritten;
		System.out.println("number of records Sent: " + recordsSent);
		System.out.println("number of records written: " + recordsWritten);

		db.conn.commit();
		db.conn.setAutoCommit(true);
		db.conn.close();
		ps.clearBatch();
	}
	
	
}
