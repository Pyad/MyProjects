package nepar;  
 import java.io.UnsupportedEncodingException;  
 import java.net.URLDecoder;  
 import java.net.URLEncoder;
import java.util.regex.Pattern;  
 public class Webecode {  
      public static void main(String[] args) {  
           // TODO Auto-generated method stub  
           String url="https://smetrics.usbank.com/b/ss/usbankcom/10/JS-2.12.0/s24431113088424?AQB=1&ndh=1&pf=1&callback=s_c_il[9].doPostbacks&et=1&t=29%2F3%2F2020%2018%3A16%3A19%203%20-330&d.&nsid=0&jsonv=1&.d&sdid=23A2072C7C062AD6-3220F21B6449758B&mid=56726085365424134070811058675193431913&aid=2F54BB880515D6BE-60000A314142808B&aamlh=12&ce=UTF-8&ns=usbank&pageName=Personal%20Home%20Page&g=https%3A%2F%2Fwww.usbank.com%2Findex.html&c.&vidAPICheck=VisitorAPI%20Present&et_dimensions=1349x613&et_width=1349&et_orientation=landscape&EVENTS=event17%2Cevent15%2C&.c&cc=USD&events=event17%2Cevent15&aamb=RKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y&c1=home%20pg&c2=home%20page%20rebranded%20ghp&c3=D%3Dv3&v3=New&c4=7%3A45AM&c6=Wednesday&c7=4%2F29%2F2020&v9=prospect&c14=D%3Dg&c18=First%20Visit&c19=1&c24=usb%3Aindex.html&c25=D%3Dc24&v27=fee29ee9982b4d37b4d292fe479ab2b0.31_0&c29=https%3A%2F%2Fwww.usbank.com%2Findex.html&v35=D%3DpageName&v37=D%3DUser-Agent&c40=dotcom&v40=home%20page%20rebranded%20ghp&c50=baseCore%7CAM_2.12.0%7C04.24.2019%7CVid_4.0.0&v90=D%3Dg&s=1366x768&c=24&j=1.6&v=N&k=Y&bw=1366&bh=613&mcorgid=675616D751E567410A490D4C%40AdobeOrg&AQE=1" ; 
           String url2="https://r1---sn-ci5gup-cags.googlevideo.com/videoplayback?pcm2cms=yes&mime=video/mp4&pl=21&itag=22&&itag=43&type=video/webm; codecs=\"vp8.0, vorbis\"&quality=medium";  
           String decodeURL = decode(url);  
           System.out.println("Decoded URL: "+decodeURL);  
           String encodeURL = encode(url2);  
           System.out.println("Encoded URL2: "+encodeURL);  
           String hal ="http://smetric.usbank.com/b/ss/";
           String pattern = "\"url\":\"(.*?)\"},";
           
           boolean matches = Pattern.matches(pattern, hal);
           System.out.println("matches = " + matches);
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
      public static String encode(String url)  
      {  
                try {  
                     String encodeURL=URLEncoder.encode( url, "UTF-8" );  
                     return encodeURL;  
                } catch (UnsupportedEncodingException e) {  
                     return "Issue while encoding" +e.getMessage();  
                }  
      }  
 }
