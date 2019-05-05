package extentReportForMultipleTestsInAClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassB extends BaseTest {
	private static final Logger log=LogManager.getLogger(ClassB.class);
	@Test
	public void method1() {
		log.info("Method 1 started");
		test = extent.createTest("class B1");
	
		driver.get("https://www.facebook.com/");
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Facebook – log");
		log.info("test completede");
		
		
		
			
		
	}

}
