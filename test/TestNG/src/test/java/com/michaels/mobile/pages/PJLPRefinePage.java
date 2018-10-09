package com.michaels.mobile.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.michaels.mobile.utils.Log;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PJLPRefinePage extends DriverPage{

	ProjectsListPage oProjectsListPage;

	public PJLPRefinePage(RemoteWebDriver driver) {
		super(driver);
		oProjectsListPage= new ProjectsListPage(driver); 
	}


	@FindBy(id="flxSkillLevel")
	public WebElement flxSkillLevel;
	

	@FindBy(id="btnDone")
	public WebElement btnDone;

	@FindBy(id="btnCancel")
	public WebElement btnCancel;
	
	@iOSFindBy(id="flxRefineSkill00")
	@AndroidFindBy(xpath="//*[@resource-id='com.michaels.michaelsstores:id/flxSkillLevelCategories']//*[@class='android.view.ViewGroup' and @index='0']")	
	public WebElement selectSkillLevel;
	
	//(//*[@resource-id='com.michaels.michaelsstores:id/flxSkillLevelCategories']//*[@class='android.view.ViewGroup'])[1]
	
		
	@FindBy(id="flxTimeReq")
	private WebElement flxTimeReq;
	
	@iOSFindBy(id="flxRefineCraft00")
	@AndroidFindBy(xpath="//*[@resource-id='com.michaels.michaelsstores:id/flxTimeReqCategories']//*[@class='android.view.ViewGroup' and @index='0']")	
	public WebElement refineByCraftTime;
	
	
	public boolean verifyRefineSkillLevel(){	
		try{			
			oProjectsListPage.verifyProjectsRefinePage();
			waitForElement(flxSkillLevel);
			this.flxSkillLevel.click();
			this.selectSkillLevel.click();
			waitForElement(btnDone);
			btnDone.click();
			waitForElement(oProjectsListPage.frmProjectsList);	
			if ("MAC".equalsIgnoreCase(platformName)) {
				if(isElementDisplayed(oProjectsListPage.segProjectList))
					flag=true;

			} else {
				
			if(oProjectsListPage.flxProductDetails.size()>0){						
				flag=true;
			}
			else
				flag=false;	
			}
		}catch(Exception e){
			return false;
		}
		return flag;

	}
	
	public boolean verifyRefineByCraftingTime(){	
		try{			
			oProjectsListPage.verifyProjectsRefinePage();
			waitForElement(flxSkillLevel);
			this.flxTimeReq.click();
			this.refineByCraftTime.click();
			waitForElement(btnDone);
			btnDone.click();
			waitForElement(oProjectsListPage.frmProjectsList);	
			if ("MAC".equalsIgnoreCase(platformName)) {
				if(isElementDisplayed(oProjectsListPage.segProjectList))
					flag=true;

			} else {
			if(oProjectsListPage.flxProductDetails.size()>0){						
				flag=true;
			}
			else
				flag=false;	
			}
		}catch(Exception e){
			return false;
		}
		return flag;

	}
	
	
	


}
