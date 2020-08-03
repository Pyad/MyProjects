package fiR;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;

public class Apread {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		Workbook wb = new HSSFWorkbook();
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet1 = wb.createSheet("new sheet");
		Sheet sheet2 = wb.createSheet("second sheet");
		
		String safeName = WorkbookUtil.createSafeSheetName("[O'Brien's sales*?]"); // returns " O'Brien's sales   "
		Sheet sheet3 = wb.createSheet(safeName);
		
		Row row = sheet3.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue(1);
		row.createCell(1).setCellValue(1.2);
		row.createCell(2).setCellValue(
		     createHelper.createRichTextString("This is a string"));
		sheet3.autoSizeColumn(2);
		row.createCell(3).setCellValue(true);
		try  (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
		    wb.write(fileOut);
		}


		
	}

}
