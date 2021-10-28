package seleniumfunction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SimpleTest {
		
		@Test
		public void icicisite() throws ParseException, InterruptedException {
			
			WebDriver driver = null;
			String browser = "chrome";
			
			if(browser=="chrome") {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}
			
			driver.get("https://loan.icicibank.com/asset-portal/auto-loan/check-eligibility?WT.mc_id=NLI_Apply_Online_page%2F");
			driver.findElement(By.xpath("//div[@class='custom-date-holder']/span/span/img")).click();
			driver.findElement(By.xpath("//div[@class='dateOptions']/input[2]")).click();
		}
}
