package nepar;
import java.util.Iterator;
import java.util.logging.Level;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
public class NeHar1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	
		        // simple page (without many resources so that the output is
		        // easy to understand
		        String url = "https://www.usbank.com/index.html";
		        downloadPage(url);
		    }

		    private static void downloadPage(String url) {
		        System.setProperty("webdriver.chrome.driver", "D:\\\\\\\\json jars\\\\\\\\chrome driver\\\\\\\\chromedriver_win32\\\\\\\\chromedriver.exe");
		        ChromeDriver driver = null;
		        try {
		            ChromeOptions options = new ChromeOptions();
		            // add whatever extensions you need
		            // for example I needed one of adding proxy, and one for blocking
		            // images
		            // options.addExtensions(new File(file, "proxy.zip"));
		            // options.addExtensions(new File("extensions",
		            // "Block-image_v1.1.crx"));
		            DesiredCapabilities cap = DesiredCapabilities.chrome();
		            cap.setCapability(ChromeOptions.CAPABILITY, options);
		            // set performance logger
		            // this sends Network.enable to chromedriver
		            /*
		             * LoggingPreferences logPrefs = new LoggingPreferences();
		             * logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		             * cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		             */

		            LoggingPreferences logPrefs = new LoggingPreferences();
		            logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		            options.setCapability("goog:loggingPrefs", logPrefs);
		            driver = new ChromeDriver(options);
		            // navigate to the page
		            System.out.println("Navigate to " + url);
		            driver.navigate().to(url);
		            // and capture the last recorded url (it may be a redirect, or the
		            // original url)
		            String currentURL = driver.getCurrentUrl();
		            LogEntries logs = driver.manage().logs().get("performance");
		            int status = -1;
		            System.out.println("\\nList of log entries:\\n");
		            for (Iterator<LogEntry> it = logs.iterator(); it.hasNext();) {
		                LogEntry entry = it.next();
		                try {
		                    JSONObject json = new JSONObject(entry.getMessage());
		                    System.out.println(json.toString());
		                    JSONObject message = json.getJSONObject("message");
		                    String method = message.getString("method");
		                    if (method != null && "Network.responseReceived".equals(method)) {
		                        JSONObject params = message.getJSONObject("params");
		                        JSONObject response = params.getJSONObject("response");
		                        String messageUrl = response.getString("url");
		                        if (currentURL.equals(messageUrl)) {
		                            status = response.getInt("status");
		                            System.out.println("---------- bingo !!!!!!!!!!!!!! returned response for " + messageUrl
		                                    + ": " + status);
		                            System.out.println("---------- bingo !!!!!!!!!!!!!! headers: " + response.get("headers"));
		                        }
		                    }
		                } catch (JSONException e) {
		                    // TODO Auto-generated catch block
		                    e.printStackTrace();
		                }
		            }
		            System.out.println("\nstatus code: " + status);
		        } finally {
		            if (driver != null) {
		                driver.quit();
		            }
		        }
		    }
		

	}


