package utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Logger LOG = Logger.getLogger(ConfigLoader.class);
    private final Properties properties;
    private static ConfigLoader instance;

    /**
     * Private constructor to initialize the ConfigLoader instance.
     * Loads properties from the configuration file and updates environment settings based on TestNG parameters.
     */
    private ConfigLoader() {
        properties = new Properties();
        loadProperties();
//        updateEnvironmentFromTestNG();
    }

    /**
     * Loads properties from the configuration file located at "/config/config.properties".
     * Throws an IOException if the file is not found or cannot be loaded.
     */
    private void loadProperties() {
        try (InputStream inputStream = getClass().getResourceAsStream("/config/config.properties")) {
            if (inputStream == null) {
                throw new IOException("Property file not found.");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the properties with the environment parameter from the TestNG context.
     * This allows setting environment-specific configurations during the test execution.

     private void updateEnvironmentFromTestNG() {
     String environment = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("environment");
     if (environment != null) {
     properties.setProperty("environment", environment);
     }
     }
     */

    /**
     * Returns the single instance of ConfigLoader
     *
     * @return the single instance of ConfigLoader
     */
    public static ConfigLoader getInstance() {
        if (instance == null) instance = new ConfigLoader();

        return instance;
    }

    /**
     * Retrieves the value of a property from the loaded properties.
     *
     * @param key the key of the property to retrieve
     * @return the value of the specified property, or null if the key is not found
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Returns the browser properties
     *
     * @return the browser properties
     */
    public String getBrowser() {
        return getProperty("browser");
    }

    /**
     * Returns the remoteUrl properties
     *
     * @return the GridUrl properties
     */
    public String getRemoteUrl() {
        return getProperty("remoteUrl");
    }

    /**
     * Returns the Url properties
     *
     * @return the Url properties
     */
    public String getUrl() {
        return getProperty("url");
    }

    /**
     * Returns the Environment properties
     *
     * @return the Environment properties
     */
    public String getEnvironment() {
        return getProperty("environment");
    }

    /**
     * Returns the timeout properties
     *
     * @return the timeout properties
     */
    public String getTimeOut() {
        return getProperty("timeOut");
    }
}

