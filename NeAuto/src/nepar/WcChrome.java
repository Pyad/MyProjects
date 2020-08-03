package nepar;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WcChrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	        ChromeOptions opt = new ChromeOptions();
		    opt.setExperimentalOption("w3c", true);
		    ChromeDriver driver = new ChromeDriver(opt);
		    driver.get("https://www.google.co.in");
		    opt.setCapability(capabilityName, value);
		    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		    capabilities.setCapability(capabilityName, value);
		    opt.
		    //new code
		    
			caps = new ChromeOptions(); 

	          logPrefs = new LoggingPreferences();

	          logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

	          caps.setCapability("goog:loggingPrefs", logPrefs);

			  System.setProperty("webdriver.chrome.driver", "D:\\json jars\\chrome driver\\chromedriver_win32\\chromedriver.exe");
	          WebDriver driver = new ChromeDriver(caps);
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    public Driver(ChromeDriverModel chromeDriverModel)
	        {
	            ChromeOptions chromeOptions = new ChromeOptions();
	            enablePerformanceMonitor = chromeDriverModel.enablePerformanceMonitoring;
	            if (enablePerformanceMonitor)
	                chromeOptions = _ChromePerformanceOptions();

	            if (!string.IsNullOrWhiteSpace(chromeDriverModel.ChromeDriverLocation))
	            {
	                if (enablePerformanceMonitor)
	                    _webDriver = new ChromeDriver(chromeDriverModel.ChromeDriverLocation, chromeOptions);
	                else
	                    _webDriver = new ChromeDriver(chromeDriverModel.ChromeDriverLocation);
	            }
	            else
	            {
	                if (enablePerformanceMonitor)
	                    _webDriver = new ChromeDriver(chromeOptions);
	                else
	                    _webDriver = new ChromeDriver();
	            }
	        }

		    
		    
		    LoggingPreferences logPrefs = new LoggingPreferences();
		    logPrefs.enable(LogType.BROWSER, Level.ALL);
		    logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
		    caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		    

	private ChromeOptions _ChromePerformanceOptions()
	        {
	            ChromeOptions option = new ChromeOptions();
	            ChromeOptions perfLogPrefs = new ChromePerformanceLoggingPreferences();
	            perfLogPrefs.AddTracingCategories(new string[] { "devtools.network", "devtools.timeline" });
	            option.PerformanceLoggingPreferences = perfLogPrefs;
	            option.AddAdditionalCapability(CapabilityType.EnableProfiling, true, true);
	            option.SetLoggingPreference("performance", LogLevel.All);
	            return option;
	        }

	}

}
