package com.bankguru.qaautomation.pageobject;

import org.openqa.selenium.WebDriver;

import com.bankguru.qaautomation.commons.AbstractPage;
import com.bankguru.qaautomation.commons.ConfigurationLoader;
import com.bankguru.qaautomation.commons.GlobalConstants;

public class LoginPageObject extends AbstractPage {
	private ConfigurationLoader configLoader;

	public LoginPageObject(WebDriver driver) {
		super(driver);
	}

	public void loginToLoginPage() {
		configLoader = new ConfigurationLoader();
		inputToDynamicTextBox("uid", configLoader.loadConfiguration().getProperty(GlobalConstants.USERNAME));
		inputToDynamicTextBox("password", configLoader.loadConfiguration().getProperty(GlobalConstants.PASSWORD));
		clickToDynamicToButton("LOGIN");
	}

}
