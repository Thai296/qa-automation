package drivers;

import org.openqa.selenium.MutableCapabilities;

public class LocalDriverFactory extends DriverFactory {
    private final DriverFactory browserFactory;

    public LocalDriverFactory(DriverFactory browserFactory) {
        this.browserFactory = browserFactory;
    }

    @Override
    protected void initDriver() {
        driver = browserFactory.getDriver();
    }

    @Override
    public MutableCapabilities getCapabilities() {
        return browserFactory.getCapabilities();
    }
}
