package nepar;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ShiftRows1 {
	private static String[] columnsHeading = {"URL", "LandingPage", "Tags"};
	private  final static String[] st = {"tag1", "tag2", "tag3", "tag4","tag5"};
	private static final String[] st1 = {"AMZ1", "AMZ2", "AMZ3", "AMZ4","AMZ5"};
	private static final String[] st2 = {"URL1", "URL2", "URL3", "URL4","URL5"};
	static Map<String, Map<String, List<String>>> finalDataSet = new LinkedHashMap<>();
    //@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		//int i= (Integer) null;
    	 //final Integer innerMi = new Integer(i);
    	
		try (OutputStream os = new FileOutputStream("D:\\\\\\\\java\\\\\\\\workspace\\\\\\\\NeAuto\\\\\\\\Books.xlsx")) {  
      Workbook wb = new XSSFWorkbook();  
      Sheet sheet = wb.createSheet("Sheet");
      
      Font headerFont = wb.createFont();
      headerFont.setBold(true);
      headerFont.setFontHeightInPoints((short) 14);
      headerFont.setColor(IndexedColors.RED.getIndex());
      
      CellStyle headerCellStyle = wb.createCellStyle();
      headerCellStyle.setFont(headerFont);
	
		for (int i=0; i<st.length;i++) {
		List<String> lt = new ArrayList<String>();
		lt.add(st[i]);
//		lt.add("tag2");
//		lt.add("tag3");
		
		Map<String, List<String>> ml = new LinkedHashMap<>();
		ml.put(st1[i], lt);
//		ml.put("AMZ2", lt);
//		ml.put("AMZ3", lt);
		
		finalDataSet.put(st2[i], ml);
		}
//		 for(Entry<String, Map<String, List<String>>> d : finalDataSet.entrySet()) {
//		    	System.out.println(d.getKey()+" "+d.getValue());
//	      }
		  
		 
		 int columnNum=1;
	    int fRow=st.length;
	   // List<String> cvals = null;
	    for (Map.Entry<String, Map<String, List<String>>> m : finalDataSet.entrySet()) {
	    	
	    	//System.out.println(m.getKey()+" "+m.getValue());
	    
	    	//Row row = sheet.createRow(fRow);
	    	Row row1 = sheet.createRow(0);
	      // int rowNum = 1;    
	        for (int i = 0; i < columnsHeading.length; i++) {
	        	 
	            Cell cell = row1.createCell(i);
	            cell.setCellValue(columnsHeading[i]);
	            cell.setCellStyle(headerCellStyle);
	        }
	        
//	        String key =m.getKey();
//            row.createCell(0).setCellValue(key);
//            
//
//            Cell dateOfBirthCell = row.createCell(2);
//            dateOfBirthCell.setCellValue(m.getValue().toString());
           
//
//	        for(Map.Entry<String, List<String>> innerMap:m.getValue().entrySet()){
//	        	
//	        	 String key =m.getKey();
//	            row.createCell(0).setCellValue(key);
//	            
//	
//	            Cell dateOfBirthCell = row.createCell(2);
//	            dateOfBirthCell.setCellValue(m.getValue().toString());
	        	
	        	
	        
//	            cvals=innerMap.getValue();
//	
//	             int tempHeight=cvals.size();
//	             int temp=fRow;
//	             for (String cval : cvals) {
//	                 Row row2;
//	                 if(sheet.getPhysicalNumberOfRows()-1>temp-1)
//	                    {
//	
//	                        row2=sheet.getRow(temp);
//	                    }
//	                    else
//	                    {
//	                        row2=sheet.createRow(temp);
//	                    }
//	                 Cell cell3=row2.createCell(columnNum);
//	                 cell3.setCellValue(cval);
//	                 temp=temp+1;
//	            }
//	             columnNum=columnNum+1; 
//	        }
//	        fRow=fRow+cvals.size();
//	        columnNum=1;
//	    }
	    
	    FileOutputStream fileOut = new FileOutputStream("D:\\\\\\\\java\\\\\\\\workspace\\\\\\\\NeAuto\\\\\\\\Books.xlsx");
		 wb.write(fileOut); 
			
			
		
//		 for(String j:finalDataSet.keySet()) {
//             System.out.println(j+","+finalDataSet.getOrDefault(j, ml));
//             }
			
		}
    }
		}
    }

		
		
		
//		Map<String, List<String>> ML = new LinkedHashMap<>();
//		for( int i=0; i<st.length; i++) {
//		ML.put(st1[i], new LinkedList<String>(){{add( st[i]);}});
//		finalDataSet.put("st2[i]", ML);
//		}
////		
//		System.out.println(finalDataSet.entrySet());
//		for(String ta: st) {
//			List<String> lt = ML.get();
//			
//		}
		




