package com.umair.facebook.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.umair.facebook.pom.base.BasePage;
import com.umair.facebook.pom.pages.session.LandingPage;
import com.umair.facebook.pom.util.FBConstants;

public class LoginPage extends BasePage {

	@FindBy(xpath = FBConstants.ib_Emailid)
	public WebElement email;

	@FindBy(xpath = FBConstants.ib_Password)
	public WebElement password;

	@FindBy(xpath = FBConstants.btn_Login)
	public WebElement btnlogin;

	public LoginPage(WebDriver driver, ExtentTest test) {
		super(driver, test);

	}

	public Object doLogin(String uName, String pwd) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Entering User Name: " +uName);
		email.sendKeys(uName);
		test.log(LogStatus.INFO, "Entering Password");
		password.sendKeys(pwd);
		test.log(LogStatus.INFO, "Clicking on Login Button");
		btnlogin.click();
		boolean loginSuccess = true;
		if (loginSuccess) {
			test.log(LogStatus.INFO, "Login is successful");
			LandingPage landingpage = new LandingPage(driver, test);
			PageFactory.initElements(driver, landingpage);
			return landingpage;
		}

		else {
			test.log(LogStatus.INFO, "Login Failed");
			LoginPage loginpage = new LoginPage(driver, test);
			PageFactory.initElements(driver, loginpage);
			return loginpage;
		}
	}
}
