package com.michaels.mobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.michaels.mobile.utils.Log;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SignInPage extends DriverPage {

	boolean flag = false;

	public SignInPage(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Locators in More form
	@FindBy(id = "txtEmail")
	public WebElement useremail;

	@FindBy(id = "txtPassword")
	public WebElement password;

	@FindBy(id = "btnSignIn")
	public WebElement btnSignIn;


	@AndroidFindBy(id = "android:id/button3")	
	public WebElement SignIn_message;

	@FindBy(id = "btnCreateAccount")
	public WebElement btn_createAccount;

	@iOSFindBy(id = "Maybe later")
	@AndroidFindBy(xpath="//*[@text='MAYBE LATER']")
	public WebElement btn_maybeLater;

	@iOSFindBy(id = "You're logged in now.")
	@AndroidFindBy(xpath = "//*[@text='You’re logged in now.']")
	public WebElement txt_loginSuccess;

	@iOSFindBy(id = "OK")
	public WebElement btn_ok;
	//@AndroidFindBy(xpath = "//*[@text='OK']")


	// Methods that performs operations in Form

	public boolean enterSignInDetails(String Email, String Password) {

		try {
			System.out.println("Initiated Method to Click on SignIn");

			if ("MAC".equalsIgnoreCase(platformName)) {
				useremail.sendKeys(Email);
				System.err.println(Password);
				password.sendKeys(Password);
				btnSignIn.click();
				if (isElementDisplayed(btn_maybeLater)){
					btn_maybeLater.click();
				}			

				waitForElement(txt_loginSuccess);
				btn_ok.click();

				flag = true;
			} else {
				this.useremail.sendKeys(Email);
				this.password.sendKeys(Password);
				this.btnSignIn.click();
				if (isElementDisplayed(btn_maybeLater)){
					btn_maybeLater.click();
				}

				waitForElement(txt_loginSuccess);
				if(isElementDisplayed(txt_loginSuccess)){
					SignIn_message.click();
					flag=true;
				}
								
			}

		} catch (Exception e) {
			System.out.println("Unable to Click on SignIn button" + e);
			return false;
		}
		return flag;
	}

	public boolean clickOnCreateAccount() {
		//DOne Porting
		try {
			Log.info("Initiated Method to Click on Create Account ");
			btn_createAccount.click();
			return true;
		} catch (Exception e) {
			Log.warn("Unable to Click on Create Account" + e);
			return false;
		}

	}
}