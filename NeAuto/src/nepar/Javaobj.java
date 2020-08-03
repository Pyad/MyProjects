package nepar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Javaobj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		        try {
		        	Javaobj.convert_json_to_java();
		        } catch (Exception e) {
		            System.out.println(e);
		        }
		    }
		    public static void convert_json_to_java() throws Exception {
		       // String ip = "37.210.57.113";
		        //String key = "9d64fcfdfacc213c7ddf4ef911dfe97b55e4696be546x532bf8302876c09ebad06b";
		        String url = "https://careers.cognizant.com/global/en";
		        URL obj = new URL(url);
		        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		        con.setRequestMethod("GET");
		        con.setRequestProperty("User-Agent", "Mozilla/5.0");
		        BufferedReader in = new BufferedReader(
		            new InputStreamReader(con.getInputStream()));
		        String inputLine;
		        StringBuffer response = new StringBuffer();
		        while ((inputLine = in .readLine()) != null) {
		            response.append(inputLine);
		        } in .close();
		        System.out.println(response.toString());
		        ObjectMapper obj3 = new ObjectMapper();
		        JavaobjTojson obj1 = new JavaobjTojson();
		        obj1 = obj3.readValue(response.toString(), JavaobjTojson.class);
		        System.out.println("-------Afer converting to java object-------------------");
		      
		        System.out.println("Referer-" + obj1.getReferer());
		        System.out.println("method-" + obj1.getMethod());
		        System.out.println("mixedContentType-" + obj1.getMixedContentType());
		        System.out.println("referrerPolicy-" + obj1.getReferrerPolicy());
		        System.out.println("requestId-" + obj1.getRequestId());
		        System.out.println("timestamp-" + obj1.getTimestamp());
		        System.out.println("type-" + obj1.getType());
		        System.out.println("wallTime-" + obj1.getWallTime());
		        System.out.println("url-" + obj1.getUrl());
		        System.out.println("User-" + obj1.getUser());
		        System.out.println("initialPriority-" + obj1.getInitialPriority());
		        
		      
		        
		        
		    }
}
		
		
		
		
		
		
		
	
