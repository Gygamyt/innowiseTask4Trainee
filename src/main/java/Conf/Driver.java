package Conf;

import Utils.ConfPropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class Driver {

    private static final ThreadLocal<WebDriver> localStorage = new ThreadLocal<>();

    private static final Logger logger = LogManager.getLogger(Driver.class);

    private static final String driverLog = "\n//////////////////////\nConf.Driver has been called.\n//////////////////////";

    public static WebDriver getDriver() {
        if (localStorage.get() == null) {
            setUpDriver();
        }
        setupImplicitWait();
//        logger.info(driverLog);
        return localStorage.get();
    }

    public static void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", ConfPropertiesReader.getProperty("chromeDriver"));
        localStorage.set(setDriversConf());
    }

    public static WebDriver setDriversConf() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
//        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920x1080");
        return new ChromeDriver(options);
    }

    public static void closeDriver() {
        localStorage.get().quit();
        localStorage.remove();
    }

    private static void setupImplicitWait() {
        localStorage.get()
                .manage()
                .timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS);
    }
}