package com.umair.facebook.pom.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.umair.facebook.pom.pages.common.TopMenu;
import com.umair.facebook.pom.util.FBConstants;

public class BasePage {

	public WebDriver driver;
	public TopMenu menu;
	public ExtentTest test;

	public BasePage() {
	}

	public BasePage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;
		menu = PageFactory.initElements(driver, TopMenu.class);
		System.out.println("Constructor initialized");
	}

	public TopMenu getTopMenu() {
		return menu;
	}

	public String veifyTitle(String expTitle) {

		test.log(LogStatus.INFO, "Verifying the title " + expTitle);
		return "";
	}

	public String verifyText(String locator, String expText) {

		return "";

	}

	public void takeScreenShot() {
		Date d = new Date();
		String scrnShotFileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String filePath = FBConstants.REPORTS_PATH + "ScreenShots//" + scrnShotFileName;
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();

		}
		test.log(LogStatus.INFO, test.addScreenCapture(filePath));
	}

	public boolean isElementPresent(String locator) {

		return false;
	}

}
