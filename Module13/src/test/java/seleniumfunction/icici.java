package seleniumfunction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class icici {
	
	@Test
	public void icicisite() throws ParseException, InterruptedException {
		
		WebDriver driver = null;
		String browser = "chrome";
		
		if(browser=="chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(LoadChrome());
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		driver.get("https://loan.icicibank.com/asset-portal/auto-loan/check-eligibility?WT.mc_id=NLI_Apply_Online_page%2F");
		String dob = "10/02/1986";
		Date d1 = new Date();
		System.out.println(d1);
		
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		Date formatteddate = sd.parse(dob);
		System.out.println(formatteddate);
		String day = new SimpleDateFormat("dd").format(formatteddate);
		String month = new SimpleDateFormat("MMM").format(formatteddate);
		String year = new SimpleDateFormat("yyyy").format(formatteddate);
		System.out.println(day);
		System.out.println(month);
		System.out.println(year);
		
		int selectyear = Integer.parseInt(year);
		System.out.println(selectyear);
		
		driver.findElement(By.xpath("//span[@id='city-map-icon' and @class='input__label-content pull-right ng-scope']/img")).click();
		Thread.sleep(2000);
		while(true) {
			
			String text = driver.findElement(By.xpath("//button[starts-with(@id,'datepicker-')]/strong")).getText();
			String[] parts = text.split(" - ");
			String parts1 = parts[0];
			String parts2 = parts[1];
			
			int loweryear = Integer.parseInt(parts1);
			int upperyear = Integer.parseInt(parts2);
			System.out.println(loweryear);
			System.out.println(upperyear);
			
			if(loweryear<=selectyear && upperyear>=selectyear) //found
				{
				driver.findElement(By.xpath("//span[text()='"+selectyear+"']")).click();
				driver.findElement(By.xpath("//div[@class='dateOptions']/input[2]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@class='ng-binding' and text()='"+month+"']")).click();
				driver.findElement(By.xpath("//div[@class='dateOptions']/input[3]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@class='ng-binding' and text()='"+day+"']")).click();
				break;
			}else if(loweryear>selectyear)//click left
			{
				driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-chevron-left']")).click();
				
			}else if(upperyear<selectyear)//click forward
			{
				driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-chevron-right']")).click();
			}
		}
		
	}
		public ChromeOptions LoadChrome() {
			
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			ops.addArguments("--disable-infobars");
			return ops;
		}
	}
