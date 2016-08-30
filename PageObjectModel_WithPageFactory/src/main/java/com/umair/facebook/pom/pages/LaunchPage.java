package com.umair.facebook.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LaunchPage {

	WebDriver driver;

	public LaunchPage(WebDriver driver) {

		System.out.println("In LaunchPage");

		this.driver = driver;
	}

	public LoginPage gotoLoginPage() {

		driver.get("http://www.facebook.com");
		return PageFactory.initElements(driver, LoginPage.class);
		 
	}

}
