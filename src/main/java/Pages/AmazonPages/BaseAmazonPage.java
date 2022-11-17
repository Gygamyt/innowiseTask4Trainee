package Pages.AmazonPages;

import Conf.Driver;
import Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseAmazonPage extends AbstractPage {

    public BaseAmazonPage(WebDriver driver) {
        super(driver);
    }

    SearchAmazonPage searchAmazonPage = new SearchAmazonPage(Driver.getDriver());

    public final Actions actions = new Actions(Driver.getDriver());

    private final String email = "testtesttesttesttestt11t@gmail.com";

    private final String password = "8xVWTOmGermx";

    private final String request = "iPhone";

    @FindBy(xpath = "//span[@class=\"nav-line-2 \"]")
    private static WebElement loginArrowButton;

    @FindBy(css = "span.nav-action-inner")
    private static WebElement signInButton;

    @FindBy(xpath = "//*[@id='ap_email']")
    private static WebElement emailInputField;

    @FindBy(id = "ap_password")
    private static WebElement passwordInputField;

    @FindBy(id = "continue")
    private static WebElement continueButton;

    @FindBy(id = "signInSubmit")
    private static WebElement signInSubmitButton;

    @FindBy(id = "twotabsearchtextbox")
    private static WebElement searchBar;

    @FindBy(id = "nav-search-submit-button")
    private static WebElement searchButton;

    @FindBy(xpath = "//*[@id='nav-link-accountList-nav-line-1']")
    public WebElement signInChecker;

    @FindBy(id = "nav-cart")
    private static WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"sc-active-cart\"]/div/div/div[1]/h1")
    public WebElement variableForResultChecking;

    public void loginArrowButtonOpen() {
        actions
                .moveToElement(loginArrowButton)
                .perform();
        waiter.until(ExpectedConditions.elementToBeClickable(signInButton));
        actions
                .click(signInButton)
                .perform();
    }

    public void emailInput() {
        actions
                .click(emailInputField)
                .sendKeys(email)
                .click(continueButton)
                .perform();
    }

    public void passwordInput() {
        actions
                .click(passwordInputField)
                .sendKeys(password)
                .click(signInSubmitButton)
                .perform();
    }

    public void searchAction() {
        actions
                .click(searchBar)
                .sendKeys(request)
                .click(searchButton)
                .perform();
    }

    public void checkResultOfTest() {
        waiter.until(ExpectedConditions.elementToBeClickable(searchAmazonPage.varForAdding));
        Driver.getDriver().get("https://www.amazon.com/");
        cartButton.click();
    }

}
