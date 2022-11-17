package Pages.OnlinerPages;

import Conf.Driver;
import Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainOnlinerPage extends AbstractPage {

    public MainOnlinerPage(WebDriver driver) {
        super(driver);
    }

    public final String request = "Смартфон Samsung Galaxy A52 SM-A525F/DS 4GB/128GB (черный)";

    @FindBy(xpath = "//input[@class=\"fast-search__input\"]")
    private static WebElement searchBar;

    @FindBy(xpath = "//iframe[@class=\"modal-iframe\"]")
    private static WebElement iFrameForSwitch;

    @FindBy(xpath = "//div[@class=\"result__item result__item_product\"]")
    private static WebElement result;

    public void searchRequest() {
        actions
                .click(searchBar)
                .sendKeys(request)
                .perform();
        Driver.getDriver().switchTo().frame(iFrameForSwitch);
        actions
                .click(result)
                .perform();
    }
}