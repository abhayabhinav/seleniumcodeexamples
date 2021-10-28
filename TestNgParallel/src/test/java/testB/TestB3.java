package testB;

import org.testng.annotations.Test;

import base.testAB.base;

public class TestB3 extends base {
    
	@Test
    public void A3() throws InterruptedException
    {
       System.out.println("Starting Test B3");
       openBrowser("IE");
       Thread.sleep(5000);
       System.out.println("Ending Test B3");
    }
}
