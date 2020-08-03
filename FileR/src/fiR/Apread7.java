package fiR;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Apread7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileInputStream file = new FileInputStream(new File("D:\\java\\workspace\\FileR\\Writesheet2.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(file);
		
		 XSSFSheet sheet = wb.getSheetAt(0);

		 ArrayList<String> columndata = null;

		 Iterator<Row> rowIterator = sheet.iterator();
		 columndata = new ArrayList<>();

		 while (rowIterator.hasNext()) {
		   Row row = rowIterator.next();
		   Iterator<Cell> cellIterator = row.cellIterator();
		   while (cellIterator.hasNext()) {
		     Cell cell = cellIterator.next();

		     if (row.getRowNum() > 0) { // To filter column headings
		       if (cell.getColumnIndex() == 0) {// To match column
		                         // index
		         switch (cell.getCellType()) {
		         case Cell.
	
		           columndata.add(cell.getNumericCellValue() + "");
		           break;
		         case Cell.CELL_TYPE_STRING:
		           columndata.add(cell.getStringCellValue());
		           break;
		         }
		       }
		     }
		   }
		 }

	}

}
