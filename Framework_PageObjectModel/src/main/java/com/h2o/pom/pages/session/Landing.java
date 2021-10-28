package com.h2o.pom.pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.h2o.pom.basepage.basepage;
import com.relevantcodes.extentreports.ExtentTest;

public class Landing extends basepage {
	
	public Landing(WebDriver driver, ExtentTest test) {
		super(driver,test);
	}
	
	public Profile LandingPage() {
		VerifyText("xxxxxxxx", "sometext");
		Profile prof = new Profile(driver,test);
		PageFactory.initElements(driver, prof);
		return prof;
	}

}
