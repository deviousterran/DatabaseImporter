
public class DBrouteContract {

	
	public final String COLUMN_WAREHOUSE = 	"warehouse";
	public final String	COLUMN_CUSTOMER_NUMBER = "customerNumber";
	public final String COLUMN_SALES_REP = "salesRep";
	public final String COLUMN_STOP_NUMBER = "stopNumber";
	public final String COLUMN_CREDIT_ORDER = "creditOrder";
	public final String COLUMN_INVOICE_NUMBER = "invoiceNumber";
	public final String COLUMN_INVOICE_DATE = "invoiceDate";
	public final String COLUMN_INVOICE_AMOUNT = "invoiceAmount";
	public final String COLUMN_QUANTITY_ORDERED = "quantityOrdered";
	public final String COLUMN_CUBE = "cube";
	public final String COLUMN_WEIGHT = "weight";
	public final String COLUMN_ORDER_TIME = "orderTime";
	public final String COLUMN_SHIP_DATE = "shipDate";
	public final String COLUMN_ORDER_DATE = "orderDate";
	public final String COLUMN_SHIP_QUANTITY = "shipQuantity";
	public final String COLUMN_NET_SALES = "netSales";
	public final String COLUMN_ACTUAL_COSTS = 	"actualCosts";
	public final String COLUMN_PROFIT = "profit";
	public final String COLUMN_PROFIT_PERCENT = "profitPercent";
	public final String TABLE_NAME = "route";
	public final String CREATE_TABLE_IF_NOT_EXISTS = "CREATE TABLE IF NOT EXISTS \"route\" ( `warehouse` INTEGER,"
			+ " `customerNumber` INTEGER, `salesRep` TEXT, `route` TEXT, `stopNumber` INTEGER,"
			+ " `creditOrder` TEXT, `invoiceNumber` INTEGER, `invoiceDate` TEXT,"
			+ " `invoiceAmount` REAL, `quantityOrdered` REAL, `cube` REAL, `weight` REAL,"
			+ " `orderTime` INTEGER, `shipDate` TEXT, `orderDate` TEXT, `shipQuantity` INTEGER,"
			+ " `netSales` REAL, `actualCost` REAL, `profit` REAL, `profitPercent` REAL,"
			+ " PRIMARY KEY(`invoiceNumber`) )";
	public final String CREATE_TABLE = "CREATE TABLE \"route\" ( `warehouse` INTEGER,"
			+ " `customerNumber` INTEGER, `salesRep` TEXT, `route` TEXT, `stopNumber` INTEGER,"
			+ " `creditOrder` TEXT, `invoiceNumber` INTEGER, `invoiceDate` TEXT,"
			+ " `invoiceAmount` REAL, `quantityOrdered` REAL, `cube` REAL, `weight` REAL,"
			+ " `orderTime` INTEGER, `shipDate` TEXT, `orderDate` TEXT, `shipQuantity` INTEGER,"
			+ " `netSales` REAL, `actualCost` REAL, `profit` REAL, `profitPercent` REAL,"
			+ " PRIMARY KEY(`invoiceNumber`) )";
	

}
