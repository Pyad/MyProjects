package fiR;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Fil2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = null;
		File ip= new File("D:\\java\\workspace\\FileR\\src\\fiR\\Tes.txt");
		try {
		 bufferedReader = new BufferedReader(new FileReader(ip));
		String line;
		
		while((line = bufferedReader.readLine())!= null) {
			System.out.println(line);
		}
		}catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				bufferedReader.close();
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		}
		
		

	}


