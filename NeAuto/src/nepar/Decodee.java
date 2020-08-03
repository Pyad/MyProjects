package nepar;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Decodee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String st = "{\"message\":{\"method\":\"Network.requestWillBeSent\",\"params\":{\"documentURL\":\"https://www.cognizant.com/\",\"frameId\":\"EEF52014B73A7E9687991807DFD39938\",\"hasUserGesture\":false,\"initiator\":{\"lineNumber\":0,\"type\":\"parser\",\"url\":\"https://www.cognizant.com/\"},\"loaderId\":\"8DE44183DA9EBAF0118476D1E2AE48F5\",\"request\":{\"headers\":{\"Referer\":\"https://www.cognizant.com/\",\"User-Agent\":\"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.129 Safari/537.36\"},\"initialPriority\":\"Low\",\"method\":\"GET\",\"mixedContentType\":\"none\",\"referrerPolicy\":\"no-referrer-when-downgrade\",\"url\":\"https://cognizant.sc.omtrdc.net/b/ss/ctsprodlive/1/JS-2.13.1-LAS8/s87783837758693?AQB=1&ndh=1&pf=1&t=4%2F4%2F2020%208%3A11%3A17%201%20-330&sdid=65C3A331ADB7690A-3B51BC8A01F892FF&mid=59064629407289888902002949255328946803&aamlh=12&ce=UTF-8&pageName=Digital%20Solutions%20to%20Advance%20Your%20Business%20%7C%20Cognizant&g=https%3A%2F%2Fwww.cognizant.com%2F&cc=USD&ch=EN_US&aamb=RKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y&h1=en_US&c8=D%3Dv8&c15=D%3Dv15&v15=Digital%20Solutions%20to%20Advance%20Your%20Business%20%7C%20Cognizant&c16=D%3Dv16&v16=D%3Dg&c18=D%3Dv18&v18=Digital%20Solutions%20to%20Advance%20Your%20Business-%20Cognizant%20%7C%20Home%20Page&v29=59064629407289888902002949255328946803&v37=nc&c44=New&v44=New&c45=120&v45=Mozilla%2F5.0%20%28Windows%20NT%206.1%3B%20Win64%3B%20x64%29%20AppleWebKit%2F537.36%20%28KHTML%2C%20like%20Gecko%29%20Chrome%2F81.0.4044.129%20Safari%2F537.36&c46=10%3A41%20PM%7CSunday&c60=D%3Dv60&v60=cts%3Aus%3Aen%3Aen_us&c61=D%3Dv61&v61=Digital%20Solutions%20to%20Advance%20Your%20Business%20%7C%20Cognizant&c62=D%3Dv62&v62=https%3A%2F%2Fwww.cognizant.com%2F&c63=D%3Dv63&v63=1f44fc80-9fef-450c-8e80-6409d2a3e8c3&v64=true&v65=2018-04-15&v66=en_US&v67=US&v68=EN&c69=D%3Dv69&v69=External%7CBookmarked&v70=en_us&c71=D%3Dv71&v71=CTS%3AUS%3AEN%3AHOME-PAGE&v72=UNCATEGORIZED&v73=UNCATEGORIZED&v74=2020-04-28&v81=Cognizant%20%2C%20Digital%20Solutions%2C%20digital%20business&v110=Not%20Identified%3ANot%20Identified%3AIndia%3AChennai%3ANot%20Identified%3ANot%20Identified%3ANot%20Identified%3ANot%20Identified&v111=IN%3ANot%20Identified%3ANot%20Identified%3ATamil%20Nadu%3ANot%20Identified%3ANot%20Identified%3ANot%20Identified%3ANot%20Identified&s=1366x768&c=24&j=1.6&v=N&k=Y&bw=1366&bh=613&mcorgid=00FD3942552521970A4C98A4%40AdobeOrg&AQE=1\"},\"requestId\":\"12744.237\",\"timestamp\":82197.465466,\"type\":\"Image\",\"wallTime\":1588560077.162872}},\"webview\":\"EEF52014B73A7E9687991807DFD39938\"}";
	  System.out.println("decoded url" +decode(st));
	
	}
	
	
	private static String decode(String s) {

		try {
			String prevURL = "";
			String decodeURL = s;
			while (!prevURL.equals(decodeURL)) {
				prevURL = decodeURL;
				decodeURL = URLDecoder.decode(decodeURL, "UTF-8");
//			 if ((!decodeURL.isEmpty()) && decodeURL.length()>1000) {
//					
//					System.out.println("Length greater than 1000->" + decodeURL);
//					System.out.println();
//				
//			 }
			}
			return decodeURL;
			
		} catch (UnsupportedEncodingException e) {
			return "Issue decoding" + e.getMessage();
		}

	}

}
