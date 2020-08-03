package introd;
import com.fasterxml.jackson.databind.*;
import java.io.*;


public class JsontoJavaobj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ObjectMapper mapper = new ObjectMapper();
		
		try {
			SampleTest test = mapper.readValue(new File("Individualdata.JSON"), SampleTest.class);
			System.out.println(test.getFirstName()+" "+test.getLastName());
			System.out.println(test.toString());
		}catch(IOException e) {
		}		
	}

}
