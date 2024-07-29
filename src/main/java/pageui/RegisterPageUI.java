package pageui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.WebElementWaits;

public class RegisterPageUI {
    private final WebElementWaits webElementWaits;

    public RegisterPageUI(WebDriver driver, WebDriverWait wait) {
        webElementWaits = new WebElementWaits(driver, wait);
    }

    public WebElement emailIdTxt() {
        return webElementWaits.waitUntilVisibilityOfElementByXpath("//input[@name='emailid']");
    }

    public WebElement submitBtn() {
        return webElementWaits.waitUntilVisibilityOfElementByXpath("//input[@name='btnLogin']");
    }
}
