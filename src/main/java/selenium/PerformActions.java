package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class PerformActions {
    private static final Logger LOG = Logger.getLogger(PerformActions.class);
    private final Actions actions;

    public PerformActions(WebDriver driver) {
        actions = new Actions(driver);
    }

    /**
     * move to given web element and perform
     *
     * @param element web element
     */
    public void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    /**
     * move to given web element and click
     *
     * @param element web element
     */
    public void moveToElementAndClick(WebElement element) {
        actions.moveToElement(element).click().build().perform();
    }

    /**
     * move to given web element and double click and perform
     *
     * @param element web element
     */
    public void moveToElementAndDoubleClick(WebElement element) {
        actions.moveToElement(element).doubleClick().perform();
    }

    /**
     * move to given web element and pause and click
     *
     * @param element          web element
     * @param timeOutInSeconds time to pause
     */
    public void moveToElementAndPauseAndClick(WebElement element, int timeOutInSeconds) {
        actions.moveToElement(element).pause(Duration.ofSeconds(timeOutInSeconds)).click().build().perform();
    }

    /**
     * send keys and pause till time out
     *
     * @param value            value
     * @param timeOutInSeconds time to pause
     */
    public void sendKeysAndPause(String value, int timeOutInSeconds) {
        actions.sendKeys(value).pause(Duration.ofSeconds(timeOutInSeconds)).build().perform();
    }

    /**
     * send keys to web element
     *
     * @param element web element
     * @param value   value
     */
    public void sendKeysToElement(WebElement element, String value) {
        actions.sendKeys(element, value).build().perform();
    }

    /**
     * click on given web element and perform
     *
     * @param element web element
     */
    public void clickOnElement(WebElement element) {
        actions.click(element).build().perform();
    }
}
