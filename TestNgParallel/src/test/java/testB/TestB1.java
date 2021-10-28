package testB;

import org.testng.annotations.Test;

import base.testAB.base;

public class TestB1 extends base {
    
	@Test
    public void A1() throws InterruptedException
    {
       System.out.println("Starting Test B1");
       openBrowser("Chorme");
       Thread.sleep(5000);
       System.out.println("Ending Test B1");
    }
}
