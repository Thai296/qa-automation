package drivers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverFactory extends DriverFactory {
    private final String remoteUrl;
    private final DriverFactory browserFactory;

    public RemoteDriverFactory(DriverFactory browserFactory, String remoteUrl) {
        this.remoteUrl = remoteUrl;
        this.browserFactory = browserFactory;
    }

    @Override
    protected void initDriver() {
        try {
            MutableCapabilities capabilities = browserFactory.getCapabilities();
            driver = new RemoteWebDriver(new URL(remoteUrl), capabilities, false);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Malformed remote URL: " + remoteUrl, e);
        }
    }

    @Override
    public MutableCapabilities getCapabilities() {
        return browserFactory.getCapabilities();
    }
}
