package com.mavtest;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WCog {
	
	

	public static WebDriver driver;
	public static String is;
	public static String b = is;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		 is = System.getProperty("user.dir");
		 
		 System.out.println(WCog.is);
		driver = BaseClass.BrowserLaunch();
		BaseClass.Iwait(300);
		
		driver.get("https://www.cognizant.com");
		By c = Locators.News;
		WebElement e = BaseClass.finEle(c);
//		WebDriverWait wait = new WebDriverWait(driver,90);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.career));
		BaseClass.Await(e);
		String Title = driver.getTitle();
		System.out.println(Title);
		BaseClass.back();
		BaseClass.Iwait(30000);
		
		
		List<LogEntry> entries =  driver.manage().logs().get(LogType.PERFORMANCE).getAll();
		LogExtraction.setDatMap(entries);
		
		
		

	}

}
