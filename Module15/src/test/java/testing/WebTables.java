package testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class WebTables {
	static WebDriver driver = null;
	
	@Test
	public static void Tables() throws Exception {
		
		String browser = "Chrome";
		if(browser=="Chrome") {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY", "null");
			driver  = new ChromeDriver(LoadChrome());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		
		//Get total number of rows and Cols
		
		int rows = driver.findElements(By.cssSelector(".dataTable>tbody>tr")).size();//274
		int cols = driver.findElements(By.cssSelector(".dataTable>tbody>tr:nth-child(1)>td")).size();//5
		System.out.println("Total Rows "+rows);
		System.out.println("Total Cols "+cols);
		
		//Print a certain col data for a company
		
		String CompanyName = "Ashok Leyland";
		
		List<WebElement> ReadCompany = driver.findElements(By.cssSelector(".dataTable>tbody>tr>td:nth-child(1)"));// All company name
		List<WebElement> CurrentPrice = driver.findElements(By.cssSelector(".dataTable>tbody>tr>td:nth-child(4)"));// Alll current price data
		
		for(int i=0;i<ReadCompany.size();i++) {
			if(CompanyName.equals(ReadCompany.get(i).getText())) {
				System.out.println(ReadCompany.get(i).getText()+"------------"+CurrentPrice.get(i).getText());
				break;
			}
			
		}
		
		int rowNum1 = getRowNumWithCellData("232.20");
		System.out.println(rowNum1);
		rowNum1 = rowNum1-1;
		System.out.println(ReadCompany.get(rowNum1).getText());
		
	}
		
		//Custom functions in WebTables
	
	public static int getRowNumWithCellData(String data) {
		List<WebElement> rows1 = driver.findElements(By.cssSelector(".dataTable>tbody>tr"));
		System.out.println(rows1.size());
		
		for(int rowNum1=0;rowNum1<rows1.size();rowNum1++) {
			WebElement rowdata = rows1.get(rowNum1);
			List<WebElement> cells1 = rowdata.findElements(By.tagName("td"));
				for(int cellNum1=0;cellNum1<cells1.size();cellNum1++) {
					String celldata = cells1.get(cellNum1).getText();
					if(celldata.equals(data))
						return ++rowNum1;
				}
			
		} return -1;

}

	public static ChromeOptions LoadChrome() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ops.addArguments("--disable-infobars");
		ops.addArguments("--silent");
		return ops;
	}
}
