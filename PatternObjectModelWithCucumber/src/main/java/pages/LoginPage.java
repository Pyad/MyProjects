package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import wdMethods.ProjectMethods;

public class LoginPage extends ProjectMethods{
	
	public LoginPage() {		
		PageFactory.initElements(driver,this);
	}
	 
	@FindBy(how=How.ID,using="username")
	private WebElement eleUserName;	
	@And("Enter the UserName as (.*)")
	public LoginPage typeUserName(String data) {
	//	WebElement eleUserName = locateElement("DemoSalesManager");
		type(eleUserName, data);
		return this;
	}
	
	
	@FindBy(how=How.ID,using="password")
	private WebElement elePassword;	
	@And("Enter the Password as (.*)")
	public LoginPage typePassword(String data) {
		//WebElement elePassword = locateElement("password");
		type(elePassword, data);
		return this;
	}
	
	
	@FindBy(how=How.CLASS_NAME,using="decorativeSubmit")
	private WebElement eleLogin;
	@When("Click on Login button")
	public HomePage clickLogIn() {
		//WebElement eleLogin = locateElement("class","decorativeSubmit");
		click(eleLogin);
		/*HomePage hp = new HomePage();
		return hp;*/
		return new HomePage();
		
	}
	@When("Click Login button for Failure")
	public LoginPage clickLogInForFailer() {
		click(eleLogin);
		return this;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
