package drivers;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.testng.annotations.Test;

public class BasicDriver {
	
	@Test
	public void launchsite() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		FirefoxDriver mozilla = new FirefoxDriver();
		mozilla.manage().window().maximize();
		mozilla.get("http://qch2o.caliberdirect.com");
		Thread.sleep(5000);
		mozilla.quit();
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver chrome = new ChromeDriver();
		chrome.get("http://qch2o.caliberdirect.com");
		chrome.manage().window().maximize();
		Thread.sleep(5000);
		chrome.quit();
		
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY , "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\IEDriverServer_Win32_3.11.1\\IEDriverServer.exe");
		InternetExplorerDriver ie = new InternetExplorerDriver();
		ie.get("http://qch2o.caliberdirect.com");
		Thread.sleep(5000);
		ie.quit();
		
		System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\Edge Driver\\MicrosoftWebDriver.exe");
		EdgeDriver edge = new EdgeDriver();
		edge.get("http://qch2o.caliberdirect.com");
		edge.manage().window().maximize();
		Thread.sleep(5000);
		edge.quit();
	}

}
