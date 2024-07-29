package drivers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;


public abstract class DriverFactory {
    protected WebDriver driver;

    protected abstract void initDriver();

    public WebDriver getDriver() {
        if (null == driver) {
            initDriver();
        }
        return driver;
    }

    public abstract MutableCapabilities getCapabilities();
}
