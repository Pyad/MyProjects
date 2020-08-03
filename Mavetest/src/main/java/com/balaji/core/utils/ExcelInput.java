package com.balaji.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelInput {
	
	public static Sheet sheet;
	public static Row row;
	public static HashMap<String, String> map = null;
	
	public static Map<String, String> readData() throws IOException{
		
		
		String path="path";
		File file = new File(path);
		
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet("");
		map = new LinkedHashMap<String, String>();
		int lastRow = sheet.getLastRowNum();
		row= sheet.getRow(0);
		List<String> lt = new LinkedList<String>();
		
		for(int i=1; i<lastRow+1; i++) {
			Row r = CellUtil.getRow(i, sheet);
			String key = CellUtil.getCell(r, 3).getStringCellValue();
			lt.add(key);
			lt.removeIf(item -> item == null ||"".equals(item));
		}
		
		for(String str : lt) {
			for(String s: str.split("\n")) {
				String[] kv = s.split("=");
				System.out.println(kv[0].trim()+" , "+kv[1].trim());
				map.put(kv[0].trim(), kv[1].trim());
			}
		}
		
		
		return map;
		
		
		
	}
	

}
