package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EdgeDriverFactory extends DriverFactory {

    @Override
    protected void initDriver() {
        WebDriverManager.edgedriver().clearDriverCache().setup();
        EdgeOptions options = createEdgeOptions();
        driver = new EdgeDriver(options);
    }

    @Override
    public EdgeOptions getCapabilities() {
        return createEdgeOptions();
    }

    /**
     * Creates and configures EdgeOptions.
     *
     * @return configured EdgeOptions instance
     */
    public EdgeOptions createEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        configureArguments(options);
        configureExperimentalOption(options);
        configurePreferences(options);
        return options;
    }

    /**
     * Configures Preferences with various settings
     *
     * @param options the EdgeOptions instance to configure
     */
    private void configurePreferences(EdgeOptions options) {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
    }

    /**
     * Configures ExperimentalOption with various settings
     *
     * @param options the EdgeOptions instance to configure
     */
    public void configureExperimentalOption(EdgeOptions options) {
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
    }

    /**
     * Configures ExperimentalOption with various settings
     *
     * @param options the EdgeOptions instance to configure
     */
    public void configureArguments(EdgeOptions options) {
        options.addArguments("test-type",
                "allow-running-insecure-content",
                "start-maximized",
                "disable-extensions",
                "disable-dev-shm-usage",
                "disable-popup-blocking",
                "disable-infobars");
    }
}
