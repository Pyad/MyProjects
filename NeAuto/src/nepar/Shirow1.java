package nepar;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Shirow1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OutputStream os = new FileOutputStream("D:\\\\java\\\\workspace\\\\NeAuto\\\\Books.xlsx")); 
            Workbook wb = new XSSFWorkbook();  
                Sheet sheet = wb.createSheet("Sheet");

	}

}
