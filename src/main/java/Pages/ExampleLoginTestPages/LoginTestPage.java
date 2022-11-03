package Pages.ExampleLoginTestPages;

import Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginTestPage extends AbstractPage {

    public LoginTestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id=\"username\"]")
    private static WebElement nameBar;

    @FindBy(xpath = "//input[@id=\"password\"]")
    private static WebElement passwordBar;

    @FindBy(xpath = "//i[@class=\"fa fa-2x fa-sign-in\"]")
    private static WebElement loginButton;

    @FindBy(xpath = "//div[@id=\"flash\"]")
    public static WebElement unSuccessfulLogin;

    public void fillLoginBar(String login) {
        nameBar.sendKeys(login);
    }

    public void fillPasswordBar(String password) {
        passwordBar.sendKeys(password);
    }
    public void finallyLogin() {
        loginButton.click();
    }


}
