package Pages.OnlinerPages;

import Conf.Driver;
import Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PageOfRequestedProduct extends AbstractPage {

    public PageOfRequestedProduct(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@class=\"catalog-masthead__title js-nav-header\"]")
    public WebElement valueForResultOfRequestCheck;

    @FindBy(xpath = "//span[text() = 'Описание и фото']")
    private static WebElement moduleWithDescription;

    @FindBy(xpath = "//li[@class=\"item selected\"]")
    private static WebElement selectedItemXpath;

    @FindBy(xpath = "//*[text() = 'В корзину']")
    private static WebElement neededProduct;

    @FindBy(xpath = "//div[@class=\"product-aside__offers-item product-aside__offers-item_primary\"]")
    private static WebElement utilityForAddingProductMethod;

    @FindBy(xpath = "//div[@class=\"product-recommended__subheader\"][1]")
    public WebElement sidePanelForAssertion;

    @FindBy(xpath = "//div[@class=\"auth-bar__counter\"]")
    public WebElement numberOfProductsValue;


    public void moduleChecking() {
        if (isModuleCheckingClickable(moduleWithDescription)) {
            moduleWithDescription.click();
        }
    }

    private boolean isModuleCheckingClickable (WebElement element){
        return selectedItemXpath.getText().equalsIgnoreCase(element.getText());
    }

    //пробовал очень много вариантов, ничего особо не вышло, поэтому этот безумный костыль
    public void addProductToCart() {
        actions
                .moveToElement(utilityForAddingProductMethod)
                .moveToElement(neededProduct)
                .click(neededProduct)
                .perform();
    }
}
