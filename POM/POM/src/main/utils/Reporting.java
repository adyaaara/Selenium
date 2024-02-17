package utils;

import java.util.Properties;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporting {
	
	public static ExtentReports reports;
	public ExtentTest test;
	
	public String testcasename;
	public static Properties prop;
	public String testdescription;
	
	public void startReport()
	{
		
		reports = new ExtentReports("./Reports/POM_Results.html", false);
	}
	
	public void startTest(String TestcaseName, String TestcaseDescription)
	{
		test = reports.startTest(TestcaseName, TestcaseDescription);
	}
	
	public abstract long takeSnap();

	
	public void reportStep(String status, String details)
	{
		long snapnumber =takeSnap();
		if(status.equalsIgnoreCase("pass")) {
		test.log(LogStatus.PASS, details+test.addScreenCapture(".././Reports/Screenshot/"+snapnumber+".png"));
		}else if(status.equalsIgnoreCase("fail")) {
			test.log(LogStatus.FAIL, details+test.addScreenCapture(".././Reports/Screenshot/"+snapnumber+".png"));
		}
	}
	
	public void reportStep(String status, String details, boolean snap)
	{
		//long snapnumber =takeSnap();
		if(!snap) {
		if(status.equalsIgnoreCase("pass")) {
		test.log(LogStatus.PASS, details);
		}else if(status.equalsIgnoreCase("fail")) {
			test.log(LogStatus.FAIL, details);
		}
		}
	}

	public void endTest()
	{
		reports.endTest(test);
	}
	
	public void endReport()
	{
		reports.flush();
	}

}
