import org.helper.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    DriverManager driverManager;
    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void initTestPreRequisites() {
        this.driverManager = new DriverManager();
        driver = this.driverManager.initChromeDriver();
        this.initURL();
    }

    public void initURL() {
        driver.get("https://elpais.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
