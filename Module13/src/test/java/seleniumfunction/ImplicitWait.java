package seleniumfunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.google.common.base.StandardSystemProperty;

public class ImplicitWait {

	@Test
	public void Iwait() {
		
		WebDriver driver = null;
		String browser = "chrome";
		
		if(browser=="chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			driver = new ChromeDriver(ops);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
			driver.findElement(By.id("login1")).sendKeys("selenium");
			String text = driver.findElement(By.id("login1")).getAttribute("value");
			System.out.println(text);
			text = driver.findElement(By.xpath("//input[@type='checkbox']")).getAttribute("checked");
			System.out.println(text);
			text = driver.findElement(By.xpath("//input[@type='checkbox']")).getText();
			System.out.println(text);
			
			
		}

	}

}
