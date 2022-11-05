package Pages.OnlinerPages;

import Conf.Driver;
import Pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CartOnliner extends AbstractPage {

    public CartOnliner(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"cart-message__title cart-message__title_big\"]")
    public WebElement emptyCartMessage;
    @FindBy(xpath = "//a[@class=\"button-style button-style_auxiliary button-style_small cart-form__button cart-form__button_remove\"]")
    private static WebElement cartRemoveButton;

    @FindBy(xpath = "//a[@class=\"cart-form__link cart-form__link_other cart-form__link_small\"][2]")
    private static WebElement cartCloseButton;

    public void cartCheckingAndDeleting() {
        if (!checkWebElementOnPage(By.xpath("//div[@class=\"cart-message__title cart-message__title_big\"]"))) {
            actions
                    .moveToElement(cartRemoveButton)
                    .click(cartRemoveButton)
                    .perform();
            cartCloseButton.click();
        }
    }
}
