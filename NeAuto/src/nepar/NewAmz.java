package nepar;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.collections4.FactoryUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class NewAmz {


		
		

		



			public static void main(String[] args) throws Exception{
					
				String UN = System.getProperty("user.name");
				System.out.println(UN);
						// TODO Auto-generated method stub
						System.setProperty("webdriver.chrome.driver", "D:\\json jars\\chrome driver\\chromedriver_win32\\chromedriver.exe");
						WebDriver driver = new ChromeDriver();
						driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
						driver.manage().window().maximize();
//						new com.sun.security.auth.module.NTSystem().getName();
						
						
						driver.get("https://www.amazon.in");
						driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
						
						// iframe
//						List<WebElement> framelist = driver.findElements(By.tagName("iframe"));
//						int n = framelist.size();
//						System.out.println("n " +n);
						
						//findelements
//						
//						List<WebElement> ele = driver.findElements(By.tagName("l"));
//						int e = ele.size();
//						System.out.println("e " +e);
//						for(WebElement k : ele) {
//							System.out.println("links " + k);
//						}
						//dropdown
//						WebElement ele = driver.findElement(By.id("searchDropdownBox"));
//						Select dd = new Select(ele);
//						List<WebElement> n = dd.getOptions();
//						int e = n.size();
//						System.out.print(e);
//						for(int i=0; i<e; i++) {
//							String sValue = n.get(i).getText();
//							 System.out.println(sValue);
//						}
						JavascriptExecutor js = (JavascriptExecutor) driver; 
						js.executeScript("window.scrollBy(0,2000)");
						
						//Action class
						WebElement ele = driver.findElement(By.id("nav-link-accountList"));
						Actions act = new Actions(driver);
						act.moveToElement(ele).perform();
						
//						WebElement cl= driver.findElement(By.xpath("//div[@id= 'nav-al-your-account']/a[2]"));
//						act.click().build().perform();
//						WebElement un = driver.findElement(By.xpath("//input[@id=\"ap_email\"]"));
//						JavascriptExecutor js = (JavascriptExecutor) driver;  
		//
//		                 js.executeScript("document.getElementById('ap_email').value='balaji@gmail.com';");
						
						
						
						//takescreenshot
//						TakesScreenshot scrShot =((TakesScreenshot)driver);
//
//				        //Call getScreenshotAs method to create image file
//
//				                File src =scrShot.getScreenshotAs(OutputType.FILE);
//
//				            //Move image file to new destination
//
//				              File DestFile=new File("D:\\test.png");
//
//				                //Copy file at destination
//
//				               
//				                	FileUtils.copyFile(src, DestFile);
				                	

				                	

				                	
						
						
						
						

			}

		


}



