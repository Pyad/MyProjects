package nepar;

import java.util.Date;

public class Employee {
	
	String name;
	String email;
	Date d1;
	double m;
	
	public Employee(String string, String string2, Date time, double d) {
		// TODO Auto-generated constructor stub
		 name = string;
		 email = string2;
		 d1 = time;
		 m = d;	
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public Date getDateOfBirth() {
		// TODO Auto-generated method stub
		return d1;
	}

	public Double getSalary() {
		// TODO Auto-generated method stub
		return m;
	}

}
