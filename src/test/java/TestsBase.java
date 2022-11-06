import Conf.Driver;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class TestsBase {

//    @BeforeEach
//    void setUpSession() {
//        Conf.Driver.getDriver();
//    }

    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @AfterEach
    void destroySession() throws InterruptedException {
//        Thread.sleep(50000);
        Driver.closeDriver();
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] getScreenshot() {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}