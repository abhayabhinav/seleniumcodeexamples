package com.h2o.pom.basetestcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.h2o.pom.util.ExtentManager;
import com.h2o.pom.util.h2oConstants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class basetestcase {
	
	public WebDriver driver;
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	
public void openbrowser(String browser) {
		
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", h2oConstants.ChromeDriver_exe);
			driver = new ChromeDriver(loadChrome());
		}else if(browser.equals("Mozilla")){
			System.setProperty("webdriver.gecko.driver", h2oConstants.FirefoxDriver_exe);
			driver = new FirefoxDriver(loadFirefox());
		}else if(browser.equals("IE")){
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY , h2oConstants.IEDriver_exe);
			driver = new InternetExplorerDriver(loadInternet());
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Browser Opened Successfully");
	}
	
	public ChromeOptions loadChrome() {
		ChromeOptions copt = new ChromeOptions();
		copt.addArguments("--disable-infobars");
		return copt;
	}
	
	public FirefoxOptions loadFirefox() {
		FirefoxOptions fopt = new FirefoxOptions();
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile prof = profile.getProfile("Abhinav");
		prof.setAssumeUntrustedCertificateIssuer(false);
		prof.setAcceptUntrustedCertificates(true);
		prof.setPreference("dom.webnotifications.enabled", false);
		fopt.setProfile(prof);
		return fopt;
		
	}
	
	public InternetExplorerOptions loadInternet() {
		InternetExplorerOptions ieopts = new InternetExplorerOptions();
		ieopts.setPageLoadStrategy(PageLoadStrategy.EAGER);
		ieopts.withInitialBrowserUrl("https://www.google.com/?gws_rd=ssl");
		return ieopts;
		
	}
}
