package com;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * Class contains all the properties required to configure the driver
 *
 */
public class Configuration {

    private static Properties prop;

    /* Browser Configuration */
    public static final String LOCAL_BROWSER = getValue("local.browser");

    /* Matson Cargo Portal Configuration */
    public static final String WEB_URL = getValue("webURl");
    public static final String PORTAL_PASSWORD = getValue("portal.password");

    /* Mobile Properties */
    public static final String DEVICE_NAME = getValue("deviceName");
    public static final String PLATFORM_VERSION = getValue("platformVersion");
    public static final String PLATFORM_NAME = getValue("platformName");
    public static final String APP_PACKAGE = getValue("appPackage");
    public static final String APP_ACTIVITY = getValue("appActivity");

    /* Driver Configuration */
    public static final long DEFAULT_IMPLICIT_TIMEOUT = Long.parseLong(getValue("timeout.implicit"));
    public static final long DEFAULT_EXPLICIT_TIMEOUT = Long.parseLong(getValue("timeout.explicit"));

    private static Properties getProp() {
        if (prop == null) {
            prop = new Properties();
            InputStream input;
            try {
                input = new FileInputStream("config.properties");
                prop.load(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return prop;
    }

    /**
     * Initially checks for any environment variable. If null
     * Checks for the property value which is set either from the terminal/console. If null
     * Gets the default value from the config file
     *
     * @param propertyName Property Key set from Environment variables/Maven command line/config
     * @return propertyValue
     */
    public static String getValue(String propertyName) {
        String propertyValue = System.getenv(propertyName);

        if (Objects.isNull(propertyValue)) {
            propertyValue = Objects.isNull(System.getProperty(propertyName)) ? getProp().getProperty(propertyName) : System.getProperty(propertyName);
        }
        return propertyValue;
    }
}
