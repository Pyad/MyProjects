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

public class Ibelieve5 {

	private static Row row = null;
	private static Sheet sheet = null;
	private static Workbook wb = null;
	private static Cell cell = null;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		try (InputStream os = new FileInputStream("D:\\\\\\\\java\\\\\\\\workspace\\\\\\\\NeAuto\\\\\\\\Books.xlsx")) {
			wb = new XSSFWorkbook(os);
			sheet = wb.getSheetAt(0);

			Map<String, Map<String, String>> map = new LinkedHashMap<>();
			Map<String, String> map1 = new LinkedHashMap<>();
			map1.put("Home PAge1", "Tag1");
			map1.put("Home PAge2", "Tag2");
			map1.put("Home PAge3", "Tag3");
			map1.put("Home PAge4", "Tag4");
			map1.put("Home PAge5", "Tag5");
			map1.put("Home PAge6", "Tag6");
			map1.put("Home PAge7", "Tag7");
			map1.put("Home PAge8", "Tag8");
			map1.put("Home PAge9", "Tag9");
			map1.put("Home PAge10", "Tag10");
			// map.put("URL7", new HashMap(){{put("Home PAge7", "Tag7");}});

			map.put("URL1", map1);
			map.put("URL2", map1);
			map.put("URL3", map1);
			map.put("URL4", map1);
			map.put("URL5", map1);
			map.put("URL6", map1);
			map.put("URL7", map1);
			map.put("URL8", map1);
			map.put("URL9", map1);
			map.put("URL10", map1);

			ArrayList<String> keyList = new ArrayList<String>(map.keySet());
			ArrayList<String> keyList1 = new ArrayList<String>(map1.keySet());
			ArrayList<String> valueList = new ArrayList<String>(map1.values());
			
			
			System.out.println("valueList " +valueList);

			// for(String i : map.keySet()) {
			//
			//
			//
			// for(Entry<String, String> m : map1.entrySet()) {
			// System.out.println(i+" "+ m.getKey()+" "+m.getValue());
			// }
			// }
			// int i=0;
//			int counter = 0;
			int r= sheet.getLastRowNum();
			int counter=0;
			for (int k = 0; k < keyList.size(); k++) {
				if (k!=0) {
				row = sheet.createRow( counter+k);
				}
				else {
					row = sheet.createRow( k);
				}
				cell = row.createCell(0);
				cell.setCellValue(keyList.get(k));
				cell = row.createCell(1);
				cell.setCellValue("URLS");
				cell = row.createCell(2);
				cell.setCellValue("Landing Page");
				cell = row.createCell(3);
				cell.setCellValue("Tags");
				
				
				
				// System.out.println("k->" +k);

				// int nofoRow1= sheet.getLastRowNum();
				for (int i = 0; i < keyList.size(); i++) {
					// int r= sheet.getLastRowNum();
					if((i!=0) || (i==0 && k!=0))   {
						
						row = sheet.createRow(counter+i+(k+1));
						}
					else {
						row = sheet.createRow(i+1);	
					}
					
					
					
					System.out.println(row);
					System.out.println("Ksize "+keyList.size());

					cell = row.createCell(1);
					cell.setCellValue(keyList.get(i));
					// System.out.println("i->"+i);
					// System.out.println("Size->"+keyList.size());
					//

					// Row row1 = sheet.createRow(i);
					cell = row.createCell(2);
					cell.setCellValue(keyList1.get(i));
					// System.out.println(i);
					// sheet.autoSizeColumn(i);

					Cell cell2 = row.createCell(3);
					cell2.setCellValue(valueList.get(i));
					// System.out.println(i);

					// i++;

				}
				counter=counter+keyList.size();

			}
			FileOutputStream out = new FileOutputStream(new File("D:\\java\\workspace\\NeAuto\\Books2counternew.xlsx"));
			wb.write(out);
			System.out.println("Excel closed");
			out.close();

		}
	}
}
