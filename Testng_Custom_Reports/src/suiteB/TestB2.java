package suiteB;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestB2 {
	
	@Test(priority=1)
	public void TestB21() {
		String actual = "B";
		String expected = "B";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=2)
	public void TestB22() {
		String actual = "A";
		String expected = "B";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=3,dependsOnMethods={"TestB22"})
	public void TestB23() {
		System.out.println("Pass");
	}

}
