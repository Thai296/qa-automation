package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ChromeDriverFactory extends DriverFactory {

    @Override
    protected void initDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions options = createChromeOptions();
        driver = new ChromeDriver(options);
    }

    @Override
    public ChromeOptions getCapabilities() {
        return createChromeOptions();
    }

    /**
     * Creates and configures ChromeOptions.
     *
     * @return configured ChromeOptions instance
     */
    public ChromeOptions createChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        configureArguments(options);
        configureExperimentalOption(options);
        configurePreferences(options);
        return options;
    }

    /**
     * Configures Preferences with various settings
     *
     * @param options the ChromeOptions instance to configure
     */
    private void configurePreferences(ChromeOptions options) {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
    }

    /**
     * Configures ExperimentalOption with various settings
     *
     * @param options the ChromeOptions instance to configure
     */
    public void configureExperimentalOption(ChromeOptions options) {
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
    }

    /**
     * Configures ExperimentalOption with various settings
     *
     * @param options the ChromeOptions instance to configure
     */
    public void configureArguments(ChromeOptions options) {
        options.addArguments("test-type",
                "allow-running-insecure-content",
                "start-maximized",
                "disable-extensions",
                "disable-dev-shm-usage",
                "disable-popup-blocking",
                "--remote-allow-origins=*",
                "disable-infobars");
    }
}
