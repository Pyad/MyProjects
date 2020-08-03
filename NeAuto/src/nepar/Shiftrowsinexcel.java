package nepar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Shiftrowsinexcel {

	
	       private static Row row = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		        try (InputStream os = new FileInputStream("D:\\\\java\\\\workspace\\\\NeAuto\\\\Books.xlsx")) {  
		            Workbook wb = new XSSFWorkbook();  
		                Sheet sheet = wb.createSheet("Sheet");  
		                
		                Map<String, String> map = new LinkedHashMap<String, String>();
		                map.put("name", "Balaji");
		                map.put("age", "Z");
		                map.put("nick", "Bala");
		                
		                ArrayList<String> keyList = new ArrayList<String>(map.keySet());
		                ArrayList<String> valueList = new ArrayList<String>(map.values());
		                
		                int n = map.size();

		                int j=0;
		                
		                for (int i=0; i<n; i++) { 
		                	row     = sheet.createRow(i); 
		                
		             row.createCell(j).setCellValue(keyList.get(i));
		             row.createCell(j+1).setCellValue(valueList.get(i));
		             
		             //sheet.shiftRows(2, 3, 4);
		                }
//		                for(int k=2; k<n; k++) {
//		                	 row.createCell(j+1).setCellValue(keyList.get(k));
//				             row.createCell(j+2).setCellValue(valueList.get(k));
//		                }
		                for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
		                	  row = sheet.getRow(rowIndex);
		                	  System.out.println(row.getLastCellNum());
		                	  if (row != null) {
		                	    Cell cell = row.getCell(1);
		                	   // System.out.println(row.getPhysicalNumberOfCells());
//		                	    if (cell != null) {
//		                	      // Found column and there is value in the cell.
//		                	      String cellValueMaybeNull = cell.getStringCellValue();
//		                	      // Do something with the cellValueMaybeNull here ...
//		                	      System.out.println(cellValueMaybeNull.length());
//		                	      
//		                	      
//		                	    }
		                	    
		                	  }
		                	}
		            
		              
		            FileOutputStream fileOut = new FileOutputStream("D:\\\\\\\\java\\\\\\\\workspace\\\\\\\\NeAuto\\\\\\\\Books.xlsx");
		            wb.write(fileOut); 
		        }catch(Exception e) {  
		            System.out.println(e.getMessage());  
		        }         
	}
}

	  
		
		

