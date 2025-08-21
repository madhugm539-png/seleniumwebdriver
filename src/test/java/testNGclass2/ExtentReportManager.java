package testNGclass2;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext context)
	{
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);//this line will combine all three classes
		
		extent.setSystemInfo("Computer Name", "Localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Rester Name", "Madhu");
		extent.setSystemInfo("os", "Windows10");
		extent.setSystemInfo("Browser name", "chrome");
		
		
	}
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());// create a new entry in the report
		test.log(Status.PASS, "Test case passed is:"+result.getName());//update status p/f/s
		
		  }
	public void onTestFailure(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.log(Status.FAIL,"Test case FAILED is:"+result.getName());
		test.log(Status.FAIL,"test case FAILD cause is:+"+result.getThrowable());
		
		  }
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP,"Test case SKIPPPED is:"+result.getName());
		  }
	public void onFinish(ITestContext context) {
	extent.flush();
		  }
	
	}

