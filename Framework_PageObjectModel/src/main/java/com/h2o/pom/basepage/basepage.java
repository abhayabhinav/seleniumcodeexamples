package com.h2o.pom.basepage;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.h2o.pom.commonpages.topMenu;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class basepage {
	
	public static WebDriver driver;
	public topMenu menu ;
	public static ExtentTest test;
	
	public basepage(WebDriver driver, ExtentTest test) {
		basepage.driver=driver;
		basepage.test=test;
		menu = PageFactory.initElements(driver, topMenu.class);
	}
	
	public String VerifyText(String locator, String ExpString) {
		test.log(LogStatus.INFO, "Verifying the expected text");
		return "Write code for asserting something on landing page";
	}
	
	
	public boolean IsElementPresent(String locator) {
		WebElement element = getElementXpath(locator);
		if(element!=null)
			return true;
		else
			return false;
	}
	
	
	public WebElement getElementXpath(String locator) {
		WebElement E = null;
		if(locator.endsWith("xpath")) {
			E = driver.findElement(By.xpath(locator));
		}else {
			reportfail("Element not found");
		}
		return E;
	}

	public void reportfail(String message) {
		test.log(LogStatus.FAIL, message);
		takeScreenshots();
	}

	public topMenu getMenu() {
		return menu;
	}
	
	public static void takeScreenshots() {
		//filename of the screenshot
		
		Date d = new Date();
		String screenshot = d.toString().replace(":", "_").replace(":", "_");
		
		//take the screen shot
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\test-output\\Screenshots"+screenshot+".png";
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// embed the screen shot in the report
		test.log(LogStatus.INFO, "Screenhot:"+test.addScreenCapture(path));
		
	}
	
	public void waitForPageToLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int i=0;
		while(i!=20) {
			String state = (String) js.executeScript("return document.readyState;");
			String ExpectedState = "complete";
			if(state.equals(ExpectedState)) {
				break;
			}else {
				sleep(1);
				i++;
			}
		}
		
		i=0;
		while(i!=20) {
			long status = (long) js.executeScript("return jQuery.active");
			if(status==0) {
				break;
			}else {
				sleep(1);
				i++;
			}
		}
	}
	
	public void sleep(long time) {
		long value = time*1000;
		try {
			Thread.sleep(value);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
