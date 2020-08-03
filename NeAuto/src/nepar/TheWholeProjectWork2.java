package nepar;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TheWholeProjectWork2 {
	//private static URL url = null;
	

	public static  void main(String[] args) throws MalformedURLException, UnsupportedEncodingException {
		// TODO Auto-generated method stubj
		//String url = "https://smetrics.usbank.com/b/ss/usbankcom/10/JS-2.12.0/s84588586393204?AQB=1&ndh=1&pf=1&callback=s_c_il[1].doPostbacks&et=1&t=20%2F2%2F2020%207%3A47%3A32%205%20-330&d.&nsid=0&jsonv=1&.d&sdid=4CA3DB40BB56A3B1-062CCA439234AD7C&mid=25135486547984740651195090168424127981&aamlh=12&ce=UTF-8&ns=usbank&pageName=Personal%20Home%20Page&g=https%3A%2F%2Fwww.usbank.com%2Findex.html&r=https%3A%2F%2Fwww.usbank.com%2Findex.html&c.&vidAPICheck=VisitorAPI%20Present&et_dimensions=794x576&et_width=794&et_orientation=landscape&EVENTS=event17%2Cevent15%2C&.c&cc=USD&events=event17%2Cevent15&aamb=RKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y&c1=home%20pg&c2=home%20page%20rebranded&c3=D%3Dv3&v3=Repeat&c4=9%3A15PM&c6=Thursday&c7=3%2F20%2F2020&v9=prospect&c14=D%3Dg&c18=More%20than%207%20days&c19=2&c24=usb%3Aindex.html&c25=D%3Dc24&v27=4183033d771f40e0a01b52a304feecfb.31_0&c29=https%3A%2F%2Fwww.usbank.com%2Findex.html&v35=D%3DpageName&v37=D%3DUser-Agent&c40=dotcom&v40=D%3Dc2&c50=R%20October%202019%7CAM_2.17.0%7C10.07.2019%7CbaseOLB%7CVid_4.0.0&v59=nh&v90=D%3Dg&s=1366x768&c=24&j=1.6&v=N&k=Y&bw=811&bh=576&mcorgid=675616D751E567410A490D4C%40AdobeOrg&AQE=1";
		//System.out.println(query_pairs);
		URL url = new URL("https://smetrics.usbank.com/b/ss/usbankcom/10/JS-2.12.0/s84588586393204?AQB=1&ndh=1&pf=1&callback=s_c_il[1].doPostbacks&et=1&t=20%2F2%2F2020%207%3A47%3A32%205%20-330&d.&nsid=0&jsonv=1&.d&sdid=4CA3DB40BB56A3B1-062CCA439234AD7C&mid=25135486547984740651195090168424127981&aamlh=12&ce=UTF-8&ns=usbank&pageName=Personal%20Home%20Page&g=https%3A%2F%2Fwww.usbank.com%2Findex.html&r=https%3A%2F%2Fwww.usbank.com%2Findex.html&c.&vidAPICheck=VisitorAPI%20Present&et_dimensions=794x576&et_width=794&et_orientation=landscape&EVENTS=event17%2Cevent15%2C&.c&cc=USD&events=event17%2Cevent15&aamb=RKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y&c1=home%20pg&c2=home%20page%20rebranded&c3=D%3Dv3&v3=Repeat&c4=9%3A15PM&c6=Thursday&c7=3%2F20%2F2020&v9=prospect&c14=D%3Dg&c18=More%20than%207%20days&c19=2&c24=usb%3Aindex.html&c25=D%3Dc24&v27=4183033d771f40e0a01b52a304feecfb.31_0&c29=https%3A%2F%2Fwww.usbank.com%2Findex.html&v35=D%3DpageName&v37=D%3DUser-Agent&c40=dotcom&v40=D%3Dc2&c50=R%20October%202019%7CAM_2.17.0%7C10.07.2019%7CbaseOLB%7CVid_4.0.0&v59=nh&v90=D%3Dg&s=1366x768&c=24&j=1.6&v=N&k=Y&bw=811&bh=576&mcorgid=675616D751E567410A490D4C%40AdobeOrg&AQE=1");
	//Map<String, List<String>> val = splitQuery(url);
	Map<String, String> val1 = spli(url);
//		
//		for (Entry<String, String> entry : val.entrySet()) {
//
//            System.out.println(entry.getKey()+"="+entry.getValue());
//
//    }
//		  
	for (Entry<String, String> entry : val1.entrySet()) {
    System.out.println(entry.getKey() + "/" + entry.getValue());
}
	
	
	
//	}
	}
		public static  Map<String, String> spli(URL url) throws MalformedURLException, UnsupportedEncodingException{
			//URL url = new URL("https://smetrics.usbank.com/b/ss/usbankcom/10/JS-2.12.0/s84588586393204?AQB=1&ndh=1&pf=1&callback=s_c_il[1].doPostbacks&et=1&t=20%2F2%2F2020%207%3A47%3A32%205%20-330&d.&nsid=0&jsonv=1&.d&sdid=4CA3DB40BB56A3B1-062CCA439234AD7C&mid=25135486547984740651195090168424127981&aamlh=12&ce=UTF-8&ns=usbank&pageName=Personal%20Home%20Page&g=https%3A%2F%2Fwww.usbank.com%2Findex.html&r=https%3A%2F%2Fwww.usbank.com%2Findex.html&c.&vidAPICheck=VisitorAPI%20Present&et_dimensions=794x576&et_width=794&et_orientation=landscape&EVENTS=event17%2Cevent15%2C&.c&cc=USD&events=event17%2Cevent15&aamb=RKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y&c1=home%20pg&c2=home%20page%20rebranded&c3=D%3Dv3&v3=Repeat&c4=9%3A15PM&c6=Thursday&c7=3%2F20%2F2020&v9=prospect&c14=D%3Dg&c18=More%20than%207%20days&c19=2&c24=usb%3Aindex.html&c25=D%3Dc24&v27=4183033d771f40e0a01b52a304feecfb.31_0&c29=https%3A%2F%2Fwww.usbank.com%2Findex.html&v35=D%3DpageName&v37=D%3DUser-Agent&c40=dotcom&v40=D%3Dc2&c50=R%20October%202019%7CAM_2.17.0%7C10.07.2019%7CbaseOLB%7CVid_4.0.0&v59=nh&v90=D%3Dg&s=1366x768&c=24&j=1.6&v=N&k=Y&bw=811&bh=576&mcorgid=675616D751E567410A490D4C%40AdobeOrg&AQE=1");
			
		    Map<String, String> query_pairs = new LinkedHashMap<String, String>();
		    String query = url.getQuery();
		    String[] pairs = query.split("&");
		    for (String pair : pairs) {
		        int idx = pair.indexOf("=");
		        query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
		       // System.out.println(query_pairs);
		    }
		    return query_pairs;
		}
}
//		    
//		    
//		    
//		}
//		public static Map<String, String> splitQuery(URL url) throws UnsupportedEncodingException {
//			  final Map<String, String> query_pairs = new LinkedHashMap<String, String>();
//			  final String[] pairs = url.getQuery().split("&");
//			  for (String pair : pairs) {
//			    final int idx = pair.indexOf("=");
//			    final String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), "UTF-8") : pair;
//			    if (!query_pairs.containsKey(key)) {
//			      query_pairs.put(key, new LinkedList<String>());
//			    }
//			    final String value = idx > 0 && pair.length() > idx + 1 ? URLDecoder.decode(pair.substring(idx + 1), "UTF-8") : null;
//			    query_pairs.get(key).add(value);
//			  }
//			  return query_pairs;
//			}
//			
//	}





