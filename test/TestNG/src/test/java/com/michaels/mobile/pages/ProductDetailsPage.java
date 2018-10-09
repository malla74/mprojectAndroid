package com.michaels.mobile.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

import com.michaels.mobile.pages.HomePage;

public class ProductDetailsPage extends DriverPage{

	
	ProductListPage oProductListPage;
	SignInPage oSignInPage;
	
	String text;

	public ProductDetailsPage(RemoteWebDriver driver) {
		super(driver);
		
		oProductListPage= new ProductListPage(driver);
		oSignInPage = new SignInPage(driver);
	}


	
	@FindBy(id="btnAddToShoppingList")
	public WebElement btnAddToShoppingList;
	
	@iOSFindBy(id = "OK")
	@AndroidFindBy(id="android:id/button3")
	public WebElement btnOK;
	
	@iOSFindBy(xpath="//XCUIElementTypeButton[@name='SIGN IN']")	
	@AndroidFindBy(id="android:id/button1")
	public WebElement btnSignIn;
	
	@FindBy(id="btnBuyOnline2")
	public WebElement btnBuyOnline;
	
	@FindBy(id="checkNearByStores")
	public WebElement checkNearByStores;
	
	@FindBy(id="flxListView")
	public WebElement flxListView;
	
	@FindBy(id="lblRecomProducts")
	public WebElement lblRecomProducts;
	
	@FindBy(id="ShowMoreProducts")
	public WebElement showMoreProducts;
	
	@FindBy(id="frmPDP")
	public WebElement frm_PDP;
	
	
	@FindBy(id="lblItemNumber")
	public WebElement lblItemNumber;
	
	
	
	public boolean addToMyList(){	
		try{
			oProductListPage.verifyProductDetailsPage();
			btnAddToShoppingList.click();
			waitForElement(btnOK);
			btnOK.click();		
			flag=true;
		}catch(Exception e){
			return false;
		}
		return flag;
	}
	
	
	public boolean addToMyListNotLoggedIn(String Useremail, String Password){	
		try{

			oProductListPage.verifyProductDetailsPage();
			btnAddToShoppingList.click();
			btnSignIn.click();
			oSignInPage.enterSignInDetails(Useremail, Password);
			waitForElement(btnOK);
			btnOK.click();		
			flag=true;
		}catch(Exception e){
			return false;
		}
		return flag;
	}
	
	
	public boolean buyOnline(){	
		try{

			oProductListPage.verifyProductDetailsPage();
			text="BUY ONLINE";
			if ("MAC".equalsIgnoreCase(platformName)) {
				
				//scrollToTextIos(text);

			} else {
			scrollUp();	
			}
			btnBuyOnline.click();
			Thread.sleep(2000);
			if(isElementDisplayed(androidWebView))
				flag=true;					
			else
				flag=false;
		
		}catch(Exception e){
			return false;
		}
		return flag;
	}
	
	public boolean checkNearByStores(){	
		try{

			oProductListPage.verifyProductDetailsPage();
		//	text="CHECK NEARBY STORES";
			//text="BUY ONLINE";
			if ("MAC".equalsIgnoreCase(platformName)) {
				scrollToTextIos("CHECK NEARBY STORES");
				
				//scrolliOS("down", By.id("checkNearByStores"));
			} else {
			scrollUp();
			}
			waitForAndClickElement(checkNearByStores);
			//checkNearByStores.click();
			if(isElementDisplayed(flxListView))
				flag=true;					
			else
				flag=false;
		
		}catch(Exception e){
			return false;
		}
		return flag;
	}
	
	
	public boolean checkRecommendedProductsShowMore(){	
		try{

			oProductListPage.verifyProductDetailsPage();
			if ("MAC".equalsIgnoreCase(platformName)) {
			//	scrollToTextIos("RECOMMENDED PRODUCTS");
				scrollDowntoTextiOS(4,"RECOMMENDED PRODUCTS","down");
				if(isElementDisplayed(lblRecomProducts))	{
					
					scrollToTextIos("SHOW MORE");
					if(isElementDisplayed(showMoreProducts))
						flag=true;
					else
					flag=false;
				}
			} else {			
		
			scrollDowntoText("RECOMMENDED PRODUCTS",4);
			
			if(isElementDisplayed(lblRecomProducts))	{
				
				scrollDowntoText("SHOW MORE",4);
				if(isElementDisplayed(showMoreProducts))
					flag=true;
			} else
				flag=false;
			}
		
		}catch(Exception e){
			return false;
		}
		return flag;
	}
	
	public boolean checkShowMoreUpto15Products(){	
		try{

			oProductListPage.verifyProductDetailsPage();		
			for (int i=0;i<4;i++) {				  

				System.out.println("Loop no:"+i);
				if ("MAC".equalsIgnoreCase(platformName)) {
					scrollToTextIos("SHOW MORE");
					if(isElementDisplayed(showMoreProducts)){
						showMoreProducts.click();						
					}
					
				}else{
				
				scrollDowntoText("SHOW MORE",6);

				if(isElementDisplayed(showMoreProducts)){
					showMoreProducts.click();					
				}				
				scrollUp();
				Thread.sleep(2000);
				scrollUp();
			}
			
			}
			if(!isElementDisplayed(showMoreProducts))
				flag=true;

		}catch(Exception e){
			return false;
		}
		return flag;
	}

}



