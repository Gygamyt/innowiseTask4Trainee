import Conf.Driver;
import Pages.AmazonPages.BaseAmazonPage;
import Pages.AmazonPages.CartPage;
import Pages.AmazonPages.SearchAmazonPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AmazonTest extends TestsBase {

    private final BaseAmazonPage baseAmazonPage = new BaseAmazonPage(Driver.getDriver());
    private final SearchAmazonPage searchAmazonPage = new SearchAmazonPage(Driver.getDriver());

    private final CartPage cartPage = new CartPage(Driver.getDriver());
    @Test
    public void amazonTest() {
        Driver.getDriver().get("https://www.amazon.com/");
        baseAmazonPage.loginArrowButtonOpen();
        baseAmazonPage.emailInput();
        baseAmazonPage.passwordInput();
        Assertions.assertNotEquals("Hello, sign in", baseAmazonPage.signInChecker.getText());
        baseAmazonPage.searchAction();
        Assertions.assertEquals("\"iPhone\"", searchAmazonPage.searchChecker.getText());
        searchAmazonPage.addPhoneAndCheck();
        baseAmazonPage.checkResultOfTest();
        Assertions.assertNotEquals("Your Amazon Cart is empty.", baseAmazonPage.variableForResultChecking.getText());
        cartPage.deleteItemsFromCart();
    }
}