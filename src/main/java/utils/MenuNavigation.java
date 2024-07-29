package utils;

import constants.PropertyMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import selenium.WebDriverInteractions;

public class MenuNavigation {
    private static final Logger LOG = Logger.getLogger(MenuNavigation.class);
    private final WebDriverInteractions webDriverInteractions;
    private final ConfigLoader config;
    public MenuNavigation(WebDriver driver, ConfigLoader config) {
        this.config = config;
        webDriverInteractions = new WebDriverInteractions(driver);
    }

    public void navigateLoginPage() {
        webDriverInteractions.getUrl(config.getUrl() + PropertyMap.LOGIN_PAGE);
    }
}
