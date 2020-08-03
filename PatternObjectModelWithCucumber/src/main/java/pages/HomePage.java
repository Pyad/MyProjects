package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Then;
import wdMethods.ProjectMethods;

public class HomePage extends ProjectMethods{

	public HomePage() {		
		PageFactory.initElements(driver, this);
	}		

	@FindBy(how = How.CLASS_NAME, using="decorativeSubmit")
	WebElement logout;	
	public LoginPage clickLogout() {		
		click(logout);
		return new LoginPage(); 
	}	
	
	@Then("Login should be successful")
	public LoginPage clickLogout1() {		
		System.out.println("Login Successfully");
		return new LoginPage(); 
	}	

}










