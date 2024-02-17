package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class FacebookHomePage extends GenericWrappers {
	
	
	public FacebookHomePage(RemoteWebDriver driver, ExtentTest test) {
		
		this.driver = driver;
		this.test= test;
	}
	
	public FacebookSignUpPage clickOnCreateNewAccount() {
		
		//clickByXpath("//*[text()='Create a new account']");
		clickByXpath(prop.getProperty("FaceBookHomePage.createNewAccount.XPath"));
		return new FacebookSignUpPage(driver, test);
		
	}

}
