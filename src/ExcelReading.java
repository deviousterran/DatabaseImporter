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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {

    public static ArrayList<Route> readWorksheet(Sheet sheet) {
    	ArrayList<Route> rte = new ArrayList<Route>();
    	ArrayList<String> result = new ArrayList<String>();
    	double percentComplete = 0;
    	int lastRow = sheet.getLastRowNum();
    	//int lastRow = 500;
        Row row = null;
        int numberOfElements = sheet.getRow(0).getLastCellNum();
        boolean output = false;
        System.out.println("the number of elements is:" + numberOfElements);
        
        System.out.println("the last row of the sheet is:" + lastRow);
        //start on row 2 only if I have Headers.  In this case i do, so i start on 1(which is row 2...zero-based!)
        for (int i = 1; i <= lastRow; i++) {
            row = sheet.getRow(i);
            percentComplete = ((double)i/(double)lastRow)*100;
 


            	//System.out.println("excel parsing is " + percentComplete + "% complete");
            	if((int)percentComplete % 5 == 0){
            		if(output){
            			System.out.println("111excel parsing is " + (int)percentComplete + "% complete");
            			output = false;
            		}
            		
            	}else{
            		output = true;
            	}
            
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
        	System.out.println("Opening Workbook...");
            inp = new FileInputStream(fileName);
            Workbook wb = WorkbookFactory.create(inp);
            XSSFWorkbook SXwb = new XSSFWorkbook(fileName);
            

            
            
            for(int i=0;i<SXwb.getNumberOfSheets();i++) {
                result = readWorksheet(SXwb.getSheetAt(i)); 
            }
            SXwb.close();
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