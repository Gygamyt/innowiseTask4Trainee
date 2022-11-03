import Conf.Driver;
import Pages.AmazonPages.BaseAmazonPage;
import Pages.AmazonPages.SearchAmazonPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AmazonTest extends TestsBase {

    BaseAmazonPage baseAmazonPage = new BaseAmazonPage(Driver.getDriver());

    SearchAmazonPage searchAmazonPage = new SearchAmazonPage(Driver.getDriver());

    @Test
    public void amazonTest() throws InterruptedException {
        Driver.getDriver().get("https://www.amazon.com/");
        baseAmazonPage.loginArrowButtonOpen();
        baseAmazonPage.emailInput();
        baseAmazonPage.passwordInput();
        Assertions.assertFalse(baseAmazonPage.signInChecker.getText().equalsIgnoreCase("hello, sign in"));
        baseAmazonPage.searchAction();
        Assertions.assertTrue(searchAmazonPage.searchChecker.getText().equalsIgnoreCase("\"iPhone\""));
        searchAmazonPage.addPhoneAndCheck();
        baseAmazonPage.checkResultOfTest();
        Assertions.assertFalse(baseAmazonPage.variableForResultChecking.getText().equalsIgnoreCase("Your Amazon Cart is empty."));
    }
}