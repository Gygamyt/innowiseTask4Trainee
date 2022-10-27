import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Driver {

    private static final ThreadLocal<WebDriver> localStorage = new ThreadLocal<>();

    private static final Logger logger = LogManager.getLogger(Driver.class);

    private static final String driverLog = "\n//////////////////////\nDriver has been called.\n//////////////////////";

    public static WebDriver getDriver() {
        if (localStorage.get() == null) {
            setUpDriver();
        }
        logger.info(driverLog);
        return localStorage.get();
    }

    public static void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", ConfPropertiesReader.getProperty("chromeDriver"));
        localStorage.set(setDriversConf());
    }

    public static WebDriver setDriversConf() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.addArguments("--start-maximized");
//        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        return new ChromeDriver(options);
    }

    public static void closeDriver() {
        localStorage.get().quit();
        localStorage.remove();
    }
}
