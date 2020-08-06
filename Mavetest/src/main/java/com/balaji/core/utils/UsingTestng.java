package com.balaji.core.utils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingTestng {

	public static WebDriver driver;
		// TODO Auto-generated method stub
		@BeforeTest
		public static void browserLaunch() {
			
		
			WebDriverManager.chromedriver().setup();
			
			
			driver = new ChromeDriver();

			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

			driver.manage().window().maximize();

			driver.manage().deleteAllCookies();
			
		}
		
		@Test(priority=2)
		public static void pageLaunch() {
			
			driver.get("https://www.google.com");
			((JavascriptExecutor) driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			System.out.println(tabs);
		    driver.switchTo().window(tabs.get(2)); //switches to new tab
		    //driver.get("https://www.facebook.com");
			
			driver.get("https://www.youtube.com");
			String h =driver.getWindowHandle();
			System.out.println(h);
			
		}
		
		
		@Test(priority=3, enabled=false)
		@Parameters({ "optional-value" })
		public static void pageLaunch1(@Optional("optional value") String value) {
			
			driver.get(value);
			
			
		}
		
		@Test(priority=4)
		@Parameters({"web"})
		public static void pageLaunch5(String value) {
			
			driver.get(value);
			
			
		}
		
		
		
		@Test(dependsOnMethods="pageLaunch1", groups = "q", enabled=false)
		public static void pageLaunch3() {
			
			
			System.out.println(driver.getTitle());
			
		}
		
		@Test(priority=1, groups = "q")
		public static void pageLaunch2() {
			
			driver.get("https://v1.hdfcbank.com/assets/popuppages/netbanking.htm");
			System.out.println(driver.getTitle());
			WebElement ele = driver.findElement(By.xpath("(//a[@class='btn btn-default redBtn'])[2]"));
			String s = ele.getAttribute("value");
			System.out.println(s);
			
		}
		
		
		
		@AfterTest
		public static void quit() {
			
			driver.quit();
		}
		
		
		
}

