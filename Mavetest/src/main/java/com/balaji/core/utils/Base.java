package com.balaji.core.utils;

import java.awt.Robot;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Base {
	
	public static WebDriver browserLaunch() {
		
		try {
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			System.setProperty("Webdriver.chrome.driver", "C:\\Users");
			ChromeOptions caps = new ChromeOptions();
			LoggingPreferences logprefs = new LoggingPreferences();
			logprefs.enable(LogType.PERFORMANCE, Level.ALL);
			caps.setCapability("goog:loggingPrefs", logprefs);
			
			WebDriver driver = new ChromeDriver(caps);
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			return driver;
			
			
		}
		
		catch(Exception e) {
			return null;
		}
		
	}
	
	public static void Rewrite (WebElement at, String Edata) throws InterruptedException{
		while(!(at.getAttribute("Value").trim().equals((Edata.trim())))){
			Thread.sleep(2000);	
				at.clear();
				at.sendKeys(Edata);
		}
		
	}
		
		public static void Rewrite (By Ele, String Edata, WebDriver driver) throws InterruptedException{
			
			WebElement at = Base.exist1(driver, Ele);
			while(!(at.getAttribute("Value").trim().equals((Edata.trim())))){
				Thread.sleep(2000);	
					at.clear();
					at.sendKeys(Edata);
			}
			
		}	
		
		public static WebElement exist1(WebDriver driver, By Locator) {
				// TODO Auto-generated method stub
				try {
					
					return driver.findElement(Locator);
				}
				catch(Exception e) {
					return null;
				}
				
			}
			
		public static void ExistClickSelect(By byele, WebDriver driver, String cs, By Byele2) {
			
			try {
				WebElement webele = Base.exist1(driver, byele);
				webele.click();
				Base.dropdown1(driver, cs, Byele2);
			}
			catch(Exception e) {
				Assert.fail(e.getMessage());
			}
		}
		
		public static void dropdown1(WebDriver driver, String selval, By Locator)throws InterruptedException{
			
			String e = selval;
			List<WebElement> options = driver.findElements(Locator);
			
			for(WebElement opt : options) {
				if(opt.getText().equalsIgnoreCase(e)) {
					Thread.sleep(1500);
					opt.click();
				}
			}
			
		}
		
		public static void dropdown(WebDriver driver, By hDLocator1, String month) {
			try {
				Select dropdown1 = new Select(driver.findElement(hDLocator1));
				dropdown1.selectByVisibleText(month);
			}
			catch(Exception e) {
				return;
			}
		}
	
		public static void SelectHandle(Set<String> wHandles, WebDriver driver) {
			String pHandle1 = driver.getWindowHandle();
			for(String E: wHandles) {
				if(pHandle1 != E) {
					driver.switchTo().window(E);
					
				}
			}
			
			
		}
		
		public static void EWait(WebDriver driver2, int i, String string) {
			new WebDriverWait(driver2, i).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(string)));
		}
	
		public static void ExplicitWait(WebDriver driver2, int i, By st) {
			new WebDriverWait(driver2, i).until(ExpectedConditions.visibilityOfElementLocated(st));
		}
		
		public static void sendkey(Actions act, WebDriver driver, WebElement lp, String unact) {
			try {
				act.moveToElement(lp).sendKeys(unact).perform();
			}
			catch(Exception e) {
				return;
			}
			
		}
		
		public static void title(WebDriver driver) {
			String URL= driver.getCurrentUrl();
			
			
		}
		
		public static void Iwait(WebDriver driver, long sec) {
			try {
				driver.manage().timeouts().implicitlyWait(sec, TimeUnit.MILLISECONDS);
			}
			catch(Exception e) {
				return;
			}
			
		}
		
		public static void Aclick(Actions act, WebElement elem) {
			try {
				act.moveToElement(elem).click().perform();
			}
			catch(Exception e) {
				return;
			}
		}
		
		public static void ExistClick(By byele, WebDriver driver) {
			try {
				WebElement webele = Base.exist1(driver, byele);
				webele.click();
			}
			catch(Exception e) {
				Assert.fail(e.getMessage());
			}
		}
		public static void SendKeys(By byele, String data, WebDriver driver) {
			try {
				WebElement webele = Base.exist1(driver, byele);
				webele.sendKeys(data);
			}catch(Exception e) {
				Assert.fail(e.getMessage());
			}
		}
		
		public static void PSendKeys(By byele, String data, WebDriver driver) {
			try {
				WebElement webele = Base.exist1(driver, byele);
				webele.click();
				webele.sendKeys(data);
			}
			catch(Exception e) {
				Assert.fail(e.getMessage());
			}
		}
		
		public static void SDropdown(By byele, String data, WebDriver driver) {
			try {
				WebElement webele = Base.exist1(driver, byele);
				Select sel = new Select(webele);
				sel.selectByVisibleText(data);
				
			}
			catch(Exception e) {
				Assert.fail(e.getMessage());
			}
		}
		
		
		
		public static WebElement exist2(WebDriver driver, By Locator) {
			try {
				return driver.findElement(Locator);
				
			}catch(Exception e ) {
				return null;
			}
		}
		
		
//		Robot rob = new Robot();
//		rob.keyPress(KeyEvent.VK_F11);
//		rob.keyRelease(KeyEvent.VK_F11);
//		
//		// do some actions here.
//		
//		
//		rob.keyPress(KeyEvent.VK_F11);
//		rob.keyRelease(KeyEvent.VK_F11);
//		
		
		
//		Map<String, String> data = ExcelInput.readData();
//		driver = Base.browserLaunch();
		
//		By questionLocator = Auth.logicbx;
//		WebElement ques = Base.exist1(driver, questionLocator);
//		String tex = ques.getText();
//		String[] items = tex.split(" ");
//		List<String> itemList = Arrays.asList(items);
//		String Lastword = itemList.get(itemList.size()- 1);
//		String NLastword = Lastword.replace("?", "");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}

		
