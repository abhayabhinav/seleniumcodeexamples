package buildingblock;

import static org.testng.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Rediff_BuySellStock {
WebDriver driver = null;
	
	@Test(priority=1)
	public void launch() {
		
		String browser = "Chrome";
		if(browser=="Chrome") {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver(loadChrome());
		}else if(browser=="Mozilla") {
			System.setProperty("Webdriver.gecko.driver", "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver=new FirefoxDriver(loadFirefox());
		}
		
		//Login
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	
		@Test(priority=2)
		public void login() {
		driver.get("http://portfolio.rediff.com/portfolio-login");
		waitForPageToLoad();
		driver.findElement(By.id("useremail")).sendKeys("abhay.abhinav@gmail.com");
		driver.findElement(By.id("emailsubmit")).click();
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("userpass"))));
		driver.findElement(By.id("userpass")).sendKeys("Manub@1029");
		driver.findElement(By.id("loginsubmit")).click();
		waitForPageToLoad();
		String input = "Abhinav Abhay";
		String username = driver.findElement(By.xpath("//span[@id='username']/a")).getText();
		System.out.println(username);
		assertEquals(input, username);
	}
	
		@Test(priority=3)
		public void AddStock() {
			WebElement e = driver.findElement(By.id("portfolioid"));
			Select s = new Select(e);
			s.selectByIndex(1);
			waitForPageToLoad();
			sleep(2);
			driver.findElement(By.id("addStock")).click();
			driver.findElement(By.id("addstockname")).sendKeys("Infosys");
			List<WebElement> elements = driver.findElements(By.xpath("//div[@id='ajax_listOfOptions']/div"));
			sleep(1);
			for(WebElement element : elements) {
				String str = "Infosys Ltd.";
				if(str.equals(element.getText())) {
					element.click();
					break;
				}else
					Assert.fail("Element not found in the list");
			}
			driver.findElement(By.xpath("//a[@id='stockPurchaseDate']")).click();
			SelectDate("12/10/2017");
			driver.findElement(By.id("addstockqty")).sendKeys("100");
			driver.findElement(By.id("addstockprice")).sendKeys("500");
			driver.findElement(By.xpath("//label[@class='selectTab']")).click();
			driver.findElement(By.id("addStockButton")).click();
			WebElement clickable = driver.findElement(By.id("addStock"));
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(clickable));
			waitForPageToLoad();
			sleep(2);
		}
		
		@Test(priority=4)
		public void buyStock() {
			int resultRowNumber = getRowNumForCellData("Infosys Ltd.");
			//System.out.println(resultRowNumber);
			driver.findElement(By.xpath("//table[@class='dataTable sortable' and @id='stock']/tbody/tr["+resultRowNumber+"]/td[1]")).click();
			driver.findElement(By.xpath("//table[@class='dataTable sortable']/tbody/tr["+resultRowNumber+"]/td[3]/div/input[1]")).click();
			driver.findElement(By.id("buySellCalendar")).click();
			SelectDate("17/8/2018");
			driver.findElement(By.id("buysellqty")).sendKeys("100");
			driver.findElement(By.id("buysellprice")).sendKeys("500");
			driver.findElement(By.id("buySellStockButton")).click();
			sleep(2);
			waitForPageToLoad();
			driver.findElement(By.xpath("//table[@class='dataTable sortable' and @id='stock']/tbody/tr["+resultRowNumber+"]/td[1]")).click();
			driver.findElement(By.xpath("//table[@class='dataTable sortable']/tbody/tr["+resultRowNumber+"]/td[3]/div/input[1]")).click();
			driver.findElement(By.id("buySellCalendar")).click();
			SelectDate("17/8/2018");
			driver.findElement(By.id("buysellqty")).sendKeys("200");
			driver.findElement(By.id("buysellprice")).sendKeys("300");
			driver.findElement(By.id("buySellStockButton")).click();
			sleep(2);
			waitForPageToLoad();
			driver.findElement(By.xpath("//table[@class='dataTable sortable' and @id='stock']/tbody/tr["+resultRowNumber+"]/td[1]")).click();
			driver.findElement(By.xpath("//table[@class='dataTable sortable']/tbody/tr["+resultRowNumber+"]/td[3]/div/input[1]")).click();
			driver.findElement(By.id("buySellCalendar")).click();
			SelectDate("17/8/2018");
			driver.findElement(By.id("buysellqty")).sendKeys("300");
			driver.findElement(By.id("buysellprice")).sendKeys("400");
			driver.findElement(By.id("buySellStockButton")).click();
			sleep(2);
			waitForPageToLoad();
			sleep(2);
			WebElement clickable = driver.findElement(By.id("addStock"));
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(clickable));

		}
		
		
		@Test(priority=5)
		public void transactionHistory() {
			int resultRowNumber = getRowNumForCellData("Infosys Ltd.");
			//System.out.println(resultRowNumber);
			int totalShareQty=0;
			int TotalSharePrice=0;
			int actualavgbuyprice ;
			int shareintoprice ;
			
			driver.findElement(By.xpath("//table[@class='dataTable sortable']/tbody/tr["+resultRowNumber+"]/td[1]")).click();
			driver.findElement(By.xpath("//table[@class='dataTable sortable']/tbody/tr["+resultRowNumber+"]/td[3]/div/input[3]")).click();
			List<WebElement> count = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
			for(int i=0;i<count.size();i++) {
				int j = i+1;
				int share = Integer.parseInt(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+j+"]/td[3]")).getText());
				int price = Integer.parseInt(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+j+"]/td[4]")).getText());
				shareintoprice = share*price ;
				TotalSharePrice = (shareintoprice+TotalSharePrice);
				totalShareQty = (share+totalShareQty);
			}
			
				System.out.println(totalShareQty);
				System.out.println(TotalSharePrice);
				actualavgbuyprice = (TotalSharePrice/totalShareQty);
				float actualavgbuyprice2 = Math.round((actualavgbuyprice*100.0)/100.0);
				System.out.println(actualavgbuyprice2);
				
				driver.findElement(By.xpath("//form[@id='popupTransactionForm']/div[2]/a")).click();
				float expectedavgbuyprice = Float.valueOf((driver.findElement(By.xpath("//table[@class='dataTable sortable']/tbody/tr["+resultRowNumber+"]/td[5]")).getText()));
				System.out.println(expectedavgbuyprice);
				assertEquals(actualavgbuyprice2, expectedavgbuyprice);
				
				
				
		}
		
		/*@Test(priority=4)
		public void deleteStock() {
			int resultRowNumber = getRowNumForCellData("Tata Consultancy Services Ltd.");
			System.out.println(resultRowNumber);
			driver.findElement(By.xpath("//table[@class='dataTable sortable' and @id='stock']/tbody/tr["+resultRowNumber+"]/td[1]")).click();
			driver.findElement(By.xpath("//table[@class='dataTable sortable']/tbody/tr["+resultRowNumber+"]/td[3]/div/input[2]")).click();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			waitForPageToLoad();
			//IsElementPresent();
			resultRowNumber = getRowNumForCellData("Tata Consultancy Services Ltd.");
			System.out.println(resultRowNumber);
		}	*/
		
		public boolean IsElementPresent(String ValidateElement) {
			int present = driver.findElements(By.id(ValidateElement)).size();
			if(present==0)
				return false;
			else
				return true;
		}

		public int getRowNumForCellData(String dataIdentified) {
			List<WebElement> rowList = driver.findElements(By.xpath("//table[@class='dataTable sortable' and @id='stock']/tbody/tr"));
			for(int rowNum=0;rowNum<rowList.size();rowNum++) {
				int rowdata = (rowNum+1);
				List<WebElement> cellList = driver.findElements(By.xpath("//table[@class='dataTable sortable' and @id='stock']/tbody/tr["+rowdata+"]/td"));
				for(int cellNum=1;cellNum<cellList.size();cellNum++) {
					String celldata = cellList.get(cellNum).getText();
					//System.out.println(celldata);
					if(dataIdentified.contains(celldata))
						return ++rowNum;
					}
				} return -1;
			}

		private void SelectDate(String d) {
			Date current = new Date();
			System.out.println(current);
			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date selected = sd.parse(d);
				String day = new SimpleDateFormat("dd").format(selected);
				String Month = new SimpleDateFormat("MMMM").format(selected);
				String Year = new SimpleDateFormat("yyyy").format(selected);
				System.out.println(day+"----"+Month+"----"+Year);
				String desiredMonthYear = Month+" "+Year;
				String displayedMonthYear = driver.findElement(By.xpath("//div[@class='dpTitleText']")).getText();
				System.out.println(desiredMonthYear);
				System.out.println(displayedMonthYear);
				
				while(true) {
					displayedMonthYear = driver.findElement(By.xpath("//div[@class='dpTitleText']")).getText();
					if(desiredMonthYear.equals(displayedMonthYear)) {
						driver.findElement(By.xpath("//*[text()='"+day+"']")).click();
						break;
					}else{
						if(selected.compareTo(current) > 0)
							driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[4]/button")).click();
						else if(selected.compareTo(current) < 0)
							driver.findElement(By.xpath("//div[@id='datepicker']/table/tbody/tr/td[2]/button")).click();
					}
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void waitForPageToLoad() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			int i=0;
			while(i!=15) {
				String state = (String) js.executeScript("return document.readyState;");
				String ExpectedState = "complete";
				if(state.equals(ExpectedState)) {
					break;
				}else {
					sleep(1);
					i++;
				}
			}
			
			i=0;
			while(i!=15) {
				long status = (long) js.executeScript("return jQuery.active");
				if(status==0) {
					break;
				}else {
					sleep(1);
					i++;
				}
			}
		}
		
	private void sleep(long time) {
		long value = time*1000;
		try {
			Thread.sleep(value);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ChromeOptions loadChrome() {
		ChromeOptions copts = new ChromeOptions();
		copts.addArguments("--disable-notifications");
		copts.addArguments("--disable-infobars");
		return copts;
	}
	
	public FirefoxOptions loadFirefox() {
		FirefoxOptions fopts = new FirefoxOptions();
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile prof = profile.getProfile("Abhinav");
		prof.setAcceptUntrustedCertificates(true);
		prof.setAssumeUntrustedCertificateIssuer(false);
		prof.setPreference("dom.webnotifications.enabled", false);
		fopts.setProfile(prof);
		return fopts;
	}

}
