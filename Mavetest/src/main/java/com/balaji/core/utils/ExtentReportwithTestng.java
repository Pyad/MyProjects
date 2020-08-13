package com.balaji.core.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportwithTestng {
	ExtentHtmlReporter htmlreport;
	static ExtentReports extent;
	public static WebDriver driver;
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	static ExtentTest test;
	
	
	@BeforeSuite(description="Testcases is started")
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
	@Test(description="Testcases is started")
	public void test() throws Exception{
		
	 test = extent.createTest("MyFirsttest", "Sample");
//		test.log(Status.INFO, "Shows usage of logs");
		test.info("usuage of info");
		Status s = test.getStatus();
		System.out.println(s);
		test.log(Status.INFO, "status of test.log");
		
		
//		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(path))
		
		
		
	}
	
	@Test
	public static void pageLaunch() throws IOException {
		
//		Log.info("PageLaunch");
		 test = extent.createTest("Seleniumtest", "Sample").pass("PageLaunch is passed");
		
		
		driver.get("https://www.google.com");
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		System.out.println(tabs);
	    driver.switchTo().window(tabs.get(2)); //switches to new tab
	    //driver.get("https://www.facebook.com");
		
		driver.get("https://www.youtube.com");
//		String h =driver.getWindowHandle();
//		System.out.println(h);
		test.addScreenCaptureFromPath(getScreenshot());
		
		
		
		
	}
	
	@Test
	public static void pageLaunch1() throws IOException {
		
		test = extent.createTest("Seleniumtest", "Facebook").pass("PageLaunch for facebook is passed");
		driver.get("https://www.facebook.com");
		test.addScreenCaptureFromPath(getScreenshot());
		test.log(Status.PASS, "PageLaunch for facebook is passed");
		test.log(test.getStatus(), "PageLaunch1status");
		com.aventstack.extentreports.model.Test t = test.getModel();
		
		System.out.println("t output "+t.toString());
	}
	
	
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
		extent.flush();
		
		
	}
	
	
	@AfterSuite
	public void Repor() {
		String url = "https://extentreports.com";
		String name = "exte";
		
		
		
	}
	
	
	public static  String getScreenshot() throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
		File des = new File(path);
		try {
			
			FileUtils.copyFile(src, des);
			
		}
		catch(IOException e) {
			Log.error(e.getMessage());
		}
		
		return path;
		
		
	}
	
	
	
	
	
	
	
	
	

}
