package com.h2o.pom.testcases;



import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.h2o.pom.basetestcase.basetestcase;
import com.h2o.pom.util.DataManagement;
import com.h2o.pom.util.Xls_Reader;
import com.h2o.pom.util.h2oConstants;

public class testA extends basetestcase {
	
	Xls_Reader xlsReader;
	String TestCaseName = "TestA";
	
	@Test(dataProvider="getData")
	public void storeData(Hashtable<String,String> table) {
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		xlsReader = new Xls_Reader(h2oConstants.Xls_Reader_PATH);
		return DataManagement.getTestData(xlsReader, TestCaseName);
	}

}
