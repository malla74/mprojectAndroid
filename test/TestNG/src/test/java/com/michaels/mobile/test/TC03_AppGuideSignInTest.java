package com.michaels.mobile.test;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.michaels.mobile.pages.AppGuidePage;
import com.michaels.mobile.pages.SignInPage;
import com.michaels.mobile.utils.ExcelUtility;


public class TC03_AppGuideSignInTest extends DriverTest{
	
	AppGuidePage oAppGuidePage;
	SignInPage oSignInPage;
	//String USER_EMAIL =ExcelUtility.getData("TC01","Username");
	//String PASSWORD = ExcelUtility.getData("TC01","SignInPassword");
	String USER_EMAIL="prod@mail.com";	
	String PASSWORD="Test1234";	
	
	@BeforeClass
	public void setUpPage() {

		oAppGuidePage = new AppGuidePage(driver);
		oSignInPage = new SignInPage(driver);
	}
	
	
	@Test
	public void tc03_appGuideSignInTest() {
		try {	
				
			assertTrue(oAppGuidePage.verifySignIn(), " Unable to Verify SignIn From App Guide ");
			if(oSignInPage.enterSignInDetails(USER_EMAIL, PASSWORD)) {
				passTestCase("******* Test Case PASSED ******* " + Thread.currentThread().getStackTrace()[1].getMethodName());
			} else {				
				failTestCase("******* Test Case FAILED ******* " + Thread.currentThread().getStackTrace()[1].getMethodName());
			}
		} catch (Exception e) {

		}
	}
	
	@AfterClass
	public void closeApp() {
		System.out.println("\n Closing the Driver");
		driver.quit();
	}

}
