package extentReportForMultipleTestsInAClass;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassA extends BaseTest {

	@Test
	public void classA() {
		test=extent.createTest("classA");
		Assert.assertTrue(false);
		
	}
}
