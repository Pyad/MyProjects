package fiR;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Apread6 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File("D:\\java\\workspace\\FileR\\Writesheet2.xlsx"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) 
		{
		Row row = rowIterator.next();
		//System.out.println("Row "+row);
		Iterator <Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) 
		{
		Cell cell = cellIterator.next();
		System.out.println(cell.getStringCellValue()+ "\t" );
		}
		}

	}

}
