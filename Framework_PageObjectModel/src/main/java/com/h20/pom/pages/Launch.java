package com.h20.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.h2o.pom.basepage.basepage;
import com.h2o.pom.util.h2oConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Launch extends basepage {
	 
    public Launch(WebDriver driver, ExtentTest test) {
    	super(driver,test);
    }

	public Login launchH2o() {
		test.log(LogStatus.INFO, "Call to Launch H2O");
    	driver.get(h2oConstants.HOME_url);
    	Login log = new Login(driver,test);
    	PageFactory.initElements(driver, log);
    	return log;
    }
}
