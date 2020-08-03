package nepar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.charset.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebCog4 {
	private static WebDriver driver = null;
	private static List<String> list = null;
	private static List<String> all = new ArrayList<String>();
	// private static List<String> lt = null;
	private static Row row = null;
	private static Sheet sheet = null;
	private static Workbook wb = null;
	private static Cell cell = null;

	public static void main(String[] args) throws InterruptedException, IOException {

		BrowserLaunch();

	}

	public static void BrowserLaunch() throws InterruptedException, IOException {

		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver",
				"D:\\\\json jars\\\\chrome driver\\\\chromedriver_win32\\\\chromedriver.exe");

		ChromeOptions caps = new ChromeOptions();
		caps.setPageLoadStrategy(PageLoadStrategy.EAGER);
		LoggingPreferences logPrefs = new LoggingPreferences();

		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

		caps.setCapability("goog:loggingPrefs", logPrefs);

		driver = new ChromeDriver(caps);

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://www.cognizant.com/");
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(12000, TimeUnit.MILLISECONDS);
		
		System.out.println(driver.getTitle());
		 
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		System.out.println("Total no.of.links -> " +links.size());
		list = new LinkedList<String>();

		for (WebElement tex : links) {

			list.add(tex.getText());
			

		}

		list.removeIf(item -> item == null || "".equals(item));

		
		for (int i = 0; i < 5; i++) {

			String lin = list.get(i);
			System.out.println("Link name -> " + lin);
			driver.findElement(By.linkText(lin)).click();
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			//System.out.println(driver.getTitle());
			LogExtraction(lin);

			// System.out.println(links.get(i).getText());
			
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			driver.navigate().back();
			driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);

		}

	}

	public static void LogExtraction(String lin) throws IOException {
		String st = lin;

		List<String> lt = new ArrayList<String>();

		
		WebCog4 entry = new WebCog4();
		List<LogEntry> expected = entry.logs();

		Pattern pattern = Pattern.compile("\"url\":\"(.*?)\"},");
		System.out.println("log" + expected);

		for (LogEntry entry1 : expected) {

			if ((entry1.getMessage().indexOf("https://cognizant.sc.omtrdc.net/b/ss/") > -1)
					&& (entry1.getMessage().indexOf("Network.requestWillBeSent") > -1)) {

				Matcher matcher = pattern.matcher(entry1.getMessage());
				// System.out.println("M " + entry1);

				if (matcher.find()) {

					String s = matcher.group(1);
					// System.out.println("matcher s "+s);

					lt.add(s);
					//System.out.println("Size of LT " + lt.size());
					

				}
				
			}

		}
		//System.out.println(" LT " + lt);
		excelwrite(lt, st);
	}

	//

	private static void excelwrite(List<String> lt, String st) throws IOException {
		// TODO Auto-generated method stub
		String lin = st;
		int n = lt.size();
		System.out.println("LT size "+n);
		Map<String, List<String>> multiMap = new LinkedHashMap<String, List<String>>();
		WebCog4 entry = new WebCog4();
		List<String> all = entry.decode(lt);
		// List<String> all = entry.durl(lt);
		multiMap.put(lin, all);

		for (Entry<String, List<String>> ent : multiMap.entrySet()) {
			System.out.println("Key = " + ent.getKey() + ", Value = " + ent.getValue());
		}
		InputStream os = new FileInputStream("D:\\\\\\\\java\\\\\\\\workspace\\\\\\\\NeAuto\\\\\\\\BooksWebCog3.xlsx");
		wb = new XSSFWorkbook(os);
		sheet = wb.getSheetAt(0);
		CellStyle wrapStyle = wb.createCellStyle();
		wrapStyle.setWrapText(true);
		ArrayList<String> keyList1 = new ArrayList<String>(multiMap.keySet());
		Collection<List<String>> valueList = multiMap.values();

		// for(List<String> ele : valueList) {
		// for(String nes:ele) {
		// System.out.println("Values List "+nes);
		// }
		//
		// }

		//int counter = 0;
		// for (int k = 0; k < keyList1.size(); k++) {
		// if (k!=0) {
		// row = sheet.createRow( counter+k);
		// }
		// else {
		// row = sheet.createRow( k);
		// }
		//// cell = row.createCell(0);
		//// cell.setCellValue(keyList1.get(k));
		// cell = row.createCell(1);
		// cell.setCellValue("URLS");
		//
		// cell = row.createCell(2);
		// cell.setCellValue("Tags");
		int counter =0;
		if(counter==0) {
			row = sheet.createRow(0);
			Cell cell = row.createCell(0);
			cell.setCellValue("Links");
			
			cell = row.createCell(1);
			cell.setCellValue("Tags");
		for (int i = 0; i < 1; i++) {
			
			row = sheet.createRow(counter+n);
			
			Cell cell1 = row.createCell(0);
			cell1.setCellValue(keyList1.get(i));
			
			for(int j=0; j<n;j++) {
			
			for (List<String> ele : valueList) {
				for (String nes : ele) {
					//cell2.setCellStyle(wrapStyle);
					row = sheet.createRow(j+2+counter);
					cell1 = row.createCell(1);
					cell1.setCellValue(nes);
					//System.out.println("Values List "+nes);
				}

			}
			
			
			}
				
			}
			
			
			counter = counter +n;
			// int r= sheet.getLastRowNum();
//			if ((i != 0)) {
//
//				row = sheet.createRow(counter + i);
//			} else {
//				row = sheet.createRow(i + 1);
//			}
//
//			cell = row.createCell(1);
//			cell.setCellValue(keyList1.get(i));
//
//			Cell cell2 = row.createCell(2);
//			for (List<String> ele : valueList) {
//				for (String nes : ele) {
//					//cell2.setCellStyle(wrapStyle);
//					cell2.setCellValue(nes);
//					System.out.println("Values List "+nes);
//				}
//
//			}
			 //sheet.autoSizeColumn(2);

			//
			// System.out.println(row);
			// System.out.println("Ksize "+keyList1.size());

			//
			// System.out.println("i->"+i);
			// System.out.println("Size->"+keyList.size());
			//

			// Row row1 = sheet.createRow(i);
			// cell = row.createCell(2);
			// cell.setCellValue(keyList1.get(i));
			// System.out.println(i);
			// sheet.autoSizeColumn(i);

			// Cell cell2 = row.createCell(3);
			// cell2.setCellValue(valueList.retainAll(i));
			// System.out.println(i);

			// i++;
			
		}

		FileOutputStream out = new FileOutputStream(new File("D:\\java\\workspace\\NeAuto\\BooksWebCog3.xlsx"));
		wb.write(out);
		System.out.println("excel close");
		System.out.println();
		out.close();

		// String decodeURL = decode(s);
		//
		// System.out.println(" decodeURL -> " + decodeURL);
		// System.out.println();
		//
		// al.add(decodeURL);
		// System.out.println("Size of al "+al.size());
	}


	// al.clear();
	// multiMap.clear();

	// multiMap.put(lin, al);
	// else {
	// multiMap.put(lin, al);
	//
	// for (Entry<String, ArrayList<String>> entry5 : multiMap.entrySet())
	// System.out.println("Key = " + entry5.getKey() +
	// ", Value = " + entry5.getValue());
	// }

	// if(decodeURL.contains("assets.adobedtm.com")) {
	// System.out.println("Unmathced tags "+ decodeURL);
	// System.out.println();
	// }
	// else if ((!decodeURL.isEmpty()) && decodeURL.length()>700) {
	// iter(decodeURL, st);
	// System.out.println("Length greater than ->" + decodeURL);
	// System.out.println();
	// }
	// else if(decodeURL.length()<1000) {
	// System.out.println("Length less than ->" + decodeURL);
	// System.out.println();
	//
	// }



	private static List<String> decode(List<String> lt2) throws UnsupportedEncodingException {
		List<String> decodedURL = new ArrayList<String>();
           
		for (int i = 0; i < lt2.size(); i++) {
			String s = lt2.get(i);

			String prevURL = "";
			String decodeURL = s;

			while (!prevURL.equals(decodeURL)) {
				prevURL = decodeURL;
				decodeURL = URLDecoder.decode(decodeURL, "UTF-8");
				// if ((!decodeURL.isEmpty()) && decodeURL.length()>1000) {
				//
				// System.out.println("Length greater than 1000->" + decodeURL);
				// System.out.println();
				//
				// }

			}
			decodedURL.add(decodeURL);
			//System.out.println("Decode = " + decodeURL);
            
		}
		
		return decodedURL;
		
	}

	/**
	 * @author DELL
	 * @return logEnt
	 * 
	 */
	public static List<LogEntry> logs() {
		driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
		
		List<LogEntry> logEntries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();

		//System.out.println("Size - LogEntries" + logEntries.size());

		return logEntries;
		// list = Arrays.asList(logEntries);

	}

	// public static List<String> durl(List<String> lt2){
	//
	// List<String> decodeURL = decode(lt2);
	//
	// //System.out.println(" decodeURL -> " + decodeURL);
	// System.out.println();
	//
	// al.add(decodeURL);
	// System.out.println("Size of al "+al.size());
	// return (al);
	// }
	//
	// public static void iter(String decodeURL, String st) {
	//
	//
	// System.out.println("String " +st);
	// Map<String,ArrayList<String>> multiMap = new
	// LinkedHashMap<String,ArrayList<String>>();
	//
	// ArrayList<String> al = new ArrayList<String>();
	// al.add(decodeURL);
	//
	//
	//
	//
	// for(int i =0; i<al.size();i++) {
	// System.out.println("ArrayList " +al.get(i));
	//
	// }
	//
	// multiMap.put(st, al);
	//
	// for (Entry<String, ArrayList<String>> entry : multiMap.entrySet())
	// System.out.println("Key = " + entry.getKey() +
	// ", Value = " + entry.getValue());
	// }

}
