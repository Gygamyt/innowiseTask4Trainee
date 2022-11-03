package Pages;

import Conf.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    private static WebDriver driver = Driver.getDriver();

    public boolean checkWebElementOnPage(By element) {
        try {
            Driver.getDriver().findElement(element);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public AbstractPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        AbstractPage.driver = driver;
    }

}
