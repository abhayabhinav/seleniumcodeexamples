package com.abhinav.datadrivenframework.base;

import java.util.Hashtable;

public class DataUtil {
	
	public static Object[][] getTestData(Xls_Reader xls,String test){
		String sheetName = "Login";
		int StartTestRow=1;
		while(!xls.getCellData(sheetName, 0, StartTestRow).equals(test)) {
			StartTestRow++;
		}
		
		
		int testRowHeader = StartTestRow+1;
		int testRowdata = StartTestRow+2;
		
		System.out.println("Row Number of the test case is "+StartTestRow);
		
		//calculate rows of data
		
		int row=0;
		while(!xls.getCellData(sheetName, 0, testRowdata+row).equals("")) {
			row++;
		}
		
		System.out.println("Total number of data row for the selected test case is "+row);
		
		//calculate cols of data
		
		int col=0;
		while(!xls.getCellData(sheetName, col, testRowHeader).equals("")) {
			col++;
		}
		
		System.out.println("Total number of data columns for the selected test case is "+col);
		
		//read data
		
		Object[][] data = new Object[row][1];
		int datarow=0;
		Hashtable<String, String> table = null;
		for(int i=testRowdata;i<(testRowdata+row);i++) {
			table = new Hashtable<String,String>();
			for(int j=0;j<=col;j++) {
					String key = xls.getCellData(sheetName, j, testRowHeader);
					String value = xls.getCellData(sheetName, j, i);
					table.put(key,value);
			}
			
			data[datarow][0] = table;
			datarow++;
		}
		return data;		
		}
	
	
	public static boolean isRunnable(String test, Xls_Reader xls) {

		String sheetName = "TestCase";
		int TestCaseRow = xls.getRowCount(sheetName);
		System.out.println(TestCaseRow);
		
		for(int r=2;r<=TestCaseRow;r++) {
			if(xls.getCellData(sheetName, "TestCaseID", r).equals(test)){
				if(xls.getCellData(sheetName, "Runmode", r).equals("Y")) {
					return true;
				}else
					return false;		
		}
	}
		
		return false;
}

	
	
	
	
	
	
	
	
	
	
	
	}
