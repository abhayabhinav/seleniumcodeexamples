package test.mvn;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest {
	
	@Test
	public void openbrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qch2o.caliberdirect.com");
	}
}
