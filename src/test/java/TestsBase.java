import Conf.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class TestsBase {
    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @RegisterExtension
    public TestWatcherOverrided testWatcherOverrided = new TestWatcherOverrided(Driver.getDriver());

    @AfterAll
    public static void destroySession() throws InterruptedException {
//        Thread.sleep(50000);
        Driver.closeDriver();
    }

//    public void assertTrue(Object page, WebElement webElement, String value){
//        Assertions.assertTrue(page.webElement.getText().equalsIgnoreCase(value));
//    }
}