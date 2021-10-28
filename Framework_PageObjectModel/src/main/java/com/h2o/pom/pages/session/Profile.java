package com.h2o.pom.pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.h2o.pom.basepage.basepage;
import com.h2o.pom.util.h2oConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Profile extends basepage {
	
	
	@FindBy(xpath=h2oConstants.CreateLoan)
	public WebElement CreateLoan;
	
	public Profile(WebDriver driver, ExtentTest test) {
		super(driver,test);
	}
	
	public void clickLoanCreation() throws Exception {
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Click on Create Loan Link on dashboard page");
		CreateLoan.click();
		takeScreenshots();
		//IsElement("xyz");
	}

}
