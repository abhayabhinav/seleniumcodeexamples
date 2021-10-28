package com.abhinav.datadrivenframework.base;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase {
	
	@Test(dataProvider="getdata")
	public void TestA(Hashtable<String, String> data) {

	}
	
	@DataProvider
	public Object[][] getdata(){
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\Data.xlsx");
		String test = "TestC";
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
				if(!xls.getCellData(sheetName, 0, i).equals("N")) {
					String key = xls.getCellData(sheetName, j, testRowHeader);
					String value = xls.getCellData(sheetName, j, i);
					table.put(key,value);
				}
			}
			
			data[datarow][0] = table;
			datarow++;
		}
		return data;		
		}
	}
