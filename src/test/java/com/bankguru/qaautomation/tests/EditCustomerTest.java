package com.bankguru.qaautomation.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bankguru.qaautomation.commons.AbstractTest;
import com.bankguru.qaautomation.commons.RandomCharacters;
import com.bankguru.qaautomation.pageobject.EditCustomerPageObject;
import com.bankguru.qaautomation.pageobject.HomePageObject;
import com.bankguru.qaautomation.pageobject.PageGeneratorManager;

public class EditCustomerTest extends AbstractTest {
	private HomePageObject homePageObject;
	private EditCustomerPageObject editCustomerPageObject;
	private RandomCharacters randomCharacters;
	private static final String VALUE_NULL = "";

	@BeforeMethod()
	public void beforeMethod() {
		log.info("*** Before Method ***");
		randomCharacters = new RandomCharacters();
		homePageObject = PageGeneratorManager.getHomePage(driver);
		editCustomerPageObject = PageGeneratorManager.getEditCustomerPage(driver);

		log.info("Step 1: Action - Click to Edit Customer Link ***");
		homePageObject.clickToDynamicLink("Edit Customer");

		log.info("Step 2: Action - Input valid Customer Id and click on Submit button ***");
		editCustomerPageObject.inputToDynamicTextBox("cusid", configLoaded.loadConfiguration().getProperty("customerid"));
		editCustomerPageObject.clickToDynamicToButton("Submit");
	}

	@Test(groups = "Verify Customer Id", description = "Edit Customer - Verify Customer Id.")
	public void EC1ToEC4() throws Exception {
		log.info("*** EC1 To EC4 - Verify Customer Id ***");
		editCustomerPageObject = PageGeneratorManager.getEditCustomerPage(driver);

		log.info("Step 1: Action - Back to Edit Customer page");
		homePageObject.back();

		log.info("Step 1: Action: Do not enter a value in Customer Id and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("cusid", VALUE_NULL);

		log.info("Step 1: Expected Result: An error message 'Customer ID is required' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Customer ID is required");

		log.info("Step 2: Action: Do not enter a value in Customer Id and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("cusid", randomCharacters.getRandomAlphaNumericString(8));

		log.info("Step 2: Expected Result: An error message 'Characters are not allowed' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Characters are not allowed");

		log.info("Step 3: Action: Do not enter a value in Customer Id and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("cusid", randomCharacters.getRandomStringwithSpecialCharacters(8));

		log.info("Step 3: Expected Result: An error message 'Special characters are not allowed' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Special characters are not allowed");

		log.info("Step 4: Action: Enter valid Customer Id and click on Submit button.");
		editCustomerPageObject.inputToDynamicTextBox("cusid", configLoaded.loadConfiguration().getProperty("customerid"));
		editCustomerPageObject.clickToDynamicToButton("Submit");

		log.info("Step 4: Expected Result: Verify the Edit Customer page is displayed.");
		editCustomerPageObject.isDynamicMessageDisplayed("Edit Customer");
	}

	@Test(groups = "Verify Address Field", description = "Edit Customer - Verify Address Field")
	public void EC5() throws Exception {
		log.info("*** EC5 - Verify Address Field ***");
		editCustomerPageObject = PageGeneratorManager.getEditCustomerPage(driver);

		log.info("Step 1: Action: Do not enter a value in Address field and press TAB.");
		editCustomerPageObject.inputToDynamicTextArea("addr", VALUE_NULL);

		log.info("Step 1: Expected Result: An error message 'Address Field must not be blank' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Address Field must not be blank");
	}

	@Test(groups = "Verify City Field", description = "Edit Customer - Verify City Field")
	public void EC6ToEC8() throws Exception {
		log.info("*** EC6 To EC8 - Verify City Field ***");
		editCustomerPageObject = PageGeneratorManager.getEditCustomerPage(driver);

		log.info("Step 1: Action: Do not enter a value in City field and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("city", VALUE_NULL);

		log.info("Step 1: Expected Result: An error message 'City Field must not be blank' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("City Field must not be blank");

		log.info("Step 2: Action: Enter numeric value in CITY Field and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("city", randomCharacters.getRandomNumericString(5));

		log.info("Step 2: Expected Result: An error message 'Numbers are not allowed' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Numbers are not allowed");

		log.info("Step 3: Action: Enter Special Character In CITY Field and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("city", randomCharacters.getRandomStringwithSpecialCharacters(5));

		log.info("Step 3: Expected Result: An error message 'Special characters are not allowed' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Special characters are not allowed");
	}

	@Test(groups = "Verify State Field", description = "Edit Customer - Verify State Field")
	public void EC9ToEC11() throws Exception {
		log.info("*** EC9 To EC11 - Verify State Field ***");
		editCustomerPageObject = PageGeneratorManager.getEditCustomerPage(driver);

		log.info("Step 1: Action: Do not enter a value in State field and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("state", VALUE_NULL);

		log.info("Step 1: Expected Result: An error message 'State must not be blank' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("State must not be blank");

		log.info("Step 2: Action: Enter numeric value in State Field and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("state", randomCharacters.getRandomNumericString(5));

		log.info("Step 2: Expected Result: An error message 'Numbers are not allowed' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Numbers are not allowed");

		log.info("Step 3: Action: Enter Special Character In State Field and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("state", randomCharacters.getRandomStringwithSpecialCharacters(5));

		log.info("Step 3: Expected Result: An error message 'Special characters are not allowed' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Special characters are not allowed");
	}

	@Test(groups = "Verify PIN Field", description = "Edit Customer - Verify PIN Field")
	public void EC12ToEC15() throws Exception {
		log.info("*** EC12 To EC15 - Verify PIN Field ***");
		editCustomerPageObject = PageGeneratorManager.getEditCustomerPage(driver);

		log.info("Step 1: Action: Do not enter a value in PIN field and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("pinno", VALUE_NULL);

		log.info("Step 1: Expected Result: An error message 'PIN Code must not be blank' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("PIN Code must not be blank");

		log.info("Step 2: Action: Enter character value in PIN  Field and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("pinno", randomCharacters.getRandomAlphaString(3) + randomCharacters.getRandomNumericString(3));

		log.info("Step 2: Expected Result: An error message 'Characters are not allowed' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Characters are not allowed");

		log.info("Step 3: Action: Enter Special Character In PIN Field and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("pinno", randomCharacters.getRandomStringwithSpecialCharacters(5));

		log.info("Step 3: Expected Result: An error message 'Special characters are not allowed' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Special characters are not allowed");

		log.info("Step 4: Action: Enter Less than 6 digit in PIN field and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("pinno", randomCharacters.getRandomNumericString(5));

		log.info("Step 4: Expected Result: An error message 'PIN Code must have 6 Digits' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("PIN Code must have 6 Digits");
	}

	@Test(groups = "Verify Telephone Field", description = "Edit Customer - Verify Telephone Field")
	public void EC16ToEC17() throws Exception {
		log.info("*** EC16 To EC17 - Verify Telephone Field ***");
		editCustomerPageObject = PageGeneratorManager.getEditCustomerPage(driver);

		log.info("Step 1: Action: Do not enter a value in Telephone Field and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("telephoneno", VALUE_NULL);

		log.info("Step 1: Expected Result: An error message 'Mobile no must not be blank' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Mobile no must not be blank");

		log.info("Step 2: Action: Enter Special Character In Telephone Field and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("telephoneno", randomCharacters.getRandomStringwithSpecialCharacters(5));

		log.info("Step 2: Expected Result: An error message 'Special characters are not allowed' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Special characters are not allowed");
	}

	@Test(groups = "Verify Email Field", description = "Edit Customer - Verify Email Field")
	public void EC18ToEC20() throws Exception {
		log.info("*** EC18 To EC20 - Verify Email Field ***");
		editCustomerPageObject = PageGeneratorManager.getEditCustomerPage(driver);

		log.info("Step 1: Action: Do not enter a value in Email Field and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("emailid", VALUE_NULL);

		log.info("Step 1: Expected Result: An error message 'Email-ID must not be blank' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Email-ID must not be blank");

		log.info("Step 2: Action: Enter invalid email in Email field and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("emailid", randomCharacters.getRandomAlphaNumericString(5) + "@gmail");

		log.info("Step 2: Expected Result: An error message 'Email-ID is not valid' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Email-ID is not valid");

		log.info("Step 3: Action: Enter invalid email in Email field and press TAB.");
		homePageObject.inputToDynamicTextBox("emailid", randomCharacters.getRandomAlphaNumericString(5));

		log.info("Step 3: Expected Result: An error message 'Email-ID is not valid' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Email-ID is not valid");

		log.info("Step 4: Action: Enter invalid email in Email field and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("emailid", randomCharacters.getRandomAlphaNumericString(5) + "@");

		log.info("Step 4: Expected Result: An error message 'Email-ID is not valid' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Email-ID is not valid");

		log.info("Step 5: Action: Enter invalid email in Email field and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("emailid", randomCharacters.getRandomAlphaNumericString(3) + "@gmail.");

		log.info("Step 5: Expected Result: An error message 'Email-ID is not valid' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Email-ID is not valid");

		log.info("Step 6: Action: Enter invalid email in Email field and press TAB.");
		editCustomerPageObject.inputToDynamicTextBox("emailid", randomCharacters.getRandomAlphaNumericString(3) + "gmail.com");

		log.info("Step 6: Expected Result: An error message 'Email-ID is not valid' must shown.");
		editCustomerPageObject.isDynamicMessageLabelDisplayed("Email-ID is not valid");

	}
}
