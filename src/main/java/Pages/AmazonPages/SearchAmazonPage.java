package Pages.AmazonPages;

import Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchAmazonPage extends AbstractPage {

    public SearchAmazonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//a[@class=\"a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal\"])[3]")
    private WebElement searchResultForAdding;

    @FindBy(xpath = "//input[@name=\"submit.add-to-cart\"]")
    private WebElement addButtonToCart;

    @FindBy(xpath = "//span[contains(@class, \"a-color-state\")]")
    public WebElement searchChecker;

    @FindBy(xpath = "//input[@aria-labelledby=\"attachSiNoCoverage-announce\"]")
    private WebElement subAccept;

    @FindBy(xpath = "(//span//button[text()=\"Add\"])[1]")
    private WebElement finallyAddButton;

    @FindBy(xpath = "//span[@class=\"a-size-medium-plus a-color-base sw-atc-text a-text-bold\"]")
    public WebElement varForAdding;

    public void addPhoneAndCheck() {
        actions
                .moveToElement(searchResultForAdding)
                .click(searchResultForAdding)
                .click(addButtonToCart)
                .perform();
        waiter.until(ExpectedConditions.elementToBeClickable(subAccept));
        javascriptExecutor.executeScript("arguments[0].click();", subAccept);
    }
}
