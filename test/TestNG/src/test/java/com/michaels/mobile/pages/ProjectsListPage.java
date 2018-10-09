package com.michaels.mobile.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

import com.michaels.mobile.pages.HomePage;

public class ProjectsListPage extends DriverPage{

	HomePage oHomePage;

	public ProjectsListPage(RemoteWebDriver driver) {
		super(driver);
		oHomePage=new HomePage(driver);
	}



	@FindBy(id="frmProjects")
	public WebElement frmProjects;
	
	@iOSFindBy(xpath="//XCUIElementTypeButton[@name='btnCategoryName0']")
	@AndroidFindBy(xpath="(//*[@resource-id='com.michaels.michaelsstores:id/flxMainContainer']//*[@class='android.view.ViewGroup'])[1]")
	public WebElement projects_page1;
	
	@iOSFindBy(xpath="//XCUIElementTypeCell[@name='segCateogories_1_1']")
	public WebElement projects_page2_element1;
	
	@FindBy(id="flxCategoryList")
	public List<WebElement> lst_projectcategory;


	@FindBy(id="frmProjectsList")
	public WebElement frmProjectsList;
	
	@FindBy(id="segProjectList")
	public WebElement segProjectList;
	
	@FindBy(id="flxProductDetails")
	public List<WebElement> flxProductDetails;
	
	@iOSFindBy(xpath="//XCUIElementTypeCell[@name='segProjectList_1_1']")
	public WebElement segProjectList_element1;
	
	@FindBy(id="frmPJDP")	
	public WebElement frmPJDP;
	
	@FindBy(id="btnRefineSearch")
	private WebElement btnRefineSearch;
	
	@FindBy(id="frmRefineProjects")
	private WebElement frm_RefineProjects;
	
	
	public boolean verifyProjectsLandingPage(){		
		waitForElement(frmProjects);
		if(isElementDisplayed(frmProjects)){
			System.out.println("Projects Landing Page is displayed");
			return true;
		}				
		else
			return false;

	}

	
	public boolean verifyProjectsListPage(){	
		try{

			verifyProjectsLandingPage();
			waitForElement(projects_page1);
			projects_page1.click();
			Thread.sleep(2000);			
			if ("MAC".equalsIgnoreCase(platformName)) {
				projects_page2_element1.click();							

			} else {
			lst_projectcategory.get(0).click();			
			waitForElement(frmProjectsList);
			}
			if(isElementDisplayed(frmProjectsList)){
				waitForElement(segProjectList);
				flag=true;
			}else
				flag=false;			

		}catch(Exception e){
			return false;
		}
		return flag;

	}
	
	public boolean verifyProjectsListPageScrollTest(){	
		try{

			verifyProjectsListPage();
			if(isElementDisplayed(segProjectList)){
				if ("MAC".equalsIgnoreCase(platformName)) {

					scrolliOS("down", By.className("XCUIElementTypeTable"));					

				} else {
				scrollUp();
				Thread.sleep(1000);
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
	
	
	public boolean verifyProjectsDetailsPage(){	
		try{

			verifyProjectsListPage();
			if ("MAC".equalsIgnoreCase(platformName)) {
				waitForElement(segProjectList_element1);
				segProjectList_element1.click();					

			}else
			flxProductDetails.get(0).click();
			waitForElement(frmPJDP);
			if(isElementDisplayed(frmPJDP)){						
				flag=true;
			}else
				flag=false;			

		}catch(Exception e){
			return false;
		}
		return flag;

	}
	
	
	public boolean verifyProjectsRefinePage(){	
		try{

		//	verifyProductsListPage();
			waitForElement(btnRefineSearch);
			btnRefineSearch.click();
			waitForElement(frm_RefineProjects);
			if(isElementDisplayed(frm_RefineProjects)){						
				flag=true;
			}else
				flag=false;			

		}catch(Exception e){
			return false;
		}
		return flag;

	}
}



