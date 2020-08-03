package nepar;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Phhar {

	
		    public static void main(String[] args) throws IOException, InterruptedException {

		        //BrowserMobProxy
		        BrowserMobProxy server = new BrowserMobProxyServer();
		        server.start(0);
		        server.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
		        server.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
		        server.newHar("Google");

		        //PHANTOMJS_CLI_ARGS
		        ArrayList<String> cliArgsCap = new ArrayList<>();
		        cliArgsCap.add("--proxy=localhost:"+server.getPort());
		        cliArgsCap.add("--ignore-ssl-errors=yes");

		        //DesiredCapabilities
		        DesiredCapabilities capabilities = new DesiredCapabilities();
		        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		        capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
		        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"D:\\json jars\\pahjs\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");

		        //WebDriver
		        WebDriver driver = new PhantomJSDriver(capabilities);
		        driver.get("https://www.usbank.com/index.html");
		        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		        
		       WebElement mg = driver.findElement(ByXPath("//a[@title='Wealth Management']"));
		       mg.click();
		        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		        JavascriptExecutor js = (JavascriptExecutor) driver; 
//				js.executeScript("window.scrollBy(0,2000)");
				

		        //HAR
		        Har har = server.getHar();
//		        int i=2;
		        for(int i=2;i<4;i++) {
		        FileOutputStream fos = new FileOutputStream("D:\\HAR\\HAR-Information"+i+".har");
		        System.out.println("Loop in");
		        har.writeTo(fos);
		        
		        }
		        System.out.println("Loop out");
		        server.stop();
		        driver.close();
		    }

			private static By ByXPath(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		


	}


