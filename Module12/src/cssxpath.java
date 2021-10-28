import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.testng.annotations.Test;

public class cssxpath {

	@Test
	public void launchSite() throws InterruptedException {
		
		WebDriver driver = null;
		String browser = "Chrome";
		
		if(browser=="Chrome"){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions ops = new ChromeOptions();
		    ops.addArguments("--disable-notifications");
		    driver = new ChromeDriver(ops);
		}else if (browser=="firefox") {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser=="InternetExplorer") {
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY , "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\IEDriverServer_Win32_3.11.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if(browser=="Edge") {
			System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\Edge Driver\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
	}
		
		//common functions
		
		
	    driver.get("http://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("abhay.abhinav@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Chotubaby@1015");
		driver.findElement(By.xpath("//input[@id='u_0_2']")).click();
		driver.findElement(By.xpath("//span[@class='_1vp5']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='u_fetchstream_1_a']/li[3]/a")).click(); ////*[@id="u_fetchstream_1_a"]/li[3]/a
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@id='u_fetchstream_2_1k']/span/input")).sendKeys("Nikita");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='name' and @tabindex='0']")).click();
		//driver.close();
		//driver.quit();*/
	}
}