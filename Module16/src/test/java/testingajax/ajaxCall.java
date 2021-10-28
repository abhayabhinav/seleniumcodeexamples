package testingajax;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ajaxCall {
	
	@Test
	public void ajax() throws Exception {
		WebDriver driver = null;
		String browser = "Chrome";
		if(browser=="Chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY", "null");
			driver  = new ChromeDriver(LoadChrome());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("hello");
		Thread.sleep(2000);
		List<WebElement> container = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		
		for(int i=0;i<container.size();i++) {
			System.out.println(container.get(i).getText());
		}
		
	}
		
		
		public ChromeOptions LoadChrome() {
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			ops.addArguments("--disable-infobars");
			ops.addArguments("--silent");
			return ops;
		}
	}
