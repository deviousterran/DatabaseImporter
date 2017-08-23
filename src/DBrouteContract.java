
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
	public final String COLUMN_ACTUAL_COSTS = 	"actualCost";
	public final String COLUMN_PROFIT = "profit";
	public final String COLUMN_PROFIT_PERCENT = "profitPercent";
	public final String COLUMN_ROUTE = "route";
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
	
	public final String CREATE_MYSQL_TABLE = "CREATE TABLE `charpro`.`route` ("
			  + "`invoiceNumber` INT NOT NULL,"
			  + "`warehouse` INT NULL,"
			  + "`customerNumber` INT NULL,"
			  + "`salesrep` VARCHAR(45) NULL,"
			  + "`route` VARCHAR(45) NULL,"
			  + "`stopNumber` INT NULL,"
			  + "`creditOrder` VARCHAR(45) NULL,"
			  + "`invoiceDate` VARCHAR(45) NULL,"
			  + "`invoiceAmount` DECIMAL(15,2) UNSIGNED NULL,"
			  + "`quantityOrdered` INT NULL,"
			  + "`cube` DOUBLE NULL,"
			  + "`weight` DOUBLE NULL,"
			  + "`orderTime` INT NULL,"
			  + "`shipDate` VARCHAR(45) NULL,"
			  + "`orderDate` VARCHAR(45) NULL,"
			  + "`shipQuantity` INT NULL,"
			  + "`netSales` DECIMAL(15,2) NULL,"
			  + "`actualCost` DECIMAL(15,2) NULL,"
			  + "`profit` DECIMAL(15,2) NULL,"
			  + "`profitPercent` DECIMAL(15,2) NULL,"
			  + "PRIMARY KEY (`invoiceNumber`));";
	public final String CREATE_TABLE_IF_NOT_EXISTS_MYSQL = "CREATE TABLE IF NOT EXISTS `charpro`.`route` ("
			  + "`invoiceNumber` INT NOT NULL,"
			  + "`warehouse` INT NULL,"
			  + "`customerNumber` INT NULL,"
			  + "`salesrep` VARCHAR(45) NULL,"
			  + "`route` VARCHAR(45) NULL,"
			  + "`stopNumber` INT NULL,"
			  + "`creditOrder` VARCHAR(45) NULL,"
			  + "`invoiceDate` VARCHAR(45) NULL,"
			  + "`invoiceAmount` DECIMAL(15,2) UNSIGNED NULL,"
			  + "`quantityOrdered` INT NULL,"
			  + "`cube` DOUBLE NULL,"
			  + "`weight` DOUBLE NULL,"
			  + "`orderTime` INT NULL,"
			  + "`shipDate` VARCHAR(45) NULL,"
			  + "`orderDate` VARCHAR(45) NULL,"
			  + "`shipQuantity` INT NULL,"
			  + "`netSales` DECIMAL(15,2) NULL,"
			  + "`actualCost` DECIMAL(15,2) NULL,"
			  + "`profit` DECIMAL(15,2) NULL,"
			  + "`profitPercent` DECIMAL(15,2) NULL,"
			  + "PRIMARY KEY (`invoiceNumber`));";

}
