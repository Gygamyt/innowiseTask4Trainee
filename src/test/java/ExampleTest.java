import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class ExampleTest extends TestsBase {

    private final WebDriver driver = Driver.getDriver();
    private final LoginTestPage loginTestPage = new LoginTestPage(driver);


    private final String correctLogin = "tomsmith";
    private final String correctPassword = "SuperSecretPassword!";
    private final String incorrectLogin = "foo";
    private final String incorrectPassword = "bar!";

    @Test
    public void correctLogin() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/login");
        loginTestPage.fillLoginBar(correctLogin);
        loginTestPage.fillPasswordBar(correctPassword);
        loginTestPage.finallyLogin();
        Assertions.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://the-internet.herokuapp.com/secure"));
    }

    @Test
    public void incorrectLogin() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/login");
        loginTestPage.fillLoginBar(incorrectLogin);
        loginTestPage.fillPasswordBar(incorrectPassword);
        loginTestPage.finallyLogin();
        Assertions.assertTrue(LoginTestPage.unSuccessfulLogin.isDisplayed());
    }
}