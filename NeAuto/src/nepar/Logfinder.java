package nepar;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.logging.LogEntry;

public class Logfinder {

	public static void main(String[] args) {
		
		
		String st = lin;

		List<String> lt = new ArrayList<String>();

		
		WebCog5 entry = new WebCog5();

		Pattern pattern = Pattern.compile("\"url\":\"(.*?)\"},");
		System.out.println("log" + expected);

		for (LogEntry entry1 : expected) {

			if ((entry1.getMessage().indexOf("https://cognizant.sc.omtrdc.net/b/ss/") > -1)
					&&(entry1.getMessage().indexOf("pev2") > -1) && (entry1.getMessage().indexOf("Network.requestWillBeSent") > -1) &&  (entry1.getMessage().indexOf("pev1") > -1) && (entry1.getMessage().indexOf("Image") > -1) && (entry1.getMessage().indexOf("GET") > -1) ) {

				Matcher matcher = pattern.matcher(entry1.getMessage());
				// System.out.println("M " + entry1);

				if (matcher.find()) {

					String s = matcher.group(1);
					 System.out.println("matcher s "+s);

					//lt.add(s);
					//System.out.println("Size of LT " + lt.size());
					

				}
				
			}

		}
		System.out.println(" LT " + lt);
		//excelwrite(lt, st);
	}


	}

}