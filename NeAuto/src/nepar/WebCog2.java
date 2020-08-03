package nepar;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.charset.*;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebCog2 {
	private static WebDriver driver = null;
	private static List<String> list = null;
	private static List<String> al  = new ArrayList<String>();
	

	public static void main(String[] args) throws InterruptedException {
		
		
            BrowserLaunch();
            
           
            
		
	}
	public static void BrowserLaunch() throws InterruptedException {
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver",
				"D:\\\\json jars\\\\chrome driver\\\\chromedriver_win32\\\\chromedriver.exe");
		
		 ChromeOptions caps = new ChromeOptions();
		 caps.setPageLoadStrategy(PageLoadStrategy.EAGER);
		LoggingPreferences logPrefs = new LoggingPreferences();
		
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		

		caps.setCapability("goog:loggingPrefs", logPrefs);
		

		driver = new ChromeDriver(caps);

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://www.cognizant.com/");
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(12000, TimeUnit.MILLISECONDS);
		//Thread.sleep(1200);
		System.out.println(driver.getTitle());
		//LogExtraction();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		System.out.println(links.size());
		 list = new LinkedList<String>();
		
		for(WebElement tex: links) {
			
			list.add(tex.getText());
//			System.out.println(tex.getText());
			
			
		}
		
		list.removeIf(item -> item == null || "".equals(item));
		
		//for(int i=0; i<list.size()-5;i++) {
			for(int i=0; i<2;i++) {
			
			String lin = list.get(i);
			System.out.println("link " +lin);
			 driver.findElement(By.linkText(lin)).click();
			 driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			 System.out.println(driver.getTitle());
			 LogExtraction(lin);
			
			
			//System.out.println(links.get(i).getText());
			//launch(links.get(i).getText());
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			driver.navigate().back();
			driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
		
		}	
			
		}
  
		
	
      public static void LogExtraction(String lin) {
    	   String st = lin;
    	   
    	
    	   Map<String,List<String>> multiMap = new LinkedHashMap<String,List<String>>();	
			
		
			
		//List<LogEntry> logEntries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
    	   WebCog2 entry = new WebCog2();
   		List<LogEntry> expected = entry.logs();
		
		
		Pattern pattern = Pattern.compile("\"url\":\"(.*?)\"},");
		System.out.println("log" + expected);

		for (LogEntry entry1 : expected) {

			if ((entry1.getMessage().indexOf("https://cognizant.sc.omtrdc.net/b/ss/" )> -1) && (entry1.getMessage().indexOf("Network.requestWillBeSent") > -1)) {
				
				
				Matcher matcher = pattern.matcher(entry1.getMessage());
				System.out.println("M " + entry1);
				
			
				if (matcher.find() ) {

					
					String s = matcher.group(1);
					System.out.println("matcher s "+s);
					
					List<String> all = entry.durl(s);
					 multiMap.put(lin,all);
					 
					 for (Entry<String, List<String>> ent: multiMap.entrySet())  
				            System.out.println("Key = " + ent.getKey() + 
				                             ", Value = " + ent.getValue()); 
					
//					String decodeURL = decode(s);
//					
//					System.out.println(" decodeURL -> " + decodeURL);
//					System.out.println();
//					
//					al.add(decodeURL);
//					System.out.println("Size of al "+al.size());
				}
           }
				
				//multiMap.put(lin, al);
//					else  {
//					multiMap.put(lin, al);
//					
//					for (Entry<String, ArrayList<String>> entry5 : multiMap.entrySet())  
//			            System.out.println("Key = " + entry5.getKey() + 
//			                             ", Value = " + entry5.getValue()); 
//					}
					 
					
					
//					if(decodeURL.contains("assets.adobedtm.com")) {
//						System.out.println("Unmathced tags "+ decodeURL);
//						System.out.println();
//					}
//					else if ((!decodeURL.isEmpty()) && decodeURL.length()>700) {
//						iter(decodeURL, st);
//						System.out.println("Length greater than ->" + decodeURL);
//						System.out.println();
//					}
//					else if(decodeURL.length()<1000) {
//						System.out.println("Length less than ->" + decodeURL);
//						System.out.println();
//						
//					}

				}
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
			System.out.println("Decode = " +decodeURL);
			return decodeURL;
			
		} catch (UnsupportedEncodingException e) {
			return "Issue decoding" + e.getMessage();
		}

	}
	
	/**
	 * @author DELL
	 * @return logEnt
	 * 
	 */
	public static List<LogEntry> logs() {
		driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
		
		 List<LogEntry> logEntries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
		 
		 System.out.println("Size - LogEntries" +logEntries.size());
		 
		 return logEntries;
		// list = Arrays.asList(logEntries);
     
		}
	
	
	  public static List<String> durl(String s2){
		   
				String decodeURL = decode(s2);
				
				System.out.println(" decodeURL -> " + decodeURL);
				System.out.println();
				
				al.add(decodeURL);
				System.out.println("Size of al "+al.size());
				return (al);
			}
	
public static void iter(String decodeURL, String st) {
		
		
		System.out.println("String  " +st);
		Map<String,ArrayList<String>> multiMap = new LinkedHashMap<String,ArrayList<String>>();
		
		ArrayList<String> al  = new ArrayList<String>();
		al.add(decodeURL);
		
		
		
		
		for(int i =0; i<al.size();i++) {
			System.out.println("ArrayList " +al.get(i));
			
		}
		
		multiMap.put(st, al);
		
		 for (Entry<String, ArrayList<String>> entry : multiMap.entrySet())  
	            System.out.println("Key = " + entry.getKey() + 
	                             ", Value = " + entry.getValue()); 
	}
	
	
	
	
	
	
}
