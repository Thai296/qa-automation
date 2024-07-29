package pageui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.WebElementWaits;

public class HomePageUI {
    private final WebElementWaits webElementWaits;

    public HomePageUI(WebDriver driver, WebDriverWait wait) {
        webElementWaits = new WebElementWaits(driver, wait);
    }

    public WebElement userIdTxt() {
        return webElementWaits.waitUntilVisibilityOfElementByXpath("//input[@name='uid']");
    }

    public WebElement passwordTxt() {
        return webElementWaits.waitUntilVisibilityOfElementByXpath("//input[@name='password']");
    }

    public WebElement loginBtn() {
        return webElementWaits.waitUntilVisibilityOfElementByXpath("//input[@name='btnLogin']");
    }

    public WebElement resetBtn() {
        return webElementWaits.waitUntilVisibilityOfElementByXpath("//input[@name='btnReset']");
    }

    public WebElement linkBtn() {
        return webElementWaits.waitUntilVisibilityOfElementByXpath("//a[text()='here']");
    }
}
