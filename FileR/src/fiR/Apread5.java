package fiR;


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

public class Apread5 {



		    static XSSFWorkbook workbook = new XSSFWorkbook();

		    public void getList(List<String> listcriteria){
		        Map<Integer, List<String>> hashmap = new HashMap<Integer , List<String>>();
		        String[] data1 = {"ACSS Description1", "ACSS Description2", "ACSS Description3", "SACSS Description4"};
		        List s1 = Arrays.asList(data1);
		        System.out.println("s1 ->" +s1);
		        hashmap.put(1,s1); 
		        String[] data2 = {"11", "1", "4", "12"};
		        List s2 = Arrays.asList(data2);
		        hashmap.put(2,s2); 

		        System.out.println("hashmap : "+hashmap);
		        Set<Integer> keyset = hashmap.keySet();
		        int rownum = 1;
		        int cellnum = 0;
		        XSSFSheet sheet = workbook.getSheetAt(0);
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
		            rownum=1;
		        }
		    }

		    public static void main(String[] args) throws IOException {
		        //Creation of List from an Array to test getList Method
		        String[] ss = {"a","b","c","d","e"};
		        List<String> listcriteria = new ArrayList<String>();
		        listcriteria.addAll(Arrays.asList(ss));
		        /***********************************************************/

		        Apread5 t = new Apread5();
		        // Because I put 5 key values pairs in hashmap (see getList method), I create  Writesheet.xlsx 
		        // file that contains 5 rows each row contains 5 cell
		        FileOutputStream out = new FileOutputStream( new File("Writesheet2.xlsx"));
		        XSSFSheet sheet = workbook.createSheet();
		        for(int i = 0;i<5;i++){
		            XSSFRow row = sheet.createRow(i);
		            for(int j=0;j<5;j++)
		            row.createCell(j);
		        }
		        workbook.write(out);
		        out.close();//end creation of Excel file

		        // I open Writesheet.xlsx file and write the data on it
		        InputStream inp = new FileInputStream( new File("Writesheet2.xlsx"));
		        workbook = new XSSFWorkbook(inp);
		        // listcriteria contains the data that will be written it on  Writesheet.xlsx
		        t.getList(listcriteria);
		        out = new FileOutputStream( new File("Writesheet2.xlsx"));
		        workbook.write(out);
		        out.close();
		        inp.close();
		        System.out.println("Writesheet.xlsx written successfully" );

		    }

	}


