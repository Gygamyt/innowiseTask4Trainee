import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

abstract public class TestsBase {

//    @BeforeEach
//    void setUpSession() {
//        Driver.getDriver();
//    }

    @AfterEach
    void destroySession() {
        Driver.closeDriver();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] getScreenshot() {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}