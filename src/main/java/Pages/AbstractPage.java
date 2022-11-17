package Pages;

import Conf.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    private static WebDriver driver = Driver.getDriver();

    public Actions actions = new Actions(Driver.getDriver());

    public JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();

    public WebDriverWait waiter = new WebDriverWait(Driver.getDriver(), 10);

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
