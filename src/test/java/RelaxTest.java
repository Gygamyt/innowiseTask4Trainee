import Conf.Driver;
import Pages.RelaxPages.LunaPage;
import Pages.RelaxPages.RelaxMainPage;
import Pages.RelaxPages.RestaurantsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class RelaxTest extends TestsBase {
    RelaxMainPage relaxMainPage = new RelaxMainPage(Driver.getDriver());
    LunaPage lunaPage = new LunaPage(Driver.getDriver());

    RestaurantsPage restaurantsPage = new RestaurantsPage(Driver.getDriver());

    public final String lunaPhoneExpected = "+375 29 333-00-74";
    public final String lunaAddressExpected = "Могилев, ул. Ленинская, 22";

    String lunaAddressResult;
    String lunaPhoneResult;
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
        System.out.println(lunaWorkingHoursExpected + " expected");
        System.out.println(lunaWorkingHours + " result");
        Assertions.assertAll(
                () -> Assertions.assertIterableEquals(lunaWorkingHoursExpected, lunaWorkingHours),
                () -> Assertions.assertEquals(lunaPhoneExpected, lunaPhoneResult),
                () -> Assertions.assertEquals(lunaAddressExpected, lunaAddressResult)
        );
        getScreenshot();
    }

    @Test
    public void restaurantTest() {
        Driver.getDriver().get("https://www.relax.by/");
        relaxMainPage.openRestaurantPage();
        restaurantsPage.applyingFilters();
        Assertions.assertTrue(restaurantsPage.varForAssertionSecond.getText().equalsIgnoreCase("2"));
        getScreenshot();
    }
}
