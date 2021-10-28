package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ActionClass {
	
	@Test
	public void mouseevent() throws Exception {
		WebDriver driver = null;
		String browser = "Chrome";
		if(browser=="Chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY", "null");
			driver  = new ChromeDriver(LoadChrome());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		driver.get("https://www.americangolf.co.uk/");
		WebElement glofClubs = driver.findElement(By.xpath("//*[@id='header-navigation']/div[1]/ul/li[1]/a"));
		Actions act = new Actions(driver);
		act.moveToElement(glofClubs).build().perform();
		WebElement putters = driver.findElement(By.xpath("//*[@id='CLUBS_1']/ul/li[3]/ul/li/a/span[1]"));
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(putters));
		driver.findElement(By.xpath("//*[@id='CLUBS_1']/ul/li[3]/ul/li/a/span[1]")).click();
		
		
		
		
	}
	
	public ChromeOptions LoadChrome() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ops.addArguments("--disable-infobars");
		ops.addArguments("--silent");
		return ops;
	}
	

}
