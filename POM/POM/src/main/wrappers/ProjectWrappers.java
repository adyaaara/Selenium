package wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.DataInputProvider;

public class ProjectWrappers extends GenericWrappers {

	
	public String dataSheetName;
	
	@BeforeSuite( groups = "smoke")
	public void beforeSuite() {
		
		startReport();
	}
	
	@BeforeMethod( groups = "smoke")
	public void beforeMethod() {
		
		startTest(testcasename, testdescription);
		invokeApp(browsertoluanch, application);
	}
	
	@AfterMethod( groups = "smoke")
	public void afterMethod() {
		//closeAllBrowsers();
	}
	
	@AfterClass( groups = "smoke")
	public void afterClass() {
		endTest();
	}
	
	@AfterSuite( groups = "smoke")
	public void afterSuite() {
		
		endReport();
	}
	
	@BeforeTest( groups = "smoke")
	public void beforeTest()
	{
		loadObject();
	}
	
	@AfterTest( groups = "smoke")
	public void afterTest()
	{
		unloadObject();
	}
	
	
	@DataProvider(name="fetchData")
	public String[][] getTestData() {
		
		return DataInputProvider.getData(dataSheetName);
	}
}



