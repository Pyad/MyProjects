package com.mavtest;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.JavascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Actions act;
	
	public static WebDriver driver;
	//public static 
	public static void Iwait(long s) {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(s, TimeUnit.MILLISECONDS);
		}
		catch(Exception e) {
			
		
	}

}
	
public static void Await(WebElement e) {
		
		try {
			act = new Actions(driver);
			act.moveToElement(e).click().perform();
		}
		catch(Exception e1) {
			
		
	}

}

	public static WebElement finEle(By st) {
		
			return driver.findElement(st);
		
	}
	public static void back() {
		
		driver.navigate().back();
	}
	
	public static void Jclick(WebElement r) {
		
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", r);
		}
		catch(Exception e){
			
		}
	}
	public static WebDriver BrowserLaunch() throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
			WebDriverManager.chromedriver().setup();
			
			 ChromeOptions caps = new ChromeOptions();
			 caps.setPageLoadStrategy(PageLoadStrategy.EAGER);
			LoggingPreferences logPrefs = new LoggingPreferences();
			
			logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
			

			caps.setCapability("goog:loggingPrefs", logPrefs);
			

			driver = new ChromeDriver(caps);

			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

			driver.manage().window().maximize();

			driver.manage().deleteAllCookies();
			Actions act = new Actions(driver);
			
			
			//Jclick(e);
			return driver;
			
			//act.moveToElement(e).click().perform();
			
		
		
		

		
	}
	}
