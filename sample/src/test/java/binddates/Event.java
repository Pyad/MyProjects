package binddates;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Event {

	public String name;
	
	@JsonFormat
	(shape= JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd  hh:mm")
	public Date birthDate;
	
	Event (String name, Date date){
		this.name = name;
		this.birthDate = date;
	}
	
	
}
