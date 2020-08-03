package nepar;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.net.URLEncodedUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Splimethod {
	
	static XSSFWorkbook workbook = new XSSFWorkbook();
	private static String[]  var = {"One", "Two", "Three", "Four", "Five"};


public static void main(String[] args) throws URISyntaxException {
	// TODO Auto-generated method stub
@SuppressWarnings("resource")
XSSFWorkbook workbook = new XSSFWorkbook();
XSSFSheet sheet = workbook.createSheet("EmployeeData");

String url = "https://smetrics.usbank.com/b/ss/usbankcom/10/JS-2.12.0/s84588586393204?AQB=1&ndh=1&pf=1&callback=s_c_il[1].doPostbacks&et=1&t=20%2F2%2F2020%207%3A47%3A32%205%20-330&d.&nsid=0&jsonv=1&.d&sdid=4CA3DB40BB56A3B1-062CCA439234AD7C&mid=25135486547984740651195090168424127981&aamlh=12&ce=UTF-8&ns=usbank&pageName=Personal%20Home%20Page&g=https%3A%2F%2Fwww.usbank.com%2Findex.html&r=https%3A%2F%2Fwww.usbank.com%2Findex.html&c.&vidAPICheck=VisitorAPI%20Present&et_dimensions=794x576&et_width=794&et_orientation=landscape&EVENTS=event17%2Cevent15%2C&.c&cc=USD&events=event17%2Cevent15&aamb=RKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y&c1=home%20pg&c2=home%20page%20rebranded&c3=D%3Dv3&v3=Repeat&c4=9%3A15PM&c6=Thursday&c7=3%2F20%2F2020&v9=prospect&c14=D%3Dg&c18=More%20than%207%20days&c19=2&c24=usb%3Aindex.html&c25=D%3Dc24&v27=4183033d771f40e0a01b52a304feecfb.31_0&c29=https%3A%2F%2Fwww.usbank.com%2Findex.html&v35=D%3DpageName&v37=D%3DUser-Agent&c40=dotcom&v40=D%3Dc2&c50=R%20October%202019%7CAM_2.17.0%7C10.07.2019%7CbaseOLB%7CVid_4.0.0&v59=nh&v90=D%3Dg&s=1366x768&c=24&j=1.6&v=N&k=Y&bw=811&bh=576&mcorgid=675616D751E567410A490D4C%40AdobeOrg&AQE=1";

List<NameValuePair> params = URLEncodedUtils.parse(new URI(url), Charset.forName("UTF-8"));
  // System.out.println(params);
   
   
   int n = params.size();
		 //  System.out.println(n);
   
   for (int rowNum = 0; rowNum < n; rowNum++) {
	   Row row = sheet.createRow(rowNum);
	  
	   
   for(int i=0; i<n; i++) {
	
	for(int j=0; j<=i; j++) {
		//System.out.println(str[i]);
//        				Row row1 = sheet.createRow(k);
row.createCell(i).setCellValue((params.get(j)).toString());
			 //sheet.autoSizeColumn(i);
	
	 
    			}
    		}
    		
    		   }
    		   getfile();
    		   
    		   
    			
	
	
	

    			
    		
    		   }
public static void getfile() {
	// TODO Auto-generated method stub

  try {
        for(int i=0; i<5; i++)	{
		FileOutputStream out = new FileOutputStream(new File("D:\\java\\workspace\\FileR\\workbook"+var[i]+i+".xlsx"));
workbook.write(out);
out.close();
System.out.println("successfully written"+i);
	            }
			}catch (Exception e) {
				e.printStackTrace();
			}
		
	}

}
