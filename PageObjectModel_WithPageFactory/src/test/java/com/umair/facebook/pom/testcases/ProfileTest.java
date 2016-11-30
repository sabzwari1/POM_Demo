package com.umair.facebook.pom.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.umair.facebook.pom.pages.LaunchPage;
import com.umair.facebook.pom.pages.LoginPage;
import com.umair.facebook.pom.pages.session.LandingPage;
import com.umair.facebook.pom.pages.session.ProfilePage;
import com.umair.facebook.pom.testcases.base.BaseTest;

public class ProfileTest extends BaseTest {

	@Test
	public void testProfile() {
		init("firefox");
		LaunchPage launchpage = PageFactory.initElements(driver, LaunchPage.class);
		LoginPage loginPage = launchpage.gotoLoginPage();
		loginPage.veifyTitle("Facebook");
		Object page = loginPage.doLogin("xhot_2handle@msn.com", "allahplease8983");
		if (page instanceof LoginPage) {
			Assert.fail("Login Failed");
		} else if (page instanceof LandingPage) {
			System.out.println("Login Successful");
		}
		LandingPage landingPage = (LandingPage) page;
		landingPage.veifyTitle("xxxxxxxxxxxxx");
		ProfilePage profilePage = landingPage.gotoProfilePage();
		profilePage.verifyprofilepage();
		profilePage.getTopMenu().logout();
		
		
	}

}
