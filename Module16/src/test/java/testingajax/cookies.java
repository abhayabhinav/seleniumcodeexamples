package testingajax;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class cookies {
	
	@Test
	public void ajax() throws Exception {
		WebDriver driver = null;
		String browser = "Chrome";
		if(browser=="Chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY", "null");
			driver  = new ChromeDriver(LoadChrome());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		driver.get("https://www.ndtv.com/");
		Set<Cookie> cookies = driver.manage().getCookies();
		Iterator<Cookie> its = cookies.iterator();
		while(its.hasNext()) {
			Cookie c = its.next();
			System.out.println(c.getName()+"---"+c.getValue());
			if(c.getName().equals("updateNewscookie")) {
				driver.manage().deleteCookie(c);
				Cookie mycookie = new Cookie("tvc_adBlocker_check", "Wed Jul 12 2018 17:44:42 GMT-0500 (Central Daylight Time)");
				driver.manage().addCookie(mycookie);
			}
			
		}
		
		System.out.println("------------------------------");
		
		cookies = driver.manage().getCookies();	
		its = cookies.iterator();
		while(its.hasNext()) {
			Cookie c = its.next();
			System.out.println(c.getName()+"---"+c.getValue());
		}
	}
		
		
		public ChromeOptions LoadChrome() {
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			ops.addArguments("--disable-infobars");
			ops.addArguments("--silent");
			return ops;
		}
	}

