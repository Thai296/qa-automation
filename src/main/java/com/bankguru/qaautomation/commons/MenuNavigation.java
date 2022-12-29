package com.bankguru.qaautomation.commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class MenuNavigation {
	private Log log = LogFactory.getLog(getClass());
	private WebDriver driver;
	private ConfigurationLoader configLoader;

	public MenuNavigation(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateHomePage() throws Exception {
		configLoader = new ConfigurationLoader();
		String url = configLoader.loadConfiguration().getProperty(GlobalConstants.URL);//bankGuru page
		navigateToUrl(url);
	}

	private void navigateToUrl(String url) {
		log.info("Navigate to URL: " + url);
		driver.get(url.toString());
	}
}
