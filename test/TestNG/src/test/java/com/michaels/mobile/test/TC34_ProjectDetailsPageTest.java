
package com.michaels.mobile.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.michaels.mobile.pages.AppGuidePage;
import com.michaels.mobile.pages.HomePage;
import com.michaels.mobile.pages.ProjectsListPage;

public class TC34_ProjectDetailsPageTest extends DriverTest {

	HomePage oHomePage;
	AppGuidePage oAppGuidePage;
	ProjectsListPage oProjectsListPage;

	@BeforeClass
	public void setUpPage() {

		oHomePage = new HomePage(driver);
		oAppGuidePage = new AppGuidePage(driver);
		oProjectsListPage= new ProjectsListPage(driver);
	}

	@Test
	public void tc34_projectDetailsPageTest() {
		try {
			assertTrue(oAppGuidePage.verifyAppGuide(), " Unable to Verify App Guide ");
			assertTrue(oHomePage.clickOnProjectsMenu()	, " Unable to click on Projects Menu");				
			if (oProjectsListPage.verifyProjectsDetailsPage()) {
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

