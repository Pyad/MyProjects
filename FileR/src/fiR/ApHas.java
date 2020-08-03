package fiR;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApHas {
	
	public static final String location = "D:\\java\\workspace\\FileR\\workbook3.xlsx";
	private static FileInputStream fis;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
//	@SuppressWarnings("unused")
//	private static File file;
	
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//realAlldata();
		System.out.print(realAlldata());
	}
		public static void loadExcel() throws Exception{
			File file = new File(location);
			fis  = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("EmployeeData");
			fis.close();
		}
		
		public static List<Map<String, String>> realAlldata() throws Exception{
			if (sheet == null){
			loadExcel();
		}
		List<Map<String, String>> mapLists = new ArrayList<>();
		
		int rows = sheet.getLastRowNum();
		//System.out.println("Rows values "+ rows);
		row = sheet.getRow(0);
//		System.out.println("Row values "+ row);
//		System.out.println("lastcell nu" +row.getLastCellNum());
//		System.out.println("sheet-> " +sheet);
		
		
		for(int j=1; j<row.getLastCellNum();j++) {
			
			Map<String, String> mymap = new LinkedHashMap<>();
			
			for (int i=0; i<rows+1; i++) {
			Row r = CellUtil.getRow(i, sheet);
			String key = CellUtil.getCell(r, 0).getStringCellValue();
			String value = CellUtil.getCell(r, j).getStringCellValue();
			
			
			mymap.put(key, value);
		}
            mapLists.add(mymap);

	} 
            return mapLists;
    }

}
