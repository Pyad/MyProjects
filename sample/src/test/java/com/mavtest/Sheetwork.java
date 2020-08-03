package com.mavtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sheetwork {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Expected();
		
	}
	public static Map<String, String>Expected() throws IOException{
		File file = new File("C:\\Users\\DELL\\Desktop\\test.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		int n = workbook.getNumberOfSheets();
		for(int i=0; i < n; i++) {
			System.out.println(workbook.getSheetName(i));
		}
	    Sheet sheet = workbook.getSheet("Sheet3");
	    int lastRow = sheet.getLastRowNum();
	//	Map<String, Map<String, String>> excelDataMapobj = new LinkedHashMap<String, Map<String, String>>();
		Map<String, String> dataMapobj = new LinkedHashMap<String, String>();
		for(int j=1; j<=lastRow; j++) {
		Row row = sheet.getRow(j);
		Cell valueCell = row.getCell(4);
		
		String value = valueCell.getStringCellValue().trim();
		
		String[] arrStr = value.split("&&");
		System.out.println("arrLenght"+arrStr.length);
		for(int i=0; i<=arrStr.length-1; i++) {
			System.out.println("arrLenght"+arrStr.length);
			
			String[] kv = arrStr[i].split("=");
//			if(kv.length==3) {
//				dataMapobj.put(kv[0].trim(), kv[1].trim());
//				System.out.println(kv[0]+" -> "+kv[1]+" ->"+kv[3]);
//			}
			System.out.println("Lenght"+kv.length);
			for(int k=0; k<kv.length;k++) {
				
				System.out.println("str["+k+"] : "+kv[k]);
				
			}
			
		}
		}
		
		workbook.close();
		return dataMapobj;
		
		
		
		
		
		
		
		
		//System.out.println(n);
		
		
//		Sheet sheet = workbook.getSheet("Sheet1");
//		int lastRow = sheet.getLastRowNum();

	}

}
