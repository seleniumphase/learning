package Tetsnglearn.loadcomponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport {
	
	public static ExtentReports reportobject()
	{
		String path =System.getProperty("user.dir")+"/Report/Report.html";
		ExtentSparkReporter Reporter = new ExtentSparkReporter(path);
		Reporter.config().setReportName("Test Results");
		Reporter.config().setDocumentTitle("Flipkart Result");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(Reporter);
		report.setSystemInfo("Tester", "Hetal");
		return report;
		
		
	}

}
