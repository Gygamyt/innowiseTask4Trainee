import Conf.Driver;
import Pages.RelaxPages.LunaPage;
import Pages.RelaxPages.RelaxMainPage;
import Pages.RelaxPages.RestaurantsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

//done
public class RelaxTest extends TestsBase {
    private final RelaxMainPage relaxMainPage = new RelaxMainPage(Driver.getDriver());
    private final LunaPage lunaPage = new LunaPage(Driver.getDriver());
    private final RestaurantsPage restaurantsPage = new RestaurantsPage(Driver.getDriver());

    public final String lunaPhoneExpected = "+375 29 333-00-74";
    public final String lunaAddressExpected = "Могилев, ул. Ленинская, 22";

    private String lunaAddressResult;
    private String lunaPhoneResult;
    public final ArrayList<String> lunaWorkingHoursExpected = new ArrayList<>() {{
        add("12:00—00:00");
        add("12:00—00:00");
        add("12:00—00:00");
        add("12:00—00:00");
        add("12:00—02:00");
        add("14:00—02:00");
        add("14:00—00:00");
    }};

    public ArrayList<String> lunaWorkingHours;

    @Test
    public void lunaTest() {
        Driver.getDriver().get("https://www.relax.by/");
        relaxMainPage.findLuna();
        lunaAddressResult = lunaPage.addressButton.getText();
        lunaPhoneResult = lunaPage.phoneButton.getText();
        lunaWorkingHours = new ArrayList<>();
        lunaPage.lunaWorkingHoursButton.click();
        wait.until(ExpectedConditions.visibilityOf(lunaPage.forWaiter));
        lunaPage.fillListLunaWorkingHours(lunaWorkingHours);
        Assertions.assertAll(
                () -> Assertions.assertIterableEquals(lunaWorkingHoursExpected, lunaWorkingHours),
                () -> Assertions.assertEquals(lunaPhoneExpected, lunaPhoneResult),
                () -> Assertions.assertEquals(lunaAddressExpected, lunaAddressResult)
        );
    }
    @Test
    public void restaurantTest() throws InterruptedException {
        Driver.getDriver().get("https://www.relax.by/");
        relaxMainPage.openRestaurantPage();
        restaurantsPage.applyingFilters();
        wait.until(ExpectedConditions.visibilityOf(restaurantsPage.varForAssertionSecond));
        Thread.sleep(1000);
        Assertions.assertEquals("2", restaurantsPage.varForAssertionSecond.getText());
    }
}
