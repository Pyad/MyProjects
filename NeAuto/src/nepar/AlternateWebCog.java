package nepar;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

public class AlternateWebCog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\DELL\\Downloads\\chrome81.0\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		ChromeOptions caps = new ChromeOptions();
		//caps.setCapability("goog:loggingPrefs", logPrefs);

		//driver = new ChromeDriver(caps);

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		try {
		driver.get("https://www.usbank.com/index.html");
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(12000, TimeUnit.MILLISECONDS);

		System.out.println(driver.getTitle());

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		List<WebElement> links = driver.findElements(By.tagName("a") );
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		System.out.println("Total no.of.links -> " + links.size());
//		List<WebElement> list = new LinkedList<WebElement>();
//		links.removeIf(item -> item == null || "".equals(item));
	//	System.out.println("Total no.of.links -> " + links.size());
		List<String> list2 = new LinkedList<String>();
		
		for(int i=0; i<links.size(); i++) {
			WebElement x = links.get(i);
			boolean n = x.isDisplayed();
			boolean m = x.isEnabled();
			if(n== true) {
				list2.add(x.getText());
				System.out.println("Link "+x.getText() +" displayed "+n +" isenabled "+ m);
			}
			else {
				
				//list.add(x.getText());
				System.out.println("Link "+x.getText() +" dis "+n +"  isenabled" + m );
				
			}
			
			
			
		}
		//List<LogEntry> logEntries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
		
		
		System.out.println("Total links " +list2.size());
	}catch(Exception e) {
		e.printStackTrace();
	}
		
}
}
