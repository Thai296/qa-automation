package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameWebElement {
    private static final Logger LOG = Logger.getLogger(FrameWebElement.class);
    private final WebDriver driver;
    private final WebElementWaits webElementWaits;
    private static final int MAX_CONNECTION_ATTEMPTS = 5;

    public FrameWebElement(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        webElementWaits = new WebElementWaits(driver, wait);
    }

    /**
     * switch to default window from frame
     */
    public void switchToDefaultWindow() {
        driver.switchTo().defaultContent();
    }

    /**
     * switch to frame by given frame element
     *
     * @param element frame web element
     */
    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    /**
     * switch to frame by frame number
     *
     * @param frame frame number
     */
    public void switchToFrame(int frame) {
        driver.switchTo().frame(frame);
    }

    /**
     * switch to frame by given locator
     *
     * @param locator locator
     */
    public void switchToFrame(By locator) {
        boolean isSuccess = false;
        int attempt = 1;
        do {
            try {
                WebElement element = webElementWaits.waitUntilElementToBeClickableByLocator(locator);
                switchToFrame(element);
                isSuccess = true;
            } catch (StaleElementReferenceException e) {
                LOG.warn("Caught StaleElementReferenceException while switching to frame, locator=" + locator + ", attempts=" + attempt);
            }
        } while (!isSuccess && ++attempt <= MAX_CONNECTION_ATTEMPTS);
    }
}
