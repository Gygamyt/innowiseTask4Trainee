package Pages.RelaxPages;

import Conf.Driver;
import Pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class LunaPage extends AbstractPage {

    public LunaPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@class=\"Button PersonalContacts__item PersonalContacts__worktime Button--outline\"]")
    public WebElement lunaWorkingHoursButton;
    @FindBy(css = "span.Button__text")
    public WebElement addressButton;
    @FindBy(xpath = "//span[@class=\"Button__phone\"]")
    public WebElement phoneButton;
    @FindBy(xpath = "//div[@class=\"Popup__content\"]")
    public WebElement forWaiter;

    public ArrayList<String> fillListLunaWorkingHours(ArrayList<String> arrayList) {
        for (int utilityInt = 1; utilityInt < 8; utilityInt++) {
            WebElement workHours = Driver.getDriver()
                    .findElement(By.xpath(String.format("(//div[@class=\"ContactsPopupOpening__subMain\"])[%d]", utilityInt)));
            arrayList.add(workHours.getText());
        }
        return arrayList;
    }
}
