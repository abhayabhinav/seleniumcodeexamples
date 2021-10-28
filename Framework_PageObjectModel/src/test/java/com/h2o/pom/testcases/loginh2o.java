package com.xxx.pom.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.h20.pom.pages.Launch;
import com.h20.pom.pages.Login;
import com.xxx.pom.basetestcase.basetestcase;
import com.xxx.pom.pages.session.Landing;
import com.xxx.pom.util.DataManagement;
import com.xxx.pom.util.Xls_Reader;
import com.xxx.pom.util.xxxConstants;
import com.relevantcodes.extentreports.LogStatus;

public class loginxxx extends basetestcase{
	
	Xls_Reader xlsReader;
	String TestCaseName = "LoginTest";
	
	@DataProvider
	public Object[][] getData(){
		
		xlsReader = new Xls_Reader(xxxConstants.Xls_Reader_PATH);
		return DataManagement.getTestData(xlsReader, TestCaseName);
	}
	
	@Test(dataProvider="getData")
	public void loginToxxx(Hashtable<String,String> table) {
		test = extent.startTest("Login Test");
		test.log(LogStatus.INFO, "Open Browser");
		openbrowser(table.get("browser"));
		
		Launch launchpage = new Launch(driver, test);
		PageFactory.initElements(driver, launchpage);
		launchpage.launchxxx();
		
		Login log = new Login(driver, test);
		PageFactory.initElements(driver, log);
		
		Object page =  log.logintoxxx(table.get("username"),table.get("password"));
		
		if(page instanceof Landing)
			test.log(LogStatus.PASS, "Login test passed");
		else
			test.log(LogStatus.FAIL, "Login test failed");
			Assert.fail();
	}
	
	
	@AfterMethod
	public void quit() {	
	extent.endTest(test);
	extent.flush();
	}
}
