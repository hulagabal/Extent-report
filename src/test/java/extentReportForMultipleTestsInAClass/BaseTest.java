package extentReportForMultipleTestsInAClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class BaseTest implements ITestListener {

	

	
	public static ExtentReports extent;
	public static ExtentTest test;
	protected WebDriver driver;

	@BeforeTest
	public void setUp() {
		extent=Library.getReport();

		
	}

	@BeforeMethod
	public void launchBrowser() {
		driver=Library.getDriver();
	}

	@AfterMethod
	public void closeDriver(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail("sanpshot below: " + test.addScreenCaptureFromPath(Library.takeScreenShot(driver)));
		}

		driver.quit();
	}

	@AfterTest
	public void tearDown() {
		extent.flush();

	}

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,
				MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
		test.fail(result.getThrowable());
	}

	

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
		test.skip(result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

	

	
}