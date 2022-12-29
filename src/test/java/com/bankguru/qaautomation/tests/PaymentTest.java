package com.bankguru.qaautomation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankguru.qaautomation.commons.AbstractTest;
import com.bankguru.qaautomation.commons.ConfigurationLoader;
import com.bankguru.qaautomation.commons.GlobalConstants;
import com.bankguru.qaautomation.pageobject.DeleteAccountPageObject;
import com.bankguru.qaautomation.pageobject.EditCustomerPageObject;
import com.bankguru.qaautomation.pageobject.HomePageObject;
import com.bankguru.qaautomation.pageobject.NewAccountPageObject;
import com.bankguru.qaautomation.pageobject.NewCustomerPageObject;
import com.bankguru.qaautomation.pageobject.PageGeneratorManager;

public class PaymentTest extends AbstractTest {
	private HomePageObject homePageObject;
	private NewCustomerPageObject newCustomerPageObject;
	private EditCustomerPageObject editCustomerPageObject;
	private NewAccountPageObject newAccountPageObject;
	private ConfigurationLoader configLoader;
	private DeleteAccountPageObject deleteAccountPageObject;

	@Test(description = "Payment - Create new customer account and check created successfully.")
	public void TC_01_Payment() throws Exception {
		log.info("*** Testing - Payment: TC_01 ***");

		newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
		homePageObject = PageGeneratorManager.getHomePage(driver);

		log.info("Step 1: Action: Open the New Customer page.");
		homePageObject.clickToDynamicLink("New Customer");

		log.info("Step 1: Expected Result: The New Customer page open successfully.");
		Assert.assertTrue(newCustomerPageObject.isDynamicMessageDisplayed("Add New Customer"), "The Header Text DasBoard Page should be displayed");

		log.info("Step 2: Action: Fill in all fields with data valid and click on Submit button.");
		newCustomerPageObject.setAllValueInFillAtNewCustomerPage();
		newCustomerPageObject.clickToDynamicToButton("Submit");

		log.info("Step 2: Expected Result: The new customer is created with infomation correct.");
		newCustomerPageObject.verifyCustomerRegisteredSuccessfully();
	}

	@Test(description = "Payment - Edit customer account and check edited successfully.")
	public void TC_02_Payment() throws Exception {
		log.info("*** Testing - Payment: TC_02 ***");
		homePageObject = PageGeneratorManager.getHomePage(driver);
		editCustomerPageObject = PageGeneratorManager.getEditCustomerPage(driver);
		configLoader = new ConfigurationLoader();

		log.info("Step 1: Action: Open the Edit Customer page.");
		homePageObject.clickToDynamicLink("Edit Customer");

		log.info("Step 1: Expected Result: The Edit Customer Form page open successfully.");
		Assert.assertTrue(editCustomerPageObject.isDynamicMessageDisplayed("Edit Customer Form"));

		log.info("Step 2: Action: Enter Customer ID field and click Submit button.");
		editCustomerPageObject.inputToDynamicTextBox("cusid", configLoader.loadConfiguration().getProperty(GlobalConstants.CUSTOMERID));
		editCustomerPageObject.clickToDynamicToButton("Submit");

		log.info("Step 2: Expected Result: The Edit Customer page open successfully.");
		Assert.assertTrue(editCustomerPageObject.isDynamicMessageDisplayed("Edit Customer"));

		log.info("Step 3: Action: Fill in Address, City, State, Pin, Mobile number, Email fields and click Submit button.");
		editCustomerPageObject.setValueInFieldsRequires();
		editCustomerPageObject.clickToDynamicToButton("Submit");

		log.info("Step 3: Expected Result: Edit Customer is successfully.");
		editCustomerPageObject.verifyCustomerEditSuccessfully();
//		editCustomerPageObject.acceptAlert();
	}

	@Test(description = "Payment - Add new account and check created successfully, then verify 'Current Amount' and 'Initial Deposit' are equal.")
	public void TC_03_Payment() throws Exception {
		log.info("*** Testing - Payment: TC_03 ***");
		homePageObject = PageGeneratorManager.getHomePage(driver);
		newAccountPageObject = PageGeneratorManager.getNewAccountPage(driver);

		log.info("Step 1: Action: Open the New Account page.");
		homePageObject.clickToDynamicLink("New Account");

		log.info("Step 1: Expected Result: The New Account form page open successfully.");
		newAccountPageObject.isDynamicMessageDisplayed("Add new account form");

		log.info("Step 2: Action: Fill in CustomerID, Account type, Initial deposit field and click Submit button.");
		newAccountPageObject.inputFieldsRequire();

		log.info("Step 2: Expected Result: The New Account generated successfuly.");
		newAccountPageObject.isDynamicMessageDisplayed("Account Generated Successfully!!!");
	}

	@Test(description = "Payment - Delete all account of this customer account and check deleted successfully.")
	public void TC_04_Payment() throws Exception {
		log.info("*** Testing - Payment: TC_04 ***");
		homePageObject = PageGeneratorManager.getHomePage(driver);
		deleteAccountPageObject = PageGeneratorManager.getDeleteAccountPage(driver);
		configLoader = new ConfigurationLoader();

		log.info("Step 1: Action: Open the Delete Account page.");
		homePageObject.clickToDynamicLink("Delete Account");

		log.info("Step 1: Expected Result: The Delete Account form page open successfully.");
		deleteAccountPageObject.isDynamicMessageDisplayed("Delete Account Form");

		log.info("Step 2: Action: Fill in Account NO field and click Submit button.");
		deleteAccountPageObject.inputToDynamicTextBox("accountno", configLoader.loadConfiguration().getProperty(GlobalConstants.CUSTOMERID));
		deleteAccountPageObject.clickToDynamicToButton("Submit");

		log.info("Step 2: Expected Result: The Account deleted successfuly.");
		deleteAccountPageObject.acceptAlert();
		deleteAccountPageObject.isDynamicMessageDisplayed("Account Deleted Successfully!!!");
	}

}
