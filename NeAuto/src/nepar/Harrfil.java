package nepar;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.ProxyServer;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import edu.umass.cs.benchlab.har.HarEntries;
import edu.umass.cs.benchlab.har.HarLog;
import edu.umass.cs.benchlab.har.HarWarning;
import edu.umass.cs.benchlab.har.tools.HarFileReader;

public class Harrfil {
		// TODO Auto-generated method stub
		
 public static HarEntries entries;
 public static HarLog log;
 public static List<HarWarning> warnings = new ArrayList<HarWarning>();
 public static HarFileReader r = new HarFileReader();
 public static String harPath = "D:\\HAR\\automationmob.har";
 public static File f = new File(harPath);
 public static ProxyServer server = new ProxyServer(4448);
 public static Har har;
public static void main(String[] args) throws Exception { 
try{ 
// start the proxy
server.start();
//captures the moouse movements and navigations
server.setCaptureHeaders(true);
server.setCaptureContent(true);
// get the Selenium proxy objects
Proxy proxy = server.seleniumProxy();
// configure it as a desired capability
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability(CapabilityType.PROXY, proxy);
// start the browser up
//WebDriver driver = new FirefoxDriver(capabilities);
System.setProperty("webdriver.chrome.driver","C:\\V2AutoW\\chromedriver\\chromedriver.exe");
ChromeDriver driver=new ChromeDriver(capabilities);
driver.get("GIVE your URL");
driver.manage().window().maximize();
Thread.sleep(5000);
server.newHar();
Thread.sleep(5000);
// get the HAR data
har = server.getHar();
//To write the file on your specified path location
FileOutputStream fos = new FileOutputStream(harPath);
har.writeTo(fos);
//it wiil end the har reading.
server.endHar();
//String[] temp;
//temp = Expdata.split(",");

/*for(int i = 0; i<temp.length;i++){
   
   System.out.println(": Verifing : "+temp[i]+" is Present in HAR file");
   
   if(Convertedstring.contains(temp[i].toString()))
   {
   Thread.sleep(2000);
 System.out.println(": Success : "+temp[i]+" is Present in HAR file");
 
   }else{
   System.out.println("Fail : "+temp[i]+" is Not Present in HAR file");
   }*/
  // }

String Actdata="Evergage Campaign Impression";

log = r.readHarFile(f, warnings);
entries = log.getEntries();
//It will convert all data to the string.(if it is not in string then also convert to the string).
String Convertedstring=entries.toString();
System.out.println(Convertedstring);
if(Actdata.contains(Convertedstring))
{
 System.out.println("Pass");
}else{
 System.out.println("Fail");
}
// it will stop the server.
//server.stop();
driver.quit();
}
catch (Exception e) {
 System.out.println("Exception Occurred: "+e.getMessage());
}

}
}

	}

}
