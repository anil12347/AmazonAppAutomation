package com.mobile.testing.appium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonTestCase extends BaseClass{
	
	AmazonPages pages=new AmazonPages();
	public Logger logger = LogManager.getLogger(AmazonTestCase.class);
	
	@Test
	@Parameters({"AutoamtionName","AndroidVersion","PlatformName","DeviceName"})
	public void amazonTesting(String automationName,String androidVersion,String platformName,String deviceName) {
		try {
		initialization(automationName, androidVersion, platformName, deviceName);
		String username=getProperties("username");
		logger.info("Enter the username :"+username);
		String password=getProperties("password");
		logger.info("Enter the password :"+password);
	
		pages.login(username,password);
		
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	@Test
	public void searchAndCompare() {
		String search=getProperties("searchKey");
		logger.info("Enter the username :"+search);
		
		pages.searchTv(search);
		
	}

}
