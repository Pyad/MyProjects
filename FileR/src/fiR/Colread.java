package fiR;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
public class Colread {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String excelFilePath = "D:\\java\\workspace\\FileR\\workbook.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(1);
		Row row = sheet.createRow(0);
		//Iterator<Row> iterator = sheet.iterator();
		
		
		
		for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
		  row = sheet.getRow(rowIndex);
		  int colIndex = row.getPhysicalNumberOfCells();
		  if (row != null) {
		    Cell cell = row.getCell(colIndex);
		    if (cell != null) {
		      // Found column and there is value in the cell.
		    String  cellValueMaybeNull = cell.getStringCellValue();
		      // Do something with the cellValueMaybeNull here ...
		    System.out.print(cellValueMaybeNull);
		    }
		  }
		}

	}

}
