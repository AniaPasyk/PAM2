package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

    private static final String propFilesPath = "src/test/resources/resources.properties";

    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propFilesPath));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return properties;
    }
}


