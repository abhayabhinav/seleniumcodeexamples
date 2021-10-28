package suiteC;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestC2 {
	
	@Test(priority=1)
	public void TestC21() {
		String actual = "B";
		String expected = "B";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=2)
	public void TestC22() {
		String actual = "A";
		String expected = "A";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=3,dependsOnMethods={"TestC22"})
	public void TestC23() {
		System.out.println("Pass");
	}

}
