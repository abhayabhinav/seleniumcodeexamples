package seleniumfunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDown {
	
	@Test
	public void drop() {
		WebDriver driver = null;
		String browser = "chrome";
		
		if(browser=="chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(LoadChrome());
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
			driver.navigate().to("http://qtpselenium.com/home/contact_trainer");
			
			WebElement dropdown = driver.findElement(By.name("country_id"));
			Select options = new Select(dropdown);
			//options.selectByIndex(3);
			//options.selectByValue("106");
			options.selectByVisibleText("India");
			String selected = options.getFirstSelectedOption().getText();
			System.out.println(selected);
			
	}

	public ChromeOptions LoadChrome() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ops.addArguments("--disable-infobars");
		return ops;
	}
}