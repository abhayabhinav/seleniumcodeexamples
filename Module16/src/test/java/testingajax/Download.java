package testingajax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

public class Download {
	
	@Test
	public void FrefoxDownload() {
		
		WebDriver driver = null;
		String browser = "Chrome";
		
		if(browser=="Chrome") {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver(LoadFirefox());
		}
		
		driver.get("http://qtpselenium.com/test/testdownload.php");
		driver.findElement(By.xpath("/html/body/a[1]")).click();
		
		
	}
	
	public FirefoxOptions LoadFirefox() {
		
		FirefoxOptions option = new FirefoxOptions();
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile prof = profile.getProfile("Abhinav");
		
		prof.setPreference("dom.webnotifications.enabled", false);
		prof.setPreference("browser.download.folderList", 2);
		prof.setPreference("browser.download.dir", "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\SeleniumCode\\Module16\\Temp");
		prof.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		prof.setAcceptUntrustedCertificates(true);
		prof.setAssumeUntrustedCertificateIssuer(false);
		option.setProfile(prof);
		return option;
		
	}

}
