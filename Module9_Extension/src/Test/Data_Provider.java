package Test;
import java.lang.reflect.Method;

import org.testng.annotations.*;


public class Data_Provider {
	
	@DataProvider (name="DoRegisterDataProvider")
	public static Object[][] getData(Method m) {
		
		Object data[][] = null;
		
		if(m.getName().equals("doReg")) {
			data = new Object[2][3];
			data[0][0] = "U1";
			data[0][1] = "P1";
			data[0][2] = 1234;
			
			data[1][0] = "U2";
			data[1][1] = "U2";
			data[1][2] = 5678;
			

		}else if(m.getName().equals("doRegAnother")){
			data = new Object[2][4];
			
			data[0][0] = "U1";
			data[0][1] = "P1";
			data[0][2] = 1234;
			data[0][3] = 5678;

			data[1][0] = "U2";
			data[1][1] = "U2";
			data[1][2] = 9012;
			data[1][3] = 3456;
		}
		return data;
	}
	
	

}
