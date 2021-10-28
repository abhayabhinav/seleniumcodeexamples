import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.testng.annotations.Test;

public class DynamicBrowsers {

	@Test
	public void launchSite() {
		
		String browser = "Chrome";
		WebDriver driver = null;
		
		if(browser=="Chrome"){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browser=="firefox") {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser=="InternetExplorer") {
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY , "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\IEDriverServer_Win32_3.11.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if(browser=="Edge") {
			System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\Edge Driver\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
	}
		
		//common functions
		
		driver.get("https://qch2o.caliberdirect.com");
		driver.manage().window().maximize();
		driver.close();
		driver.quit();
	}
}
