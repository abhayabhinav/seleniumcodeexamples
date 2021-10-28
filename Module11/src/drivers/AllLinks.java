package drivers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AllLinks {
	
	@Test
	public void extractLinks() {
		
		WebDriver driver = null;
		String browser = "chrome";
		
		if(browser=="chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(LoadChrome());
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		driver.get("https://www.cnn.com/");
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("Total No of Web Element on the page is "+ Links.size());
		WebElement Tenthlink = Links.get(9);
		Tenthlink.click();
		String Title = driver.getTitle();
		System.out.println(Title);
		
		
	}
	
	public ChromeOptions LoadChrome() {
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ops.addArguments("--disable-infobars");
		return ops;
	}

}
