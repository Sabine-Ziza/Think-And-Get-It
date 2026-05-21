
package utils;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;


public class ConfigLoader {
    private static Properties properties;

    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");

            properties = new Properties();
            properties.load(file);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}

