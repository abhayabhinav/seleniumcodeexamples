package com.abhinav.datadrivenframework.base;

public class DataManagement {

	public static void main(String[] args) {
		
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\Data.xlsx");
		String test = "TestA";
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
		
		for(int i=testRowdata;i<=testRowdata+row;i++) {
			for(int j=0;j<=col;j++) {
				if(!xls.getCellData(sheetName, 0, i).equals("N"))
				System.out.print(xls.getCellData(sheetName, j, i) +" ");
			}System.out.println();
		}
				
		}
	}

