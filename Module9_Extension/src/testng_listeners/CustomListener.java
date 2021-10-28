package testng_listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomListener extends TestListenerAdapter {
	
	public void onTestFailure(ITestResult tr) {
		System.out.print("FAIL");
		System.out.println("---------------"+tr.getName());
	}
	
	public void onTestSkipped(ITestResult tr)  {
		System.out.println("SKIPPED");
	}

	public void onTestSuccess(ITestResult tr)  {
	System.out.println("SUCCESS");
}

}
