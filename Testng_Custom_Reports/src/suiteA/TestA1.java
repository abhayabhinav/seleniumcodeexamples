package suiteA;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestA1 {
	
	@Test(priority=1)
	public void TestA11() {
		String actual = "A";
		String expected = "A";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=2)
	public void TestA12() {
		String actual = "A";
		String expected = "B";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=3,dependsOnMethods={"TestA12"})
	public void TestA13() {
		System.out.println("Pass");
	}
	

}
