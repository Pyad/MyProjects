package nepar;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.PageFactory;

public class Class2 {

//	private static WebDriver driver = null;
//	private static Actions act = null;
	//private static JavascriptExecutor js = (JavascriptExecutor) driver;
	
//	public static void finde(String Locator) {
//		try {
//			return driver.findelement(Locator);
//		}
//	}
//
//	public WebElement finde(WebDriver driver, String Locator) {
//		// TODO Auto-generated method stub
//		
//		
//	}
	public static WebDriver driver;
	
//	public Class2() {		
//		PageFactory.initElements(driver,this);
//	}	
//	
	public static WebDriver getdriver(){
	    if (driver == null){
	      driver = new ChromeDriver();
	      return driver;
	    }else{
	      return driver;
	    }
	}
	public static void BrowserLaunch(WebDriver driver, Actions act) {
		try {
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			System.setProperty("webdriver.chrome.driver",
					"D:\\\\json jars\\\\chrome driver\\\\chromedriver_win32\\\\chromedriver.exe");

			ChromeOptions caps = new ChromeOptions();
			caps.setPageLoadStrategy(PageLoadStrategy.EAGER);
			LoggingPreferences logPrefs = new LoggingPreferences();

			logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

			caps.setCapability("goog:loggingPrefs", logPrefs);

			driver = new ChromeDriver(caps);
			act = new Actions(driver);

			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

			driver.manage().window().maximize();

			driver.manage().deleteAllCookies();
			
			driver.get("https://www.cognizant.com/");
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);

			driver.manage().timeouts().implicitlyWait(12000, TimeUnit.MILLISECONDS);

		}
		catch(Exception e) {
			return;
		}
		
	}

	public static WebElement finde(WebDriver driver, String locator) {
		// TODO Auto-generated method stub
		try {
			return driver.findElement(By.xpath(locator));
		}
		catch(Exception e) {
			return null;
		}
	}

	public static void clickop(WebElement e, Actions act) {
		// TODO Auto-generated method stub
		try {
			 act.moveToElement(e).click().perform();
		}
		catch(Exception e1) {
			return;
		}
		
	}

	public static void senk(WebElement s, Actions act, String str) {
		// TODO Auto-generated method stub
		try {
			System.out.println("sendkey");
			Thread.sleep(3000);
			Actions ac = act.moveToElement(s);
			System.out.println("element");
			ac.sendKeys(str).build().perform();
			System.out.println("element1");
		}
		catch(Exception e1) {
			return;
		}
	}

	public void javascr(JavascriptExecutor js, String str, WebElement s) {
		// TODO Auto-generated method stub
		
		//WebElement pesel = driver.findElement(fldPesel);
		js.executeScript("arguments[0].value='" + str + "';", s);
		
		
	}

	public void sendke(WebDriver driver, WebElement s, String str) {
		// TODO Auto-generated method stub
		try {
			s.sendKeys(str);
		}
		catch(Exception e) {
			
		}
		
	}
}
