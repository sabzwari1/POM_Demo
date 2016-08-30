package com.umair.facebook.pom.pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	public ProfilePage gotoProfilePage() {
		
		
		return PageFactory.initElements(driver, ProfilePage.class);
		
	}
	
	
	
}
