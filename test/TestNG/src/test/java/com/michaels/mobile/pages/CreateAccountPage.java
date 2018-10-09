package com.michaels.mobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.michaels.mobile.utils.Log;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class CreateAccountPage extends DriverPage{

	public CreateAccountPage(RemoteWebDriver driver) {
		super(driver);		
	}
	
	// Locators in AppGuide form
		@FindBy(id = "txtFirstName")
		public WebElement txtFirstName;
		
		@FindBy(id = "txtLastName")
		public WebElement txtLastName;
		
		@FindBy(id="txtEmail")
		public WebElement txtEmail;

		@FindBy(id = "txtConfrimEmail")
		public WebElement txtConfrimEmail;		

		@AndroidFindBy(id = "txtPassword")
		public WebElement txtPassword;
		
		@FindBy(id = "txtConfirmPassword")
		public WebElement txtConfirmPassword;	
		
		@FindBy(id = "txtZipCode")
		public WebElement txtZipCode;	
		
		
		@FindBy(id = "txtPhoneNo")
		public WebElement txtPhoneNo;	
		
		@FindBy(id = "imgCheckAgree")
		public WebElement IAgree;	
		
		@FindBy(id = "imgCheckAge")
		public WebElement CheckAge;	
		
		@FindBy(id = "btnNext")
		public WebElement CreateAccount;	
		
		@AndroidFindBy(id = "android:id/button2")
		public WebElement NoThanks_btn;
		
		@FindBy(id="btnYes")
		public WebElement btn_Okay;
		
		@AndroidFindBy(xpath="//*[@text='Maybe later']")
		private WebElement btnMayBeLater;
		
		@FindBy(id="btnNotRightNow")
		public WebElement btn_NotRightNow;
		
		
		@FindBy(id = "android:id/button3")
		public WebElement btn_OK;	
		
	@iOSFindBy(id = "lbl1")
	public WebElement txt_accountCreated;
	
	@FindBy(id="btnOk")
	public WebElement btnOK;

	/*
	 * @FindBy(id = "lblGuideControl1") public WebElement btn_seewhatsnew;
	 */

	// Methods that performs operations in the Form
		
			
		
public boolean createAccount(String FirstName, String LastName, String Password, String ZipCode){
			
			try{				
			Log.info("Initiated method to enter details and click on create account ");
				String Email= generateEmail(FirstName, LastName);
				long PhoneNo1= generatephNumber(10);
				String PhoneNo= Long.toString(PhoneNo1);
				
				Thread.sleep(2000);
			//	waitForElement(NoThanks_btn);
			/*if ("MAC".equalsIgnoreCase(platformName)) {

			} else {
				if (isElementDisplayed(NoThanks_btn))
					NoThanks_btn.click();
			}*/

			enterText(txtFirstName, FirstName);
			enterText(txtLastName, LastName);
			enterText(txtEmail, Email);
			enterText(txtConfrimEmail, Email);
			enterText(txtPassword, Password);
			enterText(txtConfirmPassword, Password);
			enterText(txtZipCode, ZipCode);
			enterText(txtPhoneNo, PhoneNo);
			
			if ("MAC".equalsIgnoreCase(platformName)) {
				scrollToTextIos("CREATE ACCOUNT");

			} else {
				scrollUp();
			}

			waitForElement(CreateAccount);
			Thread.sleep(4000);
			IAgree.click();
			CheckAge.click();
			this.CreateAccount.click();
			Thread.sleep(2000);
			waitForElement(btn_Okay);
			if(isElementDisplayed(btn_Okay) || isElementDisplayed(btnMayBeLater))
				flag=true;
			/*
				if(txt_accountCreated.getText().equalsIgnoreCase("Account Created"))
					return true;
				else
					return false;*/
		
		} catch (Exception e) {
			return false;
		}
			return flag;
	}


public boolean appGuide_CreateAccount(String FirstName, String LastName, String Password, String ZipCode){
	
	try{				

		createAccount(FirstName, LastName, Password, ZipCode);
		if(isElementDisplayed(btn_NotRightNow)){
			btn_NotRightNow.click();
			flag=true;
		}else if(isElementDisplayed(btnMayBeLater)){
			btnMayBeLater.click();
			flag=true;
		}

} catch (Exception e) {
	return false;
}
	return flag;
}

	/**
	 * @param FirstName
	 * @param LastName
	 * @return
	 */
	public String generateEmail(String FirstName, String LastName){
		
		int x=generateRandomInt(100);
		String Email = FirstName+LastName+x+"@"+"mail.com";
		return Email;

	}

	/**
	 * @return
	 */
	public long generatephNumber1() {
		return (long) (Math.random() * 100000 + 4444400000L);
	}
	
	
	private long generatephNumber(int n){
	    double tenToN = Math.pow(10, n),
	           tenToNMinus1 = Math.pow(10, n-1);
	    long randNum = (long) (Math.random() * (tenToN - tenToNMinus1) + tenToNMinus1);
	    return randNum;
	}
	
	public boolean moreSignUp_createAccount(String FirstName, String LastName, String Password, String ZipCode){
		
		try{				
			createAccount(FirstName, LastName, Password, ZipCode);
			if(isElementDisplayed(btn_Okay)){
				btn_Okay.click();
				flag=true;
			}else if(isElementDisplayed(btnMayBeLater)){
				btnMayBeLater.click();
				flag=true;				
			}
	} catch (Exception e) {
		return false;
	}
	return flag;
			}
	

}
