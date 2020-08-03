package nepar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.poi.hwpf.usermodel.ListEntry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Logerr {
//       private static DesiredCapabilities caps = null;
	  private static ChromeOptions caps = null;
       
       private static LoggingPreferences logPrefs = null;
       
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		
//		DesiredCapabilities caps = DesiredCapabilities.chrome();
//		caps.setCapability("goog:loggingPrefs", logPrefs);
//		LoggingPreferences logPrefs = new LoggingPreferences();
//    	logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
//				// #as per latest docs
//				//caps['goog:loggingPrefs'] = {'performance': 'ALL'}
//				WebDriver driver = ChromeDriver(desiredcapabilities=caps);
//
//				driver.get("https://stackoverflow.com");
//				
//
//				for entry in driver.get_log('performance'):
//				   
//
//				driver.quit();
		
		
		
//	    //  caps = DesiredCapabilities.chrome();
//		caps = new ChromeOptions(); 
//
//          logPrefs = new LoggingPreferences();
//
//          logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
//
//          caps.setCapability("goog:loggingPrefs", logPrefs);
//		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		//ChromeOptions cap = new ChromeOptions();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

		Map<String, Object> perfLogPrefs = new HashMap<String, Object>();
		perfLogPrefs.put("traceCategories", "browser,devtools.timeline,devtools"); // comma-separated trace categories
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("perfLoggingPrefs", perfLogPrefs);
		caps.setCapability(ChromeOptions.CAPABILITY, options);

		//RemoteWebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), cap);

		  System.setProperty("webdriver.chrome.driver", "D:\\json jars\\chrome driver\\chromedriver_win32\\chromedriver.exe");
          WebDriver driver = new ChromeDriver();

          driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

          driver.manage().window().maximize();

          driver.manage().deleteAllCookies();
          driver.get("https://www.usbank.com/index.html");
          driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
          WebElement mg = driver.findElement(By.xpath("//a[@title='Wealth Management']"));
          mg.click();
	       
	        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
          
          List<LogEntry>  entr = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
          System.out.println(entr);
          



//      driver.get("https://www.usbank.com/business-banking.html");

//      Thread.sleep(4000);

	}

}
