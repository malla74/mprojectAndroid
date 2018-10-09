package com.michaels.mobile.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GeneralUtility {
	
	 //This method is to capture the screenshot and return the path of the screenshot.
	 
		public static String getScreenshot(RemoteWebDriver driver, String screenshotName) throws Exception {
			
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;		
			File source= ts.getScreenshotAs(OutputType.FILE);					
			
			//after execution, you could see a folder "FailedTestsScreenshots" under src folder
			//String destination =  "\\FailedTestsScreenshots\\"+screenshotName+dateName+".png";
			String destination = "./reports/FailedTestsScreenshots/"+screenshotName+".png";
			
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);			
			return destination;
		}

}
