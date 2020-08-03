package fiR;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

public class prof {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fos = null;
		File configfile = null;
		
		try {
			configfile = new File("config.properties");
			fos = new FileOutputStream(configfile);
			Properties propconfig = new Properties();
			propconfig.setProperty("username", "Balaji");
			propconfig.setProperty("age", "22");
			propconfig.setProperty("email", "abc@abc.com");
			propconfig.store(fos, "test");
			fos.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
