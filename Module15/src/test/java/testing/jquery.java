package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class jquery {
	
	@Test
	public void detectiframe() throws Exception {
		WebDriver driver = null;
		String browser = "Chrome";
		if(browser=="Chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY", "null");
			driver  = new ChromeDriver(LoadChrome());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		//drag example
		driver.get("http://jqueryui.com/draggable/");
		int total = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total Count of iframe "+ total);
		driver.switchTo().frame(0);
		WebElement s = driver.findElement(By.xpath("//*[@id='draggable']/p"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(s, 100, 100).build().perform();
		driver.switchTo().defaultContent();
		
		// drop and drag example
		
		driver.get("http://jqueryui.com/droppable/");
		Thread.sleep(3000);
		int total1 = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total Count of iframe "+ total1);
		driver.switchTo().frame(0);
		WebElement src = driver.findElement(By.xpath("//*[@id='draggable']/p"));
		WebElement dest = driver.findElement(By.xpath("//*[@id='droppable']/p"));
		act.dragAndDrop(src, dest).build().perform();
		driver.switchTo().defaultContent();
		driver.close();
		
	}
	
	public ChromeOptions LoadChrome() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ops.addArguments("--disable-infobars");
		ops.addArguments("--silent");
		return ops;
	}
	
}
