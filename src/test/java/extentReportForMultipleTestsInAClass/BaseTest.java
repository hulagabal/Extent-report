package extentReportForMultipleTestsInAClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest implements ITestListener {

	public WebDriver driver;

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	public void setUp() {
		getReport();

		/// http://www.booking.hptdc.in/
	}

	@BeforeMethod
	public void launchBrowser() {
		getDriver();
	}

	@AfterMethod
	public void closeDriver(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail("sanpshot below: " + test.addScreenCaptureFromPath(takeScreenShot(driver)));
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

	public String takeScreenShot(WebDriver driver) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		String date = dateFormat.format(new Date());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test
		// method name
		String destination = "C:/Users/Mutturaj/workspace/ExtentReports/" + date + ".png";
		try {
			FileUtils.copyFile(scrFile, new File(destination));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
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

	public static void getReport() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/MyReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Host Name", "Test");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("QA Name", "Mutturaj Hulagabal");

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent report");
		htmlReporter.config().setReportName("Final Report");

	}

	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}
}