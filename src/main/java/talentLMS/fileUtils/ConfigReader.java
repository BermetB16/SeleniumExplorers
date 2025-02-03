package talentLMS.fileUtils;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ConfigReader {

    static Properties properties;
    static String PATH = "src/main/resources/app.properties";

    private ConfigReader() {
    }

    static {
        try (FileInputStream fis = new FileInputStream(PATH)) {
            properties = new Properties();
            properties.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}