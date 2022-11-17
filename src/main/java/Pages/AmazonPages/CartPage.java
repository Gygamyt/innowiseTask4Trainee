package Pages.AmazonPages;

import Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends AbstractPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class=\"a-size-small sc-action-delete\"]//a[@class=\"a-link-normal\"]")
    WebElement firstItemForDeleting;

    @FindBy(xpath = "(//input[@type=\"submit\"][@value=\"Delete\"])[3]")
    public WebElement deleteAllItemsAButton;

    public void deleteItemsFromCart() {
        firstItemForDeleting.click();
        waiter.until(ExpectedConditions.elementToBeClickable(deleteAllItemsAButton));
        actions.moveToElement(deleteAllItemsAButton).click().perform();
    }
}
