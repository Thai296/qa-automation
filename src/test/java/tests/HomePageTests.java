package tests;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobject.HomePageObject;

public class HomePageTests extends BaseTest {
    private HomePageObject homePageObject;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        try {
            log.info("Running BeforeMethod");
            homePageObject = new HomePageObject(driver, wait, config);
            homePageObject.openLoginPage();
        } catch (Exception e) {
            log.error("Error running BeforeMethod, ", e);
        }
    }

    @Test (priority = 1, description = "User or Password is not valid")
    @Parameters({"userId", "password", "alertTxt"})
    public void verifyUserOrPasswordIsNotValid(String userId, String password, String alertTxt) {
        log.info("Starting test case: verifyUserOrPasswordIsNotValid");

        log.info("Step 1 - Expected Result: The Home page is displayed");
        homePageObject.verifyHomePageIsDisPlayed();

        log.info("Step 2 - Action: Input the userId");
        homePageObject.inputUserId(userId);

        log.info("Step 3 - Action: Input the password");
        homePageObject.inputPassword(password);

        log.info("Step 4 - Action: Click on Login");
        homePageObject.clickOnLogin();

        log.info("Step 4 - Expected Result: The Alert is displayed with text 'User or Password is not valid'");
        Alert alert = homePageObject.verifyTheAlertIsDisplayedAndGetIts(alertTxt);

        log.info("Step 5 - Action: Click on Alert");
        homePageObject.clickOnAlert(alert);
    }
}
