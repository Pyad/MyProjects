package fiR;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Apread1 {

	public static void main(String[] args) throws FileNotFoundException, IOException  {
		// TODO Auto-generated method stub
		

		XSSFWorkbook wb = new XSSFWorkbook();
		Sheet sheet1 = wb.createSheet("sheet1");
		String safeName = WorkbookUtil.createSafeSheetName("[my sheet]"); // returns " O'Brien's sales   "
		Sheet sheet2 = wb.createSheet(safeName);
		Row row = sheet1.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Balaji");
		
		
		try (OutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
		    wb.write(fileOut);
		}
		
				

	}

}
