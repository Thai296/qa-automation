package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebElementLocator {
    private final WebDriver driver;

    public WebElementLocator(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * get the By Xpath
     *
     * @param xpath value
     * @return By object
     */
    public By byXpath(String xpath) {
        return By.xpath(xpath);
    }

    /**
     * get the By id
     *
     * @param id value
     * @return By object
     */
    public By byId(String id) {
        return By.id(id);
    }

    /**
     * get the By Name
     *
     * @param name value
     * @return By object
     */
    public By byName(String name) {
        return By.name(name);
    }

    /**
     * get the By className
     *
     * @param className value
     * @return By object
     */
    public By byClassName(String className) {
        return By.className(className);
    }

    /**
     * get the By tagName
     *
     * @param tagName value
     * @return By object
     */
    public By byTagName(String tagName) {
        return By.tagName(tagName);
    }

    /**
     * get the By cssSelector
     *
     * @param cssSelector value
     * @return By object
     */
    public By byCssSelector(String cssSelector) {
        return By.cssSelector(cssSelector);
    }

    /**
     * get the By linkText
     *
     * @param linkText value
     * @return By object
     */
    public By byLinkText(String linkText) {
        return By.linkText(linkText);
    }

    /**
     * get the By partialLinkText
     *
     * @param partialLinkText value
     * @return By object
     */
    public By byPartialLinkText(String partialLinkText) {
        return By.partialLinkText(partialLinkText);
    }

    /**
     * get web element
     *
     * @param by by
     * @return web element object
     */
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    /**
     * get list of web element
     *
     * @param by by
     * @return List of web element object
     */
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    /**
     * find the web element by given xpath
     *
     * @param xpath value
     * @return web element
     */
    public WebElement findElementByXpath(String xpath) {
        return findElement(byXpath(xpath));
    }

    /**
     * find the web element by given id
     *
     * @param id value
     * @return web element
     */
    public WebElement findElementById(String id) {
        return findElement(byId(id));
    }

    /**
     * find the web element by given link text
     *
     * @param linkText value
     * @return web element
     */
    public WebElement findElementByLinkText(String linkText) {
        return findElement(byLinkText(linkText));
    }

    /**
     * find the web element by given partial link text
     *
     * @param partialLinkText value
     * @return web element
     */
    public WebElement findElementByPartialLinkText(String partialLinkText) {
        return findElement(byPartialLinkText(partialLinkText));
    }

    /**
     * find the web element by given name
     *
     * @param name value
     * @return web element
     */
    public WebElement findElementByName(String name) {
        return findElement(byName(name));
    }

    /**
     * find the web element by given tag name
     *
     * @param tagName value
     * @return web element
     */
    public WebElement findElementByTagName(String tagName) {
        return findElement(byTagName(tagName));
    }

    /**
     * find the web element by given class name
     *
     * @param className value
     * @return web element
     */
    public WebElement findElementByClassName(String className) {
        return findElement(byClassName(className));
    }

    /**
     * find the web element by given css selector
     *
     * @param cssSelector value
     * @return web element
     */
    public WebElement findElementByCssSelector(String cssSelector) {
        return findElement(byCssSelector(cssSelector));
    }

    /**
     * get a list of web elements by xpath
     *
     * @param xpath value
     * @return list of web elements
     */
    public List<WebElement> findElementsByXpath(String xpath) {
        return findElements(byXpath(xpath));
    }

    /**
     * get a list of web elements by id
     *
     * @param id value
     * @return list of web elements
     */
    public List<WebElement> findElementsById(String id) {
        return findElements(byId(id));
    }

    /**
     * get a list of web elements by link text
     *
     * @param linkText value
     * @return list of web elements
     */
    public List<WebElement> findElementsByLinkText(String linkText) {
        return findElements(byLinkText(linkText));
    }

    /**
     * get a list of web elements by partial link text
     *
     * @param partialLinkText value
     * @return list of web elements
     */
    public List<WebElement> findElementsByPartialLinkText(String partialLinkText) {
        return findElements(byPartialLinkText(partialLinkText));
    }

    /**
     * get a list of web elements by name
     *
     * @param name value
     * @return list of web elements
     */
    public List<WebElement> findElementsByName(String name) {
        return findElements(byName(name));
    }

    /**
     * get a list of web elements by tag name
     *
     * @param tagName value
     * @return list of web elements
     */
    public List<WebElement> findElementsByTagName(String tagName) {
        return findElements(byTagName(tagName));
    }

    /**
     * get a list of web elements by class name
     *
     * @param className value
     * @return list of web elements
     */
    public List<WebElement> findElementsByClassName(String className) {
        return findElements(byClassName(className));
    }

    /**
     * get a list of web elements by css selector
     *
     * @param cssSelector value
     * @return list of web elements
     */
    public List<WebElement> findElementsByCssSelector(String cssSelector) {
        return findElements(byCssSelector(cssSelector));
    }

    /**
     * get a list of web elements by xpath for given web element
     *
     * @param element web element
     * @param xpath   value
     * @return list of web elements
     */
    public List<WebElement> findElementsForGivenElementByXpath(WebElement element, String xpath) {
        return element.findElements(byXpath(xpath));
    }

    /**
     * get a list of web elements by tag name for given web element
     *
     * @param element web element
     * @param tagName value
     * @return list of web elements
     */
    public List<WebElement> findElementsForGivenElementByTagName(WebElement element, String tagName) {
        return element.findElements(byTagName(tagName));
    }

    /**
     * get a list of web element by tag name for given web element
     *
     * @param element web element
     * @param tagName value
     * @return list of web elements
     */
    public WebElement findElementForGivenElementByTagName(WebElement element, String tagName) {
        return element.findElement(byTagName(tagName));
    }

    /**
     * get a web element by class name for given web element
     *
     * @param element   web element
     * @param className value
     * @return web element
     */
    public WebElement findElementForGivenElementByClassName(WebElement element, String className) {
        return element.findElement(byClassName(className));
    }

    /**
     * get a web element by Xpath for given web element
     *
     * @param element web element
     * @param xpath   value
     * @return web element
     */
    public WebElement findElementForGivenElementByXpath(WebElement element, String xpath) {
        return element.findElement(byXpath(xpath));
    }

    /**
     * get a web element by Id for given web element
     *
     * @param element web element
     * @param id      value
     * @return web element
     */
    public WebElement findElementForGivenElementById(WebElement element, String id) {
        return element.findElement(byId(id));
    }

    /**
     * get a web element by Link Text for given web element
     *
     * @param element  web element
     * @param linkText value
     * @return web element
     */
    public WebElement findElementForGivenElementByLinkText(WebElement element, String linkText) {
        return element.findElement(byLinkText(linkText));
    }

    /**
     * get a web element by Partial Link Text for given web element
     *
     * @param element         web element
     * @param partialLinkText value
     * @return web element
     */
    public WebElement findElementForGivenElementByPartialLinkText(WebElement element, String partialLinkText) {
        return element.findElement(byPartialLinkText(partialLinkText));
    }

    /**
     * get a web element by Name for given web element
     *
     * @param element web element
     * @param name    value
     * @return web element
     */
    public WebElement findElementForGivenElementByName(WebElement element, String name) {
        return findElement(byName(name));
    }

    /**
     * get a web element by Css Selector for given web element
     *
     * @param element     web element
     * @param cssSelector value
     * @return web element
     */
    public WebElement findElementForGivenElementByCssSelector(WebElement element, String cssSelector) {
        return findElement(byCssSelector(cssSelector));
    }
}
