package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC001_LoginLogOut extends ProjectMethods{
	
	@BeforeTest
	public void setValues() {
		browserName = "chrome";
		dataSheetName = "TC001";
		testCaseName = "CreateLead";
		testDescription = "Create a New Lead";
		testNodes = "Leads";
		authors = "Babu";
		category = "smoke";		
	}
	
	@Test(dataProvider = "fetchData")
	public void createLeaf(String uName, String pwd) {
		new LoginPage()
		.typeUserName(uName)
		.typePassword(pwd)
		.clickLogIn()
		.clickLogout();		
	}
	

}





