package nepar;
import org.apache.commons.httpclient.*;

import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.*;

public class Httpp {

		// TODO Auto-generated method stub
		
		

	

		  private static String url = "https://www.google.com";

		  public static void main(String[] args) {
		    // Create an instance of HttpClient.
		    HttpClient client = new HttpClient();
		    

		    // Create a method instance.
		    GetMethod method = new GetMethod(url);
//		    GetMethod m = new GetMethod(url);
//		    String o = m.getQueryString();
//		    System.out.println(o);

		    // Provide custom retry handler is necessary
//		   method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
//		          new DefaultHttpMethodRetryHandler(3, false));
//		    method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
//			          new DefaultHttpMethodRetryHandler(3, false));
            client.
		    try {
		      // Execute the method.
		      int statusCode = client.executeMethod(method);

		      if (statusCode != HttpStatus.SC_OK) {
		        System.err.println("Method failed: " + method.getStatusLine());
		      }

		      // Read the response body.
		      byte[] responseBody = method.getResponseBody();

		      // Deal with the response.
		      // Use caution: ensure correct character encoding and is not binary data
		      System.out.println(new String(responseBody));

		    } catch (HttpException e) {
		      System.err.println("Fatal protocol violation: " + e.getMessage());
		      e.printStackTrace();
		    } catch (IOException e) {
		      System.err.println("Fatal transport error: " + e.getMessage());
		      e.printStackTrace();
		    } finally {
		      // Release the connection.
		      method.releaseConnection();
		    }  
		  }
		

	}


