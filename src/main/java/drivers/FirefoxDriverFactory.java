package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverFactory extends DriverFactory {

    @Override
    protected void initDriver() {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        FirefoxOptions options = createFirefoxOptions();
        driver = new FirefoxDriver(options);
    }

    @Override
    public FirefoxOptions getCapabilities() {
        return createFirefoxOptions();
    }

    /**
     * Creates and configures FirefoxOptions.
     *
     * @return configured FirefoxOptions instance
     */
    public FirefoxOptions createFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        configureArguments(options);
        return options;
    }

    /**
     * Configures ExperimentalOption with various settings
     *
     * @param options the FirefoxOptions instance to configure
     */
    public void configureArguments(FirefoxOptions options) {
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
