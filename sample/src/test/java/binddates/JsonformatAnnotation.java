package binddates;

import introd.SampleTest;
import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.Date;
import java.text.*;

public class JsonformatAnnotation {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			SampleTest test = mapper.readValue(new File("Individualdata.JSON"),SampleTest.class);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			Date date = df.parse(test.getDateOfBirth());
			
			Event1 event = new Event1("BirthDate", date);
			mapper.setDateFormat(df);
			System.out.print("Birthdate ");
			System.out.println(mapper.writeValueAsString(event));
			
			
		}catch(IOException e) {}

	}

}