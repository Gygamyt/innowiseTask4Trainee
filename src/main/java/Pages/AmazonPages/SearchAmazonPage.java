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

    @FindBy(xpath = "(//a[@class=\"a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal\"])[2]")
    private WebElement searchResultForAdding;

    @FindBy(xpath = "//*[@id=\"add-to-cart-form\"]/div/span[1]")
    private WebElement addButtonToCart;

    @FindBy(xpath = "//span[contains(@class, \"a-color-state\")]")
    public WebElement searchChecker;

    @FindBy(id = "a-autoid-28-announce")
    private WebElement subAccept;

    @FindBy(xpath = "(//span//button[text()=\"Add\"])[1]")
    private WebElement finallyAddButton;

    @FindBy(xpath = "//span[@class=\"a-size-medium a-color-success a-text-beside-button a-text-bold\"]")
    public WebElement varForAdding;

    public void addPhoneAndCheck() {
        actions
                .moveToElement(searchResultForAdding)
                .click(searchResultForAdding)
                .moveToElement(subAccept)
                .click(subAccept)
                .click(addButtonToCart)
                .perform();
        waiter.until(ExpectedConditions.elementToBeClickable(finallyAddButton));
        javascriptExecutor.executeScript("arguments[0].click();", finallyAddButton);
    }
}
