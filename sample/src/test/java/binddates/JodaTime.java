package binddates;

import introd.SampleTest;
import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.Date;
import java.text.*;
//import org.joda.time.DateTime;

public class JodaTime {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			SampleTest test = mapper.readValue(new File("Individualdata.JSON"),SampleTest.class);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			Date date = df.parse(test.getDateOfBirth());
			
			
			mapper.setDateFormat(df);
			System.out.print("Birthdate ");
			System.out.println(mapper.writeValueAsString(date));
			
			
		}catch(IOException e) {}

	}

}
