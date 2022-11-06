package Pages.GoogleTranslatePages;

import Pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleTranslatePage extends AbstractPage {

    public GoogleTranslatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[@class=\"VfPpkd-Bz112c-RLmnJb\"])[1]")
    private WebElement leftAllLangButton;
    @FindBy(xpath = "(//div[@class=\"VfPpkd-Bz112c-RLmnJb\"])[3]")
    private WebElement rightAllLangButton;
    @FindBy(xpath = "(//div[@data-language-code=\"en\"])[1]")
    private WebElement englishLeftButtonFromAll;
    @FindBy(xpath = "(//div[@data-language-code=\"ru\"])[2]")
    private WebElement russianRightButtonFromAll;
    @FindBy(xpath = "//button[@data-language-code=\"ru\"]")
    public WebElement russianRightButton;
    @FindBy(xpath = "//button[@data-language-code=\"en\"]")
    public WebElement englishLeftButton;
    @FindBy(xpath = "//textarea[@aria-label=\"Source text\"]")
    private WebElement textBar;
    @FindBy(xpath = "//span[@class=\"ryNqvb\"]")
    public WebElement resultBar;

    public void translateTest() {
        setLang(leftAllLangButton, englishLeftButtonFromAll);
        waiter.until(ExpectedConditions.elementToBeClickable(rightAllLangButton));
        setLang(rightAllLangButton, russianRightButtonFromAll);
        waiter.until(ExpectedConditions.elementToBeClickable(textBar));
        textBar.sendKeys("Test");
        waiter.until(ExpectedConditions.visibilityOf(resultBar));
    }

    public void setLang(WebElement allLangButton, WebElement langButton) {
        allLangButton.click();
        actions.moveToElement(langButton).perform();
        waiter.until(ExpectedConditions.elementToBeClickable(langButton));
        langButton.click();
    }
}
