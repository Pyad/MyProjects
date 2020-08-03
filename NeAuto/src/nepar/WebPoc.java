package nepar;
import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.UnsupportedEncodingException;

import java.net.URLDecoder;

import java.util.HashMap;

import java.util.Iterator;

import java.util.LinkedHashMap;

import java.util.List;

import java.util.Map;

import java.util.concurrent.TimeUnit;

import java.util.logging.Level;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

 

import org.apache.commons.collections4.map.HashedMap;

import org.apache.logging.log4j.Logger;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.logging.LogEntry;

import org.openqa.selenium.logging.LogType;

import org.openqa.selenium.logging.LoggingPreferences;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

 

import com.sitecat.migration.BaseApply;

 

import org.apache.logging.log4j.*;


public class WebPoc {


		// TODO Auto-generated method stub
		
		
		public class POCForApply extends BaseApply {

		                public static String decodeURL;

		                public static DesiredCapabilities caps;

		                public static LoggingPreferences logPrefs;

		                public static Map<Integer, String> dataMapActual;

		                public static List<LogEntry> entries1;

		                public static String[] str3;

		                private static Logger logs=LogManager.getLogger(POCForApply.class.getName() );

		               

		                public static Map<Integer, String> setDataMap(List<LogEntry> entries) throws IOException, InterruptedException {

		                                int count=0;       

		                                dataMapActual = new LinkedHashMap<Integer, String>();

		                //            List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();

		logs.debug("Execution starts...");

		                                Pattern pattern = Pattern.compile("\"url\":\"(.*?)\"},");

		                                logs.info(

		                                                                "********The URL has been Extracted and Decoded from the Network Logs Using Selenium WebDriver*********");

		                                System.out.println();

		                                for (LogEntry entry : entries) {

		                                                if ((entry.getMessage().indexOf("https://smetrics.usbank.com/b/ss/") > -1)) {

		 

		                                                                Matcher matcher = pattern.matcher(entry.getMessage());

		 

		                                                                if (matcher.find()) {

		 

		                                                                                String s = matcher.group(1);

		                                                                                decodeURL = decode(s);

		                                                                                if(!decodeURL.isEmpty())

		                                                                                {

		                                                                                dataMapActual.put(count++, decodeURL);

		                                                                               

		                                                                                //setDataExcel("C:\\Users\\837090\\Desktop\\Applyflow.xlsx",decodeURL);

		                                                                                }

		                                                                                //System.out.print(decodeURL);

		                                                                                //System.out.println();

		                                                                               

		                                                                                }

		                                                                }

		                                                }

		                                logs.info("the number of image requests are "+" "+dataMapActual.size());

		                                System.out.println();

		                                for(int i=0;i<dataMapActual.size();i++)

		                                {logs.info("inside for");

		                               

		                                                setDataExcel("C:\\Users\\837090\\Desktop\\Applyflow",dataMapActual.get(i),i+1);

		                                logs.info("the image request of index "+i+" "+dataMapActual.get(i));

		                                System.out.println();

		                //            m1(dataMapActual.get(i));

		                                }

		                               

		                                return dataMapActual;

		                }

		                public static void setDataExcel(String validationSheet, String extrcted,int a)

		                                                throws IOException {

		                logs.info("excellll");

		                                File file = new File(validationSheet);

		 

		                                FileInputStream inputStream = new FileInputStream(file);

		                                @SuppressWarnings("resource")

		                                Workbook workbook = new XSSFWorkbook(inputStream);

		                                Sheet sheet = workbook.getSheet("Auth Flows - Test Plan");

		                                logs.info("sheet recognized");

		                //            int lastRow = sheet.getLastRowNum();

		 

		         sheet.getRow(a).createCell(4).setCellValue(extrcted);

		 

		               

		                                FileOutputStream fos = new FileOutputStream(file);

		                                workbook.write(fos);

		                                fos.close();

		                }

		               

		                public static void m1(String decodeURL)

		                {

		                               

		               

		                                HashMap<String, String> map = new HashMap();

		                               

		                                                String[] str5 = decodeURL.split("\\?");

		                                                if (str5.length == 2) {

		                                                                  

		                                                                str3 = str5[1].split("&");

		                                                                for (int l = 0; l < str3.length; l++) {

		 

		                                                                                String[] str4 = str3[l].split("=");

		                                                                                if (str4.length == 2)

		                                                                                                map.put(str4[0], str4[1]);

		                                                                }

		                                                }

		               

		                //            String[] str5 = decodeURL.split("\\?");

		                                Iterator it = map.entrySet().iterator();

		                                while (it.hasNext()) {

		 

		                                                Map.Entry pair = (Map.Entry) it.next();

		                                                if (pair.getKey().equals("c1") || pair.getKey().equals("c2")||pair.getKey().equals("c40")||pair.getKey().equals("c53")||pair.getKey().equals("products")

		                                                                                || pair.getKey().equals("pageName")||pair.getKey().equals("events")||pair.getKey().equals("v26")) {

		                                                logs.info("the extracted key value pair of above image request ---> "+pair.getKey()+"  =   "+pair.getValue());

		                                                System.out.println();}

		                                }

		                }

		                public static String decode(String url) {

		                                try {

		                                                String prevURL = "";

		                                                String decodeURL = url;

		                                                while (!prevURL.equals(decodeURL)) {

		                                                                prevURL = decodeURL;

		                                                                decodeURL = URLDecoder.decode(decodeURL, "UTF-8");

		                                                }

		                                                return decodeURL;

		                                } catch (UnsupportedEncodingException e) {

		                                                return "Issue while decoding" + e.getMessage();

		                                }

		}

		                public static void main(String[] args) throws Exception {

		                                // TODO Auto-generated method stub

		                                caps = DesiredCapabilities.chrome();

		                                                logPrefs = new LoggingPreferences();

		                                                logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

		                                                caps.setCapability("goog:loggingPrefs", logPrefs);

		                                                System.setProperty("webdriver.chrome.driver",

		                                                                                "C:\\\\Users\\\\837090\\\\eclipse-workspace\\\\test1\\\\src\\\\browser\\\\chromedriver.exe");

		                                                WebDriver driver = new ChromeDriver(caps);

		                                                driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		                                                driver.manage().window().maximize();

		                                                driver.manage().deleteAllCookies();

		 

//		                                            driver.get("https://www.usbank.com/business-banking.html");

//		                                            Thread.sleep(4000);

//		             driver.findElement(By.xpath("//*[@id=\"tab1\"]")).click();

//		             Thread.sleep(4000);

//		             driver.findElement(By.xpath("//*[@id=\"tab2\"]")).click();

//		             Thread.sleep(4000);

		                                                driver.get("https://it4-apply.usbank.com/oneapply/savings/login?PRODUCT_CODE=SAV&SUB_PRODUCT_CODE=RS\r\n");

		                                                Thread.sleep(4000);

		 

		                                //            Thread.sleep(2000);

		                                                WebElement a = driver.findElement(By.xpath("//*[@id=\"btn-login-id\"]"));

		                                                BaseApply.scrollToView(driver, a);

		                                                BaseApply.safeJavaScriptClick(driver, a);

		                                                Thread.sleep(5000);

		                                                WebElement element1 = driver.findElement(By.xpath("//*[@id='form']/div[3]/button"));

		                                                driver.manage().window().fullscreen();

		                                                Actions actionss = new Actions(driver);

		                                                actionss.moveToElement(element1).click().perform();

		                                                Thread.sleep(3000);

		                                               

		                                                //about you

		                                               

		 

		                                                driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Testcasepass");

		                                                driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("test");

		 

		                                                driver.manage().window().fullscreen();

		                                                WebDriverWait wait = new WebDriverWait(driver, 30);

		                                                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"primary-btn\"]")));

		                                                element.click();

		                                                Thread.sleep(5000);

		                                               

		                                                //contact

		                                               

		                                                driver.findElement(By.id("emailId")).sendKeys("test@test.com");

		                                                driver.findElement(By.id("primaryPhoneNumber")).sendKeys("1236667777");

		                                                driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/button[2]")).click();

		                                                Thread.sleep(5000);

		               List<LogEntry>  entries2 = driver.manage().logs().get(LogType.PERFORMANCE).getAll();

		                                setDataMap(entries2);

		                                driver.quit();

		                }

		 

		}

	}

}
