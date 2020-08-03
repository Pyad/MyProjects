
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
import org.apache.poi.xssf.usermodel.XSSFSheet;
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

public class WebCog7 {
	private static int counter = 0;
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
		driver.quit();
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
		try {
		driver.get("https://www.usbank.com/index.html");
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(12000, TimeUnit.MILLISECONDS);

		System.out.println(driver.getTitle());

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		List<WebElement> links = driver.findElements(By.tagName("a") );
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		System.out.println("Total no.of.links -> " + links.size());
		list = new LinkedList<String>();

		for (WebElement tex : links) {
			String x = tex.getText();
			if(!(x.indexOf("Skip to")>-1)) {
			list.add(tex.getText());

		}
		}

		list.removeIf(item -> item == null || "".equals(item));
		
		//wholelist(list);

		for (int i = 0; i < list.size(); i++) {

			String lin = list.get(i);
			System.out.println("Link name -> " + lin);
			
			driver.findElement(By.linkText(lin)).click();
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			// System.out.println(driver.getTitle());
			LogExtraction(lin);

			// System.out.println(links.get(i).getText());

			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			driver.navigate().back();
			driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);

		}

	}catch(Exception e) {
		
		e.printStackTrace();
	}
	}
	
	private static void wholelist(List<String> list2) throws IOException {
		// TODO Auto-generated method stub
		try {
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet  sheet = book.createSheet("test");
		System.out.println("Total links " +list2.size());
		for(int i=0; i<list2.size(); i++) {
			row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(list2.get(i));
			
			
		}
		
		FileOutputStream out = new FileOutputStream(new File("D:\\java\\workspace\\NeAuto\\Allthelinks.xlsx"));
		book.write(out);
		System.out.println("excel close");
		System.out.println();
		out.close();
		}
		
		finally {
			System.out.println("All the links are stored in the excel");
		}
		
	}

	public static void LogExtraction(String lin) throws IOException {
		String st = lin;

		List<String> lt = new ArrayList<String>();

		WebCog7 entry = new WebCog7();
		List<LogEntry> expected = entry.logs();
		// String reg = "\"url\":^((https)://)+"
		Pattern pattern = Pattern.compile("(\"url\":\"(https:\\/\\/cognizant.sc.omtrdc.net.*?)\"})");
		// ("\"url\":\"(.*?)\"},")
		System.out.println("log" + expected);

		for (LogEntry entry1 : expected) {

			if ((entry1.getMessage().indexOf("Network.requestWillBeSent") > -1)
					&& (entry1.getMessage().indexOf("https://cognizant.sc.omtrdc.net/b/ss/") > -1)
					&& (entry1.getMessage().indexOf("pev1") > -1) && (entry1.getMessage().indexOf("pev2") > -1)
					&& (entry1.getMessage().indexOf("GET") > -1) && (entry1.getMessage().indexOf("Image") > -1)) {

				Matcher matcher = pattern.matcher(entry1.getMessage());
				System.out.println("M " + entry1);
				// if(matcher == null) {
				//
				// }
				System.out.println(matcher.find(1));
				if (matcher.find(1)) {
					String s = matcher.group(1);
					// System.out.println("matcher s "+s)
					lt.add(s);
				} else {
					System.out.println("This link does not contain S.TL parameter");
					String s = "This link does not contain S.TL parameter";
					lt.add(s);
					// mapinitialize(lt, st);
				}

			}
		}	
		if(lt.size()==0)
		{
			String s1 = "This link does not contain S.TL parameter";
			lt.add(s1);
			mapinitialize(lt, st);
		}else {
			mapinitialize(lt, st);
		}	
	}

	//

	private static void mapinitialize(List<String> lt, String st) throws IOException {
		// TODO Auto-generated method stub
		String lin = st;
		int n = lt.size();
		System.out.println("LT size " + n);
		Map<String, List<String>> multiMap = new LinkedHashMap<String, List<String>>();
		WebCog7 entry = new WebCog7();
		List<String> all = entry.decode(lt);
		// List<String> all = entry.durl(lt);
		multiMap.put(lin, all);

		for (Entry<String, List<String>> ent : multiMap.entrySet()) {
			System.out.println("Key = " + ent.getKey() + ", Value = " + ent.getValue());
		}

		ArrayList<String> keyList1 = new ArrayList<String>(multiMap.keySet());
		Collection<List<String>> valueList = multiMap.values();

		// excelwrite(multiMap, n);

		try (InputStream os = new FileInputStream(
				new File("D:\\\\\\\\java\\\\\\\\workspace\\\\\\\\NeAuto\\\\\\\\LinksWebCog3.xlsx"))) {
			wb = new XSSFWorkbook(os);
			sheet = wb.getSheetAt(0);
			CellStyle wrapStyle = wb.createCellStyle();
			wrapStyle.setWrapText(true);

			if (counter == 0) {
				row = sheet.createRow(0);
				Cell cell = row.createCell(0);
				cell.setCellValue("Links");

				cell = row.createCell(1);
				cell.setCellValue("Tags");

				// row = sheet.createRow(counter+1);
			}

			// for (int i = 0; i < 1; i++) {

			// row = sheet.createRow(counter+1);

			for (int j = 0; j < n; j++) {

				for (List<String> ele : valueList) {
					for (String nes : ele) {
						// cell2.setCellStyle(wrapStyle);
						// row = sheet.createRow(j+n);
						System.out.println(keyList1.get(0) + nes);
						if (j == 0) {

							int rowCount = sheet.getLastRowNum();
							row = sheet.createRow(rowCount + 1);
							// row = sheet.createRow(counter+1);
							Cell cell1 = row.createCell(0);
							cell1.setCellValue(keyList1.get(0));
							cell1 = row.createCell(1);
							cell1.setCellValue(nes);
							System.out.println(keyList1.get(0) + nes);

						}
						// else {
						//
						// int rowCount = sheet.getLastRowNum();
						// row = sheet.createRow(rowCount+1);
						// Cell cell2 = row.createCell(1);
						// //cell2 = row.createCell(1);
						// cell2.setCellValue(nes);
						// System.out.println(nes);
						//
						// }

						// System.out.println("Values List "+nes);
					}

				}

				int rowCount = sheet.getLastRowNum();
				System.out.println("row count" + rowCount);

				counter = counter + rowCount;

			}

			os.close();
		}

		FileOutputStream out = new FileOutputStream(new File("D:\\java\\workspace\\NeAuto\\LinksWebCog3.xlsx"));
		wb.write(out);
		System.out.println("excel close");
		System.out.println();
		out.close();
	}

	// }
	public static void readexcel() throws IOException {
		String FilePath = "D:\\java\\workspace\\NeAuto\\LinksWebCog3.xlsx";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = new XSSFWorkbook(fs);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet("Sheet1");

		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getLastRowNum();
	

		// To get the number of columns present in sheet
		//int totalNoOfCols = sh.getColumns();

				for (int i = 0; i < totalNoOfRows+1; i++) {

	        Row row = sheet.getRow(i);

	        //Create a loop to print cell values in a row

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	            //Print Excel data in console

	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

	        }
	}
	}

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
			// System.out.println("Decode = " + decodeURL);

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

		// System.out.println("Size - LogEntries" + logEntries.size());

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

	// public static void excelwrite(Map<String, List<String>> multiMap, int n)
	// throws IOException {
	// ArrayList<String> keyList1 = new ArrayList<String>(multiMap.keySet());
	// Collection<List<String>> valueList = multiMap.values();
	// try (FileInputStream os = new FileInputStream(new
	// File("D:\\\\\\\\java\\\\\\\\workspace\\\\\\\\NeAuto\\\\\\\\BooksWebCog3.xlsx"))){
	// wb = new XSSFWorkbook(os);
	// sheet = wb.getSheetAt(0);
	// CellStyle wrapStyle = wb.createCellStyle();
	// wrapStyle.setWrapText(true);
	//
	// int rowCount = sheet.getLastRowNum();
	// System.out.println(rowCount);
	// int counter = 0;
	// if( counter ==0) {
	// row = sheet.createRow(0);
	// Cell cell = row.createCell(0);
	// cell.setCellValue("Links");
	//
	// cell = row.createCell(1);
	// cell.setCellValue("Tags");
	// }
	//
	// row = sheet.createRow(counter);
	//
	//
	//
	//
	// for(int j=0; j<n;j++) {
	// Cell cell1 = row.createCell(0);
	// cell1.setCellValue(keyList1.get(j));
	// for (List<String> ele : valueList) {
	// for (String nes : ele) {
	// //cell2.setCellStyle(wrapStyle);
	// //row = sheet.createRow(j+n);
	// cell1 = row.createCell(1);
	// cell1.setCellValue(nes);
	// //System.out.println("Values List "+nes);
	// }
	//
	// }
	//
	//
	//
	//
	// counter=counter+n;
	//
	//
	// }
	//
	//
	// os.close();
	// }
	//
	// FileOutputStream out = new FileOutputStream(new
	// File("D:\\java\\workspace\\NeAuto\\BooksWebCog3.xlsx"));
	// wb.write(out);
	// System.out.println("excel close");
	// System.out.println();
	// wb.close();
	// out.close();
	// }

}
