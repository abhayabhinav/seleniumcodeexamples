package Test;

import org.testng.Assert;
import org.testng.annotations.Test;



public class ApplicationTest {
	
	@Test(priority=1)
	public void dologinTest() {
			Assert.assertEquals("A","B");
		System.out.println("Login");
		
	}
	
	@Test(priority=2,dependsOnMethods= {"dologinTest"})
	public void chnagepwdTest() {
		System.out.println("Change pwd");
		
	}
	
	@Test(priority=3, dependsOnMethods= {"dologinTest"})
	public void logoutTest() {
		System.out.println("logout");
		
	}
	
	
}
