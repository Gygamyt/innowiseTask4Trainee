import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    private static WebDriver driver = Driver.getDriver();

    public AbstractPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        AbstractPage.driver = driver;
    }

}
