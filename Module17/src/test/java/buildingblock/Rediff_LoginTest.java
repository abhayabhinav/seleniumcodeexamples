package buildingblock;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Rediff_LoginTest {
	WebDriver driver = null;
	@Test
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
	
	/*public boolean SuccessLogin(String xpath) {
		String username = driver.findElement(By.xpath("xpath")).getAttribute("value");
		if(username=="Abhinav Abhay")
			return true;
			else
			return false;
	}*/

	public ChromeOptions LoadChrome() {
		
		ChromeOptions copts = new ChromeOptions();
		copts.addArguments("--disable-notifications");
		copts.addArguments("--disable-infobars");
		return copts;
	}
	
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
