package utils;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SampleReport {
	
	@Test
	public void generateReport() {
		
		
	ExtentReports	report = new ExtentReports("./Reports/result.html" ,false);
ExtentTest test = report.startTest("TC001", "Verify IRCTC Registration Page");
test.log(LogStatus.PASS, "1st step got passed");
test.log(LogStatus.PASS, "2st step got passed");

test.log(LogStatus.PASS, "3st step got passed");

test.log(LogStatus.PASS, "4st step got passed");

test.log(LogStatus.PASS, "5st step got passed");
test.log(LogStatus.PASS, "6st step got passed");
report.endTest(test);
report.flush();

		
		
		
		
		
	}

}

