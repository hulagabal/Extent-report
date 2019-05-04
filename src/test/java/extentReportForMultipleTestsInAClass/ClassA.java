package extentReportForMultipleTestsInAClass;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassA extends BaseTest {

	@Test
	public void method1() {
		test = extent.createTest("class A1");

		driver.get("https://www.facebook.com/");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Facebook – log");

	}

	@Test
	public void method2() {
		test = extent.createTest("class A1");

		driver.get("https://www.facebook.com/");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Facebook – log");

	}

}
