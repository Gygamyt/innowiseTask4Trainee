import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

abstract public class TestsBase {

//    @BeforeEach
//    void setUpSession() {
//        Driver.getDriver();
//    }

    @AfterEach
    void destroySession() {
        Driver.closeDriver();
    }

}