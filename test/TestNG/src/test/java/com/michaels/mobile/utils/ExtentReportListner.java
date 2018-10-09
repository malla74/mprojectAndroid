package com.michaels.mobile.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.michaels.mobile.test.DriverTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportListner extends DriverTest implements ITestListener {

	protected static ExtentReports reports;
	protected static ExtentTest test;
	//public static RemoteWebDriver driver;
	
	
	
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("on test start");
		test = reports.startTest(result.getMethod().getMethodName());
		System.out.println(result.getMethod().getMethodName() + " test is started");
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + " test is started");	

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		for (String s : Reporter.getOutput()) {
		    reports.setTestRunnerOutput(s);		
		    test.log(LogStatus.INFO, s);
		}		
		System.out.println("on test success");			
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + " Test is Passed");	
		
	}

	@Override
	public void onTestFailure(ITestResult result) {	
		System.out.println("on test failure");
		for (String s : Reporter.getOutput()) {
		    reports.setTestRunnerOutput(s);		
		    test.log(LogStatus.INFO, s);
		}		
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " Test is failed");				  
		try {

			String screenshotPath = "."+GeneralUtility.getScreenshot(driver, result.getMethod().getMethodName());
			System.out.println("name"+result.getMethod().getMethodName());				
			//To add it in the extent report 
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " Test is failed", result.getThrowable().getMessage());
			// test.log(LogStatus.INFO, Thread.currentThread().getStackTrace()[1].getMethodName());
			test.log(LogStatus.INFO, result.getThrowable());
		} catch (Exception e) {			
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("on start");
		//reports = new ExtentReports(	"./reports/" + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
		reports = new ExtentReports(
				"./reports/" + "Extentreport.html");
		File configfile = new File("./reports/extent-config.xml");
		reports.loadConfig(configfile);		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("on finish");		
		reports.endTest(test);				    
		reports.flush();
	}

	
	public void setTestRunnerOutput(java.lang.String log){
		test.log(LogStatus.INFO, log);
	}
	
	
	
}
