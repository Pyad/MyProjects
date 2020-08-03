package fiR;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Fil1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File ip= new File("D:\\java\\workspace\\FileR\\src\\fiR\\Tes.txt");
		
		//Methods to read
		FileReader fr =null;
		try {
			fr = new FileReader(ip);
			int i;
			while((i=fr.read())!= -1) {
				System.out.print((char)i);
			}
		}
		catch(FileNotFoundException e) {
			
		   e.printStackTrace();
			}
		catch(IOException e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				fr.close();
			}
			catch(IOException e) {
			e.printStackTrace();
		}
		

	}

}
}
