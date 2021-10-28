package drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class InternetOptions {
	
	@Test
	public void IEOptions() {
		
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\SeleniumCode\\Module11\\ielog.txt");
		//System.setProperty(InternetExplorerDriverService.IE_DRIVER_SILENT_PROPERTY, "true");
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY , "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\IEDriverServer_Win32_3.11.1\\IEDriverServer.exe");
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		InternetExplorerDriver ie = new InternetExplorerDriver();
		ie.get("https://192.163.254.17/");
		ie.get("javascript:document.getElementById('overridelink').click();");
		
		
		
	}

}
