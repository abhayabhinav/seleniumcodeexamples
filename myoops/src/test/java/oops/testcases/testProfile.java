package oops.testcases;

import org.testng.annotations.Test;

import oops.test.Landing;
import oops.test.Launch;
import oops.test.Login;
import oops.test.Profile;


public class testProfile {
	
	@Test
	public void ProfileTest() {
		Launch lch = new Launch();
		Login loginpage = lch.getfblogin();
		Landing land = loginpage.dologinfb();
		Profile pro = land.landingpage();
		pro.fbprofilepage();
	}

}
