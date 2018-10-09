package com.michaels.mobile.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.michaels.mobile.utils.Log;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class RewardsProfilePage extends DriverPage{

	HomePage oHomePage;
	SignInPage oSignInPage;
	MorePage oMorePage;
	
	boolean flag = false;

	public RewardsProfilePage(RemoteWebDriver driver) {
		super(driver);
		oHomePage = new HomePage(driver);
		oSignInPage = new SignInPage(driver);
		oMorePage= new MorePage(driver);
	}

	// Locators in More form
	@FindBy(id = "txtDateOfBirth")
	public WebElement txt_DateOfBirth;
	
	@AndroidFindBy(id = "btnNext")
	public WebElement btnNext;
	
	@FindBy(id="btnNextToRewardsInterests")
	public WebElement btnNext2;
	
	@FindBy(id="txtAddress1")
	public WebElement txtAddress1;
	
	@FindBy(id="txtAddress2")
	public WebElement txtAddress2;
	
	@FindBy(id="txtCity")
	public WebElement txtCity;
	
	@iOSFindBy(id="lboxState")
	@AndroidFindBy(xpath = "//*[@text='STATE']")
	private WebElement selectState;
	
	@AndroidFindBy(xpath = "//*[@resource-id='android:id/text1']")
	private List<WebElement> listStates;
	
	
	@iOSFindBy(id="segChildAgeLevel_1_1_txtChild")
	@FindBy(id="txtChild")
	public WebElement txtChild ;
	
	@iOSFindBy(xpath="//*[@label='SKIP']")
	@AndroidFindBy(xpath="//*[@text='SKIP']")
	private WebElement btnSkip;

	@FindBy(id="imgCheckAgree")
	public WebElement imgCheckAgree ;
	
	@FindBy(id="btnCompleteProfile")
	public WebElement btnCompleteProfile ;
	
	@iOSFindBy(xpath="//*[@label='Congratulations, you’re all set up. Cue the free perks!']")
	@AndroidFindBy(xpath="//*[@text='Congratulations, you’re all set up. Cue the free perks!']")
	private WebElement successMessage;
	
	@FindBy(id="btnYes")
	public WebElement btnYes ;
	
	@FindBy(id="btnOk")
	private WebElement btnOk;

	// Methods that performs operations in Form


	
	
	public boolean setUpRewardsProfile() {

		try {
			System.out.println("Initiated Method to Setup Rewards Profile ");	
			waitForElement(txt_DateOfBirth);
			enterText(txt_DateOfBirth, "06/27");			
			btnNext.click();
			enterText(txtAddress1, "Address1");
			enterText(txtAddress2, "Address2");
			enterText(txtCity, "Alabama");
			selectState.click();
			if ("MAC".equalsIgnoreCase(platformName)) {
			driver.findElement(By.xpath("//XCUIElementTypePickerWheel")).sendKeys("Alabama");			
			driver.findElement(By.xpath("//*[@label='Done']")).click();
			btnNext.click();
			enterText(txtChild, "1");//
			btnNext2.click();			
			scrollToTextIos("SKIP");
			btnSkip.click();
			}
			else{
				listStates.get(1).click();
				btnNext.click();
				enterText(txtChild, "1");//
				btnNext2.click();			
				scrollDowntoText("SKIP",3);
				btnSkip.click();
			}			
			
			//Set Store is pending, Needs to be implemented. For now Skipping setting the Store
			Thread.sleep(2000);
			waitForElement(btnSkip);
			btnSkip.click();
			imgCheckAgree.click();
			btnCompleteProfile.click();			
			if(isElementDisplayed(successMessage)){
				btnYes.click();
				flag=true;
				}
			
		}
		catch (Exception e) {
			System.out.println("Unable to Setup Rewards Profile" + e);
			return false;
		}		
		return flag;
	}

}
