package com.umair.facebook.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.umair.facebook.pom.base.BasePage;
import com.umair.facebook.pom.pages.session.LandingPage;

public class LoginPage extends BasePage{

	WebDriver driver;
	@FindBy(xpath = "//input[@id='email']")
	public WebElement email;

	@FindBy(xpath = "//input[@id='pass']")
	public WebElement password;

	@FindBy(xpath = "//input[@id='u_0_n']")
	public WebElement btnlogin;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	public Object doLogin(String uName, String pwd) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		email.sendKeys(uName);
		password.sendKeys(pwd);
		btnlogin.click();
		boolean loginSuccess = true;
		if (loginSuccess)
			return PageFactory.initElements(driver, LandingPage.class);
		else
			return PageFactory.initElements(driver, LoginPage.class);
	}
}
