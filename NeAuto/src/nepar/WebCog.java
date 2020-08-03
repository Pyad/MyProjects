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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebCog {
	private static WebDriver driver = null;
	private static List<String> list = null;

	public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver",
				"D:\\\\json jars\\\\chrome driver\\\\chromedriver_win32\\\\chromedriver.exe");
		
		 ChromeOptions caps = new ChromeOptions();
		LoggingPreferences logPrefs = new LoggingPreferences();
		
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		

		caps.setCapability("goog:loggingPrefs", logPrefs);
		

		driver = new ChromeDriver(caps);

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://www.cognizant.com/");
		Thread.sleep(1200);
		
	
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		
		WebElement lin = driver.findElement(By.xpath("//a[@class = 'text-gray-dark1' and @title='Application Services' and contains(text(), 'Application Services')]"));
		lin.click();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		System.out.println( driver.findElement(By.xpath("//h1[@class='h3 text-white']")).isDisplayed());
		
			
		Thread.sleep(12000);

		List<LogEntry> logEntries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
		
		
		
		Pattern pattern = Pattern.compile("\"url\":\"(.*?)\"},");
		System.out.println("log" + logEntries);

		for (LogEntry entry1 : logEntries) {

			if ((entry1.getMessage().indexOf("https://cognizant.sc.omtrdc.net/b/ss/" )> -1) ) {
				
				
				Matcher matcher = pattern.matcher(entry1.getMessage());
				System.out.println("M " + entry1);

				if (matcher.find()) {

					
					String s = matcher.group(1);
					
					String decodeURL = decode(s);
					
					if(decodeURL.contains("assets.adobedtm.com")) {
						System.out.println("Unmathced tags "+ decodeURL);
						System.out.println();
					}
					else if ((!decodeURL.isEmpty()) && decodeURL.length()>1000) {
						System.out.println("Length greater than ->" + decodeURL);
						System.out.println();
					}
					else if(decodeURL.length()<1000) {
						System.out.println("Length less than ->" + decodeURL);
						System.out.println();
						
					}

				}
			}
		}
		
	}
	
	
	

	private static String decode(String s) {

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
