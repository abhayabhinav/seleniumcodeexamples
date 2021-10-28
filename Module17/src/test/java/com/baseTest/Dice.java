package com.baseTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dice {
	
WebDriver driver = null;
	
	@Test(priority=1)
	public void launch() {
		
		String browser = "Chrome";
		if(browser=="Chrome") {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver(loadChrome());
		}else if(browser=="Mozilla") {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver=new FirefoxDriver(loadFirefox());
		}
		
		//Login
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	
	@Test(priority=2)
	public void dicepage() {
	driver.get("https://www.dice.com/");
	waitForPageToLoad();
	WebElement store = driver.findElement(By.xpath("//input[@id='search-field-keyword']"));
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOf(store));
	driver.findElement(By.xpath("//input[@id='search-field-keyword']")).sendKeys("Selenium Automation");
	sleep(1);
	WebElement elements = driver.findElement(By.xpath("//div[@class='typeahead__result']/ul/li[2]/a/span"));
	Actions act = new Actions(driver);
	act.moveToElement(elements).click().build().perform();
		
	driver.findElement(By.xpath("//input[@id='search-field-location']")).clear();
	driver.findElement(By.xpath("//input[@id='search-field-location']")).sendKeys("Dallas");
	sleep(1);
	WebElement element = driver.findElement(By.xpath("//ul[@class='typeahead dropdown-menu']/li/a"));
	Actions act1 = new Actions(driver);
	act1.moveToElement(element).click().build().perform();
	
	driver.findElement(By.id("findTechJobs")).click();
	sleep(5);
	waitForPageToLoad();
	WaitTillItemToBeVerified("//div[@id='dice_paging_top']/ul/li[1]/a");
	
	List<WebElement> page = driver.findElements(By.xpath("//div[@id='dice_paging_top']/ul/li/a"));
	System.out.println(page.size());
	int i=1;
	do {
		
		List<WebElement> positions = driver.findElements(By.xpath("//span[@itemprop='title']"));
		System.out.println(positions.size());
		for(WebElement iter:positions) {
			System.out.println(iter.getText());
		}
			i= (i+1);
			System.out.println(i);
			driver.findElement(By.xpath("//div[@id='dice_paging_top']/ul/li["+i+"]/a")).click();
	}
	while(i<=page.size());	
}

	public void WaitTillItemToBeVerified(String ExpItem) {
		int i=0;
		while(i!=20) {
			WebElement e = driver.findElement(By.xpath(ExpItem));
			if(e.isDisplayed())
				return;
			else
				sleep(1);
			i++;
		}
		Assert.fail("Exp item failed to load");
	}
	
	public void waitAndClick(String Item) {
		WebElement thing = driver.findElement(By.xpath(Item));
		Actions act = new Actions(driver);
		int i=0;
		while(i!=10) {
			if(thing.isEnabled()) {
				act.moveToElement(thing).click().build().perform();
				break;
			}else {
				sleep(1);
				i++;
			}
		}
	}

	public ChromeOptions loadChrome() {
		ChromeOptions copts = new ChromeOptions();
		copts.addArguments("--disable-notifications");
		copts.addArguments("--disable-infobars");
		return copts;
	}
	
	public FirefoxOptions loadFirefox() {
		FirefoxOptions fopts = new FirefoxOptions();
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile prof = profile.getProfile("Abhinav");
		prof.setAcceptUntrustedCertificates(true);
		prof.setAssumeUntrustedCertificateIssuer(false);
		prof.setPreference("dom.webnotifications.enabled", false);
		fopts.setProfile(prof);
		return fopts;
	}
	
	private void waitForPageToLoad() {
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
	
	private void sleep(long time) {
		long value = time*1000;
		try {
			Thread.sleep(value);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

