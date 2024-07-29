package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebElementWaits {
    private final WebDriverWait wait;
    private final WebElementLocator webElementLocator;

    public WebElementWaits(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        this.webElementLocator = new WebElementLocator(driver);
    }

    /**
     * wait until the Alert is present
     *
     * @return Alert object
     */
    public Alert waitUntilAlertIsPresent() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * get web element after waiting till the presence of element is located by given locator
     *
     * @param by locator
     * @return Web element reference
     */
    public WebElement waitUntilPresenceOfElementLocatedByLocator(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * get web elements after waiting till the presence of elements is located by given locator
     *
     * @param by locator
     * @return Web elements reference
     */
    public List<WebElement> waitUntilPresenceOfAllElementLocatedByLocator(By by) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    /**
     * get web element after waiting till the visibility of element is located by given locator
     *
     * @param by locator
     * @return Web element reference
     */
    public WebElement waitUntilVisibilityOfElementLocatedByLocator(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * get web element after waiting till the element To Be Clickable is located by given locator
     *
     * @param by locator
     * @return Web element reference
     */
    public WebElement waitUntilElementToBeClickableByLocator(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * get web element after waiting till the presence of element is located by xpath
     *
     * @param xpath value
     * @return web element reference
     */
    public WebElement waitUntilPresenceOfElementByXpath(String xpath) {
        return waitUntilPresenceOfElementLocatedByLocator(webElementLocator.byXpath(xpath));
    }

    /**
     * get web element after waiting till the presence of element is located by id
     *
     * @param id value
     * @return web element reference
     */
    public WebElement waitUntilPresenceOfElementById(String id) {
        return waitUntilPresenceOfElementLocatedByLocator(webElementLocator.byId(id));
    }

    /**
     * get web element after waiting till the presence of element is located by name
     *
     * @param name value
     * @return web element reference
     */
    public WebElement waitUntilPresenceOfElementByName(String name) {
        return waitUntilPresenceOfElementLocatedByLocator(webElementLocator.byName(name));
    }

    /**
     * get web element after waiting till the presence of element is located by cssSelector
     *
     * @param cssSelector value
     * @return web element reference
     */
    public WebElement waitUntilPresenceOfElementByCssSelector(String cssSelector) {
        return waitUntilPresenceOfElementLocatedByLocator(webElementLocator.byCssSelector(cssSelector));
    }

    /**
     * get web element after waiting till the presence of element is located by className
     *
     * @param className value
     * @return web element reference
     */
    public WebElement waitUntilPresenceOfElementByClassName(String className) {
        return waitUntilPresenceOfElementLocatedByLocator(webElementLocator.byClassName(className));
    }

    /**
     * get web element after waiting till the presence of element is located by tagName
     *
     * @param tagName value
     * @return web element reference
     */
    public WebElement waitUntilPresenceOfElementByTagName(String tagName) {
        return waitUntilPresenceOfElementLocatedByLocator(webElementLocator.byTagName(tagName));
    }

    /**
     * get web element after waiting till the presence of element is located by linkText
     *
     * @param linkText value
     * @return web element reference
     */
    public WebElement waitUntilPresenceOfElementByLinkText(String linkText) {
        return waitUntilPresenceOfElementLocatedByLocator(webElementLocator.byLinkText(linkText));
    }

    /**
     * get web element after waiting till the presence of element is located by partialLinkText
     *
     * @param partialLinkText value
     * @return web element reference
     */
    public WebElement waitUntilPresenceOfElementByPartialLinkText(String partialLinkText) {
        return waitUntilPresenceOfElementLocatedByLocator(webElementLocator.byPartialLinkText(partialLinkText));
    }

    /**
     * get web elements after waiting till the presence of elements are located by xpath
     *
     * @param xpath value
     * @return web elements reference
     */
    public List<WebElement> waitUntilPresenceOfElementsByXpath(String xpath) {
        return waitUntilPresenceOfAllElementLocatedByLocator(webElementLocator.byXpath(xpath));
    }

    /**
     * get web elements after waiting till the presence of elements are located by id
     *
     * @param id value
     * @return web elements reference
     */
    public List<WebElement> waitUntilPresenceOfElementsById(String id) {
        return waitUntilPresenceOfAllElementLocatedByLocator(webElementLocator.byId(id));
    }

    /**
     * get web elements after waiting till the presence of elements are located by name
     *
     * @param name value
     * @return web elements reference
     */
    public List<WebElement> waitUntilPresenceOfElementsByName(String name) {
        return waitUntilPresenceOfAllElementLocatedByLocator(webElementLocator.byName(name));
    }

    /**
     * get web elements after waiting till the presence of elements are located by tagName
     *
     * @param tagName value
     * @return web elements reference
     */
    public List<WebElement> waitUntilPresenceOfElementsByTagName(String tagName) {
        return waitUntilPresenceOfAllElementLocatedByLocator(webElementLocator.byTagName(tagName));
    }

    /**
     * get web elements after waiting till the presence of elements are located by className
     *
     * @param className value
     * @return web elements reference
     */
    public List<WebElement> waitUntilPresenceOfElementsByClassName(String className) {
        return waitUntilPresenceOfAllElementLocatedByLocator(webElementLocator.byClassName(className));
    }

    /**
     * get web elements after waiting till the presence of elements are located by LinkText
     *
     * @param linkText value
     * @return web elements reference
     */
    public List<WebElement> waitUntilPresenceOfElementsByLinkText(String linkText) {
        return waitUntilPresenceOfAllElementLocatedByLocator(webElementLocator.byLinkText(linkText));
    }

    /**
     * get web elements after waiting till the presence of elements are located by PartialLinkText
     *
     * @param partialLinkText value
     * @return web elements reference
     */
    public List<WebElement> waitUntilPresenceOfElementsByPartialLinkText(String partialLinkText) {
        return waitUntilPresenceOfAllElementLocatedByLocator(webElementLocator.byPartialLinkText(partialLinkText));
    }

    /**
     * get web elements after waiting till the presence of elements are located by CssSelector
     *
     * @param cssSelector value
     * @return web elements reference
     */
    public List<WebElement> waitUntilPresenceOfElementsByCssSelector(String cssSelector) {
        return waitUntilPresenceOfAllElementLocatedByLocator(webElementLocator.byCssSelector(cssSelector));
    }

    /**
     * get web element after waiting till the visibility of element is located by xpath
     *
     * @param xpath value
     * @return web element reference
     */
    public WebElement waitUntilVisibilityOfElementByXpath(String xpath) {
        return waitUntilVisibilityOfElementLocatedByLocator(webElementLocator.byXpath(xpath));
    }

    /**
     * get web element after waiting till the Element To Be Clickable is located by xpath
     *
     * @param xpath value
     * @return web element reference
     */
    public WebElement waitUntilElementToBeClickableByXpath(String xpath) {
        return waitUntilElementToBeClickableByLocator(webElementLocator.byXpath(xpath));
    }
}
