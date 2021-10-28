package testing;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class iframe {
	
	@Test
	public void detectiframe() {
		WebDriver driver = null;
		String browser = "Chrome";
		if(browser=="Chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY", "null");
			driver  = new ChromeDriver(LoadChrome());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		driver.get("https://timesofindia.indiatimes.com/");
		driver.findElement(By.xpath("//a[text()='Not Now']")).click();
		int total = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total Count of iframe "+total);
		
		for(int i=0;i<total;i++) {
			driver.switchTo().frame(i);
			int nexttotal = driver.findElements(By.tagName("iframe")).size();
			System.out.println("Total Count of iframe "+nexttotal);
			
			if(nexttotal==0) {
				WebElement found = driver.findElement(By.xpath("//*[@id='btn-exit']"));
				if(found.isDisplayed())
					break;
				else
					driver.switchTo().defaultContent();
			}
			else {
				for(int j=0;j<nexttotal;j++) {
					driver.switchTo().frame(j);
					int nexttotal1 = driver.findElements(By.tagName("iframe")).size();
					System.out.println("Total Count of iframe "+nexttotal1);
					
					if(nexttotal1==0) {
						WebElement found1 = driver.findElement(By.xpath("//*[@id='btn-exit']"));
						if(found1.isDisplayed())
							break;
						else
							driver.switchTo().frame(j);
					}else
						driver.switchTo().defaultContent();
					
				} break; //coming out of j loop
			}
		}driver.findElement(By.xpath("//*[@id='btn-exit']")).click();  //coming out of i loop
				
		}
	
	public ChromeOptions LoadChrome() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ops.addArguments("--disable-infobars");
		ops.addArguments("--silent");
		return ops;
	}
}
