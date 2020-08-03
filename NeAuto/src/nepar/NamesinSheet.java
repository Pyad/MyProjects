package nepar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NamesinSheet {
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\json jars\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		 
		 geturl();
		 
		 String amazti =gettext();
		 System.out.println(amazti);
		 Teardown();
		switch (amazti) {
		case "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in":
			System.out.println("printed deiver title");
			break;
		case "no print":
			System.out.println("no print from driver");
		    break;
		}
		

	}
	private static String gettext() {
		// TODO Auto-generated method stub
		String Title = driver.getTitle();
		return Title;
	}
	private static void geturl() {
		// TODO Auto-generated method stub
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	private static void Teardown() {
		// TODO Auto-generated method stub
		driver.quit();
	}

}
