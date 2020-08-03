package nepar;

import java.io.FileOutputStream;  
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class ShiftRows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try (OutputStream os = new FileOutputStream("D:\\\\\\\\java\\\\\\\\workspace\\\\\\\\NeAuto\\\\\\\\Books.xlsx")) {  
//            Workbook wb = new XSSFWorkbook();  
//            Sheet sheet = wb.createSheet("Sheet"); 
		 String propertyValue = "Sunday  -  H15,Sunday  -  H03,Sunday  -  H13,Sunday  -  H01,Sunday  -  H05,Friday  -  H23,Saturday  -  H05,Monday  -  H16,Monday  -  H17,Monday  -  H18,Monday  -  H19,Monday  -  H20";
		    Map<String, List<String>> map = new HashMap<String, List<String>>();
		    String[] dayParts = propertyValue.split(",");
		    
//		    for(String d : dayParts) {
//		    	System.out.println(d);
//		    }
		    
//
		    for (String string : dayParts) {
		      String[] array = string.split("  -  ");
		      if (map.get(array[0]) == null) {
		        List<String> list = new ArrayList<>();
		        list.add(array[1]);
		        map.put(array[0], list);
		        for(String d : list) {
			    	System.out.println(d);
			    }
		        
		      } 
		      
		      
		      else {
		        List<String> tempList = map.get(array[0]);
		        tempList.add(array[1]);
		        map.put(array[0], tempList);
		      for(String d : tempList) {
			    	System.out.println("else "+d);
		      }
		      
		    }
		    
		    

		    Map<String, Map<String, List<String>>> payload = new HashMap<>();
		    Map<String, List<String>> hrs1 = new HashMap<>();
		    hrs1.put("Hours", new ArrayList<String>());
		      
		      for(Entry<String, List<String>> d : hrs1.entrySet()) {
			    	System.out.println("map "+d.getKey()+" "+d.getValue());
		      }
//		    payload.put("Sunday", hrs1);
//		    payload.put("Monday", hrs1);
//		    payload.put("Tuesday", hrs1);
//		    payload.put("Wednesday", hrs1);
//		    payload.put("Thursday", hrs1);
//		    payload.put("Friday", hrs1);
//		    payload.put("Saturday", hrs1);
//		    
//
//int columnNum=1;
//    int fRow=2;
//    List<String> cvals = null;
//    for (Map.Entry<String, Map<String, List<String>>> m : payload.entrySet()) {
//    	
//    	System.out.println(m.getKey()+" "+m.getValue());
//    }
//        Row row = sheet.createRow(fRow);
//        Cell cell1=row.createCell(0);
//        cell1.setCellValue("Name1");
//
//        for(Map.Entry<String, List<String>> innerMap:m.getValue().entrySet()){
//        	
//        	
//        }
//            cvals=innerMap.getValue();
//
//             int tempHeight=cvals.size();
//             int temp=fRow;
//             for (String cval : cvals) {
//                 Row row2;
//                 if(sheet.getPhysicalNumberOfRows()-1>temp-1)
//                    {
//
//                        row2=sheet.getRow(temp);
//                    }
//                    else
//                    {
//                        row2=sheet.createRow(temp);
//                    }
//                 Cell cell3=row2.createCell(columnNum);
//                 cell3.setCellValue(cval);
//                 temp=temp+1;
//            }
//             columnNum=columnNum+1; 
//        }
//        fRow=fRow+cvals.size();
//        columnNum=1;
//    }
		
		
		 
	
		   
//		        
//		                Sheet sheet = wb.createSheet("Sheet");  
//		            Row row     = sheet.createRow(1);  
//		            Row row2    = sheet.createRow(2);  
//		            Cell cell   = row.createCell(1);  
//		            Cell cell2  = row2.createCell(1);  
//		            cell2.setCellValue("Hello, Javatpoint");              
//		            sheet.shiftRows(1, 2, -1);  
//		            wb.write(os);  
//		        }catch(Exception e) {  
//		            System.out.println(e.getMessage());  
		        }         
		    
	}
}

