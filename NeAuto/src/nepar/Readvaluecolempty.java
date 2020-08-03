package nepar;

		import java.io.FileInputStream;

		import java.io.IOException;

		import java.io.InputStream;
		import java.util.ArrayList;
		import java.util.LinkedHashMap;
		import java.util.List;
		import java.util.Map;

		import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

		import org.apache.poi.ss.usermodel.Cell;

		import org.apache.poi.ss.usermodel.Row;

		import org.apache.poi.ss.usermodel.Sheet;

		import org.apache.poi.ss.usermodel.Workbook;

		import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class Readvaluecolempty {

				
				// TODO Auto-generated method stub
			private static List<String> lt =null;
			private static WebDriver driver = null;
				
				
				    public static void main(String[] args) throws InvalidFormatException, IOException{
				
				        InputStream inp = new FileInputStream("D:\\java\\workspace\\FileR\\workbookthewholepro.xlsx");
				        //
				      // int  k = lt.size();
				      //  int ctr = 0;
				
				        Workbook wb = WorkbookFactory.create(inp);
				
				        Sheet sheet = wb.getSheetAt(0);
				        
				
				        Row row = null;
				
				        Cell cell = null;
				
				        //boolean isNull = false;
				        
				        for(int i =0; i<sheet.getLastRowNum() + 1; i++) {
				        	 row = sheet.getRow(i);
				        	  cell = row.getCell(0);
				        	  System.out.println(cell.toString());
				        	 
				        	
				        }
				
//				        do{
//				
//				            try{
//				
//				            row = sheet.getRow(ctr);
//				
//				            cell = row.getCell(0);
//				            
//				            
//				          //  lt.get(index)
//		                        
//				
//				            System.out.println(cell.toString());
//				
//				            ctr++;
//				
//				            } catch(Exception e) {
//				
//				                isNull = true;
//				
//				            }
//				
//				             
//				
//				        }while(isNull!=true);
				
				       //
				        inp.close();
			
				    }
				
				     
			




	}


