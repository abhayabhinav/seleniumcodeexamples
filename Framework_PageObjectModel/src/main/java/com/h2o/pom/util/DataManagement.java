package com.h2o.pom.util;

import java.util.Hashtable;

public class DataManagement {
	
	public static Object[][] getTestData(Xls_Reader xlsReader, String TestToRun) {
		
		String sheetName = h2oConstants.sheetName;
		String TestCaseName = TestToRun;
		
		int testStartRowNum=1;
		
		//Find starting row number for the test case
		while(!xlsReader.getCellData(sheetName, 0, 1).equals(TestCaseName)) {
			testStartRowNum ++;
		}
		
		System.out.println("Test Case starts from row Num "+testStartRowNum);
		
		int colStartRowNum = testStartRowNum+1;
		int dataStartRowNum = testStartRowNum+2;
		
		//Find total num of iterations for the respective test case
		int rows=0;
		while(!xlsReader.getCellData(sheetName, 0, dataStartRowNum+rows).equals("")){
			rows++;
		}
		
		System.out.println("Total number of test iteration for the selective test are "+rows);
		
		
		//Find total num of iterations for the respective test case
		int cols=0;
		while(!xlsReader.getCellData(sheetName, cols, colStartRowNum).equals("")){
			cols++;
		}
				
		System.out.println("Total number of test data field for a specific test iteration are "+cols);
		
		
		Object[][] data = new Object[rows][1];
		
		//Read the test data for each test case and it's respective iterations
		int rowData=0;
		Hashtable<String,String> table = null;
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++) {
			table=new Hashtable<String,String>();
			for(int cNum=0;cNum<cols;cNum++) {
				String key = xlsReader.getCellData(sheetName, cNum, colStartRowNum);
				String value = xlsReader.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
			}
			data[rowData][0]=table;
			rowData++;
		}
		
		//Write data to output sheet
		//xlsWriter.setCellData(sheetName, "LoanNumber", 2, "123456789");
		return data;
		
		
	}
}
