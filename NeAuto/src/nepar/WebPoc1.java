package nepar;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import nepar.WebPoc.POCForApply;

public class WebPoc1 {

	 public static String decodeURL;

     public static DesiredCapabilities caps;

     public static LoggingPreferences logPrefs;

     public static Map<Integer, String> dataMapActual;

     public static List<LogEntry> entries1;

     public static String[] str3;

    // private static Logger logs=LogManager.getLogger(POCForApply.class.getName()); 
		public static void main(String[] args) throws Exception {

            // TODO Auto-generated method stub
			ChromeOptions opt = new ChromeOptions();
            caps = DesiredCapabilities.chrome();
            
            //ChromePerformanceLoggingPreferences perfLogPrefs = new ChromePerformanceLoggingPreferences()
            
           // perfLogPrefs = new ChromePerformanceLoggingPreferences();
                           
                            logPrefs = new LoggingPreferences();
                            logPrefs.enable(LogType.BROWSER, Level.ALL);

                            logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
                           // logPrefs.enable(LogType.BROWSER, level.);
                           
                           // caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

                            caps.setCapability("goog:loggingPrefs", logPrefs);

                            System.setProperty("webdriver.chrome.driver",

                                                            "D:\\\\json jars\\\\chrome driver\\\\chromedriver_win32\\\\chromedriver.exe");

                            WebDriver driver = new ChromeDriver(caps);

                            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

                            driver.manage().window().maximize();

                            driver.manage().deleteAllCookies();
                         // LogEntries log =  driver.manage().logs().get(LogType.BROWSER);

//                        driver.get("https://www.usbank.com/business-banking.html");

//                        Thread.sleep(4000);

//driver.findElement(By.xpath("//*[@id=\"tab1\"]")).click();

//Thread.sleep(4000);

//driver.findElement(By.xpath("//*[@id=\"tab2\"]")).click();

//Thread.sleep(4000);

                            driver.get("https://www.usbank.com/index.html");

                            Thread.sleep(6000);
                            WebElement li = driver.findElement(By.xpath("//li[@id=\"myList2\"]/a"));
                            li.click();
                            Thread.sleep(6000);
//
//
//            //            Thread.sleep(2000);
//
//                            WebElement a = driver.findElement(By.xpath("//*[@id=\"btn-login-id\"]"));
//
//                            BaseApply.scrollToView(driver, a);
//
//                            BaseApply.safeJavaScriptClick(driver, a);
//
//                            Thread.sleep(5000);
//
//                            WebElement element1 = driver.findElement(By.xpath("//*[@id='form']/div[3]/button"));
//
//                            driver.manage().window().fullscreen();
//
//                            Actions actionss = new Actions(driver);
//
//                            actionss.moveToElement(element1).click().perform();
//
//                            Thread.sleep(3000);
//
//                           
//
//                            //about you
//
//                           
//
//
//
//                            driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Testcasepass");
//
//                            driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("test");
//
//
//
//                            driver.manage().window().fullscreen();
//
//                            WebDriverWait wait = new WebDriverWait(driver, 30);
//
//                            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"primary-btn\"]")));
//
//                            element.click();
//
//                            Thread.sleep(5000);
//
//                           
//
//                            //contact
//
//                           
//
//                            driver.findElement(By.id("emailId")).sendKeys("test@test.com");
//
//                            driver.findElement(By.id("primaryPhoneNumber")).sendKeys("1236667777");
//
//                            driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/button[2]")).click();
//
//                            Thread.sleep(5000);

List<LogEntry>  entries2 = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
  System.out.println(entries2);
           // setDataMap(entries2);

            driver.quit();


	}

}
