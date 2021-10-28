package Test;

import org.testng.annotations.Test;

public class DoRegister {

	
	@Test(dataProviderClass=Data_Provider.class,dataProvider="DoRegisterDataProvider")
	public void doReg(String Username, String Password, int pin) {
		System.out.println(Username+"---"+Password+"------"+pin);
	}
	
	@Test(dataProviderClass=Data_Provider.class,dataProvider="DoRegisterDataProvider")
	public void doRegAnother(String Username, String Password, int pin, int passcode) {
		System.out.println(Username+"---"+Password+"------"+pin+"-----"+passcode);
	}
}
