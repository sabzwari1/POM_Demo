package com.umair.facebook.pom.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.umair.facebook.pom.pages.LaunchPage;
import com.umair.facebook.pom.pages.LoginPage;
import com.umair.facebook.pom.pages.session.LandingPage;
import com.umair.facebook.pom.testcases.base.BaseTest;
import com.umair.facebook.pom.util.ExtentManager;

public class LoginTest extends BaseTest {

	@Test
	public void loginTest() {

		test = extent.startTest("Login Test", "This test will verify login functionality");
		test.log(LogStatus.INFO, "Starting Login Test");
		test.log(LogStatus.INFO, "Launching browser");
		init("firefox");
		LaunchPage launchpage = new LaunchPage(driver, test);
		PageFactory.initElements(driver, launchpage);
		LoginPage loginPage = launchpage.gotoLoginPage();
		loginPage.veifyTitle("Facebook");
		
		Object page = loginPage.doLogin("", "");
		if (page instanceof LoginPage) {
			Assert.fail("Login Failed");
		} else if (page instanceof LandingPage) {
			test.log(LogStatus.PASS, "Test Successful");
			System.out.println("Login Successful");
		}
		
		LandingPage landingPage = (LandingPage)page;
		landingPage.takeScreenShot();
		
		
	}

	@AfterMethod
	public void end_Method() {
		if (extent != null) {
			extent.endTest(test);
			extent.flush();
		}
	}

}
