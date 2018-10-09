package com.michaels.mobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.michaels.mobile.utils.Log;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class MorePage extends DriverPage{

	HomePage oHomePage;
	SignInPage oSignInPage;
	
	boolean flag = false;

	public MorePage(RemoteWebDriver driver) {
		super(driver);
		oHomePage = new HomePage(driver);
		oSignInPage = new SignInPage(driver);
	}

	// Locators in More form
	@FindBy(id = "btnSignIn")
	public WebElement SignIn_btn;
	
	@AndroidFindBy(id = "android:id/button2")
	public WebElement NoThanks_btn;
	
	@FindBy(id="btnMichaelsRewards")
	public WebElement btnMichaelsRewards;
	
	@FindBy(id="btnRewardsProgmInfo")
	public WebElement btnRewardsProgmInfo;
	
	@FindBy(id="btnJoinRewards")
	public WebElement btnJoinRewards;
	
	@iOSFindBy(xpath = "//*[@label='SIGN IN']")
	@AndroidFindBy(xpath = "//*[@text='SIGN IN']")
	public WebElement signIn_Page;
	
	@iOSFindBy(xpath = "//*[@label='PROGRAM INFORMATION']")
	@AndroidFindBy(xpath = "//*[@text='PROGRAM INFORMATION']")
	public WebElement programInfo_Page;
	
	@FindBy(id="btnAddToWallet")
	public WebElement btnAddToWallet;
	
	
	@FindBy(id="btnRewardsProfile1")
	private WebElement btnRewardsProfile1;
	
	@iOSFindBy(xpath = "//*[@label='REWARDS PROFILE']")
	@AndroidFindBy(xpath = "//*[@text='REWARDS PROFILE']")
	private WebElement rewardsProfile_Page;
	
	@FindBy(id = "btnSignUp")
	public WebElement btnSignUp;
	
	@iOSFindBy(id="Sign In")
	@AndroidFindBy(id="android:id/button1")
	public WebElement btnSignIn;
	
	@FindBy(id="btnCouponMain")
	private WebElement btnCouponMain;

	@FindBy(id="lblMyStore")
	private WebElement lblMyStore;
	
	@FindBy(id="flxBackToProducts")
	private WebElement flxBackToProducts;
	
	@FindBy(id="lblMyStoreName")
	private WebElement lblMyStoreName;
	
	@iOSFindBy(xpath="//*[@label='Settings']")
	//XCUIElementTypeOther[@name="segMenuList_1_2"]
	@AndroidFindBy(xpath="//*[@text='Settings']")
	private WebElement settingsMenu;
	
	@FindBy(id="lblRegionLanguageValue")
	private WebElement lblRegionLanguageValue;
	
	
	@FindBy(id="btnLangRegion3")
	private WebElement btnLangRegion3;
	
	
	
	// Methods that performs operations in Form

	public boolean clickOnSignIn() {
//Done Porting
		try {
			Log.info("Initiated Method to Click on SignIn Button ");			
			waitForAndClickElement(SignIn_btn);
			return true;
		}
		catch (Exception e) {
			System.out.println("Unable to Click on SignIn Button" + e);
			return false;
		}

	}
	
	
	public boolean clickOnSignUp() {
		//Done Porting
				try {
					Log.info("Initiated Method to Click on SignIn Button ");					
					waitForAndClickElement(btnSignUp);
					return true;
				}
				catch (Exception e) {
					System.out.println("Unable to Click on SignIn Button" + e);
					return false;
				}

			}
	
	public boolean clickOnSignInFromMichaelRewards(String Email, String Password) {

		try {
			System.out.println("Initiated Method to Click on SignIn Button ");			
			btnMichaelsRewards.click();
			btnRewardsProgmInfo.click();
			waitForElement(programInfo_Page);
			if ("MAC".equalsIgnoreCase(platformName)) {
				scrollToTextIos("JOIN MICHAELS REWARDS");
				//scrollUp();
				btnJoinRewards.click();
				btnSignIn.click();

			} else{
				scrollUp();
				btnJoinRewards.click();
				oHomePage.btn_Yes.click();
			}				
			
			if(isElementDisplayed(signIn_Page)){
				oSignInPage.enterSignInDetails(Email, Password);				
			}
			if(isElementDisplayed(btnAddToWallet))
				flag=true;
		}
		catch (Exception e) {
			System.out.println("Unable to Click on SignIn Button" + e);
			return false;
		}		
		return flag;
	}
	
	
	public boolean navigateToRewardsProfile() {

		try {
			System.out.println("Initiated Method to navigate to Rewards Profile Page");
			waitForElement(btnMichaelsRewards);
			btnMichaelsRewards.click();
			/*waitForElement(btnRewardsProfile1);
			btnRewardsProfile1.click();	*/
			waitForAndClickElement(btnRewardsProfile1);
			if(isElementDisplayed(rewardsProfile_Page))
				flag=true;
		}
		catch (Exception e) {
			System.out.println("Unable to navigate to Rewards Profile Page" + e);
			return false;
		}		
		return flag;
	}

	
	public boolean clickOnCouponsPage() {
	
				try {
					Log.info("Initiated Method to Click on SignIn Button ");	
					waitForAndClickElement(btnCouponMain);
					return true;
				}
				catch (Exception e) {
					System.out.println("Unable to Click on SignIn Button" + e);
					return false;
				}

			}
	
	public boolean clickOnSetMyStore() {
	
				try {
					Log.info("Initiated Method to Click on SetMyStore ");	
					waitForAndClickElement(lblMyStore);
					return true;
				}
				catch (Exception e) {
					System.out.println("Unable to Click on SetMyStore" + e);
					return false;
				}

			}
	
	
	public boolean navigateBackFromSetMyStore() {
		
		try {
			Log.info("Initiated Method to Click on Back button ");	
			waitForAndClickElement(flxBackToProducts);
			return true;
		}
		catch (Exception e) {
			System.out.println("Unable to Click on Back button" + e);
			return false;
		}

	}
	
public boolean verifyStoreSet() {		
		try {
			Log.info("Initiated Method to verify MyStore Set ");	
			if(isElementDisplayed(lblMyStoreName))
			flag= true;
		}
		catch (Exception e) {
			System.out.println("Unable to verify MyStore Set " + e);
			return false;
		}
		return flag;
	}


public boolean verifySetRegionFrench() {		
	try {
		Log.info("Initiated Method to change to French locale ");
		settingsMenu.click();
		lblRegionLanguageValue.click();
		btnLangRegion3.click();
		if(isElementDisplayed(oHomePage.home_logo))
		flag= true;
	}
	catch (Exception e) {
		System.out.println("Unable to verify MyStore Set " + e);
		return false;
	}
	return flag;
}
	
}
