package utils;

import java.util.Properties;

public class TestArguments {

    // available cmd params
    private static final String username = "username";
    private static final String password = "password";

    // properties from resources.properties file
    private static final Properties properties = ReadPropertiesFile.getProperties();

    public static String getUsername() {
        return System.getProperty(username, properties.getProperty(username));
    }
    public static String getPassword() {
        return System.getProperty(password, properties.getProperty(password));
    }


}
