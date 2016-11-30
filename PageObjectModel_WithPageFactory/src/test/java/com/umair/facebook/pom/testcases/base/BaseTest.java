package com.umair.facebook.pom.testcases.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.umair.facebook.pom.util.ExtentManager;
import com.umair.facebook.pom.util.FBConstants;

public class BaseTest {

	public WebDriver driver;
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	public void init(String browserType) {
		if (browserType.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserType.equals("chrom")) {
			System.setProperty("webdriver.chrome.driver", FBConstants.CHROME_DRIVER_EXE);
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}
}