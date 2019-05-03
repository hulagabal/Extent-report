package extentReportForMultipleTestsInAClass;

import org.testng.Assert;
import org.testng.annotations.Test;



public class ClassB extends BaseTest {

	@Test
	public void classB() {
		test=extent.createTest("class B");
		Assert.assertTrue(false);
	}
}
