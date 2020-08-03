package binddates;

import java.util.Date;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.text.SimpleDateFormat;


@SuppressWarnings({ "unused", "serial" })
public class CustomDateSerializer11 extends StdSerializer<Date>{
	
	public CustomDateSerializer11() {
		
		this(null);
	}


	protected CustomDateSerializer11(Class t) {
		super(t);
		// TODO Auto-generated constructor stub
	}
	
	


	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:hh");
	
	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider arg2) throws IOException {
		// TODO Auto-generated method stub
		
		gen.writeString(formatter.format(value)+"(Chicago local time)");
		
	}
	
	
	
	



	
}


	