package fiR;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class APwrite1 {



	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		XSSFWorkbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("new sheet");
		//Row row = sheet.createRow(2);
		
		String[] str = {"Balaji", "Rajesh", "Thriuvottiyur", "Chennai"};
		int rowEnd = 15;
		int rowStart = 0;
		for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
			   Row row = sheet.createRow(rowNum);
			  
			  
			   
		for(int i=0; i<str.length; i++) {
			
			for(int j=0; j<=i; j++) {
				System.out.println(str[i]);
//				Row row1 = sheet.createRow(k);
			row.createCell(i).setCellValue(str[j]);
			sheet.autoSizeColumn(i);
			
			
			
			
			}
			
		}
			   }
		// Write the output to a file
		try (OutputStream fileOut = new FileOutputStream("workbookwrite.xlsx")) {
		    wb.write(fileOut);
		    wb.close();
		}
		

	}
	
	}
