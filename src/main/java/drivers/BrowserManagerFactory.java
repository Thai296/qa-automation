package drivers;

import constants.BrowserType;
import constants.EnvironmentType;

public class BrowserManagerFactory {

    /**
     * Gets the appropriate DriverFactory instance based on the provided browser name and environment.
     *
     * @param browserName the name of the browser
     * @param environment the environment
     * @param remoteUrl the URL to remote Selenium Grid
     * @return a DriverFactory instance for the specified browser and environment
     * @throws IllegalArgumentException if the browser or environment is not valid
     */
    public static DriverFactory getBrowser(BrowserType browserName, EnvironmentType environment, String remoteUrl) {
        DriverFactory driverFactory = getLocalDriverFactory(browserName);

        switch (environment) {
            case LOCAL:
                return new LocalDriverFactory(driverFactory);
            case REMOTE:
                if (remoteUrl != null && !remoteUrl.isEmpty()) {
                    return new RemoteDriverFactory(driverFactory, remoteUrl);
                } else {
                    throw new IllegalArgumentException("No such remoteUrl is present to be initialized. RemoteUrl: " + remoteUrl);
                }
            default:
                throw new IllegalArgumentException("No such environment is present to be initialized. Environment: " + environment);
        }
    }

    /**
     * Gets the local driver factory based on the browser name.
     *
     * @param browserName the name of the browser
     * @return a DriverFactory instance for the specified browser
     * @throws IllegalArgumentException if the browser name is not valid
     */
    private static DriverFactory getLocalDriverFactory(BrowserType browserName) {
        switch (browserName) {
            case CHROME:
                return new ChromeDriverFactory();
            case FIREFOX:
                return new FirefoxDriverFactory();
            case EDGE:
                return new EdgeDriverFactory();
            default:
                throw new IllegalArgumentException("No such browser is present to be initialized. Browser name: " + browserName);
        }
    }
}
