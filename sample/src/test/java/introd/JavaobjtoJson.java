package introd;
import com.fasterxml.jackson.databind.*;
import java.io.*;

public class JavaobjtoJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		try {
			SampleTest test = new SampleTest();
			test.setFirstName("Balaji");
			test.setLastName("Shanmugam");
			test.setAddress("KambarStreet");
			test.setCity("Chennai");
			test.setDateOfBirth("1992-07-08");
			test.setState("Tamil Nadu");
			test.setZip("600019");
			test.setPhone("123456");
			
			mapper.writeValue(new File("Individualdata.JSON"), test);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		

	}

}
