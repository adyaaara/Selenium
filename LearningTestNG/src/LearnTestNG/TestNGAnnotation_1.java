package LearnTestNG;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotation_1 {
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Starting TestNG");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("Stopping TestNG");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Start Test Execution");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Initialize Selenium for class 1");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Opening Browser");
	}
	
	@Test
	public void test1()
	{
		System.out.println("Test 1");
	}
	
	@Test
	public void test2()
	{
		System.out.println("Test 2");
		//throw new SkipException("Test 2 functionality is not supported");
		//Assert.assertEquals("Yogesh", "Nagarajan");
		//Assert.assertEquals(2, 2);
		try
		{
		Assert.assertTrue(4<1);
		}
		//Assert.assertFalse(4<1);
		catch(Throwable t)
		{
			System.out.println(t);
		}
		System.out.println("After Assert Condition");
		
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Closing Browser");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("Kill Selenium for class 1");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("End Test Execution");
	}

}
