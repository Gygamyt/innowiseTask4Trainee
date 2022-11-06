import Conf.Driver;
import Pages.GoogleTranslatePages.GoogleTranslatePage;
import org.apache.logging.log4j.core.config.plugins.PluginLoggerContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class GoogleTranslateTest extends TestsBase {
    GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(Driver.getDriver());

    @Test
    public void googleTranslateTest() {
        Driver.getDriver().get("https://translate.google.com/");
        googleTranslatePage.translateTest();
        getScreenshot();
        Assertions.assertAll(
                () -> Assertions.assertTrue(googleTranslatePage.englishLeftButton.getAttribute("aria-selected").equalsIgnoreCase("true")),
                () -> Assertions.assertTrue(googleTranslatePage.russianRightButton.getAttribute("aria-selected").equalsIgnoreCase("true")),
                () -> Assertions.assertTrue(googleTranslatePage.resultBar.getText().equalsIgnoreCase("тест"))
        );
    }
}