package buildingblock;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Rediff_CreateDeletePortfolio {
	
	WebDriver driver = null;
	static String data = "Abhinav19th";
	
	@Test(priority=1)
	public void login() {
		
		String browser="Chrome";
		
		if(browser=="Chrome") {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(LoadChrome());
		}
		else if(browser=="Mozilla") {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver=new FirefoxDriver(LoadFirefox());
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		
		//Login and Validating username--------------------------------------------------
		driver.get("http://portfolio.rediff.com/portfolio-login");
		driver.findElement(By.id("useremail")).sendKeys("abhay.abhinav@gmail.com");
		driver.findElement(By.id("emailsubmit")).click();
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("userpass"))));
		driver.findElement(By.id("userpass")).sendKeys("Manub@1029");
		driver.findElement(By.id("loginsubmit")).click();
		String input = "Abhinav Abhay";
		String username = driver.findElement(By.xpath("//span[@id='username']/a")).getText();
		System.out.println(username);
		Assert.assertEquals(input, username);
		
	}	
	
	//Create Profile---------------------------------------------
		
	  	@Test(priority=2,dependsOnMethods= {"login"})
		public void createprofile() {
			/*Sleep(5);
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.id("createPortfolio"))).click().build().perform();*/
			//WaitForPageToLoad();
			clickAndWait("createPortfolio","createPortfolioButton",10);
			ClearAndType(data);
			driver.findElement(By.id("createPortfolioButton")).click();
			//WaitForPageToLoad();
			WaitTillItemToBeVerified(data);//Verification of selected data
			//System.out.println(driver.findElement(By.id("portfolioid")).getText());
		}
		
		
		
		
		//Delete Profile----------------------------------------
	  	@Test(priority=3,dependsOnMethods= {"login","createprofile"})
	  	public void DeleteProfile() {
	  		WebElement dropdownvalue = driver.findElement(By.xpath("//select[@id='portfolioid']"));
			Select s = new Select(dropdownvalue);
			String elementToBeDeleted = s.getFirstSelectedOption().getText();
			System.out.println(elementToBeDeleted);
			if(elementToBeDeleted.equals(data)) {
				driver.findElement(By.id("deletePortfolio")).click();
				Alert Al = driver.switchTo().alert();
				Al.accept();
				driver.switchTo().defaultContent();
			}
			
		}
	  		
		
	
	//Wait for Page to Load
	
	public void WaitForPageToLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		int i=0;
		while(i!=10) {
			String state = (String)js.executeScript("return document.readyState");
			System.out.println(state);
			if(state.equals("complete"))
				break;
			else
				Sleep(1);
			i++;
		}
		
		i=0;
		while(i!=10) {
			long jquerystate = (long)js.executeScript("return jQuery.active;");
			System.out.println(jquerystate);
			if(jquerystate==0)
				break;
			else
				Sleep(1);
			i++;
		}
	}
	
	//wait till a particular element is available for verification
	
	public void WaitTillItemToBeVerified(String ExpItem) {
		int i=0;
		while(i!=10) {
			WebElement e = driver.findElement(By.id("portfolioid"));
			Select s = new Select(e);
			String verifyselected = s.getFirstSelectedOption().getText();
			if(ExpItem.equals(verifyselected))
				return;
			else
				Sleep(1);
			i++;
		}
		Assert.fail("Exp item failed to load");
	}
	
	//Try until element is interacting-------------------------
	
	public void clickAndWait(String TargetXpath, String ExpXpath, int maxtime) {
		for(int i=0;i<maxtime;i++) {
			driver.findElement(By.id(TargetXpath)).click();
			if(IsElementPresent(ExpXpath) && driver.findElement(By.id(ExpXpath)).isDisplayed())
				return ;
			else
				Sleep(1);
			}
				Assert.fail("The expected element"+TargetXpath+"is not found");
		}
	
	
	//Verify if element is present---------------------------
	
	public boolean IsElementPresent(String ValidateElement) {
		int present = driver.findElements(By.id(ValidateElement)).size();
		if(present==0)
			return false;
		else
			return true;
	}
	
	
	
	//Pause Program-------------------------------------------------
	
	public void Sleep(long value) {
		long actualwaittime = value*1000;
		try {
			Thread.sleep(actualwaittime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Clear And Type-----------------------------------------------
	
	public void ClearAndType(String Key) {
		driver.findElement(By.id("create")).clear();
		driver.findElement(By.id("create")).sendKeys(Key);
	}

	
	//Setting Chrome Configuration---------------------------------------
	
	public ChromeOptions LoadChrome() {
		ChromeOptions copts = new ChromeOptions();
		copts.addArguments("--disable-notifications");
		copts.addArguments("--disable-infobars");
		return copts;
	}
	
	
	//Setting Firefox Profile and Configuration--------------------------------------------
	
	public FirefoxOptions LoadFirefox() {
		FirefoxOptions fopts = new FirefoxOptions();
		ProfilesIni prof = new ProfilesIni();
		FirefoxProfile profile = prof.getProfile("Abhinav");
		profile.setPreference("dom.webnotifications.enabled", false);
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		profile.setPreference("webdriver.log.driver.ignore", true);
		fopts.setProfile(profile);
		return fopts;
		
	}

}
