package extentReportForMultipleTestsInAClass;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassB extends BaseTest {

	@Test
	public void classB1() {
		test=extent.createTest("class B");
		Assert.assertTrue(true);
	}

	@Test
	public void classB2() {
		test=extent.createTest("class B");
		Assert.assertTrue(false);
	}
}
