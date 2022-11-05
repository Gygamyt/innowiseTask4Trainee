package Pages.RelaxPages;

import Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RestaurantsPage extends AbstractPage {

    public RestaurantsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//span[@class=\"MenuItem__text\"])[2]")
    private WebElement filterButton;
    @FindBy(xpath = "(//div[@class=\"FilterSidebar__item --itemSelect\"])[2]")
    private WebElement raionButton;
    @FindBy(xpath = "//span[text()=\"Заводской\"]")
    private WebElement zavodskoiButton;
    @FindBy(xpath = "//span[text()=\"Еда навынос\"]")
    private WebElement neededFoodVariant;
    @FindBy(xpath = "//div[@class=\"CompositeButtons__toggle\"]")
    private WebElement allFoodVariants;
    @FindBy(xpath = "//span[text()=\"Белорусская\"]")
    private WebElement belorussianFood;
    @FindBy(xpath = "//span[text()=\"Да\"]")
    private WebElement yesButton;
    @FindBy(xpath = "//span[text()=\"Показать\"]")
    private WebElement showButton;
    @FindBy(xpath = "//span[@class=\"CatalogNav__count u-grayLightest\"]")
    public WebElement varForAssertionSecond;
    @FindBy(xpath = "//h1[@class=\"CatalogNav__heading u-paddingRight--2x\"]")
    public WebElement varForAssertionFirst;

    public void applyingFilters() {
        filterButton.click();
        waiter.until(ExpectedConditions.visibilityOf(raionButton));
        raionButton.click();
        waiter.until(ExpectedConditions.visibilityOf(zavodskoiButton));
        zavodskoiButton.click();
        allFoodVariants.click();
        waiter.until(ExpectedConditions.visibilityOf(neededFoodVariant));
        actions.moveToElement(neededFoodVariant).click(neededFoodVariant).perform();
        waiter.until(ExpectedConditions.visibilityOf(belorussianFood));
        belorussianFood.click();
        actions.moveToElement(yesButton).click(yesButton).perform();
        showButton.click();
    }
}
