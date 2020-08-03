package nepar;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrConnection {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		URL url = new URL("https://www.usbank.com/index.html");
//		URLConnection connection = url.openConnection();
//		
//		connection.set
		
		  ChromeOptions options = new ChromeOptions().addArguments(
                  '--headless',
                  '--no-sandbox',
                  '--disable-extensions')
          LoggingPreferences logPrefs = new LoggingPreferences()
          logPrefs.enable(LogType.BROWSER, Level.ALL)
          options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs)
          driver = new ChromeDriver(options)
          driver.get(Endpoints.TAGGED_PAGE_URL)
          LogEntries logs = driver.manage().logs().get(LogType.BROWSER)
          for (LogEntry entry : logs) {
              log.info entry.message
         }
		
		
		
//		HTTPURLConnectionn connection =(HttpURLConnection)url.openConnection();
//		connection.

	}

}
