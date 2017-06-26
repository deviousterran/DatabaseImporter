/*
 * Dependencies: Apache POI Library from http://poi.apache.org/
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReading {

    @SuppressWarnings("deprecation")
	public static ArrayList<Route> readWorksheet(Sheet sheet) {
    	ArrayList<Route> rte = new ArrayList<Route>();
    	ArrayList<String> result = new ArrayList<String>();
        Row row = null;
        int numberOfElements = sheet.getRow(0).getLastCellNum();
        System.out.println("the number of elements is:" + numberOfElements);
        
        System.out.println("the last row of the sheet is:" + sheet.getLastRowNum());
        //start on row 2 only if I have Headers.  In this case i do, so i start on 1(which is row 2...zero-based!)
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
          //read the whole row into result
            for (int j = 0; j < numberOfElements; j++) {//start column
            	//checking for null values
            	String temp = null;
            	if(row.getCell(j) != null ){
            		//if it's not null, send it to a string
            		temp = row.getCell(j).toString();
            		
            	}else{
            		//if it's null or other bullshit, send a empty string
            		temp = "";
            	}
                //parse out the unwanted characters
                temp = ParseData.formatLine(temp);
                //add string to result
                result.add(temp);
            }
            //temproray route object parses out the array list during construction
            Route temp = new Route(result);
            //pre-bult route object added to rte
            rte.add(temp);
            //clear the result object
            result.clear();
            
            //System.out.println("i'm on line " + i);
        }
        //return the collection of route objects
        return rte;
    }
 
    public static ArrayList<Route> readExcel(String fileName) {
        InputStream inp = null;
        ArrayList<Route> result = new ArrayList<Route>();
        try {
            inp = new FileInputStream(fileName);
            Workbook wb = WorkbookFactory.create(inp);

            for(int i=0;i<wb.getNumberOfSheets();i++) {
                result = readWorksheet(wb.getSheetAt(i)); 
            }
        } catch (InvalidFormatException ex) {
            Logger.getLogger(ExcelReading.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelReading.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelReading.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inp.close();
            } catch (IOException ex) {
                Logger.getLogger(ExcelReading.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
}