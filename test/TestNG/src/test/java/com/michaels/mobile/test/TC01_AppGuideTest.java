package com.michaels.mobile.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.michaels.mobile.pages.AppGuidePage;



public class TC01_AppGuideTest extends DriverTest{
	
	AppGuidePage oAppGuidePage;
		
	@BeforeClass
	public void setUpPage() {

		oAppGuidePage = new AppGuidePage(driver);
		
	}
	
	
	@Test
	public void tC01_appGuideTest() {
		try {
			if (oAppGuidePage.verifyAppGuide()) {
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
