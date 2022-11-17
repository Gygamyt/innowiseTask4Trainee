import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestWatcherOverrided implements TestWatcher {

    private final WebDriver driver;
    public TestWatcherOverrided(WebDriver driver) {
        this.driver = driver;
    }
    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
        getScreenshot(driver);
    }
    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        getScreenshot(driver);
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] getScreenshot(WebDriver webDriver) {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }
}
