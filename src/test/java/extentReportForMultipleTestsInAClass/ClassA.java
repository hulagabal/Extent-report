package extentReportForMultipleTestsInAClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassA extends BaseTest {
	private static final Logger log=LogManager.getLogger(ClassA.class);

	@Test
	public void method1() {
		log.info("Method 1 started");
		test = extent.createTest("method1");

		driver.get("https://www.facebook.com/");
		String title = driver.getTitle();
		System.out.println(title);
		log.info(title);
		Assert.assertEquals(title, "Facebook – log");

	}

	@Test
	public void method2() {
		log.info("Method 2 started");
		test = extent.createTest("method1");

		driver.get("https://www.facebook.com/");
		String title = driver.getTitle();
		System.out.println(title);
		log.info(title);
		Assert.assertEquals(title, "Facebook – log");

	}

}
