package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SandStarHomePage;
import wrappers.ProjectWrappers;

public class TC001 extends ProjectWrappers{
	
	@BeforeClass
	public void beforeClass() {
		
		testcasename="TC001";
		testdescription="Verify whether SandStar Launch is successfull";
		browsertoluanch="chrome";
		application="https://qa.sandstar.us/";
		//dataSheetName="TC001";
	}
	
	@Test
	public void SandStarHomePage()
	{
	
	new SandStarHomePage(driver,test);
		
	// FacebookHomePage(driver,test)
	//	.clickOnCreateNewAccount()
	//	.facebookSignupWait(8000)
	//	.enterFirstName("YOGESH")
	//	.enterLastName("TEST")
	//	.enterEmail("nyogesh.qa@gmail.com")
	//	.enterPassword("Test@123")
	//	.selectDay("10")
	//	.facebookSignupWait(5000)
	//	.selectMonth("Jul")
	//	.selectYear("1990")
	//	.clickGender()
	//	.clickSignup();
	
	}

}
