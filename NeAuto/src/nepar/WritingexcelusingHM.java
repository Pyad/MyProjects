package nepar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingexcelusingHM {


		    static XSSFWorkbook workbook = new XSSFWorkbook();

		    public void getList(List<String> listcriteria){
		        Map<Integer, List<String>> hashmap = new HashMap<Integer , List<String>>();
		        //create 5 key value pairs 
		        for(int i=0; i < 5; i++){
		            hashmap.put(i, listcriteria); 
		        }
		        System.out.println("hashmap : "+hashmap);
		        Set<Integer> keyset = hashmap.keySet();
		        int rownum = 0;
		        int cellnum = 0;
		        XSSFSheet sheet = workbook.getSheetAt(0);
		        rownum = 0;
		        for(Integer key : keyset){
		            List<String> nameList = hashmap.get(key);
		            for(String s : nameList){
		                XSSFRow row = sheet.getRow(rownum++);
		                Cell cell = row.getCell(cellnum);
		                if(null!=cell){
		                    cell.setCellValue(s);
		                }
		            }
		            cellnum++;
		            rownum=0;
		        }
		    }

		    public static void main(String[] args) throws IOException {
		        //Creation of List from an Array to test getList Method
		        String[] ss = {"a","b","c","d","e"};
		        List<String> listcriteria = new ArrayList<String>();
		        listcriteria.addAll(Arrays.asList(ss));
		        /***********************************************************/

		        WritingexcelusingHM t = new WritingexcelusingHM();
		        // Because I put 5 key values pairs in hashmap (see getList method), I create  Writesheet.xlsx 
		        // file that contains 5 rows each row contains 5 cell
		        FileOutputStream out = new FileOutputStream( new File("Writesheet.xlsx"));
		        XSSFSheet sheet = workbook.createSheet();
		        for(int i = 0;i<5;i++){
		            XSSFRow row = sheet.createRow(i);
		            for(int j=0;j<5;j++)
		            row.createCell(j);
		        }
		        workbook.write(out);
		        out.close();//end creation of Excel file

		        // I open Writesheet.xlsx file and write the data on it
		        InputStream inp = new FileInputStream( new File("Writesheet.xlsx"));
		        workbook = new XSSFWorkbook(inp);
		        // listcriteria contains the data that will be written it on  Writesheet.xlsx
		        t.getList(listcriteria);
		        out = new FileOutputStream( new File("WritesheetusingHashMap.xlsx"));
		        workbook.write(out);
		        out.close();
		        inp.close();
		        System.out.println("Writesheet.xlsx written successfully" );

		    }

		}
		
		

	
