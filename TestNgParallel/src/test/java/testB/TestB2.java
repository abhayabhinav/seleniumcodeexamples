package testB;

import org.testng.annotations.Test;

import base.testAB.base;

public class TestB2 extends base {
    
	@Test
    public void A2() throws InterruptedException
    {
       System.out.println("Starting Test B2");
       openBrowser("Mozilla");
       Thread.sleep(5000);
       System.out.println("Ending Test B2");
    }
}
