package nepar;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

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

public class Class1 extends Class2  {

	//protected static WebDriver driver = null;
	private static Actions act = null;
	
//	public Class1() {		
//		PageFactory.initElements(driver,this);
//	}
//	private static JavascriptExecutor js = (JavascriptExecutor) driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Class2 c = new Class2();
		
//		Class2.BrowserLaunch(driver, act);
		Class2.BrowserLaunch(driver, act);
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//		System.setProperty("webdriver.chrome.driver",
//				"D:\\\\json jars\\\\chrome driver\\\\chromedriver_win32\\\\chromedriver.exe");
//
//		ChromeOptions caps = new ChromeOptions();
//		caps.setPageLoadStrategy(PageLoadStrategy.EAGER);
//		LoggingPreferences logPrefs = new LoggingPreferences();
//
//		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
//
//		caps.setCapability("goog:loggingPrefs", logPrefs);
//
//		driver = new ChromeDriver(caps);
//		act = new Actions(driver);
//
//		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
//
//		driver.manage().window().maximize();
//
//		driver.manage().deleteAllCookies();
//		try {
//		driver.get("https://www.cognizant.com/");
//		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
//
//		driver.manage().timeouts().implicitlyWait(12000, TimeUnit.MILLISECONDS);
		//Class2.getdriver().getTitle();
		System.out.println(Class2.getdriver().getTitle());
		String fin = "(//i[@title='Search'])[1]";
		driver.manage().timeouts().implicitlyWait(12000, TimeUnit.MILLISECONDS);
		WebElement f = Class2.finde(driver, fin);
		
		Class2.clickop(f, act);
		
		System.out.println(driver.getTitle());
		String search = "//input[@id='tagsChk']";
		WebElement s = Class2.finde(driver, search);
		Class2.clickop(s, act);
		Thread.sleep(1000);
		s.sendKeys("careers");
		driver.manage().timeouts().implicitlyWait(40000, TimeUnit.MILLISECONDS);
		s.clear();
		String str= "java";
		Thread.sleep(20000);
		//c.sendke(driver,s,str);
		//Thread.sleep(10000);
		//s.sendKeys("java");
		
		Class2.senk(s, act, str);
		System.getProperty("user.name");
//		Thread.sleep(3000);
//		c.clickop(s, act);
//		c.javascr(js,str,s);
		
		
//		String  Locator = "//li[@role =\"menuitem\"]/ a[ contains( text(), 'Careers')]";
//		WebElement e = c.finde( driver,  Locator);
//		driver.manage().timeouts().implicitlyWait(40000, TimeUnit.MILLISECONDS);
//		String x = e.getText();
//		String a = e.getAttribute("value");
//		System.out.println(x);
//		System.out.println(a);
//		//e.click();
//		c.clickop(e, act);
//		
//		System.out.println(driver.getTitle());
//		
//		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		
	}
//		catch(Exception e) {
//		
//			System.out.print(e);
//		}
//
//
//	}
}

