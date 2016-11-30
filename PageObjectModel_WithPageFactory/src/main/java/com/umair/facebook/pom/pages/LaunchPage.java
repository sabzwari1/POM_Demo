package com.umair.facebook.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.umair.facebook.pom.base.BasePage;
import com.umair.facebook.pom.util.FBConstants;

public class LaunchPage extends BasePage {

	ExtentTest test;

	public LaunchPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		this.test= test;
	}

	public LoginPage gotoLoginPage() {
		test.log(LogStatus.INFO, "Opening URL --- " + FBConstants.url_HOMEPage);
		driver.get(FBConstants.url_HOMEPage);
		test.log(LogStatus.INFO, "URL Opened--- " + FBConstants.url_HOMEPage);
		LoginPage loginpage = new LoginPage(driver, test);
		PageFactory.initElements(driver, loginpage);
		return loginpage;

	}

}
