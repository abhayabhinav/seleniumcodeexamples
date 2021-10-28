package testA;

import org.testng.annotations.Test;

import base.testAB.base;

public class TestA1 extends base {
    
	@Test
    public void A1() throws InterruptedException
    {
       System.out.println("Starting Test A1");
       openBrowser("Chrome");
       Thread.sleep(5000);
       System.out.println("Ending Test A1");
    }
}
