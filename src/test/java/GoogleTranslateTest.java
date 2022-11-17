import Conf.Driver;
import Pages.GoogleTranslatePages.GoogleTranslatePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//done
public class GoogleTranslateTest extends TestsBase {
    GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage(Driver.getDriver());

    @Test
    public void googleTranslateTest() {
        Driver.getDriver().get("https://translate.google.com/");
        googleTranslatePage.translateTest();
        Assertions.assertAll(
                () -> Assertions.assertEquals("true", googleTranslatePage.englishLeftButton.getAttribute("aria-selected")),
                () -> Assertions.assertEquals("true", googleTranslatePage.russianRightButton.getAttribute("aria-selected")),
                () -> Assertions.assertEquals("Тест", googleTranslatePage.resultBar.getText())
        );
    }
}