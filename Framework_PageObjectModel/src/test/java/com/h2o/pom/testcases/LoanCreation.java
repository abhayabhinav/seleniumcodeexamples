package com.xxx.pom.testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.h20.pom.pages.Launch;
import com.h20.pom.pages.Login;
import com.xxx.pom.basetestcase.basetestcase;
import com.xxx.pom.pages.session.Landing;
import com.xxx.pom.pages.session.Profile;
import com.relevantcodes.extentreports.LogStatus;

public class LoanCreation extends basetestcase
{
    @Test
    public void testLoanCreation() {
    	test = extent.startTest("Create Loan");
    	test.log(LogStatus.INFO, "Opening Browser");
    	openbrowser("Mozilla");
    	Launch launchpage = new Launch(driver, test);
		PageFactory.initElements(driver, launchpage);
		
		Login log = new Login(driver,test);
		PageFactory.initElements(driver, log);
		
    	launchpage.launchxxx();
    	test.log(LogStatus.INFO, "Logging to xxx");
    	Object page = log.logintoxxx("xxxx","xxxx");
    	
    	if(page instanceof Login)
    		Assert.fail("unable to login");
    	else if(page instanceof Landing)
    		System.out.println("Logged in successfully");
    	test.log(LogStatus.PASS, "Logged in xxx suvccessfully");
    	
    	Landing landingpage = (Landing)page;
    	Profile prof = landingpage.LandingPage();
    	landingpage.VerifyText("abcd", "soem text");
    	try {
			prof.clickLoanCreation();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("verification 1 done!");
    	prof.getMenu().logout();
    }
    
    @AfterMethod
	public void quit() {	
	extent.endTest(test);
	extent.flush();
	}
}
