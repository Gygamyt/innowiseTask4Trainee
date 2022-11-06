package Pages.AmazonPages;

import Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchAmazonPage extends AbstractPage {

    public SearchAmazonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//a[@class=\"a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal\"])[2]")
    private static WebElement searchResultForAdding;
    @FindBy(xpath = "//*[@id=\"add-to-cart-form\"]/div/span[1]")
    private static WebElement addButtonToCart;
    @FindBy(xpath = "//span[contains(@class, \"a-color-state\")]")
    public WebElement searchChecker;
    @FindBy(id = "a-autoid-28-announce")
    private static WebElement subAccept;

    @FindBy(xpath = "(//span//button[text()=\"Add\"])[1]")
    private static WebElement finallyAddButton;



    public void addPhoneAndCheck() {
        actions
                .moveToElement(searchResultForAdding)
                .click(searchResultForAdding)
                .moveToElement(subAccept)
                .click(subAccept)
                .click(addButtonToCart)
                .perform();
        javascriptExecutor.executeScript("arguments[0].click();", finallyAddButton);
    }
}
