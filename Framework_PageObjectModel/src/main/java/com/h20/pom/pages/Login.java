package com.h20.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.h2o.pom.basepage.basepage;
import com.h2o.pom.pages.session.Landing;
import com.h2o.pom.util.h2oConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Login extends basepage {
	
	@FindBy(id=h2oConstants.username_field)
	public WebElement usr;
	
	@FindBy(id=h2oConstants.okta_signin_submit_button)
	public WebElement submit;
	
	@FindBy(id=h2oConstants.okta_signinpwd_field)
	public WebElement pwd;
	
	@FindBy(id=h2oConstants.submit_button)
	public WebElement oktaSubmit;
	
	
	public Login(WebDriver driver, ExtentTest test) {
		super(driver,test);
	}
	
	public Object logintoH2o(String usrname, String password) {
		test.log(LogStatus.INFO, "Login finction called");
		test.log(LogStatus.INFO, "Entering Username");
		usr.sendKeys(usrname);
		submit.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Entering Password");
		pwd.sendKeys(password);
		oktaSubmit.click();
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(getElementXpath(h2oConstants.logoutlink_xpath)));
		
		boolean login = IsElementPresent(h2oConstants.logoutlink_xpath);
		
		if(login) {
			Landing land = new Landing(driver,test);
			PageFactory.initElements(driver, land);
			return land;
		}else {
			Login log = new Login(driver,test);
			PageFactory.initElements(driver, log);
			return log;
		}
	}
}
