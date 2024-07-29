package base;

import constants.BrowserType;
import constants.EnvironmentType;
import drivers.BrowserManagerFactory;
import drivers.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestClass;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import selenium.*;
import utils.ConfigLoader;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class BaseTest {
    protected final Logger log;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected DriverFactory driverFactory;
    protected ConfigLoader config;
    protected AlertElement alertElement;
    protected CheckboxElement checkboxElement;
    protected FrameWebElement frameWebElement;
    protected PerformActions performActions;
    protected SelectDropDown selectDropDown;
    protected SwitchToPopUp switchToPopUp;
    protected TextInputElement textInputElement;
    protected WebDriverInteractions webDriverInteractions;
    protected WebElementInteractions webElementInteractions;
    protected WebElementLocator webElementLocator;
    protected WebElementWaits webElementWaits;
    public int timeOut;

    protected BaseTest() {
        this.log = Logger.getLogger(this.getClass());
    }

    static {
        // Disable excess Selenium logging
        java.util.logging.Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters()
    public void setUp() {
        config = ConfigLoader.getInstance();
        driverFactory = BrowserManagerFactory.getBrowser(BrowserType.fromString(config.getBrowser()), EnvironmentType.fromString(config.getEnvironment()), config.getRemoteUrl());
        driver = driverFactory.getDriver();
        timeOut = Integer.parseInt(config.getTimeOut());
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        webDriverInteractions = new WebDriverInteractions(driver);
        webDriverInteractions.setImplicitWait(timeOut);
        webDriverInteractions.setPageLoad(timeOut);

        alertElement = new AlertElement(driver, wait);
        checkboxElement = new CheckboxElement(driver);
        frameWebElement = new FrameWebElement(driver, wait);
        performActions = new PerformActions(driver);
        selectDropDown = new SelectDropDown(driver);
        switchToPopUp = new SwitchToPopUp(driver);
        textInputElement = new TextInputElement(driver);
        webElementLocator = new WebElementLocator(driver);
        webElementWaits = new WebElementWaits(driver, wait);
        webElementInteractions = new WebElementInteractions(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        try {
            handleTestResult(result);
        } catch (Exception e) {
            log.error("Error during tearDown", e);
        } finally {
            quitWebDriver();
        }
    }

    /**
     * Handles the result of the test method that just ran.
     *
     * @param result the result of the test method
     * @throws IOException if an I/O error occurs during screenshot capture
     */
    private void handleTestResult(ITestResult result) throws IOException {
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                log.info("***** Passed Test Case " + result.getMethod().getMethodName() + " *****");
                break;
            case ITestResult.FAILURE:
                log.error("***** Failed Test Case " + result.getMethod().getMethodName()
                        + ". Capturing Screenshot " + takeScreenshot(driver, result.getMethod()) + " *****");
                break;
            case ITestResult.SKIP:
                log.info("***** Skipped Test Case " + result.getMethod().getMethodName() + " *****");
                break;
            default:
                log.warn("***** Unknown Test Result Status (" + result.getStatus() + ") for Test Case " + result.getMethod().getMethodName() + " *****");
        }
    }

    /**
     * Takes a screenshot of the current page.
     *
     * @param driver     the WebDriver instance
     * @param testMethod the test method for which the screenshot is taken
     * @return the absolute path to the screenshot file
     * @throws IOException if an I/O error occurs during screenshot capture
     */
    private String takeScreenshot(WebDriver driver, ITestNGMethod testMethod) throws IOException {
        if (driver == null) {
            log.warn("Unable to take screenshot as driver is not initialized, methodName="
                    + ((testMethod != null) ? testMethod.getMethodName() : null));
            return StringUtils.EMPTY;
        }
        byte[] content = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        File file = getScreenshotFile(testMethod.getMethodName(), testMethod.getTestClass());
        FileUtils.writeByteArrayToFile(file, content);
        return file.getAbsolutePath();
    }

    /**
     * Gets the file to save the screenshot to.
     *
     * @param testName  the name of the test method
     * @param testClass the test class
     * @return the file to save the screenshot to
     */
    private static File getScreenshotFile(String testName, ITestClass testClass) {
        return new File(System.getProperty("user.dir") + File.separator + "screenshots"
                + File.separator + getScreenshotName(testName, testClass));
    }

    /**
     * Gets the name for the screenshot file.
     *
     * @param testName  the name of the test method
     * @param testClass the test class
     * @return the name for the screenshot file
     */
    private static String getScreenshotName(String testName, ITestClass testClass) {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
        return testName + "_" + testClass.getName() + "_" + dateFormat.format(new Date()) + ".png";
    }

    /**
     * Quits the WebDriver, performing necessary cleanup.
     */
    protected void quitWebDriver() {
        if (driver != null) {
            try {
                if (driver.getCurrentUrl().startsWith("http")) {
                    log.info("Attempting reset, url=" + driver.getCurrentUrl());
                    new Actions(driver).keyDown(Keys.ALT).sendKeys("R").keyUp(Keys.ALT).perform();
                    Thread.sleep(TimeUnit.SECONDS.toMillis(5));
                    new Actions(driver).sendKeys(Keys.ENTER).perform();
                }
            } catch (Exception e) {
                log.warn("Error during driver reset", e);
            }
            try {
                driver.close();
            } catch (Exception e) {
                log.warn("Error closing WebDriver", e);
            }
            try {
                driver.quit();
            } catch (Exception e) {
                log.error("Error quitting WebDriver", e);
            }
            driver = null;
        }
    }

    /**
     * Gets the WebDriver instance.
     *
     * @return the WebDriver instance
     */
    protected WebDriver getDriver() {
        return driver;
    }

    /**
     * Gets the timeout instance
     *
     * @return the timeout instance
     */
    public int getTimeOut() {
        return timeOut;
    }
}
