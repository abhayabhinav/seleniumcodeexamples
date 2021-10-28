package com.abhinav.datadrivenframework.base;

public class ReadingData {

	public static void main(String[] args) {
		
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\Data.xlsx");
		String sheetName = "Login";
		
		int row = xls.getRowCount(sheetName);
		System.out.println("Total Row Count is "+row);
		
		int col = xls.getColumnCount(sheetName);
		System.out.println("Total Col Count is "+col);
		
		String celldata = xls.getCellData(sheetName, 4, 5);
		System.out.println("The text at this cell is "+celldata);
		
	}

}