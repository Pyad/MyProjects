package com.balaji.core.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		 String currentDirectory = System.getProperty("user.dir");
	      System.out.println("The current working directory is " + currentDirectory);
		
		
//		ProcessBuilder processBuilder = new ProcessBuilder(currentDirectory+"\\p.bat").inheritIO();
//		processBuilder.start();
		
		Runtime runtime = Runtime.getRuntime();
		 Process p1 = runtime.exec("cmd /c start" + currentDirectory+"loopfor.bat");
//		 InputStream is = p1.getInputStream();
//		 System.out.println(is);
		 BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));

         String line;
         while ((line = reader.readLine()) != null) {
             //output.append(line + "\n");
        	 System.out.println(line);
         }
		
//		 String currentDirectory = System.getProperty("user.dir");
//	      System.out.println("The current working directory is " + currentDirectory);
		
		
//		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com");
//		Thread.sleep(2000);
//		
//		Runtime runtime = Runtime.getRuntime();
////		try {
//		    Process p1 = runtime.exec("cmd /c start C:\\Users\\DELL\\Desktop\\loopfor.bat");
//		    InputStream is = p1.getInputStream();
//		    System.out.println("is" +is.toString());
//		    int i = 0;
//		    while( (i = is.read() ) != -1) {
//		        System.out.print((char)i);
//		    }
//		} catch(IOException ioException) {
//		    System.out.println(ioException.getMessage() );
//		}

	}

}
