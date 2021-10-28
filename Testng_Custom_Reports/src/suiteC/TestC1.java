package suiteC;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestC1 {
	
	@Test(priority=1)
	public void TestC11() {
		String actual = "B";
		String expected = "B";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=2)
	public void TestC12() {
		String actual = "A";
		String expected = "A";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=3,dependsOnMethods={"TestC12"})
	public void TestC13() {
		System.out.println("Pass");
	}

}
