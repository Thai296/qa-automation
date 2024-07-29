package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WebElementInteractions {
    private static final Logger LOG = Logger.getLogger(WebElementInteractions.class);
    private final WebDriverInteractions webDriverInteractions;

    public WebElementInteractions(WebDriver driver) {
        webDriverInteractions = new WebDriverInteractions(driver);
    }

    /**
     * click on web element
     *
     * @param element web element
     */
    public void clickOnElement(WebElement element) {
        element.click();
        LOG.info("Click on element: " + element);
    }

    /**
     * click on hidden web element
     *
     * @param element         web element
     * @param elementArgument element argument
     */
    public void clickHiddenElement(WebElement element, int elementArgument) {
        if (element != null) {
            webDriverInteractions.executeScript("arguments[" + elementArgument + "].click();", element);
            LOG.info("Click on hidden element: " + element);
        } else {
            LOG.error("Hidden element does not exist");
        }
    }

    /**
     * get text from web element
     *
     * @param element web element
     * @return String text
     */
    public String getTextFromWebElement(WebElement element) {
        return element.getText();
    }

    /**
     * get list of text from the list of web element
     *
     * @param elements list of web element
     * @return list of String
     */
    public List<String> getListTextFromWebElements(List<WebElement> elements) {
        List<String> textList = new ArrayList<>();

        for (WebElement element : elements) {
            textList.add(getTextFromWebElement(element));
        }

        return textList;
    }

    /**
     * check if element is displayed
     *
     * @param element web element
     * @return true if the web element is displayed otherwise return false
     */
    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    /**
     * check if web element is enabled
     *
     * @param element web element
     * @return true if the web element is enabled otherwise return false
     */
    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    /**
     * get attribute value of web element
     *
     * @param element   web element
     * @param attribute attribute value
     * @return String attribute value of web element
     */
    public String getAttributeFromWebElement(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    /**
     * get value attribute of web element
     *
     * @param element web element
     * @return String
     */
    public String getValueAttributeFromWebElement(WebElement element) {
        return getAttributeFromWebElement(element, "value");
    }

    /**
     * get tag name from web element
     *
     * @param element web element
     * @return String tag name value
     */
    public String getTagNameFromWebElement(WebElement element) {
        return element.getTagName();
    }

    /**
     * get Css Value from web element
     *
     * @param element      web element
     * @param cssAttribute css attribute
     * @return String css value
     */
    public String getCssValueFromWebElement(WebElement element, String cssAttribute) {
        return element.getCssValue(cssAttribute);
    }

    /**
     * check if web element text matches value
     *
     * @param element web element
     * @param value   value
     * @return true if the web element text matches value otherwise false
     */
    public boolean isWebElementTextMatchesValue(WebElement element, String value) {
        String elementText = getTextFromWebElement(element);
        return elementText != null && elementText.trim().equals(value);
    }

    /**
     * check if web element text contains value
     *
     * @param element web element
     * @param value   value
     * @return true if the web element text contains value otherwise false
     */
    public boolean isWebElementContainsGivenText(WebElement element, String value) {
        String elementText = getTextFromWebElement(element);
        return elementText != null && elementText.trim().contains(value);
    }

    /**
     * waits for given time and checks if web element is displayed or enabled
     *
     * @param element web element
     * @param time    wait time
     * @return true if the web element is displayed or enabled otherwise false
     */
    public boolean isWebElementPresent(WebElement element, int time) {
        int i = 0;
        while (i < time) {
            if (isDisplayed(element) || isEnabled(element)) {
                LOG.info("WebElement found: " + element);
                return true;
            } else {
                LOG.info("WebElement not found: " + element);
                i++;
            }
        }

        return false;
    }

    /**
     * waits for given time and checks if the element is enabled
     *
     * @param element web element
     * @param time    wait time
     * @return true if the element is present
     * @throws StaleElementReferenceException if the referenced web element is no longer attached to the DOM
     */
    public boolean isElementEnabled(WebElement element, int time) throws StaleElementReferenceException {
        boolean flag = false;
        int i = 0;
        while (i < time) {
            if (isEnabled(element)) {
                LOG.info("        WebElement found: " + element);
                flag = true;
                break;
            } else {
                LOG.error("        WebElement Not found");
                i++;
            }
        }
        return flag;
    }
}
