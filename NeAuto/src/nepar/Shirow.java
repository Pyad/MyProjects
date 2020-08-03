package nepar;
import java.io.FileOutputStream;  
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class Shirow {

//this program is about to convert map values in list and using for loop printing values in excel like key value in two diff columns
		
		
 
		    public static void main(String[] args) {  
		        try (OutputStream os = new FileOutputStream("D:\\\\java\\\\workspace\\\\NeAuto\\\\Books.xlsx")) {  
		            Workbook wb = new XSSFWorkbook();  
		                Sheet sheet = wb.createSheet("Sheet");  
		                
		                Map<String, String> map = new LinkedHashMap<String, String>();
		                map.put("name", "Balaji");
		                map.put("age", "Z");
		                map.put("nick", "Bala");
		                
//		                for(String i:map.keySet()) {
//		                System.out.println(i+","+map.getOrDefault(i, "defaultValue"));
//		                }
		                
		                ArrayList<String> keyList = new ArrayList<String>(map.keySet());
		                ArrayList<String> valueList = new ArrayList<String>(map.values());
		                
		                int n = map.size();
//		                
//		                List<String> keys = new LinkedList<String>(map.keySet());
//		                for (int i = 0; i < keys.size(); i++)
//		                {
//		                    String key = keys.get(i);
//		                    String value = map.get(key);
//		                    System.out.println(key);
//		                }
//		                
		                int j=0;
		                
		                for (int i=0; i<n; i++) { 
		                	Row row     = sheet.createRow(i); 
		                	// row.createCell(i).setCellValue(keyList.get(i));
				             //row.createCell(i).setCellValue(valueList.get(i));
				           // Row row2    = sheet.createRow(i);  
				            //Row row3    = sheet.createRow(i); 
		                	
		            
		           // for (int j=0;j<n;j++) {
		            
		           // Cell cell   = row.createCell(i);  
		           //for( Map.Entry<String, String> entry : map.entrySet()){
		             row.createCell(j).setCellValue(keyList.get(i));
		             row.createCell(j+1).setCellValue(valueList.get(i));
//		            	System.out.println(keyList.get(i));
//		            	System.out.println(valueList.get(i));
//		            	
		           // }
		           // Cell cell2  = row2.createCell(0);  
		            //cell.setCellValue("Hello, Javatpoint"); 
		          //  int si = sheet.getLastRowNum();
		            //System.out.println(si);
		            //sheet.shiftRows(1, si=5, 7); 
		           
		            }
		               // }
		               // k++;
		                
		            
		            wb.write(os);  
		        }catch(Exception e) {  
		            System.out.println(e.getMessage());  
		        }         
		        }
}

	
