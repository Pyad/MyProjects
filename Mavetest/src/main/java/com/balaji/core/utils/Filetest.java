package com.balaji.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Filetest {
	
	private static String s;
	public static String pat ;
	public static String exc = s +"\\test.xlsx";
	
	public static Row row;
	public static Cell cell;
	//public static Sheet sheet;
	

	public static void main(String[] args) throws IOException {
		
		
		// TODO Auto-generated method stub
		Path p  = Paths.get("c:\\data\\myfile.txt");
		
		 pat = System.getProperty("user.dir");
		 s=pat;
	      System.out.println("The current working directory is " + Filetest.pat + Filetest.exc );
	      System.out.println("The current working directory is " + Filetest.exc);
	      String FILE_NAME = pat+"\\test.xlsx";
	      
	      File file = new File(FILE_NAME);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputStream);
			int n = workbook.getNumberOfSheets();
			for(int i=0; i < n; i++) {
				System.out.println(workbook.getSheetName(i));
			}
		    Sheet sheet = workbook.getSheet("Sheet1");
		    int lastRow = sheet.getLastRowNum();
		//	Map<String, Map<String, String>> excelDataMapobj = new LinkedHashMap<String, Map<String, String>>();
			//Map<String, String> dataMapobj = new LinkedHashMap<String, String>();
			for(int j=0; j<+lastRow; j++) {
			Row row = sheet.getRow(j);
			Cell valueCell = row.getCell(1);
			System.out.println( valueCell);
			
	      
			}
	      
		

	}

}
