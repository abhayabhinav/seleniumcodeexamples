package seleniumfunction;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
public static void CaptureScreenshot(WebDriver driver, String ScreenshotName ) {
		
		File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(SrcFile, new File(System.getProperty("user.dir")+"//"+ScreenshotName+".jpg"));
		}catch(IOException e) {
			e.printStackTrace();
			}
	}

}
