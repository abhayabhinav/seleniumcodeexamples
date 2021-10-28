package Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestObject {
	
	@Test(dataProvider="getData")
	public void dologinTest(String username, String Password, String Result, int Phone) {
		System.out.println(username +"------"+ Password);
	}
	
	@DataProvider
	public Object[][] getData(){
		 Object[][] data = new Object[3][4];
		 
		 data[0][0] = "username1";
		 data[0][1] = "Password1";
		 data[0][2] = "Pass";
		 data[0][3] = 9012;
		 
		 data[1][0] = "username2";
		 data[1][1] = "Password2";
		 data[1][2] = "Pass";
		 data[1][3] = 5678;
		 
		 data[2][0] = "username3";
		 data[2][1] = "Password3";
		 data[2][2] = "Fail";
		 data[2][3] = 1234;
		 
		 return data;
		 }

}
