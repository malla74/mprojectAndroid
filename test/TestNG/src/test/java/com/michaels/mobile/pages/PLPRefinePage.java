package com.michaels.mobile.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.michaels.mobile.utils.Log;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PLPRefinePage extends DriverPage{

	ProductListPage oProductListPage;

	public PLPRefinePage(RemoteWebDriver driver) {
		super(driver);
		oProductListPage= new ProductListPage(driver); 
	}


	@FindBy(id="flxContainerSortOptions")
	public WebElement flxContainerSortOptions;

	@FindBy(id="flxContainerShopOptions")
	public WebElement flxContainerShopOptions;

	@FindBy(id="flxRefineContainer")
	public WebElement flxRefineContainer;

	@FindBy(id="btnDone")
	public WebElement btnDone;

	@FindBy(id="btnCancel")
	public WebElement btnCancel;

	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@value='Price: low-high']")
	@AndroidFindBy(xpath="//*[@text='Price: low-high']")
	public WebElement lowToHigh;

	@FindBy(id="lblItemPrice")
	public List<WebElement>  lblItemPrice;
	
						//@iOSFindBy(id="segProductsList_1_1_lblItemPrice")
//	@iOSFindBy(id="segProductsList_1_1_segProductsList_1_1_lblItemPrice")
	@iOSFindBy(xpath="//*[contains(@value,'$')]")
	
	private WebElement lblItemPrice1;
	
	//@iOSFindBy(id="segProductsList_1_2_segProductsList_1_2_lblItemPrice")
	@iOSFindBy(xpath="//*[contains(@value,'$')]")
	private WebElement lblItemPrice2;
	
	@FindBy(id="flxContainerShopOptions")
	public WebElement flx_ContainerShopOptions;
	
	@FindBy(id="lblSale")
	private WebElement lblSale;
	
	@FindBy(id="flxSaleCont")
	private WebElement flxSaleCont;
	
	@iOSFindBy(xpath="//*[contains(@label,'No results were found')]")
	@AndroidFindBy(xpath="//*[contains(@text(),'No results were found']")
	private WebElement noResultsFoundMessage;

	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@value='Availability']")
	@AndroidFindBy(xpath="//*[@text='Availability']")
	private WebElement refineAvailability;
	
	@iOSFindBy(id="flxRefineSubCatAvailability00")
	@AndroidFindBy(xpath="(//*[@resource-id='com.michaels.michaelsstores:id/flxRefineContainer']/descendant::*//*[@class='android.view.ViewGroup'])[1]")	
	private WebElement refineAvailability_inStore;
	
	
	public boolean verifyRefineSortBy(){
		String strPrice1;
		String strPrice2;
		float price1;
		float price2;
		try{			
			oProductListPage.verifyRefinePage();
			waitForAndClickElement(lowToHigh);
			waitForAndClickElement(btnDone);			
			waitForElement(oProductListPage.frmProductsList);
			if ("MAC".equalsIgnoreCase(platformName)){
				strPrice1= lblItemPrice1.getText().replace("$", "");				
				price1= Float.parseFloat(strPrice1);
				Log.info("Price1"+price1);			
				strPrice2= lblItemPrice2.getText().replace("$", "");			
				price2= Float.parseFloat(strPrice2);
				Log.info("Price2"+price2);
			}else{
			strPrice1= lblItemPrice.get(0).getText().replace("$", "");				
			price1= Float.parseFloat(strPrice1);
			Log.info("Price1"+price1);			
			strPrice2= lblItemPrice.get(1).getText().replace("$", "");			
			price2= Float.parseFloat(strPrice2);
			Log.info("Price2"+price2);
			}
			if(price1<=price2){						
				flag=true;
			}else
				flag=false;			

		}catch(Exception e){
			return false;
		}
		return flag;

	}
	
	
	public boolean verifyRefineShopBy(){	
		try{			
			oProductListPage.verifyRefinePage();
			waitForElement(lblSale);
			this.lblSale.click();
			this.flxSaleCont.click();
			waitForElement(btnDone);
			btnDone.click();
			waitForElement(oProductListPage.frmProductsList);					
			if(oProductListPage.flxProductItem.size()>0){						
				flag=true;
			}else if (isElementDisplayed(noResultsFoundMessage))	
				flag=true;
			else
				flag=false;			
		}catch(Exception e){
			return false;
		}
		return flag;

	}
	
	
	public boolean verifyRefineByRefine(){	
		try{			
			oProductListPage.verifyRefinePage();
			waitForElement(refineAvailability);
			this.refineAvailability.click();
			this.refineAvailability_inStore.click();
			waitForElement(btnDone);
			btnDone.click();
			waitForElement(oProductListPage.frmProductsList);					
			if(oProductListPage.flxProductItem.size()>0){						
				flag=true;
			}else if (isElementDisplayed(noResultsFoundMessage))
				flag=true;
			else
				flag=false;			
		}catch(Exception e){
			return false;
		}
		return flag;

	}


}
