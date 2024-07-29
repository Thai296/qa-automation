package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextInputElement {
    private static final Logger LOG = Logger.getLogger(TextInputElement.class);
    private final WebDriverInteractions webDriverInteractions;

    public TextInputElement(WebDriver driver) {
        this.webDriverInteractions = new WebDriverInteractions(driver);
    }

    /**
     * send given value to the web element
     *
     * @param element web element
     * @param value   give character sequence
     */
    public void sendKeys(WebElement element, CharSequence value) {
        element.sendKeys(value);
        LOG.info("Entered value: " + value);
    }

    /**
     * press the given keys on the web element
     *
     * @param element web element
     * @param keys    keys sequence
     */
    public void pressKey(WebElement element, Keys keys) {
        element.sendKeys(keys);
        LOG.info("Pressed keys: " + keys);
    }

    /**
     * enter given value by execute scripts
     *
     * @param element element
     * @param value   text
     */
    public void enterValuesByExecuteScript(WebElement element, Object value) {
        webDriverInteractions.executeScript("arguments[0].click();", element);
        element.sendKeys(String.valueOf(value));
        LOG.info("Entered value: " + value);
    }

    /**
     * clear the text of element
     *
     * @param element web element
     */
    public void clearElementText(WebElement element) {
        element.clear();
        LOG.info("Cleared text in web element");
    }

    /**
     * send keys to web element and press tab
     *
     * @param element web element
     * @param value   text
     */
    public void sendKeysAndTab(WebElement element, CharSequence value) {
        sendKeys(element, value);
        pressKey(element, Keys.TAB);
    }

    /**
     * clear and send keys to web element and press tab
     *
     * @param element web element
     * @param value   text
     */
    public void clearAndSendKeysAndTab(WebElement element, CharSequence value) {
        clearElementText(element);
        sendKeys(element, value);
        pressKey(element, Keys.TAB);
    }

    /**
     * clear and send keys to web element
     *
     * @param element web element
     * @param value   text
     */
    public void clearAndSendKeys(WebElement element, CharSequence value) {
        clearElementText(element);
        sendKeys(element, value);
    }

    /**
     * clear and enter value to web element by execute script
     *
     * @param element web element
     * @param value   text
     */
    public void clearAndEnterValue(WebElement element, Object value) {
        clearElementText(element);
        enterValuesByExecuteScript(element, value);
    }

    /**
     * clear and enter value to web element by execute script and press tab
     *
     * @param element web element
     * @param value   text
     */
    public void clearAndEnterValueAndTab(WebElement element, Object value) {
        clearElementText(element);
        enterValuesByExecuteScript(element, value);
        pressKey(element, Keys.TAB);
    }

    /**
     * enter value to web element by execute script and press tab
     *
     * @param element web element
     * @param value   text
     */
    public void enterValueAndTab(WebElement element, Object value) {
        enterValuesByExecuteScript(element, value);
        pressKey(element, Keys.TAB);
    }
}
