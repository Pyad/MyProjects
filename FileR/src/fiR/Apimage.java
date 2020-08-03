package fiR;
    import java.io.FileInputStream;
    import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
    import org.apache.poi.ss.usermodel.*;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.io.InputStream;
    import java.util.ArrayList;
    import java.util.Calendar;
    import java.util.List;
    import org.apache.poi.util.IOUtils;
    import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
    import org.apache.poi.xssf.usermodel.XSSFDrawing;
    import org.apache.poi.xssf.usermodel.XSSFPicture;

    public class Apimage {
    private static String[] columns = {"Name", "Email", "Date Of Birth", "Salary", "Photo"};
    private static List<Employee> employees = new ArrayList<>();

    // Initializing employees data to insert into the excel file
    static  {
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1992, 7, 21);
        employees.add(new Employee("Ravinath Fernandoh", "ravi@example.com",
                dateOfBirth.getTime(), 1200000.0));

        dateOfBirth.set(1965, 10, 15);
        employees.add(new Employee("Gayathri Sirimanna", "fer@example.com",
                dateOfBirth.getTime(), 1500000.0));

        dateOfBirth.set(1987, 4, 18);
        employees.add(new Employee("Bivon Jethmain", "bivon@example.com",
                dateOfBirth.getTime(), 1800000.0));
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
        // Create a Workbook
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances of various things like DataFormat, 
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Employee");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Cell Style for formatting Date
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        // Create Other rows and cells with employees data
        int rowNum = 1;
        for (Employee employee : employees) {
            Row row = sheet.createRow(rowNum++);
            row.setHeight((short) 1000);

            row.createCell(0).setCellValue(employee.getName());
            row.createCell(1).setCellValue(employee.getEmail());

            Cell dateOfBirthCell = row.createCell(2);
            dateOfBirthCell.setCellValue(employee.getDateOfBirth());
            dateOfBirthCell.setCellStyle(dateCellStyle);

            row.createCell(3).setCellValue(employee.getSalary());

            //============= Inserting image - START
            /* Read input PNG / JPG Image into FileInputStream Object*/
            InputStream my_banner_image = new FileInputStream("D:\\PB_PROJECT\\NFC School Card\\NFCREST\\web\\photo_student\\4566.png");
            /* Convert picture to be added into a byte array */
            byte[] bytes = IOUtils.toByteArray(my_banner_image);
            /* Add Picture to Workbook, Specify picture type as PNG and Get an Index */
            int my_picture_id = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            /* Close the InputStream. We are ready to attach the image to workbook now */
            my_banner_image.close();
            /* Create the drawing container */
            XSSFDrawing drawing = (XSSFDrawing) sheet.createDrawingPatriarch();
            /* Create an anchor point */
            //============= Inserting image - END

            //========adding image START
            XSSFClientAnchor my_anchor = new XSSFClientAnchor();
            /* Define top left corner, and we can resize picture suitable from there */

            my_anchor.setCol1(5); //Column B
            my_anchor.setRow1(rowNum-1); //Row 3
            my_anchor.setCol2(6); //Column C
            my_anchor.setRow2(rowNum); //Row 4

            /* Invoke createPicture and pass the anchor point and ID */
            XSSFPicture my_picture = drawing.createPicture(my_anchor, my_picture_id);
            //========adding image END
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("poi-generated-file.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }
}