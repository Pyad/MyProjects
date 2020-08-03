package nepar;

import java.io.FileInputStream;

import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingoneColumn2 {

	
		// 31-Mar-2020
	// this for comparing two list one is from excel other one is added manually in the script itself and comparing
	private static List<String> lt, lt1 =null;
		
		
		    public static void main(String[] args) throws InvalidFormatException, IOException{
		
		        InputStream inp = new FileInputStream("D:\\java\\workspace\\FileR\\workbookthewholepro.xlsx");
		        lt = new ArrayList<String>();
		        lt1 = new ArrayList<String>();
		        lt1.add("AQB=1");
		        lt1.add("ndh=1");
		        lt1.add("sting2");
		        lt1.add("sting3");
		        
		       
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
		        	  lt.add(cell.toString());
		        	  //System.out.println("Printed"+i);
		        	
		        }
		        
		        Collection<String> similar = new HashSet<String>( lt );
		          Collection<String> different = new HashSet<String>();
		          different.addAll( lt );
		          different.addAll( lt1 );

		          similar.retainAll( lt1 );
		          different.removeAll( similar );

		          System.out.printf("One:%s%nTwo:%s%nSimilar:%s%nDifferent:%s%n", lt, lt1, similar, different);
		        
		        
		
//		        do{
//		
//		            try{
//		
//		            row = sheet.getRow(ctr);
//		
//		            cell = row.getCell(0);
//		            
//		            
//		          //  lt.get(index)
//                        
//		
//		            System.out.println(cell.toString());
//		
//		            ctr++;
//		
//		            } catch(Exception e) {
//		
//		                isNull = true;
//		
//		            }
//		
//		             
//		
//		        }while(isNull!=true);
		
		       //
		        inp.close();
	
		    }
		
		     
		
		


	}


