package com.bankguru.qaautomation.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bankguru.qaautomation.commons.AbstractPage;
import com.bankguru.qaautomation.commons.RandomCharacters;

public class EditCustomerPageObject extends AbstractPage {
	private String address, city, state, pin, mobile, email;
	private RandomCharacters randomCharacters;

	public EditCustomerPageObject(WebDriver driver) {
		super(driver);
	}

	public void setValueInFieldsRequires() throws Exception {
		randomCharacters = new RandomCharacters();

		address = randomCharacters.getRandomAlphaString(10);
		city = randomCharacters.getRandomAlphaString(5);
		state = randomCharacters.getRandomAlphaString(2);
		pin = randomCharacters.getRandomNumericString(6);
		mobile = randomCharacters.getRandomNumericString(10);
		email = randomCharacters.getRandomAlphaNumericString(5) + "@gmail.com";

		inputToDynamicTextArea("addr", address);
		inputToDynamicTextBox("city", city);
		inputToDynamicTextBox("state", state);
		inputToDynamicTextBox("pinno", pin);
		inputToDynamicTextBox("telephoneno", mobile);
		inputToDynamicTextBox("emailid", email);
	}

	public void verifyCustomerEditSuccessfully() throws Exception {

		Assert.assertEquals(getDynamicValueByColumnName("Address"), address);
		Assert.assertEquals(getDynamicValueByColumnName("City"), city);
		Assert.assertEquals(getDynamicValueByColumnName("State"), state);
		Assert.assertEquals(getDynamicValueByColumnName("Pin"), pin);
		Assert.assertEquals(getDynamicValueByColumnName("Mobile No."), mobile);
		Assert.assertEquals(getDynamicValueByColumnName("Email"), email);
	}

}
