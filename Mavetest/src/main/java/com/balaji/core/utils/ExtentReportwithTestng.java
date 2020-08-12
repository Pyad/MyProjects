package com.balaji.core.utils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportwithTestng {
	ExtentHtmlReporter htmlreport;
	static ExtentReports extent;
	public static WebDriver driver;
	
	
	@BeforeSuite
	public void setup() {
//		htmlReporter = new ExtentHtmlReporter("extent.html");
		
		  htmlreport	 = new ExtentHtmlReporter("extent.html");
		  extent = new ExtentReports();
		 extent.attachReporter(htmlreport);
	WebDriverManager.chromedriver().setup();
			
			
			driver = new ChromeDriver();

			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

			driver.manage().window().maximize();

			driver.manage().deleteAllCookies();
			
		 
		
	}
	@Test
	public void test() throws Exception{
		
		ExtentTest test = extent.createTest("MyFirsttest", "Sample");
		test.log(Status.INFO, "Shows usage of logs");
		test.info("usuage of info");
//		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(path))
		
		
		
	}
	
	@Test
	public static void pageLaunch() {
		
//		Log.info("PageLaunch");
		ExtentTest test1 = extent.createTest("Seleniumtest", "Sample");
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
	
	@AfterSuite
	public void teardown() {
		driver.quit();
		extent.flush();
		
		
	}
	
	
	
	
	

}
