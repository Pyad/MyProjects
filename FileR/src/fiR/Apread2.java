
package fiR;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Apread2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String excelFilePath = "D:\\java\\workspace\\FileR\\workbook.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		//Row row = sheet.createRow(0);
		
		Iterator<Row> rowIterator = sheet.iterator(); // Traversing over each row of XLSX file
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next(); // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                System.out.println ("column index"+cell.getColumnIndex());//You will have your columns fixed in Excel file
                if(cell.getColumnIndex()==0)//for example of c
                {
              // System.out.print("    ) ;       
                }
          }
     }  

	}

}
