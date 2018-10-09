package com.michaels.mobile.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;

public class Log {

	static Logger oLogger = Logger.getLogger(Log.class);

	public static void config() {
		
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\resources\\log4j.properties");
	}

	public static void info(String message) {
		config();
		oLogger.info(message);
		Reporter.log(message);
	}

	public static void warn(String message) {
		config();
		oLogger.warn(message);
	}

	public static void error(String message) {
		config();
		oLogger.error(message);
	}

	public static void main(String[] args) {
		config();
		info("First test");
	}

}
