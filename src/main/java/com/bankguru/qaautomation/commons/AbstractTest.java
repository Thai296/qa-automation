package com.bankguru.qaautomation.commons;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestClass;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.bankguru.qaautomation.browserfactory.BrowserManagerFactory;
import com.bankguru.qaautomation.browserfactory.DriverManager;
import com.bankguru.qaautomation.pageobject.LoginPageObject;
import com.bankguru.qaautomation.pageobject.PageGeneratorManager;

public class AbstractTest {
	protected final Log log;
	protected WebDriver driver;
	protected ConfigurationLoader configLoaded;
	protected DriverManager driverManager;
	protected MenuNavigation menuNavigate;
	protected LoginPageObject loginPageObject;

	protected static final int timeOut = 30;

	protected AbstractTest() {
		this.log = LogFactory.getLog(getClass());
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		configLoaded = new ConfigurationLoader();

		driverManager = BrowserManagerFactory.getBrowser(configLoaded.loadConfiguration().getProperty(GlobalConstants.BROWSER));
		driver = driverManager.getDriver();
		driverManager.navigateToDriver(configLoaded.loadConfiguration().getProperty(GlobalConstants.URL));
		driverManager.maximizeBrowser();
		driverManager.setImplicitWaitTimeOut(timeOut);

		log.info("*** Before Method ***");

		menuNavigate = new MenuNavigation(driver);
		loginPageObject = PageGeneratorManager.getLoginPage(driver);

//		this step user to bankGuru page
		log.info("Step 1: Action: Login with username and password valid.");
		loginPageObject.loginToLoginPage();
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws Exception {
		try {
			switch (result.getStatus()) {
			case ITestResult.SUCCESS:
				log.info("***** Passed Test Case " + result.getMethod().getMethodName() + " *****");
				break;
			case ITestResult.FAILURE:
				log.error("***** Failed Test Case " + result.getMethod().getMethodName() + ". Capturing Screenshot " + takeScreenshot(driver, result.getMethod()) + " *****");
				break;
			case ITestResult.SKIP:
				log.info("***** Skipped Test Case " + result.getMethod().getMethodName() + " *****");
				break;
			default:
				log.warn("***** Unknown Test Result Status (" + result.getStatus() + ") for Test Case " + result.getMethod().getMethodName() + " *****");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			quitWebDriver();
		}
	}

	private String takeScreenshot(WebDriver driver, ITestNGMethod testMethod) throws IOException {
		if (driver == null) {
			log.warn("Unable to take screenshot as driver is not initialized, methodName=" + ((testMethod != null) ? testMethod.getMethodName() : null));
			return StringUtils.EMPTY;
		}
		byte[] content = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		File file = getScreenshotFile(testMethod.getMethodName(), testMethod.getTestClass());
		FileUtils.writeByteArrayToFile(file, content);
		return file.getAbsolutePath();
	}

	private static File getScreenshotFile(String testName, ITestClass testclass) throws IOException {
		return new File(System.getProperty("user.dir") + File.separator + "screen-shots" + File.separator + getScreenshotName(testName, testclass));
	}

	private static String getScreenshotName(String testName, ITestClass testclass) {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
		return testName + "_" + testclass.getName() + "_" + dateFormat.format(new Date()) + ".png";
	}

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
				// No big deal
			}
			try {
				driver.close();
			} catch (Exception e) {
				// Maybe no big deal either
			}
			try {
				driver.quit();
			} catch (Exception e) {
				// Might be a problem
				log.error("Error quitting WebDriver, driver=" + driver, e);
			}
			driver = null;
		}
	}
}
