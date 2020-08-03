package nepar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceloperation {
	
	private static Row row = null;
	private static Sheet sheet = null;
	private static Workbook wb = null;
	private static Cell cell = null;
	private static int counter = 0;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		InputStream os = new FileInputStream(
				new File("D:\\java\\workspace\\NeAuto\\exceloper.xlsx"));
			wb = new XSSFWorkbook(os);
			sheet = wb.getSheetAt(0);
			
			sheet.getRow(0).createCell(4).setCellValue("jio");
			
			//int tot= sheet.getLastRowNum();
			row = sheet.getRow(0);
			int col = row.getLastCellNum();
			int lr = sheet.getLastRowNum();
			int pr =sheet.getPhysicalNumberOfRows();
			int rn = row.getRowNum();
			int ce= row.getPhysicalNumberOfCells();
			System.out.println("col" +col);
			System.out.println("lr" +lr);
			System.out.println("pr" +pr);
			System.out.println("rn" +rn);
			System.out.println("ce" +ce);
			
			Cell c = row.createCell(3);
			c.setCellValue("jilo1");
			//int colnum = row.getLastCellNum();
			//System.out.println(tot);
			//System.out.println(colnum);
			
			for(int i =0; i<lr+1; i++) {
				Row r= CellUtil.getRow(i, sheet); 
				System.out.println(CellUtil.getCell(r, 0).getStringCellValue());
				System.out.println(CellUtil.getCell(r, 1).getStringCellValue());
			}
			
			
			
			
			
//			for(int i=1; i<sheet.getLastRowNum()+1; i++ ) {
//				row = sheet.getRow(i);
//				System.out.println();
//				String t = row.getCell(0).getStringCellValue();
//				System.out.println("t value " +t);
//				
//				
//				
//				for(int j=0; j<colnum;j++) {
//					String l = row.getCell(j).getStringCellValue();
//				System.out.println("l Value " +l);	
//				
//				}
//				
//				
//			}
//			
			
			
			
						
						
			

		FileOutputStream out = new FileOutputStream(new File("D:\\\\java\\\\workspace\\\\NeAuto\\\\exceloper.xlsx"));
		wb.write(out);
		//System.out.println("excel close");
		System.out.println();
		out.close();
	}
		
		
	}

	

