package nepar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flinks {

	private static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
		links();
		
	}
	public static void launch() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\json jars\\Chrome81\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://www.cognizant.com/");

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		

	}
		// boolean = false;
//		boolean r = driver.findElement(By.xpath("//div[@data-cs-override-id= 'IOT']")).isDisplayed();
//		if ( r == true) {
      @SuppressWarnings("null")
	public static void links() {      
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			List<WebElement> links = driver.findElements(By.tagName("a"));
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			System.out.println(links.size());
			List<String> list = new LinkedList<String>();
			
			for(WebElement tex: links) {
				
				list.add(tex.getText());
				System.out.println(tex.getText());
				
				
			}
			
			list.removeIf(item -> item == null || "".equals(item));
			
			for(int i=0; i<list.size();i++) {
				
				String lin = list.get(i);
				System.out.println("link " +lin);
				 driver.findElement(By.linkText(lin)).click();
				 driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				 System.out.println(driver.getTitle());
				
				
				
				//System.out.println(links.get(i).getText());
				//launch(links.get(i).getText());
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.navigate().back();
				driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
			
				
				
			}
      }


	}


