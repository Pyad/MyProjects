package nepar;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.util.IOUtils;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;


import java.io.IOException;

public class InsertImage {

		 public static void main(String[] args) {
		  try {

		   Workbook wb = new XSSFWorkbook();
		   Sheet sheet = wb.createSheet("My Sample Excel");
		   //FileInputStream obtains input bytes from the image file
		   InputStream inputStream = new FileInputStream("C:\\Users\\DELL\\Desktop\\Screenshot.png");
		   //Get the contents of an InputStream as a byte[].
		   byte[] bytes = IOUtils.toByteArray(inputStream);
		   //Adds a picture to the workbook
		   int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
		   //close the input stream
		   inputStream.close();
		   //Returns an object that handles instantiating concrete classes
		   CreationHelper helper = wb.getCreationHelper();
		   //Creates the top-level drawing patriarch.
		   Drawing drawing = sheet.createDrawingPatriarch();

		   //Create an anchor that is attached to the worksheet
		   ClientAnchor anchor = helper.createClientAnchor();

		   //create an anchor with upper left cell _and_ bottom right cell
		   anchor.setCol1(1); //Column B
		   anchor.setRow1(2); //Row 3
		   anchor.setCol2(2); //Column C
		   anchor.setRow2(3); //Row 4

		   //Creates a picture
		   Picture pict = drawing.createPicture(anchor, pictureIdx);

		   //Reset the image to the original size
		   //pict.resize(); //don't do that. Let the anchor resize the image!

		   //Create the Cell B3
		   Cell cell = sheet.createRow(2).createCell(1);

		   //set width to n character widths = count characters * 256
		   int widthUnits = 90*256;
		   sheet.setColumnWidth(1, widthUnits);

		   //set height to n points in twips = n * 20
		   short heightUnits = 200*20;
		   cell.getRow().setHeight(heightUnits);

		   //Write the Excel file
		   FileOutputStream fileOut = null;
		   fileOut = new FileOutputStream("myFile.xlsx");
		   wb.write(fileOut);
		   fileOut.close();

		  } catch (IOException ioex) {
		  }
		 }
		}

	
