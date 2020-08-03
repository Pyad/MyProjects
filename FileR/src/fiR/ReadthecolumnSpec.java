package fiR;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadthecolumnSpec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		public CellAddress searchStringInXslx(String string) throws IOException{
            FileInputStream inputStream = new FileInputStream("Books.xlsx");
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            CellAddress columnNumber=null;

            while(iterator.hasNext()){
                 Row nextRow = iterator.next();
                 Iterator<Cell> cellIterator = nextRow.cellIterator();
                 while (cellIterator.hasNext()) {
                     Cell cell = cellIterator.next();
                   
                     if(cell.getCellType()==Cell.CELL_TYPE_STRING){ 
                         String text = cell.getStringCellValue();
                          if (string.equals(text)) {
                             columnNumber=cell.getAddress();
                             break;
                          }
                        }
                     }
            }
            workbook.close();
            return columnNumber;
     }
		
	}

}
