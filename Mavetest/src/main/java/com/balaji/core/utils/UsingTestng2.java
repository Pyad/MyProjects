package com.balaji.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsingTestng2 {

//  public static ExcelReader excel = null;

	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	public static Map<String, String> map = null;
	public static int rowCount;
	
	
	@Test(dataProvider= "LoginDataProvider")
	public void logintest(String email, String pwd) {
		System.out.println(email+" " +pwd);
	}
	
//  @Test(dataProvider = "getData")
//  public void testData(Hashtable<String, String> data) {
//    // System.out.println(username + "---------" + password + "------------"
//    // + is_correct);
//    
//  }

  @DataProvider(name = "LoginDataProvider")
  public static Object[][] getSheet() {
		
		

	  Object[][] data = null ;

		try {
			DataFormatter formatter = new DataFormatter();
			String path="C:\\Users\\DELL\\Desktop\\Test (2).xlsx";
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);	

			// get the number of rows
			rowCount = sheet.getLastRowNum();

			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][columnCount];

			System.out.println(rowCount);
			// loop through the rows
			for(int i=1; i <rowCount+1; i++){
				try {
					XSSFRow row = sheet.getRow(i);
					for(int j=0; j <columnCount; j++){ // loop through the columns
						try {
							String cellValue = "";
							try{
								
								if(row.getCell(j).getCellType()==CellType.STRING) 
									cellValue = row.getCell(j).getStringCellValue(); 
								else if(row.getCell(j).getCellType()==CellType.NUMERIC) 
									cellValue = String.valueOf(Math.round(row.getCell(j).getNumericCellValue()));
								
//								cellValue = row.getCell(j).getStringCellValue().toString();
										
//								formatter.formatCellValue(sheet.getRow(row).getCell(col));
							}catch(NullPointerException e){

							}

							data[i-1][j]  = cellValue; // add to the data array
						} catch (Exception e) {
							e.printStackTrace();
						}				
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			fis.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(data);
		return data;

		
		
		
		
		
		
		
		
		
		
		
		
	}

	
}

