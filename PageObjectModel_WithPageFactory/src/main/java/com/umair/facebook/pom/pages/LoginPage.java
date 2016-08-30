package com.umair.facebook.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.umair.facebook.pom.pages.session.LandingPage;

public class LoginPage {

	WebDriver driver;
	@FindBy(xpath = "//input[@id='email']")
	public WebElement email;
	
	@FindBy(xpath = "//input[@id='pass']")
	public WebElement password;

	
	@FindBy(xpath = "//input[@id='u_0_n']")
	public WebElement btnlogin;
	
	public void loginPage(WebDriver driver) {

		this.driver = driver;

	}

	public LandingPage doLogin(String uName, String pwd) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Reached doLogin Function");
		
		email.sendKeys(uName);
		password.sendKeys(pwd);
		btnlogin.click();

		return PageFactory.initElements(driver, LandingPage.class);

	}
}
