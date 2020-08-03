package nepar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ForReadinCol {
	

    private static Row row = null;
    private static Sheet sheet = null;
    
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Map<String,Map<String, String>> map = new LinkedHashMap<>();
		Map<String, String> map1= new LinkedHashMap<>();
		map1.put("Home PAge1", "Tag1");
		map1.put("Home PAge2", "Tag2");
		map1.put("Home PAge3", "Tag3");
		map1.put("Home PAge4", "Tag4");
		map1.put("Home PAge5", "Tag5");
		map1.put("Home PAge6", "Tag6");
		map.put("URL7", new HashMap(){{put("Home PAge7", "Tag7");}});
		
		map.put("URL1", map1);
		map.put("URL2", map1);
		map.put("URL3", map1);
		map.put("URL4", map1);
		map.put("URL5", map1);
		map.put("URL6", map1);
		
		//System.out.println(map.get("URL7"));
		//String m = map.values().toString();
		//System.out.println(m);
		ArrayList<String> keyList = new ArrayList<String>(map1.keySet());
		ArrayList<String> valueList = new ArrayList<String>(map1.values());
		
		
//		Iterator<Map<String, String>>  s = map.iterator();
//			while(s.hasNext()) {
//				System.out.println(s.next().toString());
//			}
			for(String i : map.keySet()) {
				
			
		
		for(Entry<String, String> m : map1.entrySet()) {
			System.out.println(i+" "+ m.getKey()+" "+m.getValue());
		}
			}
		
//		Map<string,string> newMap= new Map<string,string>();
//		for(String strKey: mapValues.keyset())
//		{
//		    newMap.put(strKey, String.valueof(mapValues.get(strKey)));
//		}
//		
//		for(String i:map.keySet()) {
//            System.out.println(i+","+map.get(i).entrySet().toString());
//            }
//		
//		for (Entry<String, Map<String, String>> entry : map.entrySet()) {
//		    System.out.println(entry.getKey()+" : "+entry.getValue());
//		}
//		System.out.println(map.getOrDefault(map, map1));
//		
		
//	
//		try (InputStream os = new FileInputStream(new File("D:\\\\java\\\\workspace\\\\NeAuto\\\\Books.xlsx")) ){  
//            //Workbook wb = new XSSFWorkbook();  
//			XSSFWorkbook workbook = new XSSFWorkbook(os);
//			Sheet sheet = workbook.getSheetAt(0);
//	         int noOfColumns = sheet.getRow(1).getLastCellNum();
//	         int noOfColumns1 = sheet.getRow(1).getPhysicalNumberOfCells();
//	         int noofRow = sheet.getPhysicalNumberOfRows();
//	         int nofoRow1= sheet.getLastRowNum();
//	         sheet.shiftRows(2, nofoRow1, 5);
           // for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			//int rowIndex = 1;
			//int rowIndex = sheet.getLastRowNum();
          	 // row = sheet.getRow(rowIndex);
          	//  System.out.println(row.getLastCellNum());
//	         System.out.println(noofRow);
//	         System.out.println(nofoRow1);
//	         System.out.println(noOfColumns);
//	         System.out.println(noOfColumns1);
	         
//	         Iterator<Row> rowIterator = sheet.iterator(); // Traversing over each row of XLSX file
//	         while (rowIterator.hasNext()) {
//	             Row row = rowIterator.next(); // For each row, iterate through each columns
//	             Iterator<Cell> cellIterator = row.cellIterator();
//	             while (cellIterator.hasNext()) {
//	                 Cell cell = cellIterator.next();
//	                 System.out.println( "column index"+cell.getColumnIndex());//You will have your columns fixed in Excel file
//	                 if(cell.getColumnIndex()==3)//for example of c
//	                 {
//	                System.out.println("finished");            
//	                 }
//	           }
//	         
//
//	         }
		
//		 FileOutputStream fileOut = new FileOutputStream("D:\\\\\\\\java\\\\\\\\workspace\\\\\\\\NeAuto\\\\\\\\Books.xlsx");
//		 workbook.write(fileOut); 
//		}
		
//		catch(Exception e) {  
//            System.out.println(e.getMessage());  
//        }  
}
}
