package com.mavtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Readdata {
	
	static String Location = "C:\\Users\\DELL\\Desktop\\test.xlsx";
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		File file = new File(Location);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Sheet2");
		CellStyle style = workbook.createCellStyle();
	    Font font = workbook.createFont();
        
		
		//fis.close();
		int n = sheet.getLastRowNum();
		System.out.println(n);
//		row = sheet.getRow(0);
		for(int i=1; i<n+1; i++) {
			driver = new ChromeDriver();
//		XSSFRow row = sheet.getRow(i);
			Row r = CellUtil.getRow(i, sheet);
			String val = CellUtil.getCell(r, 0).getStringCellValue();
			String val2 = CellUtil.getCell(r, 1).getStringCellValue();
			System.out.println(val);
			driver.get(val);
			String s = driver.getTitle();
			System.out.println(s);
			//sheet.getRow(i).createCell(i).setCellValue(s);
			
			Cell val1 =  CellUtil.createCell(r, 2, s);
//			val1.setCellValue(s);
			boolean b = s.equals(val2);
			String s1 = Boolean.toString(b);
			if(s1.equals("true")) {
				font.setColor(IndexedColors.GREEN.getIndex());
		        style.setFont(font);
		        Cell val4 =  CellUtil.createCell(r, 3, s1);
				val4.setCellStyle(style);
				
				System.out.println("Green");
			}
			else {
				
		        Cell val4 =  CellUtil.createCell(r, 3, s1);
		       
				System.out.println("RED");
				
			}
			
			
			
			
			
			driver.quit();
			
			
			
		
		}
		FileOutputStream outputStream = new FileOutputStream("C:\\\\Users\\\\DELL\\\\Desktop\\\\test.xlsx");
        workbook.write(outputStream);


	}

}
