package drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;

public class ChromeOptions {
	
	@Test
	public void chrome() throws InterruptedException{
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\SeleniumCode\\Module11\\logchrome.txt");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver chrome = new ChromeDriver();
		chrome.get("http://qch2o.caliberdirect.com");
		chrome.manage().window().maximize();
		Thread.sleep(5000);
		chrome.quit();
		
		
		
	}

}
