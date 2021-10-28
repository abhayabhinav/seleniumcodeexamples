package com.h2o.pom.util;

public class h2oConstants {
	
	//Path
	public static String FirefoxDriver_exe =  "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\geckodriver-v0.20.1-win64\\geckodriver.exe";
	public static String ChromeDriver_exe = "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\chromedriver_win32\\chromedriver.exe";
	public static String IEDriver_exe = "C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\Software\\IEDriverServer_Win32_3.11.1\\IEDriverServer.exe";
	
	public static final String Xls_Reader_PATH = System.getProperty("user.dir")+"\\TestCaseData.xlsx";
	public static final String Xls_Writer_PATH = System.getProperty("user.dir")+"\\test-output\\OutputData\\Output.xlsx";
	
	public static final String sheetName = "Data";
	
	//Locators
	public static String HOME_url = "https://uat2h2o.caliberdirect.com";
	public static final String username_field = "idp-discovery-username";
	public static final String okta_signinpwd_field = "okta-signin-password";
	
	
	
	//buttons
	public static final String submit_button = "okta-signin-submit";
	public static final String okta_signin_submit_button = "idp-discovery-submit";
	
	//link
	public static final String CreateLoan = "//*[@id='dashboardContainer']/div/div/div[3]/div/div/ul[2]/li/a";
	public static final String logoutlink_xpath = "//a[text()='Log Out']";
}
