package base.testAB;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class base{

	public WebDriver driver;
	
	public void openBrowser(String browser) {
		DesiredCapabilities cap = null;
		if(browser.equals("Mozilla")) {
			cap = DesiredCapabilities.firefox();
			//cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
		}else if(browser.equals("Chorme")) {
			cap = DesiredCapabilities.chrome();
			//cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		}else if(browser.equals("IE")) {
			cap = DesiredCapabilities.internetExplorer();
			//cap.setBrowserName("iexplore");
			cap.setPlatform(Platform.WINDOWS);
		}
		
		try {
			driver = new RemoteWebDriver(new URL("http://10.2.113.61:4444/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void quit() {
		if(driver!=null)
			driver.quit();
	}
}
