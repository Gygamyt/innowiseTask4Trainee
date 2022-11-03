import Conf.Driver;
import Pages.ExampleLoginTestPages.LoginTestPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleTest extends TestsBase {
    private final LoginTestPage loginTestPage = new LoginTestPage(Driver.getDriver());
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
        Assertions.assertTrue(Driver.getDriver().getCurrentUrl().equalsIgnoreCase("https://the-internet.herokuapp.com/secure"));
        getScreenshot();
    }

    @Test
    public void incorrectLogin() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/login");
        loginTestPage.fillLoginBar(incorrectLogin);
        loginTestPage.fillPasswordBar(incorrectPassword);
        loginTestPage.finallyLogin();
        Assertions.assertTrue(LoginTestPage.unSuccessfulLogin.isDisplayed());
        getScreenshot();
    }
}