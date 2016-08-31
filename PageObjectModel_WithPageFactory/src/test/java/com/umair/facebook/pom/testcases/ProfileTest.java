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

public class ProfileTest {

	@Test
	public void testProfile() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LaunchPage launchpage = PageFactory.initElements(driver, LaunchPage.class);
		LoginPage loginPage = launchpage.gotoLoginPage();
		Object page = loginPage.doLogin("xhot_2handle@msn.com", "allahplease8983");
		if (page instanceof LoginPage) {
			Assert.fail("Login Failed");
		} else if (page instanceof LandingPage) {
			System.out.println("Login Successful");
		}
		LandingPage landingpage = (LandingPage) page;
		ProfilePage profilepage = landingpage.gotoProfilePage();
	}

}
