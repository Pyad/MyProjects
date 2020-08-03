package fiR;
import java.util.regex.*; 

public class Regee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		  
		
		  
		        // Get the regex to be checked 
		        String regex = "Geeks"; 
		  
		        // Create a pattern from regex 
		        Pattern pattern 
		            = Pattern.compile(regex); 
		        System.out.println(pattern);
		  
		        // Get the String to be matched 
		        String stringToBeMatched 
		            = "GeeksForGeeks"; 
		  
		        // Create a matcher for the input String 
		        Matcher matcher 
		            = pattern 
		                  .matcher(stringToBeMatched); 
		  
		        // Get the subsequence 
		        // using find() method 
		        System.out.println(matcher.find()); 
		    } 
		} 

	


