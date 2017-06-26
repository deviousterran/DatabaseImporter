

public class ParseData {
    
	static String formatLine(String input){
    	String temp = input;
    	//eliminate the following characters: & " $ the newline and endline character and spaces
    	temp = temp.replaceAll("[&\"$\r\\n\\s]", "" );
    	
    	return temp;
    }
	static Double parseDouble(String s){
		Double d = null;
			if(!s.isEmpty()){
				try{
					d = Double.parseDouble(s); //if the string is not empty, parse the double
				}catch(NumberFormatException e){
					d = null;//if the parsing fails, then assign null to the object and fuck right off
				}
			}
		return d;
	}
	static Integer parseInteger(String s){
		Integer i = null;
		if(!s.isEmpty()){
			try{
				i=(int)Double.parseDouble(s);//if the string is not empty, parse the Integer
			}catch(NumberFormatException e){
				i = null;//if the parsing fails, then assign null to the object and fuck right off
			}	
		}
		return i;
		
	}
	
	
    
}
