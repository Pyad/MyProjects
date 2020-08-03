package nepar;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApacheWrite { 
	
       private static XSSFWorkbook wb = null;
       
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {"Memonto", "Insomania","Batman Begins", "The Prestige", "The DarkKnight"," Inception"," The Darkknight Rises", "Insterstellar", "Dunkirk"," Tenet"}; 
		wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Test");
		int n=str.length;
		
		for(int i =0; i<n; i++) {
			//int i =0;
			XSSFRow row = sheet.createRow(i);
			//for(int k=0; k<i;k++) {
				
		
			for(int j=0; j<1; j++) {
				
				
				row.createCell(j).setCellValue(str[i]);
				sheet.autoSizeColumn(j);
				
			
		}
	//}
		}
		
		getfile();

	}
	
	public static void getfile() {
		// TODO Auto-generated method stub

	  try {
	        for(int i=0; i<5; i++)	{
			FileOutputStream out = new FileOutputStream(new File("D:\\java\\workspace\\FileR\\NolanMovieList.xlsx"));
				wb.write(out);
				out.close();
				System.out.println("successfully written"+i);
					            }
				}catch (Exception e) {
					e.printStackTrace();
				}
			
		}

}
