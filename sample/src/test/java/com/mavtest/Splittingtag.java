package com.mavtest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class Splittingtag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String tag =  "https://cognizant.sc.omtrdc.net/b/ss/ctsprodlive/1/JS-2.13.1-LAS8/s76723927438913?AQB=1=c&ndh=1&pf=1&t=10%2F4%2F2020%209%3A22%3A45%200%20-330&mid=59641322664647130300373139435692927813&aamlh=12&ce=UTF-8&pageName=Digital%20Solutions%20to%20Advance%20Your%20Business%20%7C%20Cognizant&g=https%3A%2F%2Fwww.cognizant.com%2F&cc=USD&aamb=RKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y&c4=D%3Dg&v4=D%3Dg&c5=D%3Dv5&v5=Top%20Nav%20Header%20%7C%20News&v15=Digital%20Solutions%20to%20Advance%20Your%20Business%20%7C%20Cognizant&c16=D%3Dv16&v16=D%3Dg&c18=D%3Dv18&v18=Digital%20Solutions%20to%20Advance%20Your%20Business-%20Cognizant%20%7C%20Home%20Page&c37=8%7C8&c38=Digital%20Solutions%20to%20Advance%20Your%20Business%20%7C%20Cognizant&c39=zero&c40=8&c44=New&v44=New&c45=38&c46=11%3A52%20PM%7CSaturday&v82=135103665&s=1366x768&c=24&j=1.6&v=N&k=Y&bw=1366&bh=613&mcorgid=00FD3942552521970A4C98A4%40AdobeOrg&AQE=1";
		String tes = "11:52 PM|Saturday";
		String tes2= "Digital Solutions to Advance Your Business | Cognizant";
		String tt = "c.";
		System.out.println(tt.length());
		
		String decodeURL = decode(tag); 
		//System.out.println(decodeURL);
		
		String[] sp = decodeURL.split("[?]",0);
		//String[] sp = decodeURL.split("\"url\":\"(.*?)\"},",0);
		
//		sp[1]= 
		System.out.println(sp[0]);
		Map<String, String> data = new LinkedHashMap<String, String>();
		for (String q : sp[1].split("&")) {
           String[] qa = q.split("=");
           data.put(qa[0], qa[1]);
			System.out.println(q);
		}
		
		System.out.println(data.get("mcorgid"));
		System.out.println(data.size());
		
		if(data.containsKey("c46")) {
			System.out.println("c46 is present");
			String val = data.get("c46");
			boolean t = val.equalsIgnoreCase(tes);
			System.out.println(t);
		
			
		}
		else {
			System.out.println("c46 is not present");
		}
		
		if(data.containsKey("pageName")) {
			System.out.println("pageName is present");
			String val = data.get("pageName");
			boolean t1 = val.equalsIgnoreCase(tes2);
			System.out.println(t1);
		
			
		}
		else {
			System.out.println("pageName is not present");
		}
		

	}
	
	
	 public static String decode(String url)  
     {  
               try {  
                    String prevURL="";  
                    String decodeURL=url;  
                    while(!prevURL.equals(decodeURL))  
                    {  
                         prevURL=decodeURL;  
                         decodeURL=URLDecoder.decode( decodeURL, "UTF-8" );  
                    }  
                    return decodeURL;  
               } catch (UnsupportedEncodingException e) {  
                    return "Issue while decoding" +e.getMessage();  
               }  
     } 

}
