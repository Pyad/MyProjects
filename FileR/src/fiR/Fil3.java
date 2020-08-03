package fiR;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fil3 {

	public static void main(String[] args) throws FileNotFoundException {
		File ip= new File("D:\\java\\workspace\\FileR\\src\\fiR\\Tes.txt");
		Scanner sc = new Scanner(ip);
		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}

	}

}
