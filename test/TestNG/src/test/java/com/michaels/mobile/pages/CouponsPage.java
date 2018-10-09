package com.michaels.mobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.michaels.mobile.utils.Log;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class CouponsPage extends DriverPage{

	HomePage oHomePage;
	SignInPage oSignInPage;
	
	boolean flag = false;

	public CouponsPage(RemoteWebDriver driver) {
		super(driver);
		oHomePage = new HomePage(driver);
		oSignInPage = new SignInPage(driver);
	}

	// Locators in More form
	@FindBy(id = "lblCouponTitle")
	public WebElement lblCouponTitle;
	
	@AndroidFindBy(id = "android:id/button2")
	public WebElement NoThanks_btn;
	
	
	@iOSFindBy(xpath = "//*[@label='VIEW RESTRICTIONS']")
	@AndroidFindBy(xpath = "//*[@text='VIEW RESTRICTIONS']")
	public WebElement btnViewRestrictions;
	
	@iOSFindBy(xpath = "//*[@label='ADD TO WALLET']")
	@AndroidFindBy(xpath = "//*[@text='ADD TO WALLET']")
	public WebElement btnAddToWallet;
	
	@FindBy(id = "btnDone")
	public WebElement btnDone;
	
	@FindBy(id = "lblOfferTitle1Restrictions")
	public WebElement lblOfferTitle1Restrictions;
	
	
	@FindBy(id = "lblValidityRestrictions")
	public WebElement lblValidityRestrictions;
	
	@FindBy(id = "lblPromoCodeRestrictions")
	public WebElement lblPromoCodeRestrictions;
	
	@FindBy(id = "imgBarcodeRestrictions")
	public WebElement imgBarcodeRestrictions;
	
	@FindBy(id = "rchTxtRetrictions")
	public WebElement rchTxtRetrictions;
	
	@FindBy(id = "flxCloseBtnWrap")
	public WebElement flxCloseBtnWrap;
	
	
	@iOSFindBy(xpath="(//XCUIElementTypeOther[@name='RemoteViewBridge'])[1]")
	@AndroidFindBy(id="com.google.android.apps.walletnfcrel:id/AccountSpinnerContainer")
	public WebElement walletApp;

	// Methods that performs operations in Form

	public boolean navigateToCouponsPage() {

		try {
			Log.info("Initiated Method to verify Coupons Page ");
			
			if(isElementDisplayed(lblCouponTitle))
			flag=true;
		}
		catch (Exception e) {
			System.out.println("Unable to find Coupons Page" + e);
			return false;
		}
			return flag;
	}
	
	
	public boolean verifyViewRestrictions() {

		try {
			Log.info("Initiated Method to verify View Restrictions");
			waitForAndClickElement(btnViewRestrictions);
			if(isElementDisplayed(lblOfferTitle1Restrictions) && isElementDisplayed(lblPromoCodeRestrictions) && isElementDisplayed(lblValidityRestrictions) && 
					isElementDisplayed(imgBarcodeRestrictions) && isElementDisplayed(rchTxtRetrictions) && isElementDisplayed(flxCloseBtnWrap))
			flag=true;
		}
		catch (Exception e) {
			System.out.println("Unable to find  View Restrictions on Coupons Page" + e);
			return false;
		}
			return flag;
	}
	
	
	public boolean navigateBackFromViewRestrictions() {

		try {
			Log.info("Initiated Method to verify Close button functionality of View Restrictions");
			waitForAndClickElement(flxCloseBtnWrap);
			if(isElementDisplayed(lblCouponTitle))
			flag=true;
		}
		catch (Exception e) {
			System.out.println("Unable to verify Close button functionality of View Restrictions on Coupons Page" + e);
			return false;
		}
			return flag;
	}
	
	
	public boolean verifyAddToWallet() {

		try {
			Log.info("Initiated Method to verify Add Wallet Coupons Page");
			waitForAndClickElement(btnAddToWallet);
			if(isElementDisplayed(walletApp) || isElementDisplayed(androidWebView))
			flag=true;
		}
		catch (Exception e) {
			System.out.println("Unable to Add Wallet Coupons Page" + e);
			return false;
		}
			return flag;
	}
	
	
	public boolean navigateBackFromCouponsPage() {

		try {
			Log.info("Initiated Method to verify Done button functionality of Coupons Page");
			waitForAndClickElement(btnDone);
			if(isElementDisplayed(oHomePage.home_logo))
			flag=true;
		}
		catch (Exception e) {
			System.out.println("Unable to verify Done button functionality of Coupons Page" + e);
			return false;
		}
			return flag;
	}

}
