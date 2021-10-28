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

public class DummyTestB extends BaseTest {
	
	String testCaseName = "TestB";
	Xls_Reader xls;
	
	@Test(dataProvider="getdata")
	public void TestB(Hashtable<String, String> data) {
		
		test = rep.startTest("Start DummyTestB");
		
		if(!DataUtil.isRunnable(testCaseName, xls) ||  data.get("Runmode").equals("N")) {
			test.log(LogStatus.SKIP, "Skipping the test");
			throw new SkipException("This test data data is not selected for the run");
		}
		test.log(LogStatus.INFO, "This is test B");
		
		test.log(LogStatus.INFO,"Opening Browser");
		openbrowser("Chrome");
		test.log(LogStatus.INFO,"Browser Opened Successfully");
		
		test.log(LogStatus.INFO,"Launch CLP Portal");
		navigate("appurl");
		test.log(LogStatus.INFO,"CLP Portal launched Successfully");
	}
	
	@AfterMethod
	public void quit() {
		rep.endTest(test);
		rep.flush();
	}
	
	@BeforeMethod
	public void init() {
		SoftAssert SoftAssert = new SoftAssert();
	}
	
	
	@DataProvider
	public Object[][] getdata(){
		super.init();
		xls = new Xls_Reader(prop.getProperty("Axlsxpath"));
		return DataUtil.getTestData(xls, testCaseName);
	}

}
