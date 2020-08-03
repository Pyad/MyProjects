package nepar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

public class LoEntry {
	
	private static WebDriver driver = null;
	private static List<List<LogEntry>> list = null;
	//private List<LogEntry> logEntries = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
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
		
		
		LoEntry entry = new LoEntry();
		List<LogEntry> expected = entry.logs();

		System.out.println(expected.size());
		for(LogEntry ele : expected) {
		System.out.println(ele);
		}
	
		
		
		WebElement car = driver.findElement(By.xpath("//a[@href='/careers']"));
		car.click();
		
		
		List<LogEntry> expected1 = entry.logs();
		
		System.out.println(expected1.size());
		
		driver.navigate().back();
		expected1 = entry.logs();
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		driver.navigate().refresh();
		List<LogEntry> expected3 = entry.logs();
		
		

	}
	public List<LogEntry> logs() {
		
		
		 List<LogEntry> logEntries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
		 System.out.println("Size - LogEntries" +logEntries.size());
		 return logEntries;
		// list = Arrays.asList(logEntries);
      
		}

}
