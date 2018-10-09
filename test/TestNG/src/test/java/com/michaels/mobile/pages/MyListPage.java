package com.michaels.mobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class MyListPage extends DriverPage{

	boolean flag = false;

	public MyListPage(RemoteWebDriver driver) {
		super(driver);		
	}

	// Locators in More form
	@iOSFindBy(xpath = "//*[@label='MY LIST']")
	@AndroidFindBy(xpath = "//*[@text='MY LIST']")
	public WebElement myList_Page;
	
	@FindBy(id = "btnDeleteAll")
	public WebElement btnDeleteAll;

	// Methods that performs operations in Form

	public boolean verifyMyListPage() {

		try {
			System.out.println("Initiated Method to verify MyList Page is displayed ");			
			if(isElementDisplayed(myList_Page))
			return true;
			else
				return false;
		}
		catch (Exception e) {
			System.out.println(" MyList Page is not displayed" + e);
			return false;
		}

	}
	
	
	public boolean verifyDeleteAll() {

		try {
			System.out.println("Initiated Method to verify DeleteAll in MyList Page");			
			if(isElementDisplayed(btnDeleteAll)){
				btnDeleteAll.click();
				return true;
			} 	else
				return false;
		}
		catch (Exception e) {
			System.out.println(" MyList Page is not displayed" + e);
			return false;
		}

	}

}
