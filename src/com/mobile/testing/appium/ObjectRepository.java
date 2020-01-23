package com.mobile.testing.appium;

import org.openqa.selenium.By;

public class ObjectRepository {
	
	public static  By  amazonLogo=By.xpath("//*[@resource-id='com.amazon.mShop.android.shopping:id/sso_splash_logo']");
	public static By signIntoYourAccount=By.xpath("//*[@resource-id='com.amazon.mShop.android.shopping:id/signin_to_yourAccount']");
	public static By signInButton=By.xpath("//*[@resource-id='com.amazon.mShop.android.shopping:id/sign_in_button']");
	
	public static By welcome=By.xpath("//*[contains(text(),'Welcome')]");

	public static By loginAlreadyCustomer=By.xpath("//*[@resource-id='login_accordion_header']");
	public static By enterEmailId=By.xpath("//*[@resource-id='ap_email_login']");
	public static By clickContinue=By.xpath("//android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[4]/android.widget.Button");
	
	public static By enterPassword=By.xpath("//*[@resource-id='ap_password']");
	public static By submit=By.xpath("//*[@resource-id='signInSubmit']");
	public static By autoFillText=By.xpath("//*[@resource-id='android:id/content']");
	public static By autofill=By.xpath("//*[@resource-id='android:id/button1']");
	
	public static By searchKey=By.xpath("//*[@resource-id='com.amazon.mShop.android.shopping:id/rs_search_src_text']");
	
}
