package Pages.RelaxPages;

import Conf.Driver;
import Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RelaxMainPage extends AbstractPage {

    public RelaxMainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "search_open")
    public WebElement searchOpenInput;

    @FindBy(xpath = "//div[text()=\"Luna\"]")
    public WebElement neededSearchResult;

    @FindBy(xpath = "//div[@title=\"Еда\"][@class=\"CategoriesMainMenu__item isActive\"]")
    public WebElement foodButton;

    @FindBy(xpath = "//a[text()=\"Рестораны\"]")
    public WebElement restaurantButton;
    

    public void findLuna() {
        actions
                .moveToElement(searchOpenInput)
                .click(searchOpenInput)
                .sendKeys("Luna")
                .moveToElement(neededSearchResult)
                .click(neededSearchResult)
                .perform();
    }

    public void openRestaurantPage() {
        actions
                .moveToElement(foodButton)
                .click(foodButton)
                .perform();
        waiter.until(ExpectedConditions.visibilityOf(restaurantButton));
        actions
                .moveToElement(restaurantButton)
                .click(restaurantButton)
                .perform();
    }

}
