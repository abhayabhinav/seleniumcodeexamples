package suiteB;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestB1 {
	
	@Test(priority=1)
	public void TestB11() {
		String actual = "B";
		String expected = "B";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=2)
	public void TestB12() {
		String actual = "A";
		String expected = "B";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=3,dependsOnMethods={"TestB12"})
	public void TestB13() {
		System.out.println("Pass");
	}
}
