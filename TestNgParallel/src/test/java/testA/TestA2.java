package testA;

import org.testng.annotations.Test;

import base.testAB.base;

public class TestA2 extends base {
    
	@Test
    public void A2() throws InterruptedException
    {
       System.out.println("Starting Test A2");
       openBrowser("Mozilla");
       Thread.sleep(5000);
       System.out.println("Ending Test A2");
    }
}
