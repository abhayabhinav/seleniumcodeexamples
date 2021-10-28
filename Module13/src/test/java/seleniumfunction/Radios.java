package seleniumfunction;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Radios {
	
	static WebDriver driver = null;
	@Test
	public void drop() {
		
		String browser = "chrome";
		
		if(browser=="chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(LoadChrome());
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
			driver.navigate().to("https://tutorialehtml.com/en/html-tutorial-radio-buttons/");
			List<WebElement> radio = driver.findElements(By.name("citizenship"));
			System.out.println(radio.size());
			radio.get(1).click();
			Screenshot.CaptureScreenshot(driver,"ThirdScreenShot");
			System.out.println(radio.get(1).getAttribute("selected"));
			
	}

	public ChromeOptions LoadChrome() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ops.addArguments("--disable-infobars");
		return ops;
	}
}
