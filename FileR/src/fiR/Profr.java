package fiR;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Profr {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		File configfile = null;
		
		try{
			configfile = new File("config.Properties");
			fis = new FileInputStream(configfile);
			Properties prop = new Properties();
			prop.load(fis);
			
			String un =  prop.getProperty("username");
			String age= prop.getProperty("age");
			
			System.out.println(un);
			System.out.println(age);
			
		}
		finally {
			fis.close();
		}

	}

}
