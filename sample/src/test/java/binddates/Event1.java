package binddates;

import java.util.Date;
//import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Event1 {

	public String name;
	
//	@JsonFormat
//	(shape= JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd  hh:mm")
	
	@JsonSerialize(using = CustomDateSerializer11.class)
	public Date birthDate;
	
	Event1 (String name, Date date){
		this.name = name;
		this.birthDate = date; 
	}
	
	
}
