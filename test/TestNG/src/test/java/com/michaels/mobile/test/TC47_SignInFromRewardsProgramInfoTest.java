

package com.michaels.mobile.test;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.michaels.mobile.pages.AppGuidePage;
import com.michaels.mobile.pages.HomePage;
import com.michaels.mobile.pages.MorePage;
import com.michaels.mobile.pages.ProjectDetailsPage;
import com.michaels.mobile.pages.ProjectsListPage;
import com.michaels.mobile.pages.SignInPage;
import com.michaels.mobile.utils.ExcelUtility;

public class TC47_SignInFromRewardsProgramInfoTest extends DriverTest {

	HomePage oHomePage;
	AppGuidePage oAppGuidePage;
	MorePage oMorePage;
	SignInPage oSignInPage;
	ProjectsListPage oProjectsListPage;
	ProjectDetailsPage oProjectDetailsPage;
	
	//String USER_EMAIL = ExcelUtility.getData("TC01", "Username");
	//String PASSWORD = ExcelUtility.getData("TC01", "SignInPassword");
	
	String USER_EMAIL="srinivas.deva@kony.com";	
	String PASSWORD="srinivas1#";	

	@BeforeClass
	public void setUpPage() {

		oHomePage = new HomePage(driver);
		oAppGuidePage = new AppGuidePage(driver);
		/*oProjectsListPage= new ProjectsListPage(driver);
		oSignInPage = new SignInPage(driver);*/

               oMorePage = new MorePage(driver);
	//	oProjectDetailsPage=new ProjectDetailsPage(driver);
	}

	@Test
	public void tc47_signInFromRewardsProgramInfoTest() {
		try {
			
			assertTrue(oAppGuidePage.verifyAppGuide(), " Unable to Verify App Guide ");
			assertTrue(oHomePage.clickOnMoreMenu(), " Unable to click on More menu ");									
			if (oMorePage.clickOnSignInFromMichaelRewards(USER_EMAIL,PASSWORD)) {
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

