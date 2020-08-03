package nepar;
import java.io.File;
import java.util.Iterator;
import java.util.logging.Level;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // simple page (without many resources so that the output is
        // easy to understand
        String url = "http://www.york.ac.uk/teaching/cws/wws/webpage1.html";

        DownloadPage(url);
    }

    @SuppressWarnings("deprecation")
	private static void DownloadPage(String url)
    {
        WebDriver driver = null;

        try
        {
            ChromeOptions options = new ChromeOptions();
            options.addExtensions(new File("/path/to/extension.crx"));
           
            ChromeDriver driver1 = new ChromeDriver(options);
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
            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
            cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

            driver1 = new ChromeDriver(cap);

            // navigate to the page
            System.out.println("Navigate to " + url);
            driver1.navigate().to(url);

            // and capture the last recorded url (it may be a redirect, or the
            // original url)
            String currentURL = driver1.getCurrentUrl();

            // then ask for all the performance logs from this request
            // one of them will contain the Network.responseReceived method
            // and we shall find the "last recorded url" response
            LogEntries logs = driver1.manage().logs().get("performance");

            int status = -1;

            System.out.println("\nList of log entries:\n");

            for (Iterator<LogEntry> it = logs.iterator(); it.hasNext();)
            {
                LogEntry entry = it.next();

                try
                {
                    JSONObject json = new JSONObject(entry.getMessage());

                    System.out.println(json.toString());

                    JSONObject message = json.getJSONObject("message");
                    String method = message.getString("method");

                    if (method != null
                            && "Network.responseReceived".equals(method))
                    {
                        JSONObject params = message.getJSONObject("params");

                        JSONObject response = params.getJSONObject("response");
                        String messageUrl = response.getString("url");

                        if (currentURL.equals(messageUrl))
                        {
                            status = response.getInt("status");

                            System.out.println(
                                    "---------- bingo !!!!!!!!!!!!!! returned response for "
                                            + messageUrl + ": " + status);

                            System.out.println(
                                    "---------- bingo !!!!!!!!!!!!!! headers: "
                                            + response.get("headers"));
                        }
                    }
                } catch (JSONException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            System.out.println("\nstatus code: " + status);
        } finally
        {
            if (driver != null)
            {
                driver.quit();
            }
        }
    }
}




