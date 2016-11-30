package com.umair.facebook.pom.pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.umair.facebook.pom.base.BasePage;
import com.umair.facebook.pom.util.FBConstants;

public class LandingPage extends BasePage{

	

	@FindBy(xpath=FBConstants.lnk_ProfilePage)
	public WebElement profileLink;
	
	public LandingPage(WebDriver driver, ExtentTest test) {
		super(driver,test );
		this.test=test;
	}

	public ProfilePage gotoProfilePage() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		profileLink.click();

		return PageFactory.initElements(driver, ProfilePage.class);
		
	}
	
	
	
}
