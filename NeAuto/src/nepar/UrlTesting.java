package nepar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UrlTesting {
  
	private static List <String> lt = null;
	private static List <String> lt1 = null;
	private static   Row row = null;
	private static Cell cell = null;
	private static Map<String, String> map1 = null;
	private static Workbook wb = null;
	private static String uurl;
	private static Sheet sheet =null;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
			
			try (InputStream os = new FileInputStream("D:\\\\\\\\java\\\\\\\\workspace\\\\\\\\NeAuto\\\\\\\\URLS.xlsx")) {  
			   wb = new XSSFWorkbook(os); 
			   sheet = wb.getSheetAt(0);
			//  int noofRow1= sheet.getLastRowNum();
//			   lt = new ArrayList<>();
//			   int n = noofRow1;
//			   for(int i =0; i<=n; i++) {
//				   row = sheet.getRow(i);
//			 	  cell = row.getCell(0);
//			      lt.add(cell.getStringCellValue());
			      
			   }
//			   System.setProperty("webdriver.chrome.driver", "D:\\json jars\\chrome driver\\chromedriver_win32\\chromedriver.exe");
//				WebDriver driver = new ChromeDriver();
//				driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
//				driver.manage().window().maximize();
//				map= new LinkedHashMap<String, String>();
//				for(int j=0; j<lt.size();j++) {
//					
//				driver.get(lt.get(j));
//				driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
//                String uurl = driver.getTitle();
//                driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
//                
//                
//                //amazon();
//                
//                System.out.println(uurl);
//               // lt1.add(uurl);
//                
//                map.put(lt.get(j), uurl);
//                System.out.println(map.size());
//                
//                }
				//
			int k=1;
			 map1 = new LinkedHashMap<>();
			map1.put("Home PAge1", "Tag1");
			map1.put("Home PAge2", "Tag2");
			map1.put("Home PAge3", "Tag3");
			map1.put("Home PAge4", "Tag4");
			map1.put("Home PAge5", "Tag5");
			map1.put("Home PAge6", "Tag6");    
			  
			 ArrayList<String> keyList = new ArrayList<String>(map1.keySet());
		      ArrayList<String> valueList = new ArrayList<String>(map1.values());
			
//			 for(String i:map1.keySet()) {
//	                System.out.println(i+","+map1.getOrDefault(i, "defaultValue"));
//	                
//	                }
			
				int nofoRow1= sheet.getLastRowNum();
				//sheet.shiftRows(k, nofoRow1, 2);
//				String[] str= {"one", "two", "three","four","five"};
//				String[] str1= {"one", "two", "three","four","five"};
				 
				for (int i = 0; i < keyList.size(); i++) {
		      
					Row row = sheet.createRow(i);
		            Cell cell = row.createCell(1);
		            cell.setCellValue(keyList.get(i));
		            
		            
		         //   Row row1 = sheet.createRow(i);
		            Cell cell1 = row.createCell(2);
		            cell1.setCellValue(valueList.get(i));
		           
		        }
				//row.createCell(j).setCellValue(map.getOrDefault(key, defaultValue));
				
				 
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			//	System.out.println(lt1.size());
//                System.out.println(map.size());
				
//                
//                
//                
//				
//				driver.close();
//      
//      //System.out.println(lt.get(i));
//				int k = map.size();   
//     		   for (int rowNum = 0+1; rowNum < k; rowNum++) {
//     			   Row row = sheet.createRow(rowNum);
//     			  
//     			int j=1;   
//     		//for(int i=0; i<n; i++) {
//     			
//     		//for(int j=0; j<1; j++) {
//     				//System.out.println(str[i]);
////     				Row row1 = sheet.createRow(k);
//     			row.createCell(j).setCellValue(map.keySet().toString());
//     			 sheet.autoSizeColumn(rowNum);
// 	
//     		//	}
//     			
//     		//}
//     			   }
//       
//
//	}
//			
			FileOutputStream out = new FileOutputStream(new File("D:\\java\\workspace\\NeAuto\\URLS.xlsx"));
			wb.write(out);
			out.close();

	}

	}

	//private static void amazon() {
		// TODO Auto-generated method stub
		
		
		
		
		
		
	//}
//}
