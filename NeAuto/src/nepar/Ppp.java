package nepar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Ppp {

	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		Workbook wb3=WorkbookFactory.create(new FileInputStream("D:\\java\\workspace\\NeAuto\\Books.xlsx"));
		Sheet sh=wb3.getSheet("sheet1");  
		int rows=sh.getLastRowNum();
		//int rowsToAdd = 15;
		sh.shiftRows(1,rows,3);
		
//		for (rows = 1; rows <= rowsToAdd; rows++) {
//			
//			  sh.createRow(rows);
		
		//System.out.println(rows);
		
		//sh.shiftRows(2,rows,1);   
		sh.createRow(3);
		
		

//	}

}
}
