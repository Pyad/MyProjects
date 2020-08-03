package nepar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.LogManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LoggingPreferences;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

public class LogExtraction {
	
	public static String decodeURL;
	public static Map<Integer, String> dataMapActual;
	public static List<LogEntry> entries1;
	public static String[] str3;
	public static String absentValues = "";
	public static String validationSheet = "";
	public static String validationTab = "";
	public static LoggingPreferences logprefs;
	private static org.apache.log4j.Logger logs = LogManager.getLogger(LogExtraction.class.getName());
	
	
	public static Map<Integer, String> setDatMap(List<LogEntry>entries) throws IOException, InterruptedException{
		int count =0;
		dataMapActual = new LinkedHashMap<Integer, String>();
		Pattern pattern = Pattern.compile("\"url\":\"(.*?)\"},");
		for(LogEntry entry : entries) {
			if((entry.getMessage().indexOf("https://smterics.usbank.com/b/ss")>-1))
			{
				Matcher matcher = pattern.matcher(entry.getMessage());
				
				if(matcher.find()) {
					String s = matcher.group(1);
					decodeURL = decode(s);
					if(!decodeURL.isEmpty()) {
						if(decodeURL.length()>1000) {
							dataMapActual.put(count++, decodeURL);
						}
						
					}
					
				}
				
		}
		
		
		
	}
		
		for(int i=0; i<dataMapActual.size();i++) {
			Map networkData = actual(dataMapActual.get(i), i);
			Map networkData1 = actual2(dataMapActual.get(i), i);
			
			Map compMap = getDataExcel2(i +1);
			Map compMap1 = getDataExcel(i+1);
			
			
			
			if(compMap1.keySet().equals(networkData1.keySet())) {
				
				logs.info("Both map are equal");
				
				
			}
			else {
				HashSet<String> unionKeys = new HashSet<String>(compMap1.keySet());
				unionKeys.addAll(networkData1.keySet());
				
				unionKeys.removeAll(compMap1.keySet());
				logs.info("Keys to remove"+unionKeys);
				
				for(String KeysToRemove : unionKeys) {
					networkData1.remove(KeysToRemove);
				}
			
				
			}
			System.out.println("dynamic***************************+networkData1");
			
			MapDifference<String, String> mapDifference = Maps.difference(compMap, networkData);
			
			Boolean stat = networkData.equals(compMap);
			setDataExcel(networkData1.toString(), validationSheet, dataMapActual.get(i), i+1,
					
					networkData.toString().trim(), mapDifference.toString().trim(),stat, absentValues);
			
			absentValues = "";
			Thread.sleep(3000);
			System.out.println(mapDifference.toString().replace("only on left", "These keys are showing up in expeted but not in actual"));
			logs.info("the image request of indes" + i + " "+ dataMapActual.get(i));
			System.out.println();
			
	
			
		}
		
	
	
		
		
		return dataMapActual;
	
	
	

}


	private static void setDataExcel(String string, String validationSheet2, String string2, int i, String trim,
			String trim2, Boolean stat, String absentValues2) throws IOException {
		// TODO Auto-generated method stub
		File file = new File(validationSheet2);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(validationTab);
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		
		sheet.getRow(i).createCell(6).setCellValue(string2);
		sheet.getRow(i).createCell(7).setCellValue(trim);
		sheet.getRow(i).createCell(10).setCellValue(string);
		
		if(stat && absentValues2.isEmpty()) {
			font.setColor(IndexedColors.GREEN.getIndex());
			style.setFont(font);
			Cell statu = sheet.getRow(i).createCell(8);
			statu.setCellValue("Pass(Values are Expected)");
			statu.setCellStyle(style);
		}
		else {
			
			
			font.setColor(IndexedColors.RED.getIndex());
			style.setFont(font);
			Cell statu = sheet.getRow(i).createCell(8);
			statu.setCellValue("Fail(Values are not Expected)"+absentValues2);
			statu.setCellStyle(style);
			
		}
		
		
		sheet.getRow(i).createCell(9).setCellValue("Static values are" +trim2.toString().replace("only on left", "These keys are showing up in expeted but not in actual"));
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		fos.close();
	}
		
		
		
	


	private static Map getDataExcel(int a) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		File file = new File(validationSheet);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(validationTab);
		int lastRow = sheet.getLastRowNum();
		
		logs.info("Total entries in validation sheet"+lastRow);
		
		
		Map<String, String> dataMapobj = new LinkedHashMap<String, String>();
		
		Row row = sheet.getRow(a);
		Cell valueCell = row.getCell(5);
		
		String value = valueCell.getStringCellValue().trim();
		
		String[] arrStr = value.split("&&");
		
		for(int i=0; i<=arrStr.length-1; i++) {
			
			String[] kv = arrStr[i].split("=");
			if(kv.length==2) {
				dataMapobj.put(kv[0].trim(), kv[1].trim());
			}
			
		}
		
		Thread.sleep(5000);
		System.out.println("data from dynamic column" +dataMapobj.keySet());
		
		

		
		return dataMapobj;
		
	
	}


	private static Map<String, String> getDataExcel2(int a) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		File file = new File(validationSheet);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(validationTab);
		int lastRow = sheet.getLastRowNum();
		
		logs.info("Total entries in validation sheet"+lastRow);
		
		Map<String, Map<String, String>> excelDataMapobj = new LinkedHashMap<String, Map<String, String>>();
		Map<String, String> dataMapobj = new LinkedHashMap<String, String>();
		
		Row row = sheet.getRow(a);
		Cell valueCell = row.getCell(4);
		
		String value = valueCell.getStringCellValue().trim();
		
		String[] arrStr = value.split("&&");
		
		for(int i=0; i<=arrStr.length-1; i++) {
			
			String[] kv = arrStr[i].split("=");
			if(kv.length==2) {
				dataMapobj.put(kv[0].trim(), kv[1].trim());
			}
			
		}
		
		Thread.sleep(5000);
		System.out.println("data from Excel" +dataMapobj);
		
		

		
		return dataMapobj;
	}


	private static Map<String, String> actual2(String dec, int k) {
		
		// TODO Auto-generated method stub
		
		LinkedHashMap act = new LinkedHashMap();
		String[] str5 = dec.split("\\?", 2);
		HashMap<String, String> map = new HashMap();
		if(str5.length == 2) {
			str3 = str5[1].split("&");
			
			
			for(int l =0; l<str3.length; l++) {
				String[] str4 = str3[1].split("=", 2);
				if(str4.length==2)
					map.put(str4[0], str4[1]);
			}
		}
		
		
		
		
		return map;
	}


	private static Map<String, String> actual(String dec, int k) {
		// TODO Auto-generated method stub
		LinkedHashMap act = new LinkedHashMap();
		String[] str5 = dec.split("\\?",2);
		HashMap<String, String> map = new HashMap();
		
		if(str5.length == 2) {
			str3 = str5[1].split("&");
			
			for(int l=0; l<str3.length; l++) {
				String[] str4 = str3[1].split("=", 2);
				if(str4.length == 2)
					map.put(str4[0], str4[1]);
			}
			
			if(map.containsKey("v26")) {
				if((map.get("v26").matches("[0-9]+") && map.get("v26").length() < 10)){
					logs.info("v26 is present");
					
				}
				else {
					logs.info("v26 is present but not correct");
					absentValues = absentValues.concat("|v27 is present but empty |");
				}
			}
			
			Iterator it = map.entrySet().iterator();
			while(it.hasNext()) {
				
				Map.Entry pair = (Map.Entry)it.next();
				
				if(pair.getKey().equals("c1")||pair.getKey().equals("c2")||pair.getKey().equals("pageName")||pair.getKey().equals("c40")||pair.getKey().equals("products")) {
					act.put(pair.getKey().toString().trim(), pair.getValue().toString().trim());
				}
			}
			
			
		}
		
		System.out.println("The actual from network log" +act);
		
		
		return act;
	}


	private static String decode(String url) {
		// TODO Auto-generated method stub
		try {
			String prevURL = "";
			String decodeURL = url;
			while(!prevURL.equals(decodeURL)) {
				prevURL = decodeURL;
				decodeURL = URLDecoder.decode(decodeURL, "UTF-8");
				
			}
			return decodeURL;
		}
		catch(UnsupportedEncodingException e) {
			return "Issue while decoding" +e.getMessage();
		}
		
	}

}