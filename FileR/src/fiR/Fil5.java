package fiR;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fil5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File ipr = new File("D:\\java\\workspace\\FileR\\src\\fiR\\Tes.txt");
		File opw = new File("D:\\java\\workspace\\FileR\\src\\fiR\\writt.txt");
		
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			bufferedReader = new BufferedReader(new FileReader(ipr));
			bufferedWriter = new BufferedWriter(new FileWriter(opw));
			
			String line;
			while((line = bufferedReader.readLine())!= null) {
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
		    e.printStackTrace();
		}
		finally {
			try {
				bufferedReader.close();
				bufferedWriter.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

}
