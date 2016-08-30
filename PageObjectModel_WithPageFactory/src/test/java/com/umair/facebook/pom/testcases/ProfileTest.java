package com.umair.facebook.pom.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.umair.facebook.pom.pages.LaunchPage;
import com.umair.facebook.pom.pages.LoginPage;
import com.umair.facebook.pom.pages.session.LandingPage;



public class ProfileTest {

	
	@Test
	public void testProfile(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		LaunchPage launchpage = PageFactory.initElements(driver, LaunchPage.class);
		LoginPage loginPage = launchpage.gotoLoginPage();
		LandingPage landingpage = loginPage.doLogin("umair", "teeest");
		landingpage.gotoProfilePage();
	}
	
}
