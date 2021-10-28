package drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

public class OptionsExample {
	
	@Test
	public void site() {
		
		
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\SeleniumCode\\Module11\\log.txt");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		
		FirefoxOptions option = new FirefoxOptions();
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile prof = profile.getProfile("Abhinav");
		
		prof.setPreference("dom.webnotifications.enabled", false);
		prof.setAcceptUntrustedCertificates(true);
		prof.setAssumeUntrustedCertificateIssuer(false);
		
		
		option.setProfile(prof);
		option.addPreference("browser.startup.page", 1);
		option.addPreference("browser.startup.homepage", "https://www.tumblr.com//login");
		
		
		
		FirefoxDriver mozilla = new FirefoxDriver(option);
		mozilla.get("https://qch2o.caliberdirect.com");
		option.setPageLoadStrategy(PageLoadStrategy.EAGER);
	}

}
