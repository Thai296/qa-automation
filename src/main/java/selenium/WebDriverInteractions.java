package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URL;
import java.time.Duration;
import java.util.Set;

public class WebDriverInteractions {
    private static final Logger LOG = Logger.getLogger(WebDriverInteractions.class);
    private final WebDriver driver;
    private final JavascriptExecutor javascriptExecutor;

    public WebDriverInteractions(WebDriver driver) {
        this.driver = driver;
        this.javascriptExecutor = (JavascriptExecutor) driver;
    }

    /**
     * Executing the script on web element
     *
     * @param script  script
     * @param element web element
     */
    public void executeScript(String script, WebElement element) {
        javascriptExecutor.executeScript(script, element);
    }

    /**
     * get the title of current web page
     *
     * @return title
     */
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * get the url of current web page
     *
     * @return current url
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * get page source of current web page
     *
     * @return page source
     */
    public String getPageSource() {
        return driver.getPageSource();
    }

    /**
     * get default window handle
     *
     * @return String
     */
    public String getDefaultWindowHandle() {
        return driver.getWindowHandle();
    }

    /**
     * get list of default window handles
     *
     * @return Set of String
     */
    public Set<String> getDefaultWindowHandles() {
        return driver.getWindowHandles();
    }

    /**
     * Refresh the current web page
     */
    public void refresh() {
        driver.navigate().refresh();
    }

    /**
     * Move back a single "item" in the browser's history.
     */
    public void back() {
        driver.navigate().back();
    }

    /**
     * Move a single "item" forward in the browser's history.
     */
    public void forward() {
        driver.navigate().forward();
    }

    /**
     * Load a new web page in the current browser window
     *
     * @param url url
     */
    public void getUrl(String url) {
        LOG.info("Navigate to URL: " + url);
        driver.get(url);
    }

    /**
     * Load a new web page in the current browser window
     *
     * @param url url
     */
    public void getUrl(URL url) {
        LOG.info("Navigate to URL: " + url);
        getUrl(url.toString());
    }

    /**
     * navigate to particular url
     *
     * @param url url
     */
    public void navigateToUrl(String url) {
        LOG.info("Navigate to URL: " + url);
        driver.navigate().to(url);
    }

    /**
     * navigate to particular url
     *
     * @param url url
     */
    public void navigateToUrl(URL url) {
        LOG.info("Navigate to URL: " + url);
        navigateToUrl(url.toString());
    }

    /**
     * setting implicit wait to the web driver
     *
     * @param timeOut wait time
     */
    public void setImplicitWait(int timeOut) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
    }

    /**
     * setting wait time for page load
     *
     * @param timeOut wait time
     */
    public void setPageLoad(int timeOut) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
    }

    /**
     * setting maximize the current window
     */
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
}
