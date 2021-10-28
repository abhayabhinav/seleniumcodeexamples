package Test;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import org.testng.annotations.*;

public class ApplicationTest {
	
	SoftAssert sa = new SoftAssert();
	@BeforeSuite
	public static void BeforeSuite() {
		System.out.println("------Before Each Suite-----");
	}
	
	@AfterSuite
	public static void AfterSuite() {
		System.out.println("------After Each Suite-----");
	}
	
	@BeforeTest
	public static void BeforeTest() {
		System.out.println("------Before Each Test-----");
	}
	
	@AfterTest
	public static void AfterTest() {
		System.out.println("------After Each Test-----");
	}
	
	@BeforeMethod
	public static void BeforeMethod() {
		System.out.println("------Before Each Method-----");
	}
	
	@AfterMethod
	public static void AfterMethod() {
		System.out.println("------After Each Methods-----");
	}
	
	@Test(priority=1)
	public void doLogin() {
		System.out.println("Check login");
	}
	
	@Test(priority=2)
	public void AccessDashboard() {
		String actualdisplayname = "Abhinav";
		String expecteddisplayname = "Abhay";
		System.out.println("Print A");
		sa.assertEquals(actualdisplayname, expecteddisplayname);
		System.out.println("Print B");
		System.out.println("Dashboard Accessed");
		sa.assertAll();
	}
	
	@Test(priority=3)
	public void logout() {
		System.out.println("logged Out");
	}
}
