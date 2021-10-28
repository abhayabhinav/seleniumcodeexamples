package com.abhinav.datadrivenframework;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.abhinav.datadrivenframework.base.BaseTest;
import com.abhinav.datadrivenframework.base.DataUtil;
import com.abhinav.datadrivenframework.base.Xls_Reader;
import com.relevantcodes.extentreports.LogStatus;

public class DummyTestA extends BaseTest {
	
	String testCaseName = "TestA";
	Xls_Reader xls ;
	
	@Test(dataProvider="getdata")
	public void TestA1(Hashtable<String, String> data) {
		
		test = rep.startTest("Start DummyTestA");
		test.log(LogStatus.INFO,data.toString());
		if(!DataUtil.isRunnable(testCaseName, xls) || data.get("Runmode").equals("N")) {
			test.log(LogStatus.SKIP, "Skipping the test");
			throw new SkipException("This test data data is not selected for the run");
		}
				
		test.log(LogStatus.INFO,"Opening Browser");
		openbrowser("Chrome");
		test.log(LogStatus.INFO,"Browser Opened Successfully");
		
		test.log(LogStatus.INFO,"Launch CLP Portal");
		navigate("appurl");
		test.log(LogStatus.INFO,"CLP Portal launched Successfully");
		
		softAssert.assertTrue(verifyText("textaddress_xpath","expectedTest"),"The text on home page did not match");
		

		if(!(isElementPresent("username_xpath"))){
			test.log(LogStatus.FAIL, "Element is not present");
			takeScreenshots();
		}
		
		
		test.log(LogStatus.INFO,"Ready to Type Username");
		
		ClearAndType("username_xpath", "username_text");
		ClearAndType("Password_id", "Password_text");
		click("button_xpath");
		
		test.log(LogStatus.INFO, "Logged in Successfully to CLP Portal");
	}
	
	@BeforeMethod
	public void initi() {
		SoftAssert softAssert = new SoftAssert(); 
	}
	@AfterMethod
	public void quit() {
		try{
			softAssert.assertAll();
		}catch(Error e) {
			test.log(LogStatus.FAIL, e.getMessage());
		}
		rep.endTest(test);
		rep.flush();
	}
	
	
	@DataProvider
	public Object[][] getdata(){
		super.init();
		xls = new Xls_Reader(prop.getProperty("Axlsxpath"));
		return DataUtil.getTestData(xls, testCaseName);
	}

}