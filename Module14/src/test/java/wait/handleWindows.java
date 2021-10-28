 package wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class handleWindows {

	@Test
	public void windows() {

		WebDriver driver = null;
		String browser = "chrome";
		
		if(browser=="chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(LoadChrome());
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
			Set<String> winds = driver.getWindowHandles();
			System.out.println("Count of opened windows in the current session is " + winds.size());
			System.out.println(winds);
			
			driver.navigate().to("https://www.naukri.com/");
			
			Set<String> winds1 = driver.getWindowHandles();
			System.out.println("Count of opened windows in the current session is " + winds1.size());
			System.out.println(winds1);
			
			Iterator its = winds1.iterator();
			String MainWindow = (String) its.next();
			String FirtsPopup = (String) its.next();
			System.out.println(MainWindow);
			System.out.println(FirtsPopup);
			driver.switchTo().window(FirtsPopup);
			driver.close();
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//span[@id='block']")).click();
			driver.findElement(By.xpath("//div[@class='mTxt' and text()='Login']")).click();
			driver.findElement(By.xpath("//div[@class='rowR']/input[@name='email']")).sendKeys("abhay.abhinav@gmail.com");
			driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.alertIsPresent()).accept();
			
			/*Alert al = driver.switchTo().alert();
			System.out.println(al.getText());
			al.accept();
			driver.switchTo().defaultContent();
			driver.findElement(By.id("login1")).sendKeys("abhay.abhinav@gmail.com");
			
			/*while(its.hasNext()) {
				System.out.println(its.next());
			}*/
	}
	
	public ChromeOptions LoadChrome() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ops.addArguments("--disable-infobars");
		return ops;
	}

}
