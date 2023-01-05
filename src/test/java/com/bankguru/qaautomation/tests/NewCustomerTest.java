package com.bankguru.qaautomation.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bankguru.qaautomation.commons.AbstractTest;
import com.bankguru.qaautomation.commons.RandomCharacters;
import com.bankguru.qaautomation.pageobject.HomePageObject;
import com.bankguru.qaautomation.pageobject.NewCustomerPageObject;
import com.bankguru.qaautomation.pageobject.PageGeneratorManager;

public class NewCustomerTest extends AbstractTest {
	private HomePageObject homePageObject;
	private NewCustomerPageObject newCustomerPageObject;
	private RandomCharacters randomCharacter;
	private static final String VALUE_NULL = "";

	@BeforeMethod
	public void beforeMethod() {
		homePageObject = PageGeneratorManager.getHomePage(driver);
		homePageObject.clickToDynamicLink("New Customer");
		homePageObject.switchToImageIframe();
// 		homePageObject.switchToAdverIframe();
		homePageObject.clickCloseButtonToHideAdver();
		homePageObject.switchToDefaultFrame();
		
	}

	@Test(description = "NewCustomer - Verify Name Field - Name cannot be empty.")
	public void NC1() {
		log.info("*** NC1 - Verify Name Field - Name cannot be empty ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);

		log.info("Step 1: Action: Do not enter a value in Name field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("name", VALUE_NULL);

		log.info("Step 1: Expected Result: An error message 'Customer name must not be blank' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Customer name must not be blank");
	}

	@Test(description = "NewCustomer - Verify Name Field - Name cannot be numeric.")
	public void NC2() throws Exception {
		log.info("*** NC2 - Verify Name Field - Name cannot be numeric ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter numeric value in NAME Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("name", randomCharacter.getRandomAlphaNumericString(6));

		log.info("Step 1: Expected Result: An error message 'Numbers are not allowed' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Numbers are not allowed");
	}

	@Test(description = "NewCustomer - Verify Name Field - Name cannot have special characters.")
	public void NC3() throws Exception {
		log.info("*** NC3 - Verify Name Field - Name cannot have special characters ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter Special Character In NAME Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("name", randomCharacter.getRandomStringwithSpecialCharacters(6));

		log.info("Step 1: Expected Result: An error message 'Special characters are not allowed' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Special characters are not allowed");
	}

	@Test(description = "NewCustomer - Verify Name Field - Name cannot have first character as blank space.")
	public void NC4() throws Exception {
		log.info("*** NC4 - Verify Name Field - Name cannot have first character as blank space ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter First character Blank space In NAME Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("name", " " + randomCharacter.getRandomAlphaString(5));

		log.info("Step 1: Expected Result: An error message 'First character cannot have space' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("First character can not have space");
	}

	@Test(description = "NewCustomer - Verify Address Field - Address cannot be empty.")
	public void NC5() throws Exception {
		log.info("*** NC5 - Verify Address Field - Address cannot be empty ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Do not enter a value in ADDRESS Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextArea("addr", VALUE_NULL);

		log.info("Step 1: Expected Result: An error message 'Address Field must not be blank' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Address Field must not be blank");
	}

	@Test(description = "NewCustomer - Verify Address Field - Address cannot have first blank space.")
	public void NC6() throws Exception {
		log.info("*** NC6 - Verify Address Field - Address cannot have first blank space ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter First character Blank space in ADDRESS Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextArea("addr", " " + randomCharacter.getRandomAlphaString(5));

		log.info("Step 1: Expected Result: An error message 'First character can not have space' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("First character can not have space");
	}

	@Test(description = "NewCustomer - Verify City Field - City cannot be empty.")
	public void NC8() throws Exception {
		log.info("*** NC8 - Verify City Field - City cannot be empty ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Do not enter a value in CITY Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("city", VALUE_NULL);

		log.info("Step 1: Expected Result: An error message 'City Field must not be blank' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("City Field must not be blank");
	}

	@Test(description = "NewCustomer - Verify City Field - City cannot be numeric.")
	public void NC9() throws Exception {
		log.info("*** NC9 - Verify City Field - City cannot be numeric ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter numeric value in City Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("city", randomCharacter.getRandomAlphaNumericString(6));

		log.info("Step 1: Expected Result: An error message 'Numbers are not allowed' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Numbers are not allowed");
	}

	@Test(description = "NewCustomer - Verify City Field - City cannot have special characters.")
	public void NC10() throws Exception {
		log.info("*** NC10 - Verify City Field - City cannot have special characters ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter Special Character In City Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("city", randomCharacter.getRandomStringwithSpecialCharacters(6));

		log.info("Step 1: Expected Result: An error message 'Special characters are not allowed' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Special characters are not allowed");
	}

	@Test(description = "NewCustomer - Verify City Field - City cannot have first blank space.")
	public void NC11() throws Exception {
		log.info("*** NC11 - Verify City Field - City cannot have first blank space ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter First character Blank space in City Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("city", " " + randomCharacter.getRandomAlphaString(5));

		log.info("Step 1: Expected Result: An error message 'First character can not have space' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("First character can not have space");
	}

	@Test(description = "NewCustomer - Verify State Field - State cannot be empty.")
	public void NC12() throws Exception {
		log.info("*** NC12 - Verify State Field - State cannot be empty ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Do not enter a value in State Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("state", VALUE_NULL);

		log.info("Step 1: Expected Result: An error message 'State must not be blank' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("State must not be blank");
	}

	@Test(description = "NewCustomer - Verify State Field - State cannot be numeric.")
	public void NC13() throws Exception {
		log.info("*** NC13 - Verify State Field - State cannot be numeric ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter numeric value in State Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("state", randomCharacter.getRandomAlphaNumericString(6));

		log.info("Step 1: Expected Result: An error message 'Numbers are not allowed' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Numbers are not allowed");
	}

	@Test(description = "NewCustomer - Verify State Field - State cannot have special characters.")
	public void NC14() throws Exception {
		log.info("*** NC14 - Verify State Field - State cannot have special characters ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter Special Character In State Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("state", randomCharacter.getRandomStringwithSpecialCharacters(6));

		log.info("Step 1: Expected Result: An error message 'Special characters are not allowed' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Special characters are not allowed");
	}

	@Test(description = "NewCustomer - Verify State Field - State cannot have first blank space.")
	public void NC15() throws Exception {
		log.info("*** NC15 - Verify State Field - State cannot have first blank space ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter First character Blank space in State Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("state", " " + randomCharacter.getRandomAlphaString(5));

		log.info("Step 1: Expected Result: An error message 'First character can not have space' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("First character can not have space");
	}

	@Test(description = "NewCustomer - Verify PIN Field - PIN cannot be empty.")
	public void NC16() throws Exception {
		log.info("*** NC16 - Verify PIN Field - PIN cannot be empty ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Do not enter a value in PIN Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("pinno", VALUE_NULL);

		log.info("Step 1: Expected Result: An error message 'PIN Code must not be blank' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("PIN Code must not be blank");
	}

	@Test(description = "NewCustomer - Verify PIN Field - PIN must be numeric.")
	public void NC17() throws Exception {
		log.info("*** NC17 - Verify PIN Field - PIN must be numeric ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter character value in PIN Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("pinno", randomCharacter.getRandomAlphaString(6));

		log.info("Step 1: Expected Result: An error message 'Characters are not allowed' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Characters are not allowed");
	}

	@Test(description = "NewCustomer - Verify PIN Field - PIN cannot have special characters.")
	public void NC18() throws Exception {
		log.info("*** NC18 - Verify PIN Field - PIN cannot have special characters ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter Special Character In PIN Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("pinno", randomCharacter.getRandomStringwithSpecialCharacters(6));

		log.info("Step 1: Expected Result: An error message 'Special characters are not allowed' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Special characters are not allowed");
	}

	@Test(description = "NewCustomer - Verify PIN Field - PIN cannot have first blank space.")
	public void NC19() throws Exception {
		log.info("*** NC19 - Verify PIN Field - PIN cannot have first blank space ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter First character Blank space in PIN Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("pinno", " " + randomCharacter.getRandomAlphaString(5));

		log.info("Step 1: Expected Result: An error message 'First character can not have space' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("First character can not have space");
	}

	@Test(description = "NewCustomer - Verify PIN Field - PIN must have 6 digits.")
	public void NC20() throws Exception {
		log.info("*** NC20 - Verify PIN Field - PIN must have 6 digits ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter Less than 6 digit in PIN field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("pinno", randomCharacter.getRandomNumericString(5));

		log.info("Step 1: Expected Result: An error message 'PIN Code must have 6 Digits' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("PIN Code must have 6 Digits");
	}

	@Test(description = "NewCustomer - Verify Telephone Field - Mobile no must not be blank.")
	public void NC22() throws Exception {
		log.info("*** NC22 - Verify Telephone Field - Mobile no must not be blank ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Do not enter a value in Telephone Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("telephoneno", VALUE_NULL);

		log.info("Step 1: Expected Result: An error message 'Mobile no must not be blank' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Mobile no must not be blank");
	}

	@Test(description = "NewCustomer - Verify Telephone Field - Telephone cannot have special characters.")
	public void NC23() throws Exception {
		log.info("*** NC18 - Verify Telephone Field - Telephone cannot have special characters ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter Special Character In Telephone Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("telephoneno", randomCharacter.getRandomStringwithSpecialCharacters(6));

		log.info("Step 1: Expected Result: An error message 'Special characters are not allowed' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Special characters are not allowed");
	}

	@Test(description = "NewCustomer - Verify Telephone Field - Telephone cannot have first blank space.")
	public void NC24() throws Exception {
		log.info("*** NC24 - Verify Telephone Field - Telephone cannot have first blank space ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter First character Blank space in Telephone Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("telephoneno", " " + randomCharacter.getRandomNumericString(5));

		log.info("Step 1: Expected Result: An error message 'First character can not have space' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("First character can not have space");
	}

	@Test(description = "NewCustomer - Verify Telephone Field - Telephone cannot have character.")
	public void NC25() throws Exception {
		log.info("*** NC25 - Verify Telephone Field - Telephone cannot have character ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter character in Telephone Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("telephoneno", randomCharacter.getRandomAlphaString(5));

		log.info("Step 1: Expected Result: An error message 'Characters are not allowed.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Characters are not allowed");
	}

	@Test(description = "NewCustomer - Verify Email Field - Email cannot be empty.")
	public void NC26() throws Exception {
		log.info("*** NC26 - Verify Email Field - Email cannot be empty ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Do not enter a value in Email Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("emailid", VALUE_NULL);

		log.info("Step 1: Expected Result: An error message 'Email-ID must not be blank' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Email-ID must not be blank");
	}

	@Test(description = "NewCustomer - Verify Email Field - Email cannot have space.")
	public void NC27() throws Exception {
		log.info("*** NC27 - Verify Email Field - Email cannot have space ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter Blank space in Email Field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("emailid", randomCharacter.getRandomAlphaNumericString(3) + " " + randomCharacter.getRandomAlphaNumericString(3));

		log.info("Step 1: Expected Result: An error message 'Email-ID is not valid' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Email-ID is not valid");
	}

	@Test(description = "NewCustomer - Verify Email Field - Email must be in correct format.")
	public void NC28() throws Exception {
		log.info("*** NC28 - Verify Email Field - Email must be in correct format ***");
		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		randomCharacter = new RandomCharacters();

		log.info("Step 1: Action: Enter invalid email in Email field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("emailid", randomCharacter.getRandomAlphaNumericString(5) + "@gmail");

		log.info("Step 1: Expected Result: An error message 'Email-ID is not valid' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Email-ID is not valid");

		log.info("Step 2: Action: Enter invalid email in Email field and press TAB.");
		homePageObject.inputToDynamicTextBox("emailid", randomCharacter.getRandomAlphaNumericString(5));

		log.info("Step 2: Expected Result: An error message 'Email-ID is not valid' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Email-ID is not valid");

		log.info("Step 3: Action: Enter invalid email in Email field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("emailid", randomCharacter.getRandomAlphaNumericString(5) + "@");

		log.info("Step 3: Expected Result: An error message 'Email-ID is not valid' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Email-ID is not valid");

		log.info("Step 4: Action: Enter invalid email in Email field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("emailid", randomCharacter.getRandomAlphaNumericString(3) + "@gmail.");

		log.info("Step 4: Expected Result: An error message 'Email-ID is not valid' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Email-ID is not valid");

		log.info("Step 5: Action: Enter invalid email in Email field and press TAB.");
		newCustomerPageObject.inputToDynamicTextBox("emailid", randomCharacter.getRandomAlphaNumericString(3) + "gmail.com");

		log.info("Step 5: Expected Result: An error message 'Email-ID is not valid' must shown.");
		newCustomerPageObject.isDynamicMessageLabelDisplayed("Email-ID is not valid");
	}
}
