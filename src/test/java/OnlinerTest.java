import Conf.Driver;
import Pages.OnlinerPages.CartOnliner;
import Pages.OnlinerPages.MainOnlinerPage;
import Pages.OnlinerPages.PageOfRequestedProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OnlinerTest extends TestsBase {
    MainOnlinerPage mainOnlinerPage = new MainOnlinerPage(Driver.getDriver());
    PageOfRequestedProduct pageOfRequestedProduct = new PageOfRequestedProduct(Driver.getDriver());
    CartOnliner cartOnlinerPage = new CartOnliner(Driver.getDriver());

    @Test
    public void onlinerTest() {
        Driver.getDriver().get("https://cart.onliner.by/");
        cartOnlinerPage.cartCheckingAndDeleting();
        Driver.getDriver().get("https://www.onliner.by/");
        mainOnlinerPage.searchRequest();
        Assertions.assertTrue(pageOfRequestedProduct.valueForResultOfRequestCheck.getText().equalsIgnoreCase(mainOnlinerPage.request));
        pageOfRequestedProduct.moduleChecking();
        pageOfRequestedProduct.addProductToCart();
        System.out.println(pageOfRequestedProduct.sidePanelForAssertion.getText());
        Assertions.assertTrue(pageOfRequestedProduct.sidePanelForAssertion.getText().equalsIgnoreCase("Товар добавлен в корзину"));
        Assertions.assertTrue(pageOfRequestedProduct.numberOfProductsValue.getText().equalsIgnoreCase("1"));
        Driver.getDriver().get("https://cart.onliner.by/");
        cartOnlinerPage.cartCheckingAndDeleting();
        Assertions.assertTrue(cartOnlinerPage.emptyCartMessage.getText().equalsIgnoreCase("Ваша корзина пуста"));
    }

//    @Test
//    public void utilityTest() {
//        pageOfRequestedProduct.addProductToCart();
//    }
}
