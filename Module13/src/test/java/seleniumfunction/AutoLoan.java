package seleniumfunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.testng.annotations.Test;

public class AutoLoan {
	
	@Test
	public void BrowserOptions() {
		
		WebDriver driver = null;
		String browser = "chrome";
		
		if (browser=="chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(LoadChrome());
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}else if(browser=="firefox") {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}else if(browser=="IE") {
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\IEDriverServer_Win32_3.11.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}else if(browser=="Edge") {
			System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, "C:\\Users\\abhinav.abhay\\\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\Edge Driver\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		driver.get("https://loan.icicibank.com/asset-portal/auto-loan/check-eligibility?WT.mc_id=NLI_Apply_Online_page/");
		/*driver.findElement(By.xpath("//ul[@class='menu clearfix']/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id='main']/div[5]/div[2]/div/ul/li[2]/a[2]")).click();
		driver.findElement(By.xpath("//a[text()='Skip & Continue as Guest']")).click();*/
		driver.findElement(By.xpath("//span[@class='text' and text()='New Car Loan']")).isSelected();
	}
	
	public ChromeOptions LoadChrome() {
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ops.addArguments("--disable-infobars");
		return ops;
	}
	
}
