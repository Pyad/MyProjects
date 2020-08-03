package nepar;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.regex.Matcher;

import org.json.JSONException;
import org.json.JSONObject;
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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ObjectBuffer;

public class Wedr {
	
   private static WebDriver driver = null;
    
	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\chrome79\\chromedriver_win32 (1)\\chromedriver.exe");
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver",
				"D:\\json jars\\Chrome81\\chromedriver_win32\\chromedriver.exe");
		 ChromeOptions caps = new ChromeOptions();
	     driver = new ChromeDriver(caps);
		
		//caps.setPageLoadStrategy(PageLoadStrategy.EAGER);
		LoggingPreferences logPrefs = new LoggingPreferences();
		//caps.setCapability("w3c", false);
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

		caps.setCapability("goog:loggingPrefs", logPrefs);
		
		
		
		
		//driver = new ChromeDriver(caps);

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		List<String> list = new LinkedList<String>();
		list.add("//li[@role =\"menuitem\"]/a[ contains( text(), 'Careers')]");
		list.add("//li[@role =\"menuitem\"]/a[ @class = \"text-black small\" and contains( text(), 'News')]");
		list.add("//li[@role =\"menuitem\"]/a[ @class = \"text-black small\" and contains( text(), 'Events')]");
		list.add("//li[@role =\"menuitem\"]/a[ @class = \"text-black small\" and contains( text(), 'Investors')]");
		list.add("//a[@id = 'Industries']");
		list.add("//a[@id = 'Services']");
		
		
			//System.out.println(driver.manage().logs().getAvailableLogTypes());
		driver.get("https://www.cognizant.com/");
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(12000, TimeUnit.MILLISECONDS);
		
		System.out.println(driver.getTitle());
	
		
		//String e = '"//a[@id = \'Services\']"';
		driver.manage().timeouts().implicitlyWait(12000, TimeUnit.MILLISECONDS);		
		
		//driver.findElement(By.xpath(list.get(i)));
		for(int i=0; i<list.size();i++) {
			
			
			System.out.println("list "+list.get(i));
			//System.out.println(driver.findElement(By.xpath(list.get(i).toString())));
			String elem= list.get(i);
			System.out.println(elem);
		  driver.findElement(By.xpath(list.get(i))).click();
		  Wedr entry = new Wedr();
			List<LogEntry> expected = entry.logs();
		 
		driver.manage().timeouts().implicitlyWait(12000, TimeUnit.MILLISECONDS);
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		
		driver.navigate().back();
		
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		
		
for (LogEntry logEntry : expected)
	   {
	System.out.println("M " + logEntry);
//		   JSONObject jsonObject = new JSONObject(logEntry);
//	           System.out.println(jsonObject.getString("url"));
		   
		   if ((logEntry.getMessage().indexOf("Network.requestWillBeSent") > -1)
					&& (logEntry.getMessage().indexOf("https://cognizant.sc.omtrdc.net/b/ss/") > -1)
					&& (logEntry.getMessage().indexOf("pev1") > -1) && (logEntry.getMessage().indexOf("pev2") > -1)
					&& (logEntry.getMessage().indexOf("GET") > -1) && (logEntry.getMessage().indexOf("Image") > -1)) {

				//Matcher matcher = pattern.matcher(logEntry.getMessage());
				System.out.println("M " + logEntry);
				
		   
		   }
	         }
	   
	//System.out.println(loglogEntry);
//		System.out.println(logs.size());
//		
		
		}

	

}
	
	
	public static List<LogEntry> logs() {
		driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);

		List<LogEntry> logEntries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();

		// System.out.println("Size - LogEntries" + logEntries.size());

		return logEntries;
		// list = Arrays.asList(logEntries);

}
}