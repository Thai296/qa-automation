package com.bankguru.qaautomation.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bankguru.qaautomation.commons.AbstractPage;
import com.bankguru.qaautomation.commons.ConfigurationLoader;
import com.bankguru.qaautomation.commons.GlobalConstants;
import com.bankguru.qaautomation.commons.RandomCharacters;
import com.bankguru.qaautomation.commons.TimeStamp;
import com.bankguru.qaautomation.pageui.AbstractBankPageUI;

public class NewCustomerPageObject extends AbstractPage {
	private String customerName, gender, dateOfBirth, address, city, state, pin, mobile, email;
	private RandomCharacters randomCharacters;
	private TimeStamp timeStamp;
	private ConfigurationLoader configLoader;

	private static final String FORMAT_DATE_OLD = "MM/dd/yyyy";
	private static final String FORMAT_DATE_NEW = "yyyy-MM-dd";
	private static final String MALE = "male";
	private static final String FEMALE = "female";

	public NewCustomerPageObject(WebDriver driver) {
		super(driver);
	}

	public void setAllValueInFillAtNewCustomerPage() throws Exception {
		randomCharacters = new RandomCharacters();
		timeStamp = new TimeStamp();
		configLoader = new ConfigurationLoader();

		customerName = randomCharacters.getRandomAlphaString(10);
		dateOfBirth = timeStamp.getCurrentDate(FORMAT_DATE_OLD);
		address = randomCharacters.getRandomAlphaString(10);
		city = randomCharacters.getRandomAlphaString(5);
		state = randomCharacters.getRandomAlphaString(2);
		pin = randomCharacters.getRandomNumericString(6);
		mobile = randomCharacters.getRandomNumericString(10);
		email = randomCharacters.getRandomAlphaNumericString(5) + "@gmail.com";

		inputToDynamicTextBox("name", customerName);
		clickToDynamicRadioButton("m");
		gender = isElementSelected(AbstractBankPageUI.DYNAMIC_RADIO_BUTTON, "m") ? MALE : FEMALE;
		inputToDynamicTextBox("dob", dateOfBirth);
		inputToDynamicTextArea("addr", address);
		inputToDynamicTextBox("city", city);
		inputToDynamicTextBox("state", state);
		inputToDynamicTextBox("pinno", pin);
		inputToDynamicTextBox("telephoneno", mobile);
		inputToDynamicTextBox("emailid", email);
		inputToDynamicTextBox("password", configLoader.loadConfiguration().getProperty(GlobalConstants.PASSWORD));
	}

	public void verifyCustomerRegisteredSuccessfully() throws Exception {
		timeStamp = new TimeStamp();

		Assert.assertTrue(isDynamicMessageDisplayed("Customer Registered Successfully!!!"));

		Assert.assertEquals(getDynamicValueByColumnName("Customer Name"), customerName);
		Assert.assertEquals(getDynamicValueByColumnName("Gender"), gender);
		Assert.assertEquals(getDynamicValueByColumnName("Birthdate"), timeStamp.getConvertedDate(FORMAT_DATE_OLD, FORMAT_DATE_NEW, dateOfBirth));
		Assert.assertEquals(getDynamicValueByColumnName("Address"), address);
		Assert.assertEquals(getDynamicValueByColumnName("City"), city);
		Assert.assertEquals(getDynamicValueByColumnName("State"), state);
		Assert.assertEquals(getDynamicValueByColumnName("Pin"), pin);
		Assert.assertEquals(getDynamicValueByColumnName("Mobile No."), mobile);
		Assert.assertEquals(getDynamicValueByColumnName("Email"), email);
	}

}
