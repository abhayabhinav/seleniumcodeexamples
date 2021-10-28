package suiteA;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestA2 {
	
	@Test(priority=1)
	public void TestA21() {
		String actual = "A";
		String expected = "A";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=2)
	public void TestA22() {
		String actual = "A";
		String expected = "A";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=3,dependsOnMethods={"TestA22"})
	public void TestA23() {
		System.out.println("Pass");
	}

}
