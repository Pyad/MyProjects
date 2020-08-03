package nepar;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SjonPars {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		for(int i=0; i<5; i++) {
		Workbook wb = new XSSFWorkbook();
		try (OutputStream fileOut = new FileOutputStream("workbookcreation"+i+".xlsx")) {
		    wb.write(fileOut);
		}
		

	}

}
}
