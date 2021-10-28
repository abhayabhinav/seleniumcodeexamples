package com.h2o.pom.util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		
		if(extent==null) {
			Date d = new Date();
			String filename = d.toString().replace(":", "_").replace(" ", "_");
			System.out.println(filename);
			extent = new ExtentReports("C:\\Users\\abhinav.abhay\\Documents\\OneDrive - Tavant Technologies\\Documents\\SeleniumCode\\Framework_PageObjectModel\\test-output\\ExtentReports\\"+filename+".html", true, DisplayOrder.NEWEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\ReportsConfig.xml"));
			extent.addSystemInfo("Selenium Version","3.14.0").addSystemInfo("Environment", "QA");
		}
		return extent;
	}	
}