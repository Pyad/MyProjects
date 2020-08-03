package nepar;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readonecolumn1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		   File myFile = new File("D:\\java\\workspace\\FileR\\workbookthewholepro.xlsx");
		    FileInputStream fis = new FileInputStream(myFile);

		    // Finds the workbook instance for XLSX file
		    XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);

		    //XSSFWorkbook workBook = new XSSFWorkbook();
		    //Reading sheet at number 0 in spreadsheet(image attached for reference
		    Sheet sheet = myWorkBook.getSheetAt(0);

		    //creating a Sheet object to retrieve object  
		    Iterator<Row> itr = sheet.iterator();//iterating over excel file  

		    while (itr.hasNext())                 
		    {  
		        Row row = itr.next();
		        Iterator<Cell> cellIterator = row.cellIterator();//iterating over each column
		        //Reading cell in my case column name is ppm
		        Cell ppmEx= row.getCell(0);

		        //Cell cell = cellIterator.next();
		        while (cellIterator.hasNext())
		        {  
		            Cell cell = cellIterator.next();
		            cell.getCellTypeEnum();
		            
		            //Check the cell type and format accordingly
		            switch (cell.getCellType()) 
		            {
		                case cell.
		                    //System.out.println(cell.getNumericCellValue() + "    ");
		                    al.add(cell.getNumericCellValue());
		                    break;
		                case Cell.CELL_TYPE_STRING:
		                    //System.out.println(cell.getStringCellValue()+" ");
		                    al.add(cell.getStringCellValue());
		                    break;
		                case Cell.CELL_TYPE_BOOLEAN:
		                    //System.out.println(cell.getBooleanCellValue()+" ");
		                    al.add(cell.getBooleanCellValue());
		                case Cell.CELL_TYPE_BLANK:
		                    //System.out.println("blank");
		                    al.add("blank");

		            }  
		        }  
		        System.out.println("-");
		    }

	}

}
