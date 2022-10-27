import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfPropertiesReader {
    static FileInputStream fileInputStream;
    static Properties properties;

    static {
        try {
            fileInputStream = new FileInputStream("src/main/resources/conf.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                assert fileInputStream != null;
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty (String keyString) {
        return properties.getProperty(keyString);
    }

}