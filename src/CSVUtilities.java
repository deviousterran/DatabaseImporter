import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVUtilities {
	 private static final char DEFAULT_SEPARATOR = ',';
	    private static final char DEFAULT_QUOTE = '"';

	    //Just fuck all this!
	    public static void main(String[] args) throws Exception {
	        String csvFile = "inputTester.csv";

	        Scanner scan = new Scanner(new File(csvFile));
	        String line = "";
	        String cvsSplitBy = ",";
	        ArrayList<String> routes = new ArrayList<>();
	        routes.clear();
	        
	            
	            while (scan.hasNextLine()) {

	                // use comma as separator
	                //String[] country = line.split(cvsSplitBy);
	            	line = scan.nextLine();
	            	line = ParseData.formatLine(line);
	            	routes.addAll(parseLine(line));
	            	//System.out.println(country.length);
	            }
                for(int i =0;i< routes.size();i++){
                	System.out.println("element "+ i + ":" + routes.get(i));
                }
	    }
	    
	    
	    //we can parse a line based on ANYTHING
	    public static List<String> parseLine(String cvsLine) {
	        return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
	    }

	    public static List<String> parseLine(String cvsLine, char separators) {
	        return parseLine(cvsLine, separators, DEFAULT_QUOTE);
	    }

	    public static List<String> parseLine(String cvsLine, char separators, char customQuote) {

	        List<String> result = new ArrayList<>();

	        //if empty, return!
	        if (cvsLine == null && cvsLine.isEmpty()) {
	            return result;
	        }

	        if (customQuote == ' ') {
	            customQuote = DEFAULT_QUOTE;
	        }

	        if (separators == ' ') {
	            separators = DEFAULT_SEPARATOR;
	        }

	        StringBuffer curVal = new StringBuffer();
	        boolean inQuotes = false;
	        boolean startCollectChar = false;
	        boolean doubleQuotesInColumn = false;

	        char[] chars = cvsLine.toCharArray();

	        for (char ch : chars) {

	            if (inQuotes) {//if inQuotes is true
	                startCollectChar = true;//then we trigger the start collecting chars (or continue it)
	                if (ch == customQuote) {//if it's a quote...
	                    inQuotes = false;//then inQuotes is false... oh, because it's already true, so we would close it
	                    doubleQuotesInColumn = false;//douible quotes this column WTF would we use this for?
	                } else {//so if it's not a custom quote, meaning that it's a useable character

	                    //Fixed : allow "" in custom quote enclosed
	                    if (ch == '\"') {//so this would allow quotes to be used in a column...  
	                    	//fuck, how do we differentaie between double quotes ina column and commas.  Fucking excel  
	                        if (!doubleQuotesInColumn) {
	                            curVal.append(ch);
	                            doubleQuotesInColumn = true;
	                        }
	                    } else {
	                        curVal.append(ch);
	                    }

	                }
	            } else {
	                if (ch == customQuote) {

	                    inQuotes = true;

	                    //Fixed : allow "" in empty quote enclosed
	                    if (chars[0] != '"' && customQuote == '\"') {
	                        curVal.append('"');
	                    }

	                    //double quotes in column will hit this!
	                    if (startCollectChar) {
	                        curVal.append('"');
	                    }

	                } else if (ch == separators) {
	                	String temp;
	                	
	                    temp = ParseData.formatLine(curVal.toString());
	                    if (temp.length() > 0){
	                    	result.add(temp);
	                    }
	                    curVal = new StringBuffer();
	                    startCollectChar = false;

	                } else if (ch == '\r') {
	                    //ignore LF characters
	                    continue;
	                } else if (ch == '\n') {
	                    //the end, break!
	                    break;
	                } else {
	                    curVal.append(ch);
	                }
	            }

	        }

        	String temp;
        	
            temp = ParseData.formatLine(curVal.toString());
            if (temp.length() > 0){
            	result.add(temp);
            }

	        return result;
	    }
	    

}
