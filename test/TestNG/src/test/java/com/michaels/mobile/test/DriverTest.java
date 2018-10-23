package com.michaels.mobile.test;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;

import com.google.common.io.Files;
import com.michaels.mobile.utils.GeneralUtility;
import com.michaels.mobile.utils.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public abstract class DriverTest {

	public static String platformName;
	@SuppressWarnings("rawtypes")
	public static AndroidDriver androiddriver;
	@SuppressWarnings("rawtypes")
	public static IOSDriver iosdriver;
	public static RemoteWebDriver driver;
	DesiredCapabilities capabilities;
	protected static ExtentReports reports;
	protected static ExtentTest test;
	
	

	// Initialize all the Application Pages

	@SuppressWarnings("rawtypes")
	@BeforeClass
	public void intializingDriver() throws Exception {

		Log.info("Setting the Capabilities");
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("newCommandTimeout", 80);

		// Android Mobile desired Capabilities
		
		//capabilities.setCapability("deviceName", "4d00b67a4ba55125");		
		//capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("platformVersion", "6.0.1");
		//capabilities.setCapability("deviceName", "ce061606e483793502");
		//capabilities.setCapability("platformVersion", "7.0");
		//File app = new File("F:\\\\Work\\\\Hosting\\\\Hosting Data\\\\Matt\\\\Michaels\\\\Michaels Stores_v8.3.1_apkpure.com.apk");
		//capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);		
		capabilities.setCapability("appPackage", "com.michaels.michaelsstores");
		capabilities.setCapability("appActivity", "com.michaels.michaelsstores.ConnectedRetail");

		//capabilities.setCapability("automationName", "uiautomator2");
						
		System.out.println("Inside platform ANDROID............");
		androiddriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver = androiddriver;
		
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
		
		
		/*capabilities.setCapability("appPackage", "com.orgname.ConnectedRetail");
		capabilities.setCapability("appActivity", "com.orgname.ConnectedRetail.ConnectedRetail");*/
		
		// IOS
			capabilities.setCapability("deviceName", "iPhone");
				capabilities.setCapability("platformName", "iOS");
				//capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
				capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
				//capabilities.setCapability("app", "/Users/TestingTeam/Desktop/Michaels/iphone-23-Aug-MIKAutomation.ipa");iphone-8.3-AutomationProfile
				capabilities.setCapability("app", "/Users/kh916/Downloads/iphone-01-oct-2018-PROD-Tag-88ccca7.ipa");
				capabilities.setCapability("udid", "ba95cc21606f48aae15cb3656c292e362d8ed204");
				//capabilities.setCapability("bundleId", "com.kony.automation.appium.wda.lib");
				capabilities.setCapability("automationName", "XCUITest"); 
				capabilities.setCapability("xcodeOrgId", "4GYF9CX48P");
				capabilities.setCapability("xcodeSigningId", "iPhone Developer");

				iosdriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				platformName = iosdriver.getCapabilities().getPlatform().toString();
				Log.info("PLATFORM : " + platformName);
				driver = iosdriver;
				
	}
	
		/**
	 * To Pass The Test case and print the the case name
	 * 
	 * @param Message
	 */
	public void passTestCase(String Message) {
		assertTrue(true, "");
		Log.info(Message);
		Reporter.log(Message);
	}

	/**
	 * To Fail The Test Case
	 * 
	 * @param Message
	 */
	public void failTestCase(String Message) {
	
		assertTrue(false, Message);
		Log.warn(Message);
	}
	
	

	/*public void fileCopyTest() {

		Path source = Paths.get("\\reports\\" + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
		Path destination = Paths.get("\\test-output\\Extentreportnew.html");

		try {
			Files.copy(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}*/
	


}




/*
package com.michaels.mobile.test;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;

import com.google.common.io.Files;
import com.michaels.mobile.utils.GeneralUtility;
import com.michaels.mobile.utils.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public abstract class DriverTest {

	public static String platformName;
	@SuppressWarnings("rawtypes")
	public static AndroidDriver androiddriver;
	@SuppressWarnings("rawtypes")
	public static IOSDriver iosdriver;
	public static RemoteWebDriver driver;
	DesiredCapabilities capabilities;
	protected static ExtentReports reports;
	protected static ExtentTest test;
	
	

	// Initialize all the Application Pages

	@SuppressWarnings("rawtypes")
	@BeforeClass
	public void intializingDriver() throws Exception {

		Log.info("Setting the Capabilities");
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("newCommandTimeout", 80);

		// Android Mobile desired Capabilities
		
		//capabilities.setCapability("deviceName", "4d00b67a4ba55125");		
		//capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("platformVersion", "6.0.1");
		//capabilities.setCapability("deviceName", "ce061606e483793502");
		//capabilities.setCapability("platformVersion", "7.0");
		//File app = new File("F:\\\\Work\\\\Hosting\\\\Hosting Data\\\\Matt\\\\Michaels\\\\Michaels Stores_v8.3.1_apkpure.com.apk");
		//capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);		
		capabilities.setCapability("appPackage", "com.michaels.michaelsstores");
		capabilities.setCapability("appActivity", "com.michaels.michaelsstores.ConnectedRetail");

		//capabilities.setCapability("automationName", "uiautomator2");
						
		System.out.println("Inside platform ANDROID............");
		androiddriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver = androiddriver;
		
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
		
		/*capabilities.setCapability("appPackage", "com.orgname.ConnectedRetail");
		capabilities.setCapability("appActivity", "com.orgname.ConnectedRetail.ConnectedRetail");*/
		
		// IOS
		/*	capabilities.setCapability("deviceName", "iPhone");
				capabilities.setCapability("platformName", "iOS");
				capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
				capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
				//capabilities.setCapability("app", "/Users/TestingTeam/Desktop/Michaels/iphone-23-Aug-MIKAutomation.ipa");iphone-8.3-AutomationProfile
				capabilities.setCapability("app", "/Users/TestingTeam/Desktop/Michaels/iphone-8.3-AutomationProfile.ipa");
				capabilities.setCapability("udid", "16b45e843e728aa644ed0672b83a7c071f6db5c5");
				capabilities.setCapability("bundleId", "com.kony.automation.appium.wda.lib");
				capabilities.setCapability("automationName", "XCUITest"); 
				capabilities.setCapability("xcodeOrgId", "XASDPH97N6");
				capabilities.setCapability("xcodeSigningId", "iPhone Developer");

				iosdriver = new IOSDriver(new URL("http://10.20.19.45:4723/wd/hub"), capabilities);
				platformName = iosdriver.getCapabilities().getPlatform().toString();
				Log.info("PLATFORM : " + platformName);
				driver = iosdriver;
				*/
	// uncomment for android}
	
		/**
	 * To Pass The Test case and print the the case name
	 * 
	 * @param Message
	 */
/* uncomment for Android	
public void passTestCase(String Message) {
		assertTrue(true, "");
		Log.info(Message);
		Reporter.log(Message);
	}

	/**
	 * To Fail The Test Case
	 * 
	 * @param Message
	 */
/* uncomment for Android	
public void failTestCase(String Message) {
	
		assertTrue(false, Message);
		Log.warn(Message);
	}
	
	uncomment for android */

	/*public void fileCopyTest() {

		Path source = Paths.get("\\reports\\" + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
		Path destination = Paths.get("\\test-output\\Extentreportnew.html");

		try {
			Files.copy(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}*/
	


//uncomment for android}


