package nepar;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.charset.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebPoc2 {
	private static WebDriver driver = null;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\\\json jars\\\\chrome driver\\\\chromedriver_win32\\\\chromedriver.exe");        
      DesiredCapabilities caps = DesiredCapabilities.chrome();
		// ChromeOptions opt = new ChromeOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
       //logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
       // caps.setCapability("goog:loggingPrefs", logPrefs);
       
        caps.setCapability("goog:loggingPrefs", logPrefs);
       // opt.addArguments("--enable-logging");
        
        driver = new ChromeDriver(caps);
        
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        driver.manage().window().maximize();

      //  driver.manage().deleteAllCookies();
        
        driver.get("https://www.cognizant.com/");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        
        WebElement lin = driver.findElement(By.xpath("//a[@class = 'text-gray-dark1' and @title='Application Services' and contains(text(), 'Application Services')]"));
		lin.click();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        Thread.sleep(12000);
//        WebElement li = driver.findElement(By.xpath("//li[@id=\"myList2\"]/a"));
//        li.click();
//        Thread.sleep(9000);

        
        List<LogEntry> logEntries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
        Pattern pattern = Pattern.compile("\"url\":\"(.*?)\"},");
       System.out.println("log" +logEntries);
        
       // for (LogEntry entry : logEntries) {
        //	System.out.println("Entries values-> "+entry.getMessage().indexOf("http://smetric.usbank.com/b/ss/"));
        	for(LogEntry entry1 :logEntries) {
        		//System.out.println("MSG "+entry1.getMessage());
        		//if((entry1.getMessage().indexOf("URL") > -1)) {
         	   if((entry1.getMessage().indexOf("https://cognizant.sc.omtrdc.net/b/ss/") > -1)) {
         		   Matcher matcher = pattern.matcher(entry1.getMessage());
         		   System.out.println("M "+entry1 );
//        	
        	
        	
        	
        	
        	
           //System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
//           
           
//           Pattern pattern = Pattern.compile("\"url\":\"(.*?)\"},");
//           for(LogEntry entry1 :logEntries) {
//        	   if((entry1.getMessage().indexOf("http://smetric.usbank.com/b/ss/") > -1)) {
 //       		   Matcher matcher = pattern.matcher(entry1.getMessage());
//        		   System.out.println("Matcher values->" +matcher);
// \       	   }
//           }
        //}
       		   if(matcher.find()) {
       			   
       		   System.out.println(matcher.group(1));
        			   String s = matcher.group(1);
        			   //System.out.println(s);
        			  String decodeURL =decode(s);
        			  System.out.println(decodeURL);
        			  if(!decodeURL.isEmpty()) {
        				  System.out.println("empti ->" + decodeURL);
        			  }
        			   
        		   }
      	   }
         	   }
        	}
	
        
//        	   
          // }
            
            
            //driver.quit();
            //do something useful with the data
     //   }

	private static String decode(String s) {
		
		
//		try {
//			return URLDecoder.decode(s, StandardCharsets.UTF_8.toString());
//		}catch(UnsupportedEncodingException ex) {
//			throw new RuntimeException(ex.getCause());
//		}
		// TODO Auto-generated method stub
		try {
			String prevURL = "";
			String decodeURL = s;
			while (!prevURL.equals(decodeURL)) {
				prevURL = decodeURL;
				decodeURL = URLDecoder.decode(decodeURL, "UTF-8");

			}
			return decodeURL;
		} catch (UnsupportedEncodingException e) {
			return "Issue decoding" + e.getMessage();
		}

	}
}
