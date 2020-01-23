package com.mobile.testing.appium;


import org.openqa.selenium.By;


public class AmazonPages extends BaseClass{
	/*public static final Logger log= Logger.getLogger(AmazonPages.class);*/
	ObjectRepository object=new ObjectRepository();

	public void login(String username, String password) throws InterruptedException {
		String message=getProperties("amazonLogo");
		verifyObjectExist(object.amazonLogo,message);
		String expected=getProperties("expectedSignInToYourAccount");
		verifyTextIsPresentOrNot(object.signIntoYourAccount,expected);
		String expectedSignInToYourAccount=getProperties("expectedValueAlreadyCustomer");
		verifyTextIsPresentOrNot(object.signInButton, expectedSignInToYourAccount);
		click(object.signInButton);	
		
		String expectedValueLoginAlreadyCustomer=getProperties("expectedValueLoginAlreadyCustomer");
		verifyTextIsPresentOrNot(object.loginAlreadyCustomer, expectedValueLoginAlreadyCustomer);
		inputText(object.enterEmailId, username);
		
		click(object.autoFillText);
		click(object.autofill);
		
		String expectedValueContinue=getProperties("expectedValueContinue");
		verifyTextIsPresentOrNot(object.clickContinue, expectedValueContinue);
		click(object.clickContinue);
		inputText(object.enterPassword, password);
		click(object.autoFillText);
		click(object.autofill);
		click(object.submit);

	
	}

	public void searchTv(String search) {
		
		inputText(object.searchKey, search);
		
	}

}
