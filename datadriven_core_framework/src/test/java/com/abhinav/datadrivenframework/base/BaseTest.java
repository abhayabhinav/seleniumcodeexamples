package com.abhinav.datadrivenframework.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.abhinav.datadrivenframework.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
	
	public WebDriver driver = null;
	public Properties prop;
	public ExtentReports rep = ExtentManager.getInstance();
	public ExtentTest test;
	public SoftAssert softAssert = new SoftAssert();

	public void init() {
		
		if(prop==null) {
			prop = new Properties();
			try {
				FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\projectconfig.properties");
				prop.load(fs);
				System.out.println(prop.getProperty("appurl"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void openbrowser(String browser) {
		
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromeDriver_exe"));
			driver = new ChromeDriver(loadChrome());
		}else if(browser.equals("Mozilla")){
			System.setProperty("Webdriver.gecko.driver", prop.getProperty("FirefoxDriver_exe"));
			driver = new FirefoxDriver(loadFirefox());
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		
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
	
	public void navigate(String urlkey) {
		driver.get(prop.getProperty(urlkey));
	}
	
	public boolean isElementPresent(String locatorkey) {
		WebElement ele = getElement(locatorkey);
		if(ele.isDisplayed() && ele.isEnabled())
			return true;
		else
			return false;
	}
	
	public WebElement getElement(String locatorkey) {
		WebElement E = null;
		try{
			if(locatorkey.endsWith("xpath"))
			 E = driver.findElement(By.xpath(prop.getProperty(locatorkey)));
		else if (locatorkey.endsWith("name"))
			E = driver.findElement(By.name(prop.getProperty(locatorkey)));
		else if (locatorkey.endsWith("id"))
			E = driver.findElement(By.id(prop.getProperty(locatorkey)));
		else {
			reportFailure("Locator not correct - " + locatorkey);//critical failure
			Assert.fail("Locator not correct - " + locatorkey);
			}
			
		}catch(Exception ex) {
			reportFailure(ex.getMessage());
			ex.printStackTrace();
			Assert.fail("Failed the test " + ex.getMessage());
		}
		return E;
	
	}
	
	
	public boolean verifyText(String locatorkey, String ExpectedText){
		WebElement ActualEle = getElement(locatorkey);
		String ActualText = ActualEle.getText();
		String ExpectedText1 = prop.getProperty(ExpectedText);
		if(ActualText.equals(ExpectedText1))
			return true;
		else
			return false;
	}
	
	
	
	public void ClearAndType(String locatorkey, String Data) {
		getElement(locatorkey).clear();
		getElement(locatorkey).sendKeys(prop.getProperty(Data));
		
	}
	
	public void click(String locatorkey) {
		getElement(locatorkey).click();
	}
	
	private void reportFailure(String message) {
	test.log(LogStatus.FAIL, message);
	takeScreenshots();
}
	
	private void reportPass(String message) {
		test.log(LogStatus.PASS, message);
	}

	
	
	public void takeScreenshots() {
		//filename of the screenshot
		Date d = new Date();
		String screenshot = d.toString().replace(":", "_").replace(" ", "_");
		
		//take the screen shot
		File ScrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(ScrFile, new File(System.getProperty("user.dir")+"//Screenshots//"+screenshot+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// embed the screen shot in the report
		test.log(LogStatus.INFO, "Screenshot ->"+test.addScreenCapture(System.getProperty("user.dir")+"//Screenshots//"+screenshot+".png"));
		
	}
		
		
		public void click() {
	
		}

		public void getUrl() {
	
		}

		public void validate() {
			
		}
}
