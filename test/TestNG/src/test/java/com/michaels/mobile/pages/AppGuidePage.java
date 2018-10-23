package com.michaels.mobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.michaels.mobile.utils.Log;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AppGuidePage extends DriverPage{
    
    public AppGuidePage(RemoteWebDriver driver) {
        super(driver);
    }
    
    // Locators in AppGuide form
    @AndroidFindBy(id = "android:id/button1")
    public WebElement alert_OK_btn;
    
    @FindBy(id = "icon")
    public WebElement Settings_icon;
    
    @FindBy(id="flexGuideContent1")
    public WebElement launch_Appguide;
    
    @FindBy(id = "switchWidget")
    public WebElement permissions_switch;
    
    @AndroidFindBy(id = "android:id/button2")
    public WebElement alert_Cancel_btn;
    
    @FindBy(id = "lblGuideControl1")
    public WebElement btn_seewhatsnew;
    
    @FindBy(id = "flexGuideControl31")
    public WebElement btn_OK;
    
    
    @FindBy(id = "flexGuideControl41")
    public WebElement btn_Next;
    
    @FindBy(id = "flexGuideControl51")
    public WebElement btn_next_turnOn_bluetooth;
    @FindBy(id = "flexGuideControl61")
    public WebElement btn_SignIn;
    
    @FindBy(id = "flexGuideControl62")
    public WebElement btn_CreateAnAccount;
    
    @FindBy(id = "lblGuideControl63")
    public WebElement btn_Skip1;
    
  
    @iOSFindBy(id = "flexGuideControl21")
    public WebElement btn_Allow_Location;
    
   @iOSFindBy(id = "Allow")
   public WebElement btn_Allow;
    
    @iOSFindBy(id = "Allow")
    public WebElement btn_allow_pushNotifications;
    
    @iOSFindBy(id = "Always Allow")
    public WebElement btn_AlwaysAllow_location;
    
    @iOSFindBy(id = "Don't Allow")
    public WebElement btn_dontAllow_location;
    
    @iOSFindBy(id = "flexGuideControl51")
    public WebElement btn_Next1;
    
    //@iOSFindBy(id = "flexGuideControl41")
    //public WebElement btn_NEXT;
    
    //@iOSFindBy(id = "flexGuideControl41")
    //public WebElement btn_NEXT1;
    
   @iOSFindBy(id = "flexGuideControl63")
    public WebElement btn_Skip;
    
    @AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
    public WebElement btnAllow;
    
    @AndroidFindBy(xpath="//*[@text='Deny']")
    public WebElement btnDeny;
    
    @AndroidFindBy(id = "android:id/button2")
    public WebElement btnDenyLocationAccess;
    
    /*
     * @FindBy(id = "lblGuideControl1") public WebElement btn_seewhatsnew;
     *
     * @FindBy(id = "lblGuideControl1") public WebElement btn_seewhatsnew;
     */
    
    // Methods that performs operations in the Form
    
    
    
    public boolean verifyAppGuide(){
        
        try{
            Log.info("Initiated Method to Verify app guide Malla 1 and land on Home page ");
            waitForElement(launch_Appguide);
            if ("MAC".equalsIgnoreCase(platformName)) {
                btn_seewhatsnew.click();
                System.out.println("see whats new");
                btn_Allow_Location.click();
                System.out.println("AllowLocation");
                
                btn_Allow.click();
                System.out.println("Allow");
                
                btn_OK.click();
                System.out.println("Ok");
                btn_allow_pushNotifications.click();
                System.out.println("allow_pushNotifications");
                //Thread.sleep(5000);
                
               btn_AlwaysAllow_location.click();
               System.out.println("AlwaysAllow");
                
                
                
               
               
                btn_Next.click();
                System.out.println("Next");
                
                //btn_AlwaysAllow_location.click();
                //System.out.println("AllowAlways_location");
                
                btn_Next1.click();
                System.out.println("Next1");
             //   btn_NEXT2.click();
               // System.out.println("NEXT2");
                
                btn_next_turnOn_bluetooth.click();
                System.out.println("next_turnOn_bluetooth");
                btn_Skip.click();
                System.out.println("SKIP");
                
           
                return true;
                
               
            } else {
                btn_seewhatsnew.click();
                System.out.println("see whats new");
                waitForElement(btn_OK);
                System.out.println("OK clicked");
                btn_OK.click();
                System.out.println("before Deny for push clicked");
                btnDeny.click();
                System.out.println("After Deny for push");
                Thread.sleep(5000);
                System.out.println("Push alert Allow clicked");
                
                //alert_OK_btn.click();
                
                btn_Next.click();
                System.out.println("NEXT clicked");
                
                //waitForElement(btnAllow);
                System.out.println("before allowalways location");
                waitForElement(btnAllow);
                btnAllow.click();
                System.out.println("after ALLOW location clicked");
                //btnDeny.click();
                Thread.sleep(4000);
                /*waitForAndClickElement(btnDenyLocationAccess);
                 waitForElement(alert_Cancel_btn);//turning off bluetooth
                 alert_Cancel_btn.click();*/
                Thread.sleep(5000);
                waitForAndClickElement(btn_Next);
                waitForAndClickElement(btn_Next);
                waitForAndClickElement(btnDeny);//
                btn_Skip.click();
            }
            return true;
        }catch(Exception e){
            Log.warn("App guide Verification Failed "+e);
            return false;
        }
        
  }}



/*
package com.michaels.mobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.michaels.mobile.utils.Log;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AppGuidePage extends DriverPage{

	public AppGuidePage(RemoteWebDriver driver) {
		super(driver);		
	}
	
	// Locators in AppGuide form
		
	@AndroidFindBy(id = "android:id/button1")
		public WebElement alert_OK_btn;
		
		@FindBy(id = "icon")
		public WebElement Settings_icon;
		
		@FindBy(id="flexGuideContent1")
		public WebElement launch_Appguide;

		@FindBy(id = "switchWidget")
		public WebElement permissions_switch;		

		@AndroidFindBy(id = "android:id/button2")
		public WebElement alert_Cancel_btn;
		
		@FindBy(id = "lblGuideControl1")
		public WebElement btn_seewhatsnew;	
		
		@FindBy(id = "flexGuideControl31")
		public WebElement btn_OK;	
		
		
		@FindBy(id = "flexGuideControl41")
		public WebElement btn_Next;	
		
	@FindBy(id = "flexGuideControl51")
	public WebElement btn_next_turnOn_bluetooth;
		@FindBy(id = "flexGuideControl61")
		public WebElement btn_SignIn;	
		
		@FindBy(id = "flexGuideControl62")
		public WebElement btn_CreateAnAccount;	
		
		@FindBy(id = "lblGuideControl63")
		public WebElement btn_Skip;	
	
		
	@iOSFindBy(id = "lblGuideControl22")
	public WebElement btn_notRightNow;

	@iOSFindBy(id = "Allow")
	public WebElement btn_allow_pushNotifications;

	@iOSFindBy(id = "Always Allow")
	public WebElement btn_allowAlways_location;
	
	@iOSFindBy(id = "Don’t Allow")
	public WebElement btn_dontAllow_location;
	
	
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	public WebElement btnAllow;
	
	@AndroidFindBy(xpath="//*[@text='Deny']")
	public WebElement btnDeny;
	
	@AndroidFindBy(id = "android:id/button2")
	public WebElement btnDenyLocationAccess;
	
	

	/*
	 * @FindBy(id = "lblGuideControl1") public WebElement btn_seewhatsnew;
	 * 
	 * @FindBy(id = "lblGuideControl1") public WebElement btn_seewhatsnew;
	 */

	// Methods that performs operations in the Form
		
					
	
	/*
		public boolean verifyAppGuide(){
			
			try{
				Log.info("Initiated Method to Verify app guide and land on Home page ");
				waitForElement(launch_Appguide);				
			if ("MAC".equalsIgnoreCase(platformName)) {				
				btn_seewhatsnew.click();
				btn_notRightNow.click();
				btn_OK.click();
				btn_allow_pushNotifications.click();
				Thread.sleep(5000);
				//btn_allowAlways_location.click();
				btn_Next.click();
				btn_dontAllow_location.click();
				btn_next_turnOn_bluetooth.click();
				btn_Skip.click();
				return true;

			} else {
				btn_seewhatsnew.click();
				waitForElement(btn_OK);
				btn_OK.click();
				alert_OK_btn.click();
				btn_Next.click();
				waitForElement(btnAllow);
				btnDeny.click();
				Thread.sleep(4000);	
				waitForAndClickElement(btnDenyLocationAccess);
				waitForElement(alert_Cancel_btn);//turning off bluetooth
				alert_Cancel_btn.click();
				Thread.sleep(5000);				
				waitForAndClickElement(btn_Next);
				waitForAndClickElement(btn_Next);
				waitForAndClickElement(btnDeny);//				
				btn_Skip.click();
			}				
				return true;
			}catch(Exception e){
				Log.warn("App guide Verification Failed "+e);
				return false;
			}					
						
		}
		
		
public boolean verifySignIn(){
			
			try{
				Log.info("Intitaited method to Click on Sigin in On App guide page");
				waitForElement(launch_Appguide);
			if ("MAC".equalsIgnoreCase(platformName)) {
				btn_seewhatsnew.click();
				btn_notRightNow.click();
				btn_OK.click();
				btn_allow_pushNotifications.click();
				//btn_allowAlways_location.click();
				btn_dontAllow_location.click();
				btn_Next.click();
				btn_next_turnOn_bluetooth.click();
				waitForElement(btn_SignIn);
				btn_SignIn.click();
				flag=true;
			} else {
				
				btn_seewhatsnew.click();
				waitForElement(btn_OK);
				btn_OK.click();
				alert_OK_btn.click();
				btn_Next.click();
				waitForElement(btnAllow);
				btnDeny.click();
				Thread.sleep(4000);	
				waitForAndClickElement(btnDenyLocationAccess);
				waitForElement(alert_Cancel_btn);//turning off bluetooth
				alert_Cancel_btn.click();
				Thread.sleep(5000);				
				waitForAndClickElement(btn_Next);
				waitForAndClickElement(btn_Next);
				waitForAndClickElement(btnDeny);//					
				btn_SignIn.click();
				flag=true;
			}			
				
			}catch(Exception e){
				return false;
			}					
					return flag;	
		}

public boolean verifyCreateAccount(){
	
	try{
		Log.info("Initiated Method to Click on Sign Up button on App guide Page ");
		
		if ("MAC".equalsIgnoreCase(platformName)) {		
			waitForElement(launch_Appguide);
				btn_seewhatsnew.click();
				btn_notRightNow.click();
				btn_OK.click();
				btn_allow_pushNotifications.click();
			//	btn_allowAlways_location.click();
				btn_dontAllow_location.click();
				btn_Next.click();
				btn_next_turnOn_bluetooth.click();
				btn_CreateAnAccount.click();
				flag=true;
			} else {
				waitForElement(launch_Appguide);
				btn_seewhatsnew.click();
				waitForElement(btn_OK);
				btn_OK.click();
				alert_OK_btn.click();
				btn_Next.click();
				waitForElement(btnAllow);
				btnDeny.click();
				Thread.sleep(4000);	
				waitForAndClickElement(btnDenyLocationAccess);
				waitForElement(alert_Cancel_btn);//turning off bluetooth
				alert_Cancel_btn.click();
				Thread.sleep(5000);				
				waitForAndClickElement(btn_Next);
				waitForAndClickElement(btn_Next);
				waitForAndClickElement(btnDeny);//				
				btn_CreateAnAccount.click();
				flag=true;
			}
		
	}catch(Exception e){
		Log.info("Unable to Click on Sign Up button on App guide Page " + e);
		return false;
	}					
				return flag;
}
	

}
*/
