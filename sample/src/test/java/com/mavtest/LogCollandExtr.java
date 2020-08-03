package com.mavtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogCollandExtr {

	static List<String> lt;
	static Map<Integer, String> map;
	static Map<String, String> data;
	static HashMap<String, String> act;
	 

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
			Map<String, String>Exp = Sheetwork.Expected();
		ChromeOptions opt = new ChromeOptions();
		opt.setPageLoadStrategy(PageLoadStrategy.EAGER);
		LoggingPreferences logs = new LoggingPreferences();
		logs.enable(LogType.PERFORMANCE, Level.ALL);
		opt.setCapability("goog:loggingPrefs", logs);

		// DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		opt.setCapability(CapabilityType.LOGGING_PREFS, logs);

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://www.cognizant.com");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		Thread.sleep(1000);
		WebElement e = driver.findElement(Locators.career);
		e.click();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		driver.navigate().back();

		Thread.sleep(2000);

		List<LogEntry> logs2 = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
		// LogEntries logEntries = logs2.get();
		// for(LogEntry e1 : logs2) {
		// System.out.println(e1);
		// }
		System.out.println("Size of logs" +logs2.size());
		act = new LinkedHashMap<String, String>();
		lt = new LinkedList<String>();
		int c = 0;
		
		Pattern pattern = Pattern.compile("\\\"url\\\":\\\"(.*?)\\\"},\"requestId");
		// System.out.println("log" + expected);

		for (LogEntry entry1 : logs2) {
			//c = entry1;
			//System.out.println("size of c "+ c);
			if ((entry1.getMessage().indexOf("https://cognizant.sc.omtrdc.net/b/ss/ctsprodlive/1/JS-2.13.1-LATI/") > -1)
					&& (entry1.getMessage().indexOf("GET") > -1) && (entry1.getMessage().length() > 500)) {
				// if ((entry1.getMessage()) != null) {

				Matcher matcher = pattern.matcher(entry1.getMessage());
				System.out.println("M " + entry1);

				if (matcher.find()) {

					String s = matcher.group(1);

					String decodeURL = decode(s);
					System.out.println(decodeURL);
					// map.put(c++, decodeURL);
					// System.out.println(map.keySet());
					if (!decodeURL.isEmpty() && (decodeURL.length() > 500)) {

						System.out.println(decodeURL);

						String[] sp = decodeURL.split("[?]", 0);
						// String[] sp = decodeURL.split("\"url\":\"(.*?)\"},",0);

						// sp[1]=
						// System.out.println(sp[0]);
						data = new LinkedHashMap<String, String>();
						for (String q : sp[1].split("&")) {
							// lt.add(q);

							//System.out.println(q);

							if ((q.contains(".") && !(q.contains("=")))) {
								
								System.out.println("qValue" +q);
								data.put(q, null);
								lt.add(q);
								
									
								}
							else {
								
								String[] qa = q.split("=");
								System.out.println(qa[0] + qa[1]);
								if ((qa[0].length() > 0) && (qa[1].length() > 0)) {
									data.put(qa[0], qa[1]);

									//System.out.println(qa[0] + qa[1]);
								}
							
							}
						}
						System.out.println("Size" +lt.size());
						if (data.containsKey("pageName")) {
							System.out.println("pageName is present");
							String val = data.get("pageName");
							// boolean t1 = val.equalsIgnoreCase(tes2);
							System.out.println(val);

						} else {
							System.out.println("pageName is not present");
						}

					}
					//
			
		
//		Iterator it = data.entrySet().iterator();
		System.out.println(".c values->" +data.get(".c"));
//		while(it.hasNext()) {
//			
//			Map.Entry pair = (Map.Entry)it.next();
//			System.out.println("Pair-> " +pair);
//			
//			if(pair.getKey().equals("c1")||pair.getKey().equals("c2")||pair.getKey().equals("pageName")||pair.getKey().equals("c40")||pair.getKey().equals("products")) {
//				System.out.println(pair.getKey()+" " +pair.getValue());
//				act.put(pair.getKey().toString().trim(), pair.getValue().toString());
//			}
//		}
		
		
		
		Iterator<Map.Entry<String, String>> itr = data.entrySet().iterator();
		 while(itr.hasNext()) 
	        { 
	             Map.Entry<String, String> pair = itr.next(); 
	             System.out.println("Key = " + pair.getKey() +  
	                                 ", Value = " + pair.getValue()); 
	         	if(pair.getKey().equals("cc")||pair.getKey().equals("g")||pair.getKey().equals("AQB")||pair.getKey().equals("s")||pair.getKey().equals("AQE")) {
					System.out.println(pair.getKey()+" " +pair.getValue());
					act.put(pair.getKey().toString().trim(), null);
	        } 
	        }
		
		
		int no = act.keySet().size();
		System.out.println("no "+no);
		
		if(act.keySet().equals(Sheetwork.Expected().keySet())) {
			
			System.out.println("Both map are equal");
			
			
		}
		
		

	}
	
			}
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
	
	
	public static void ReadExcel() throws IOException {
		
		
		
		//logs.info("Total entries in validation sheet"+lastRow);
		
//		Map<String, Map<String, String>> excelDataMapobj = new LinkedHashMap<String, Map<String, String>>();
//		Map<String, String> dataMapobj = new LinkedHashMap<String, String>();
//		
//		Row row = sheet.getRow(a);
//		Cell valueCell = row.getCell(4);
//		
//		String value = valueCell.getStringCellValue().trim();
//		
//		String[] arrStr = value.split("&&");
//		
//		for(int i=0; i<=arrStr.length-1; i++) {
//			
//			String[] kv = arrStr[i].split("=");
//			if(kv.length==2) {
//				dataMapobj.put(kv[0].trim(), kv[1].trim());
//			}
//			
//		}
//		
//		Thread.sleep(5000);
//		System.out.println("data from Excel" +dataMapobj);
		
		

		
//		return dataMapobj;
	}
}
