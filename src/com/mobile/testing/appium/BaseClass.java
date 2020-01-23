package com.mobile.testing.appium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	/*
	 * Inialization of desired capabilites and driver for android application
	 */
	public Logger logger = LogManager.getLogger(BaseClass.class);
	static AndroidDriver<WebElement> driver;
	public static String ApkFile = System.getProperty("user.dir") + "/Resource/Amazon_shopping.apk";
	public static String TESTDATA=System.getProperty("user.dir") + "/TestData/testData.properties";
	static Properties prop = new Properties();
	/*public static final Logger log= Logger.getLogger(BaseClass.class);*/
	public void initialization(String appium,String version,String platformName,String deviceName) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, appium);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		//dc.setCapability(MobileCapabilityType.NO_RESET, true);
		
		dc.setCapability(MobileCapabilityType.APP, ApkFile);

		dc.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		dc.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AndroidDriver<WebElement>(url,dc);
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	/*
	 * Properties file should access every class
	 */
	 static{
        try {
        	FileInputStream fileInputStream = new FileInputStream(TESTDATA);
            prop.load(fileInputStream);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
	/*
	 * Passing key value and get the value 
	 */
    public String getProperties(String key) {
        return prop.getProperty(key);
    }
    /*
     * Click operation
     */
    
    public void click(By element) {
    	try {
    		if(driver.findElement(element).isDisplayed()) {
    			String text=driver.findElement(element).getText();
    			logger.info("Click on button : "+text);
    		driver.findElement(element).click();
    		}else {
    			logger.info("Element is not present");
    		}
    	
    }catch (NoSuchElementException e) {
    	logger.info("Element is not present : "+e);
	}
    }
	/*
	 * Verify object exist
	 */
    public void verifyObjectExist(By amazonLogo, String message) {
    	try {
    		if(driver.findElement(amazonLogo).isDisplayed()) {
    			logger.info("Validation of element is present");
    			Assert.assertTrue(true, message);
    		}
    	}catch (NoSuchElementException e) {
		logger.info("Element is not present : "+e);
		}
    }
    
    /*
     * Verify The text is present or not
     */
    public void verifyTextIsPresentOrNot(By element,String expected) {
    	AndroidElement ele=(AndroidElement) driver.findElement(element);
    	String actual=ele.getText();
    	
    	try {
    	if(actual.contains(expected)) {
    		logger.info("Text is present : "+actual);
    		Assert.assertEquals(actual, expected);
    	}
    }catch (NoSuchElementException e) {
	logger.info("Text is not present : "+e);
	}  	
    	
    }
    
    /**	 * Enter the text in the text box	 */	
    public void inputText(By element,String value ) {
		try {			
			logger.info("Input the text : " +value);
			driver.findElement(element).clear();
			driver.findElement(element).click();
			driver.findElement(element).sendKeys(value);
		}catch (NoSuchElementException e) {
			logger.info("Text is not entered : "+e);
		}
    }
    
    
}
