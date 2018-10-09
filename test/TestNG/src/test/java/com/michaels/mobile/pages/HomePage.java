package com.michaels.mobile.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.michaels.mobile.utils.Log;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomePage extends DriverPage{
	
	ProductListPage oProductListPage;
	ProductDetailsPage oProductDetailsPage;
	
	boolean flag = false;
	
	
	public HomePage(RemoteWebDriver driver) {
		super(driver);			
		oProductListPage= new ProductListPage(driver);
		oProductDetailsPage= new ProductDetailsPage(driver);
	}

	// Locators in Home form
		@FindBy(id = "btnHome")
		public WebElement home_btn;
		
		@FindBy(id = "imgLogo")
		public WebElement home_logo;
		
	
		@FindBy(id = "btnMore")
		public WebElement more_menu;
		
		@FindBy(id = "fxlContainer")
		public WebElement fxlContainerTile;
		
		@FindBy(id = "btnChooseStore")
		public WebElement btn_ChooseStore;
		
		@FindBy(id = "textSearch")
		public WebElement text_Search;
		
		@FindBy(id = "flexCarouselContainer")
		public WebElement flex_CarouselContainer;
		
		@FindBy(id = "frmProductCategoryMore")
		public WebElement frm_ProductCategoryMore;
		
		@FindBy(id = "frmWeeklyAdHome")
		public WebElement frm_WeeklyAd;
		
		@FindBy(id="frmEvents")
		private WebElement frm_Events;
				
	@iOSFindBy(id = "WebView")
	@AndroidFindBy(className = "android.webkit.WebView")
	private WebElement androidWebView;
		
		@AndroidFindBy(id = "android:id/button2")
		private WebElement btn_No;
		
		@iOSFindBy(id = "SELECT STORE")
		@AndroidFindBy(id = "android:id/button1") 
		WebElement btn_Yes;
		
		@FindBy(id = "btnListView")
		public WebElement btn_ListView;
		
	@iOSFindBy(id = "segStoresListView_1_1_btnFavorite")
		@AndroidFindBy(xpath="(//*[@resource-id='com.michaels.michaelsstores:id/btnFavorite'])[2]")
		public WebElement btn_Favorite;
		
		
	@iOSFindBy(id = "flxFooterWrap")
	public WebElement flx_footer;
	
		@AndroidFindBy(xpath="(//*[@text='Get Coupon' and @index='0'])[1]")
		public WebElement homeTile;
		
		@AndroidFindBy(xpath="(//*[@text='Get Coupon' and @index='0'])[2]")
		public WebElement homeTile2;
		
	@iOSFindBy(id = "Image0fc33bd2b89234e0")
	public WebElement homePageTile;
	
	@iOSFindBy(id = "Search")
	public WebElement searchButton_iOS;
	
		@FindBy(id="frmCoupons")
		public WebElement frmCoupons;
		
		@FindBy(id="btnProducts")
		public WebElement shopMenu;
		
		@FindBy(id="btnProjects")
		public WebElement projectsMenu;
		
		@FindBy(id="btnMyLists")
		public WebElement btnMyLists;
		
		@iOSFindBy(xpath="//XCUIElementTypeButton[@name='SIGN IN']")
		public WebElement btnSignIn;
		
		@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView[2]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")
		private WebElement homeKeypad_search;
		
		@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[5]/android.widget.TextView")	 
		public WebElement keypad_Search;
		
		@FindBy(id="btnProjects")
		public WebElement btnProjects;
		
		
		@FindBy(id="btnProducts")
		public WebElement btnProducts;
		
		@FindBy(id="lblProducts")
		public WebElement lblProducts;
		
		@FindBy(id="lblChevron")
		public WebElement lblChevron;
		
		@FindBy(id="lblAdressStore1")
		private WebElement lblAdressStore1;
		
		@FindBy(id="lblContactNo")
		private WebElement lblContactNo;
		
		@AndroidFindBy(id="com.android.contacts:id/digits")
		private WebElement storeContactNo;
		
		@iOSFindBy(id="Call")
		private WebElement btnCall;
		
		@iOSFindBy(id="Cancel")
		private WebElement btnCancel;
		
		
		@iOSFindBy(xpath="(//XCUIElementTypeButton[@name='btnStoreMap'])[1]")
		@FindBy(id="btnStoreMap")
		private WebElement btnStoreMap;		
		
		@FindBy(id="btnDepartments") 
		public WebElement btnDepartments;
		
		
		@FindBy(id="btnAisles")
		public WebElement btnAisles;
		
		@iOSFindBy(id="Michaels Store Map")
		private WebElement storeMapiOS;
		
		@FindBy(id="btnStoreInfo")
		private WebElement btnStoreInfo;
		
		@FindBy(id="flxMyStoreDetailsNew")
		private WebElement flxMyStoreDetailsNew;
		
		@FindBy(id="btnStoreMapMap")
		private WebElement btnStoreMapMap;
		
		@FindBy(id="lblStoreHours")
		private WebElement lblStoreHours;
		
		@FindBy(id="btnCoupon")
		private WebElement btnCoupon;
		
		@FindBy(id="btnChangeStore")
		private WebElement btnChangeStore;
		
		@iOSFindBy(id = "segStoresListView_1_2_btnFavorite")
		@AndroidFindBy(xpath="(//*[@resource-id='com.michaels.michaelsstores:id/btnFavorite'])[3]")
		public WebElement btn_Favorite2;
		
		@FindBy(id="btnFavoriteMyStore")
		private WebElement btnFavoriteMyStore;
		
		// Methods that performs operations in Form
		
		public boolean verifyHomeFormOnSecondLaunch(){

			waitForElement(home_logo);
			if(this.home_btn.isDisplayed()){
				System.out.println("Home Page is displayed");
				return true;
			} else
				return false;

		}
				
		public boolean clickOnMoreMenu() {

			try {
				Log.info("Initiated Method to Click on More Menu ");
	if ("MAC".equalsIgnoreCase(platformName)) {

				waitForElement(flx_footer);
				more_menu.click();				
				return true;
				}else{
		waitForElement(fxlContainerTile); 				
				more_menu.click();
					return true;
				}
		}	 catch (Exception e) {
				Log.info("Unable to Click on More Menu" + e);
				return false;
			}

		}
		
		
		public boolean clickOnMoreMenuSignIn() {

			try {
				Log.info("Initiated Method to Click on More Menu ");
				waitForElement(fxlContainerTile); 
				if(isElementDisplayed(btn_No))
					btn_No.click();				
				more_menu.click();
					return true;
				}
			 catch (Exception e) {
				Log.info("Unable to Click on More Menu" + e);
				return false;
			}

		}
		
		public boolean verifyCarousel() {

			try {
				Log.info("Initiated Method to Verify Carousel ");
				waitForElement(fxlContainerTile); 
				if(isElementDisplayed(flex_CarouselContainer))
					return true;
				else
					return false;
				}
			 catch (Exception e) {
				Log.info("Unable to find Verify Carousel" + e);
				return false;
			}

		}
		
		
		public boolean verifyCarouselclickInApp() {

			try {
				Log.info("Initiated Method to Verify Carousel ");				
				waitForElement(flex_CarouselContainer);
				waitForElement(fxlContainerTile);
				flex_CarouselContainer.click();
				if(isElementDisplayed(btn_Yes))
				{
					setFavStore("12345");
				}
											
				Thread.sleep(3000);				
				if(isElementDisplayed(frm_WeeklyAd) || isElementDisplayed(frm_ProductCategoryMore)|| isElementDisplayed(androidWebView) || isElementDisplayed(frm_Events))
					return true;		
					
				else
					return false;
				}
			 catch (Exception e) {
				Log.info("Unable to find Verify Carousel" + e);
				return false;
			}

		}
	
		public boolean verifyhomeTilesclick() {

			try {
				Log.info("Initiated Method to Verify Tile navigation ");
				waitForElement(fxlContainerTile);
				if ("MAC".equalsIgnoreCase(platformName)) {
				waitForElement(fxlContainerTile);
				homePageTile.click();
				Thread.sleep(1000);
				if (isElementDisplayed(btn_Yes)) {
					setFavStore("12345");
					waitForElement(frmCoupons);
					if (isElementDisplayed(frmCoupons))
						flag = true;
				} else if (isElementDisplayed(androidWebView))
					flag = true;
				else
					flag = false;
			} else {
				//scrollUp();
				homeTile.click();
				Thread.sleep(1000);
				if(isElementDisplayed(btn_Yes)){
					setFavStore("12345");
					if(isElementDisplayed(frmCoupons))
						flag=true;
				}else if(isElementDisplayed(androidWebView))
						flag=true;					
				else
					flag=false;
				}
			}	
			 catch (Exception e) {
				Log.info("Unable to find Verify Tile navigation" + e);
				return false;
			}
			
			return flag;
		}
		
		
		public boolean verifyhomeTile2click() {

			try {
				Log.info("Initiated Method to Verify Tile navigation ");
				waitForElement(fxlContainerTile);
				if ("MAC".equalsIgnoreCase(platformName)) {
				waitForElement(fxlContainerTile);
				homePageTile.click();
				Thread.sleep(1000);
				if (isElementDisplayed(btn_Yes)) {
					setFavStore("12345");
					waitForElement(frmCoupons);
					if (isElementDisplayed(frmCoupons))
						flag = true;
				} else if (isElementDisplayed(androidWebView))
					flag = true;
				else
					flag = false;
			} else {
				scrollUp();
				homeTile2.click();
				Thread.sleep(1000);
				if(isElementDisplayed(btn_Yes)){
					setFavStore("12345");
					if(isElementDisplayed(frmCoupons))
						flag=true;
				}else if(isElementDisplayed(androidWebView))
						flag=true;					
				else
					flag=false;
				}
			}	
			 catch (Exception e) {
				Log.info("Unable to find Verify Tile navigation" + e);
				return false;
			}
			
			return flag;
		}
		
		
		public boolean verifyHomeTiles() {

			try {
				Log.info("Initiated Method to Click on More Menu ");
				waitForElement(fxlContainerTile); 				
				if(isElementDisplayed(fxlContainerTile))
					flag=true;
				}
			 catch (Exception e) {
				Log.info("Unable to Click on More Menu" + e);
				return false;
			}
			 return flag;
		}
		
		
		
		public boolean setFavStore(String SearchString) {

			try {
				Log.info("Initiated Method to Select Store");
				waitForElement(btn_Yes); 
				if(isElementDisplayed(btn_Yes))
					btn_Yes.click();
				waitForElement(text_Search);					
					text_Search.sendKeys(SearchString);
					//	text_Search.click();

					if ("MAC".equalsIgnoreCase(platformName)) {
						searchButton_iOS.click();

					} else {
						driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[5]/android.widget.TextView").click();
						/*        Map<String, Object> EnterKeyEvent  = new HashMap<>();
		              EnterKeyEvent.put("key", "66");
		              ((RemoteWebDriver) driver).executeScript("mobile:key:event", EnterKeyEvent);*/

					}						
					Thread.sleep(5000);
					btn_ListView.click();
					btn_Favorite.click();
					flag= true;
				
			}
			catch (Exception e) {
				Log.info("Unable to find Select Store" + e);
				return false;
			}
				return flag;
		}
		
		
		public boolean clickOnShopMenu() {

			try {
				Log.info("Initiated Method to Click on Shop Menu ");
				Reporter.log("Initiated Method to Click on Shop Menu ");
				waitForElement(fxlContainerTile); 				
				shopMenu.click();
					return true;
				}
			 catch (Exception e) {
				Log.info("Unable to Click on Shop Menu" + e);
				return false;
			}

		}
		
		public boolean clickOnProjectsMenu() {

			try {
				Log.info("Initiated Method to Click on Projects Menu ");
				waitForElement(fxlContainerTile); 				
				projectsMenu.click();
					return true;
				}
			 catch (Exception e) {
				Log.info("Unable to Click on Projects Menu" + e);
				return false;
			}

		}
		
		
		public boolean verifyTextSearchWithOneWord(String SearchString) {

			try {
				
				Log.info("Initiated Method to verify Text Search with One Word ");
				waitForElement(fxlContainerTile); 
				waitForElement(text_Search); 				
				text_Search.sendKeys(SearchString);		
				if ("MAC".equalsIgnoreCase(platformName)) {
					searchButton_iOS.click();
				} else {
				homeKeypad_search.click();
				}
				waitForElement(oProductListPage.frmProductsList);
				if(isElementDisplayed(oProductListPage.segProductsList))				
					flag=true;
				}
			 catch (Exception e) {
				Log.info("Unable to Click on do a text Search" + e);
				return false;
			}
			return flag;
		}

		
		public boolean clickOnMyListMenu() {

			try {
				Log.info("Initiated Method to Click on More Menu ");
				waitForElement(fxlContainerTile); 				
				btnMyLists.click();
					return true;
				}
			 catch (Exception e) {
				Log.info("Unable to Click on More Menu" + e);
				return false;
			}

		}
		
		
		public boolean clickOnSignInFromMyListMenu() {

			try {
				clickOnMyListMenu();
				if ("MAC".equalsIgnoreCase(platformName)) {
					btnSignIn.click();
				} else 						
				btn_Yes.click();
					return true;
				}
			 catch (Exception e) {
				Log.info("Unable to Click on More Menu" + e);
				return false;
			}

		}
		
		public boolean clickOnCarousel_navigateOutofApp() {
		// Done Porting
		try {
			Log.info("Initiated Method to Click on Carousel ");
			waitForElement(flex_CarouselContainer);
			Thread.sleep(5000);
			flex_CarouselContainer.click();
			// setFavStore();
			if (isElementDisplayed(androidWebView))
				return true;
			else
				return false;

		} catch (Exception e) {
			System.out.println("Unable to find Verify Carousel" + e);
			return false;
		}

	}
		
		public boolean verifySetFavouriteStoreUsingZipCode(String SearchString) {

			try {
				Log.info("Initiated Method to Set Favourite Store ");				
				waitForElement(fxlContainerTile);				
				waitForAndClickElement(btn_ChooseStore);
				setFavStore(SearchString);					
				lblProducts.click();				
				waitForAndClickElement(lblChevron);				
				if(lblAdressStore1.getText().contains("NY"))
					flag= true;					
				}
			 catch (Exception e) {
				Log.info("Unable to find Verify Carousel" + e);
				return false;
			}
				return flag;
		}
		
		public boolean verifySetFavouriteStoreUsingAddress(String SearchString) {

			try {
				Log.info("Initiated Method to Set Favourite Store ");				
				waitForElement(fxlContainerTile);				
				waitForAndClickElement(btn_ChooseStore);
				setFavStore(SearchString);				
				lblProducts.click();				
				waitForAndClickElement(lblChevron);				
				if(lblAdressStore1.getText().contains("irving"))
					flag= true;					
				}
			 catch (Exception e) {
				Log.info("Unable to find Verify Carousel" + e);
				return false;
			}
				return flag;
		}
		
		
		public boolean verifyCallStore(String SearchString) {

			try {
				Log.info("Initiated Method to Set Favourite Store ");				
				waitForElement(fxlContainerTile);				
				waitForAndClickElement(btn_ChooseStore);
				setFavStore(SearchString);				
				lblProducts.click();				
				waitForAndClickElement(lblChevron);	
				waitForAndClickElement(lblContactNo);
				if ("MAC".equalsIgnoreCase(platformName)){
					if(isElementDisplayed(btnCall))
						btnCancel.click();
						flag= true;					
				}else{				
				if(isElementDisplayed(storeContactNo))
					flag= true;					
				}
				
			} catch (Exception e) {
				Log.info("Unable to find Verify Call Store" + e);
				return false;
			}
				return flag;
		}
		
		public boolean verifyStoreMap(String SearchString) {

			try {
				Log.info("Initiated Method to Set Favourite Store ");				
				waitForElement(fxlContainerTile);				
				waitForAndClickElement(btn_ChooseStore);
				setFavStore(SearchString);				
				lblProducts.click();				
				waitForAndClickElement(lblChevron);	
				waitForAndClickElement(btnStoreMap);
				if ("MAC".equalsIgnoreCase(platformName)){
					if(isElementDisplayed(storeMapiOS))
						flag=true;
				}else{
				if(isElementDisplayed(androidWebView) && isElementDisplayed(btnDepartments) && isElementDisplayed(btnAisles))
					flag= true;					
				}
			}catch (Exception e) {
				Log.info("Unable to find Verify Store Map" + e);
				return false;
			}
				return flag;
		}
		
		public boolean verifyTextSearchWithProductId(String ProductId) {

			try {
				verifyHomeFormOnSecondLaunch();
				Log.info("Initiated Method to verify Text Search with One Word ");
				waitForElement(text_Search); 	
				text_Search.sendKeys(ProductId);
				if ("MAC".equalsIgnoreCase(platformName)) {
					searchButton_iOS.click();

				} else {				
				homeKeypad_search.click();
				}
				waitForElement(oProductDetailsPage.frm_PDP);
				//String productidcheck= oProductDetailsPage.lblItemNumber.getAttribute("text");
				/*if(productidcheck.equalsIgnoreCase(ProductId))				
					flag=true;
				}*/
			if(isElementDisplayed(oProductDetailsPage.lblItemNumber))				
				flag=true;
			}
			
			 catch (Exception e) {
				Log.info("Unable to Click on do a text Search" + e);
				return false;
			}
			return flag;
		}
		
		
		public boolean verifyTextSearchWith2Words(String Searchtext) {

			try {
				verifyHomeFormOnSecondLaunch();
				Log.info("Initiated Method to verify Text Search with One Word ");
				waitForElement(text_Search); 				
				text_Search.sendKeys(Searchtext);	
				if ("MAC".equalsIgnoreCase(platformName)) {
					searchButton_iOS.click();

				} else {
				homeKeypad_search.click();
				}
				waitForElement(btnProducts);
				if(isElementDisplayed(oProductListPage.segProductsList))				
					flag=true;
				}
			 catch (Exception e) {
				Log.info("Unable to Click on do a text Search" + e);
				return false;
			}
			return flag;
		}
		
		public boolean verifyStoreInfo(String SearchString) {

			try {
				Log.info("Initiated Method to verify Store Info");				
				waitForElement(fxlContainerTile);				
				waitForAndClickElement(btn_ChooseStore);
				setFavStore(SearchString);				
				lblProducts.click();				
				waitForAndClickElement(lblChevron);	
				waitForAndClickElement(btnStoreInfo);				
				if(isElementDisplayed(flxMyStoreDetailsNew) && isElementDisplayed(btnStoreMapMap) && isElementDisplayed(lblStoreHours))
					flag= true;					
				
			}catch (Exception e) {
				Log.info("Unable to find Verify Store Info" + e);
				return false;
			}
				return flag;
		}
		
		public boolean clickOnHomeCouponsButton() {
			
			try {
				Log.info("Initiated Method to Click on Coupons Button ");	
				waitForAndClickElement(btnCoupon);
				return true;
			}
			catch (Exception e) {
				System.out.println("Unable to Click on Coupons Button" + e);
				return false;
			}

		}
		
		
		public boolean verifyChangeFavouriteStore(String SearchString) {

			try {
				Log.info("Initiated Method to Change Favourite Store ");								
				waitForAndClickElement(btnChangeStore);
				setFavStore(SearchString);
				btn_Favorite2.click();
				lblProducts.click();				
				waitForAndClickElement(lblChevron);				
				if(lblAdressStore1.getText().contains("CA"))
					flag= true;					
				}
			 catch (Exception e) {
				Log.info("Unable to Change Favourite Store" + e);
				return false;
			}
				return flag;
		}
		
		public boolean verifyRemoveFavouriteStore() {

			try {
				Log.info("Initiated Method to Remove Favourite Store ");
				waitForAndClickElement(btnChangeStore);
				btnFavoriteMyStore.click();
				lblProducts.click();							
				if(isElementDisplayed(btn_ChooseStore))
					flag= true;					
				}
			 catch (Exception e) {
				Log.info("Unable to Remove Favourite Store" + e);
				return false;
			}
				return flag;
		}
}


