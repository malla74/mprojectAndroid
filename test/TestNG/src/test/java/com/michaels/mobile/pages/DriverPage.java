package com.michaels.mobile.pages;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.michaels.mobile.test.DriverTest;
import com.michaels.mobile.utils.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;


/**
 * A base for all the pages within the suite
 */
public abstract class DriverPage {

	/**
	 * The driver
	 */
	public static AndroidDriver<MobileElement> androiddriver;
	public static IOSDriver<MobileElement> iosdriver;
	protected static RemoteWebDriver driver;
	protected final String platformName;

	public boolean flag = false;
	
	@iOSFindBy(id = "WebView")
	@AndroidFindBy(className = "android.webkit.WebView")
	protected WebElement androidWebView;
	
	@SuppressWarnings({ "static-access", "unchecked" })
	protected DriverPage(RemoteWebDriver driver) {

		this.driver = driver;
		androiddriver = DriverTest.androiddriver;
		iosdriver = DriverTest.iosdriver;
		this.platformName = driver.getCapabilities().getPlatform().toString();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	

	
	public void waitForElement(WebElement element) {

		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println("Element Is not Visible " + element);
		}
	}

	public void enterText(WebElement element, String text) {

		element.sendKeys(text);
		if ("MAC".equalsIgnoreCase(platformName)) {
			element.sendKeys(Keys.RETURN);
		} else {
			androiddriver.hideKeyboard();
		}

		
	}

	public void scrollTo(String text) {

		androiddriver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
				+ text + "\").instance(0))");
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\""+text+"\"));"));
	}

	@SuppressWarnings("unchecked")
	public void scrollToTextIos(String text) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		@SuppressWarnings("rawtypes")
		HashMap scrollObject = new HashMap<>();
		scrollObject.put("predicateString", "value == '" + text + "'");
		scrollObject.put("direction", "down");
		js.executeScript("mobile:scroll", scrollObject);		 

	}
	
	
	
	public void scrolliOS(String direction, By loctor) {
		
		Log.info("Initiated method to Scroll Up/Down ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		RemoteWebElement element = (RemoteWebElement) driver.findElement(loctor);
		String elementID = element.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("element", elementID); // Only for ‘scroll in element’
		scrollObject.put("direction", direction);
		js.executeScript("mobile:scroll", scrollObject);
	}
	
	
	
	
	public void scrollUp(){
		
		int h=driver.manage().window().getSize().getHeight();
		int w=driver.manage().window().getSize().getWidth();
		System.err.println("Size  :"+h+""+w);				
		int startH=(int) (h*0.25);
		int endH= (int) (h*0.75);
		int width=(int) (w*0.5);				
		System.err.println("startH  :"+startH+""+"Width :"+width);
		System.err.println("endH  :"+endH+""+"Width :"+width);				
		TouchAction ta = new TouchAction((PerformsTouchActions) driver);
		ta.press(width, endH).waitAction(Duration.ofSeconds(1)).moveTo(width, startH).release().perform();		
		
	}
	
	
	public static int generateRandomInt(int upperRange){
	    Random random = new Random();
	    return random.nextInt(upperRange);
	}
	
	
	public boolean isElementDisplayed(WebElement element){
		
		try {			
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed()) {
				Log.info("Element is displayed Successfully*****" + element);
				flag = true;
			} else
				flag = false;
		} catch (Exception e) {
			System.out.println(element + "Not Found" + e);
			flag = false;
		}
		return flag;
	}
	

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap scrollObject = new HashMap();
		scrollObject.put("direction", "down");
		scrollObject.put("name", "object name value");
		js.executeScript("mobile: scroll", scrollObject);
	}
	
	

	public void scrollDowntoText(String Text,int nofiterrations)
	{
	  Log.info("Intiated method for finding Text presence....");
	  
	  for (int i=0;i<nofiterrations;i++)
	  {
		System.out.println("Loop no:"+i);
	    if (isTextVisible(Text)) {
	    	System.out.println("***Break the loop as we got Required Text***");
	      break;
	    }
	    scrollUp();
	  }
	}
	
	public void scrollDowntoTextiOS(int nofiterrations, String Text, String direction)
	{
	  Log.info("Intiated method for finding Text presence....");
	  
	  for (int i=0;i<nofiterrations;i++)
	  {
		System.out.println("Loop no:"+i);
	    if (isTextVisible(Text)) {
	    	System.out.println("***Break the loop as we got Required Text***");
	      break;
	    }
	    scrollUp();
	  }
	}
	
	
	public boolean isTextVisible(String ExpText) {
		
	       try {
				Log.info("Intiated Method to Find the Text..."+ExpText);
				driver.findElement(By.xpath("//*[@text='"+ExpText+"']"));
				Log.info("Got the Required Text :"+ExpText);
				return true;
			} catch (Exception e) {
				Log.info("Unable to find the text");
				return false;
			}
		}
	
	
	public boolean waitForAndClickElement(WebElement element){
		
		try {			
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed()) {
				Log.info("Element is displayed Successfully*****" + element);
				element.click();
				flag = true;
			} else
				flag = false;
		} catch (Exception e) {
			System.out.println(element + "Not Found" + e);
			flag = false;
		}
		return flag;
	}
	
	
	
/*	public String  generateRandomString(int Length) {
	    String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    String retVal = "";
	    for (int i = 0, n = charset.length(); i < Length; ++i) {
	        retVal += charset.charAt(Math.floor(Math.random() * n));
	    }
	    return retVal;
	}*/ 

	
	
	//Creating a method getScreenshot and passing two parameters 
	//driver and screenshotName
/*	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
	                //below line is just to append the date format with the screenshot name to avoid duplicate names 
	                String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 TakesScreenshot ts = (TakesScreenshot) driver;
	 File source = ts.getScreenshotAs(OutputType.FILE);
	                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
	 String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
	 File finalDestination = new File(destination);
	 FileUtils.copyFile(source, finalDestination);
	                //Returns the captured file path
	 return destination;
	}*/
}