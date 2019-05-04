package extentReportForMultipleTestsInAClass;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ClassA extends BaseTest {

	@Test
	public void classB1() {
		test = extent.createTest("class A1");
		Assert.assertTrue(true);
	}

	@Test
	public void classB2() {
		test = extent.createTest("class A2");
		Assert.assertTrue(false);
	}

	@Test
	public void classB3() {
		test = extent.createTest("class A3");
		throw new SkipException("Skipped");
	}
}
