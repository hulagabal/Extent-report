package extentReportForMultipleTestsInAClass;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassB extends BaseTest {

	@Test
	public void classB1() {
		test = extent.createTest("class B1");
	
		driver.get("https://www.facebook.com/");
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Facebook – log");
		
		
		
			
		
	}

}
