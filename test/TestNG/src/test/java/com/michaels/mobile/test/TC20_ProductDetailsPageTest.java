package com.michaels.mobile.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.michaels.mobile.pages.AppGuidePage;
import com.michaels.mobile.pages.HomePage;
import com.michaels.mobile.pages.ProductListPage;

public class TC20_ProductDetailsPageTest extends DriverTest {

	HomePage oHomePage;
	AppGuidePage oAppGuidePage;
	ProductListPage oProductListPage;

	@BeforeClass
	public void setUpPage() {

		oHomePage = new HomePage(driver);
		oAppGuidePage = new AppGuidePage(driver);
		oProductListPage= new ProductListPage(driver);
	}

	@Test
	public void tc20_productDetailsPageTest() {
		try {
			oAppGuidePage.verifyAppGuide();
			oHomePage.clickOnShopMenu();				
			if (oProductListPage.verifyProductDetailsPage()) {
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
