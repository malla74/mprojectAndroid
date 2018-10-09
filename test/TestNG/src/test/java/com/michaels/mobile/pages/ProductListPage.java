package com.michaels.mobile.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

import com.michaels.mobile.pages.HomePage;
import com.michaels.mobile.utils.Log;

public class ProductListPage extends DriverPage{

	

	public ProductListPage(RemoteWebDriver driver) {
		super(driver);
		
	}


	@FindBy(id="frmProducts")
	public WebElement frmProducts;

	@iOSFindBy(id = "btnCategoryName0")
	@AndroidFindBy(xpath="//*[@resource-id='com.michaels.michaelsstores:id/flxMainContainer']//*[@class='android.view.ViewGroup' and @index='1']")
	public WebElement product_Page1;

	@FindBy(id="segCateogories")
	public List<WebElement> lst_productcategory1;

	@FindBy(id="flxCategoryList")
	public List<WebElement> lst_productcategory2;

	@iOSFindBy(id = "segCateogories_1_1_lblCategoryName")
	public WebElement productcategory_firstProduct;

	@FindBy(id="frmProductsList")
	public WebElement frmProductsList;
	
	@FindBy(id = "btnHome")
	public WebElement home_btn;
	
	@iOSFindBy(className="XCUIElementTypeCell")
	@FindBy(id="flxProductItem")
	public List<WebElement> flxProductItem;
	
	@iOSFindBy(id = "segProductsList_1_1")
	public WebElement productListPage_firstProduct;
	
	@FindBy(id="flxProductDetails1")
	public WebElement flxProductDetails;
	
	@FindBy(id="btnAddToShoppingList")
	public WebElement btnAddToShoppingList;
	
	@AndroidFindBy(id="android:id/button3")
	public WebElement btnOK;
	
	@FindBy(id="btnRefineSearch")
	public WebElement btnRefineSearch;
	
	@FindBy(id="frmSortAndRefine")
	private WebElement frm_SortAndRefine;
	
	@AndroidFindBy(xpath="//*[@text='REFINE']")
	public WebElement refinePage;
	
	@FindBy(id="segProductsList")
	public WebElement segProductsList;
	
	@iOSFindBy(id="segCateogories_1_1_btnAisle")
	@AndroidFindBy(id="lblNumber")
	private WebElement aisle_lblNumber;

	@FindBy(id="btnAisles")
	public WebElement btnAisles;
	
	@AndroidFindBy(id="com.android.packageinstaller:id/do_not_ask_checkbox")
	private WebElement neverAsk_location;
	
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_deny_button")
	private WebElement deny_location;
	
	
	public boolean verifyProductsPage(){		

		Log.info(" Initiated Method to Verify products Page ");

		if (isElementDisplayed(frmProducts)) {
			Log.info("Products Page is displayed");
			return true;
		} else
			return false;

	}

	public boolean verifyProductsListPage(){	
		try{

			verifyProductsPage();
			product_Page1.click();
			Thread.sleep(2000);
			
			if ("MAC".equalsIgnoreCase(platformName)) {
				productcategory_firstProduct.click();
				// waitForElement(oHomePage.home_btn);
				productcategory_firstProduct.click();
				Thread.sleep(2000);
			} else {
				lst_productcategory2.get(0).click();
			waitForElement(home_btn);
			Thread.sleep(10000);
			lst_productcategory2.get(0).click();
				Thread.sleep(2000);
			}		
			
			waitForElement(frmProductsList);
			if(isElementDisplayed(frmProductsList)){
				flag=true;
			}else
				flag=false;			

		}catch(Exception e){
			return false;
		}
		return flag;

	}

	public boolean verifyProductsListPageScrollTest(){	
		try{

			verifyProductsListPage();
			if(isElementDisplayed(frmProductsList)){
				if ("MAC".equalsIgnoreCase(platformName)) {

					scrolliOS("down", By.className("XCUIElementTypeTable"));					

				} else {
					scrollUp();
					scrollUp();
				}				
				flag=true;
			}else
				flag=false;			

		}catch(Exception e){
			return false;
		}
		return flag;

	}
	
	
	public boolean verifyProductDetailsPage(){	
		try{
			Log.info("Initiated Method to verify product details page ");

			verifyProductsListPage();
			if ("MAC".equalsIgnoreCase(platformName)) {
				productListPage_firstProduct.click();
			} else {
				flxProductItem.get(0).click();
				neverAsk_location.click();
				deny_location.click();
			}
			
			
			waitForElement(flxProductDetails);
			
			if (isElementDisplayed(flxProductDetails)) {
				flag = true;
			} else
				flag = false;

		} catch (Exception e) {
			return false;
		}
		return flag;

	}
	
	

	public boolean verifyRefinePage(){	
		try{

		//	verifyProductsListPage();	
			btnRefineSearch.click();
			waitForElement(frm_SortAndRefine);
			if(isElementDisplayed(frm_SortAndRefine)){						
				flag=true;
			}else
				flag=false;			

		}catch(Exception e){
			return false;
		}
		return flag;

	}
	
	
	public boolean verifyProductWayFinding(){	
		try{

			verifyProductsPage();
			product_Page1.click();
			Thread.sleep(2000);
			if(isElementDisplayed(aisle_lblNumber)){
				aisle_lblNumber.click();
				if(isElementDisplayed(androidWebView) && isElementDisplayed(btnAisles))
					flag= true;					
			}else{
				Log.info("Aisle info not available");
				flag=true;
			}
		}catch(Exception e){
			return false;
		}
		return flag;

	}

}



