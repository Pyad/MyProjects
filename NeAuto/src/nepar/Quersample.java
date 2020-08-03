package nepar;
import java.net.*; 

public class Quersample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 
		        // url  object 
		        URL url = null; 
		  
		        try { 
		            // create a URL 
		            url 
		                = new URL( 
		                    "https:// www.geeksforgeeks.org/url-getprotocol-method-in-java-with-examples?title=protocol"); 
		  
		            // get the  Query 
		            String _Query = url.getQuery(); 
		  
		            // display the URL 
		            System.out.println("URL = " + url); 
		  
		            // display the  Query 
		            System.out.println(" Query=" + _Query); 
		        } 
		        // if any error occurs 
		        catch (Exception e) { 
		  
		            // display the error 
		            System.out.println(e); 
		        } 
		    } 
		



}
