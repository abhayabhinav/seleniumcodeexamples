package testingajax;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Autoit {
	
	@Test
	public void upload() throws Exception {
		WebDriver driver = null;
		String browser = "Chrome";
		if(browser=="Chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY", "null");
			driver  = new ChromeDriver(LoadChrome());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		/*driver.get("http://qtpselenium.com/test/uploadform/contactform.php");
		driver.findElement(By.xpath("//input[@type='file' and @name='photo']")).sendKeys("C:\\Users\\abhinav.abhay\\Desktop\\Abhinav.jpg");
		//driver.findElement(By.xpath("//input[@type='file' and @name='photo']")).click();*/
		
		//H2O:
		
		driver.get("https://qch2o.caliberdirect.com");
		driver.findElement(By.id("plaintextUsername")).sendKeys("joe.jones");
		driver.findElement(By.id("password")).sendKeys("test123#");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.xpath("//span[@class='newLoan']")).click();
		
		
		//WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[@class='upload-label']"))));
		
		Thread.sleep(3000);
		
		WebElement browse = driver.findElement(By.xpath("//label[@class='upload-label']"));
		System.out.println(browse);
		Actions act = new Actions(driver);
		act.moveToElement(browse).build().perform();
		act.click().build().perform();
		
		Process process = new ProcessBuilder(System.getProperty("user.dir")+"\\temp.exe","C:\\Users\\abhinav.abhay\\Desktop\\retail.fnm", "Open").start();
		
		//driver.findElement(By.xpath("//label[@class='upload-label']")).sendKeys("C:\\Users\\abhinav.abhay\\Desktop\\retail.fnm");
	}

		public ChromeOptions LoadChrome() {
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			ops.addArguments("--disable-infobars");
			ops.addArguments("--silent");
			return ops;
		}
	}
