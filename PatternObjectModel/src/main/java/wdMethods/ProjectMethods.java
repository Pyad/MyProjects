package wdMethods;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.DataInputProvider;

public class ProjectMethods extends SeMethods{

	public String browserName;
	public String dataSheetName;

	@BeforeSuite
	public void beforeSuite(){
		startResult();
	}

	@BeforeClass
	public void beforeClass(){		
		startTestModule(testCaseName, testDescription);	
	}



	@BeforeMethod
	public void beforeMethod(){
		test = startTestCase(testNodes);
		test.assignCategory(category);
		test.assignAuthor(authors);
		startApp(browserName,false);		
	}

	@AfterSuite
	public void afterSuite(){
		endResult();
	}

	@AfterTest
	public void afterTest(){
	}

	@AfterMethod
	public void afterMethod(){
		closeAllBrowsers();

	}

	@DataProvider(name="fetchData")
	public  Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);		
	}	

}
