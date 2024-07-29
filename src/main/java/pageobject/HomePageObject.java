package pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageui.HomePageUI;
import selenium.AlertElement;
import selenium.TextInputElement;
import selenium.WebDriverInteractions;
import selenium.WebElementInteractions;
import utils.ConfigLoader;
import utils.MenuNavigation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageObject {
    private final HomePageUI homePageUI;
    private final AlertElement alertElement;
    private final MenuNavigation menuNavigation;
    private final TextInputElement textInputElement;
    private final WebDriverInteractions webDriverInteractions;
    private final WebElementInteractions webElementInteractions;
    private static final String HOME_PAGE_TITLE = "Guru99 Bank Home Page";

    public HomePageObject(WebDriver driver, WebDriverWait wait, ConfigLoader config) {
        homePageUI = new HomePageUI(driver, wait);
        alertElement = new AlertElement(driver, wait);
        menuNavigation = new MenuNavigation(driver, config);
        textInputElement = new TextInputElement(driver);
        webDriverInteractions = new WebDriverInteractions(driver);
        webElementInteractions = new WebElementInteractions(driver);
    }

    public void openLoginPage() {
        menuNavigation.navigateLoginPage();
    }

    public void inputUserId(String userId) {
        textInputElement.clearAndEnterValue(homePageUI.userIdTxt(), userId);
    }

    public void inputPassword(String password) {
        textInputElement.clearAndEnterValue(homePageUI.passwordTxt(), password);
    }

    public void clickOnLogin() {
        webElementInteractions.clickOnElement(homePageUI.loginBtn());
    }

    public void clickOnAlert(Alert alert) {
        alertElement.acceptAlert(alert);
    }

    public Alert verifyTheAlertIsDisplayedAndGetIts(String alertMsgExpected) {
        Alert alert = alertElement.switchAlert();
        assertTrue(alertElement.isAlertPresent(), "The Alert should be displayed");
        assertEquals(alertElement.getAlertText(alert), alertMsgExpected, "The Alert text should be " + alertMsgExpected);
        return alert;
    }

    public void verifyHomePageIsDisPlayed() {
        assertEquals(webDriverInteractions.getTitle().trim(), HOME_PAGE_TITLE, "The Home Page title should be " + HOME_PAGE_TITLE);
        assertTrue(webElementInteractions.isDisplayed(homePageUI.userIdTxt()), "The UserId text should be displayed");
        assertTrue(webElementInteractions.isDisplayed(homePageUI.passwordTxt()), "The Password text should be displayed");
        assertTrue(webElementInteractions.isDisplayed(homePageUI.loginBtn()), "The Login button should be displayed");
    }
}
