package drivers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class cnn_specifilinks {

	static WebDriver driver = null;
@Test
public void specificLinks() {
		

		String browser = "chrome";
		
		if(browser=="chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(LoadChrome());
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
			driver.navigate().to("https://www.cnn.com/");
			/*WebElement box = driver.findElement(By.xpath("//*[@id='homepage1-zone-1']/div[2]/div/div[3]"));
			List<WebElement> newlinks = box.findElements(By.tagName("a"));
			for(int i=0;i<newlinks.size();i++) {
				WebElement particularlink = newlinks.get(i);
				System.out.println(particularlink.getText());
			}*/
			
			String part1 = "//*[@id=\"homepage1-zone-1\"]/div[2]/div/div[3]/ul/li[";
			String part2 = "]/article/div/div/h3/a/span[1]";
			
			int i=2;
			while(IsElementPresent(part1+i+part2, "xpath")) {
				String text = driver.findElement(By.xpath(part1+i+part2)).getText();
				System.out.println(text);
				driver.findElement(By.xpath(part1+i+part2)).click();
				System.out.println(driver.getTitle());
				driver.navigate().back();
				i++;
			}
}

		public static boolean IsElementPresent(String locator, String locatortype) {
			List<WebElement> allelements = null;
			if(locatortype.equals("xpath")) 
				allelements = driver.findElements(By.xpath(locator));
			else if(locatortype.equals("cssSelector")) 
				allelements = driver.findElements(By.cssSelector(locator));
			
			if(allelements.size()==0)
					return false;
				else
					return true;
}
		public ChromeOptions LoadChrome() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ops.addArguments("--disable-infobars");
		return ops;
	}
}