package fiR;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fil4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File ipr = new File("D:\\java\\workspace\\FileR\\src\\fiR\\Tes.txt");
		File opw = new File("D:\\java\\workspace\\FileR\\src\\fiR\\writ.txt");
		
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader(ipr);
			fw = new FileWriter(opw);
			int i;
			while((i= fr.read())!=-1) {
				fw.write((char)i);
			}
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				fr.close();
				fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}
