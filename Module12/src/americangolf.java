import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class americangolf {

	@Test
	public void findelement() throws InterruptedException {
		
		WebDriver driver = null;
		String browser = "chrome";
		
		if(browser=="chrome") {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions opts = new ChromeOptions();
			opts.addArguments("--disable-notifications");
			driver = new ChromeDriver(opts);
		}			
			
			String ER = "Your shopping cart is empty";
			driver.get("https://www.americangolf.co.uk/shopping-cart");
			driver.manage().window().maximize();
			String AR = driver.findElement(By.xpath("//h1[contains(@class,'heading-1 cart-heading')]")).getText();
			System.out.println(AR);
			//assert.assertEquals(AR, ER);
			
		}

	}
