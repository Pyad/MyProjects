package nepar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Harr {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\\\json jars\\\\chrome driver\\\\chromedriver_win32\\\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		String harLog = null;
		if(driver instanceof JavascriptExecutor) {
		((JavascriptExecutor) driver).executeScript(
		" console.log(\"here\"; var options = { token: \"test\", getData: true, jsonp: false}; console.log(\"here3\"); " +
		"HAR.triggerExport(options).then(result => { console.log(result.data); sessionStorage.har = result.data; });");
		}

		for(int i = 0; i < 20 && harLog == null; i++) {
		  if (driver instanceof JavascriptExecutor) {
		    harLog = (String) ((JavascriptExecutor) driver).executeScript(
		            "return sessionStorage.har;");
		  }
		  
		  chrome.devtools.network.onRequestFinished.addListener(
		          function(request) {
		            if (request.response.bodySize > 40*1024) {
		              chrome.devtools.inspectedWindow.eval(
		                  \'console.log(\"Large image: \" + unescape(\"' +
		                  escape(request.request.url) + '"))');
		            }
		      });
		  
		  Thread.sleep(1000);
		}

	}

}
