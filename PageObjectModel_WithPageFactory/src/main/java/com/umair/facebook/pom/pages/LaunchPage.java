package com.umair.facebook.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.umair.facebook.pom.base.BasePage;

public class LaunchPage extends BasePage{

	
 
	public LaunchPage(WebDriver driver) {

		System.out.println("In LaunchPage");

		this.driver = driver;
	}

	public LoginPage gotoLoginPage() {

		driver.get("http://www.facebook.com");
		return PageFactory.initElements(driver, LoginPage.class);
		 
	}

}
