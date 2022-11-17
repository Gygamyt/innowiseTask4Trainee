import Conf.Driver;
import Pages.OnlinerPages.CartOnliner;
import Pages.OnlinerPages.MainOnlinerPage;
import Pages.OnlinerPages.PageOfRequestedProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OnlinerTest extends TestsBase {
    private final MainOnlinerPage mainOnlinerPage = new MainOnlinerPage(Driver.getDriver());
    private final PageOfRequestedProduct pageOfRequestedProduct = new PageOfRequestedProduct(Driver.getDriver());
    private final CartOnliner cartOnlinerPage = new CartOnliner(Driver.getDriver());

    @Test
    public void onlinerTest() {
        Driver.getDriver().get("https://cart.onliner.by/");
        cartOnlinerPage.cartCheckingAndDeleting();
        Driver.getDriver().get("https://www.onliner.by/");
        mainOnlinerPage.searchRequest();
        Assertions.assertEquals(mainOnlinerPage.request, pageOfRequestedProduct.valueForResultOfRequestCheck.getText());
        pageOfRequestedProduct.moduleChecking();
        pageOfRequestedProduct.addProductToCart();
        Assertions.assertEquals("Товар добавлен в корзину", pageOfRequestedProduct.sidePanelForAssertion.getText());
        pageOfRequestedProduct.closeSidePanel();
        Assertions.assertTrue(pageOfRequestedProduct.numberOfProductsValue.isDisplayed());
        pageOfRequestedProduct.returnToTheCart();
        Assertions.assertEquals(mainOnlinerPage.request, pageOfRequestedProduct.varForAssertionInCart.getText());
        cartOnlinerPage.cartCheckingAndDeleting();
        Assertions.assertEquals("Ваша корзина пуста", cartOnlinerPage.emptyCartMessage.getText());
    }
}