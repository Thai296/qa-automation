package com.bankguru.qaautomation.pageobject;

import org.openqa.selenium.WebDriver;

import com.bankguru.qaautomation.commons.AbstractPage;
import com.bankguru.qaautomation.commons.ConfigurationLoader;
import com.bankguru.qaautomation.commons.GlobalConstants;

public class NewAccountPageObject extends AbstractPage {
	private ConfigurationLoader configLoader;
	private static final double inititalDeposit = 5000;
	
	public NewAccountPageObject(WebDriver driver) {
		super(driver);
	}

	public void inputFieldsRequire() {
		configLoader = new ConfigurationLoader();
		inputToDynamicTextBox("cusid", configLoader.loadConfiguration().getProperty(GlobalConstants.CUSTOMERID));
		selectDynamicValueInDropdown("Savings", "selaccount");
		inputToDynamicTextBox("inideposit", Double.toString(inititalDeposit));
		clickToDynamicToButton("submit");
	}
}
