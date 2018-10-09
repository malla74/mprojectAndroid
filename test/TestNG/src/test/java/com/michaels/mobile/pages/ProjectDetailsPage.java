package com.michaels.mobile.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

import com.michaels.mobile.pages.HomePage;

public class ProjectDetailsPage extends DriverPage{

	HomePage oHomePage;
	ProjectsListPage oProjectsListPage;
	SignInPage oSignInPage;
	
	String text;

	public ProjectDetailsPage(RemoteWebDriver driver) {
		super(driver);
		oHomePage=new HomePage(driver);
		oProjectsListPage= new ProjectsListPage(driver);
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
	
	@iOSFindBy(xpath="//*[@label='FIND IT']")
	@AndroidFindBy(xpath="//*[@text='FIND IT']")
	private WebElement btnFindIt;
	
	@iOSFindBy(id="Michaels Store Map")
	private WebElement storeMapiOS;
	
	public boolean addToMyList(){	
		try{
			oProjectsListPage.verifyProjectsDetailsPage();
			waitForElement(btnAddToShoppingList);
			btnAddToShoppingList.click();
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

			oProjectsListPage.verifyProjectsDetailsPage();
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
	
	public boolean addToMyListNotLoggedIn(String Useremail, String Password){	
		try{

			oProjectsListPage.verifyProjectsDetailsPage();
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
	
	
	public boolean verifyFindIt(){	
		try{

			oProjectsListPage.verifyProjectsDetailsPage();
			if ("MAC".equalsIgnoreCase(platformName)) {
				scrollToTextIos("FIND IT");
				btnFindIt.click();
				if(isElementDisplayed(storeMapiOS) && isElementDisplayed(oHomePage.btnAisles))	
				flag=true;
			}else{
				scrollDowntoText("FIND IT", 5);	
				btnFindIt.click();
				if(isElementDisplayed(androidWebView) && isElementDisplayed(oHomePage.btnAisles))	
				flag=true;
			}
			
		}catch(Exception e){
			return false;
		}
		return flag;
	}
	
	/*
	
	public boolean checkNearByStores(){	
		try{

			oProductListPage.verifyProductDetailsPage();
			text="CHECK NEARBY STORES";
			scrollUp();
			checkNearByStores.click();
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
		//	scrollDown(androiddriver, lblRecomProducts);
			scrollUp();
			Thread.sleep(1000);
			scrollUp();	
			Thread.sleep(1000);
			scrollUp();	
			Thread.sleep(1000);
			scrollTo("SHOW MORE");
			if(isElementDisplayed(lblRecomProducts) || isElementDisplayed(showMoreProducts))				
				flag=true;					
			else
				flag=false;
		
		}catch(Exception e){
			return false;
		}
		return flag;
	}*/

}



