package com.mavtest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Newtab {
	public static WebDriver driver;
	public static JavascriptExecutor js=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		
		
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://www.google.com");
		
//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
//		
//		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t"); 
//		driver.findElement(By.linkText("https://mail.google.com/mail/?tab=rm&ogbl")).sendKeys(selectLinkOpeninNewTab);
		
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		System.out.println(tabs);
	    driver.switchTo().window(tabs.get(2)); //switches to new tab
	    //driver.get("https://www.facebook.com");
		
		driver.get("https://www.youtube.com");
		String h =driver.getWindowHandle();
		System.out.println(h);


	}

}
