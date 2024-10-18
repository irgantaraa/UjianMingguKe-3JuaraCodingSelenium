import com.juaracoding.Utils;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.PurchaseProduct;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PurchaseTest {
    private static final Logger log = LoggerFactory.getLogger(PurchaseTest.class);
    private WebDriver driver;
    private LoginPage loginPage;
    private PurchaseProduct purchaseProduct;

    @BeforeClass
    public void setUp() {
        // Initialize DriverSingleton using the desired browser, e.g., Chrome
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        purchaseProduct = new PurchaseProduct();
    }

    @AfterClass
    public void finish() {
        Utils.delay(5);
        DriverSingleton.closeObjectInstance();
    }

    @Test (priority = 1)
    public void purchaseTest() {
        log.info("Starting successful purchase test");
        loginPage.loginuser("standard_user", "secret_sauce");
        purchaseProduct.checkout();
        purchaseProduct.form("Irgantara", "form", "17131");
        String successMessage = purchaseProduct.getTxtSuccesfull();
        Assert.assertEquals(successMessage, "Thank you for your order!");
        log.info("Purchase test passed with success message: {}", successMessage);
        purchaseProduct.DashboardLogout();
    }

    @Test (priority = 2)
    public void purchaseNegativeTest() {
        log.info("Starting negative purchase test");
        loginPage.loginuser("standard_user", "secret_sauce");
        purchaseProduct.checkout();
        purchaseProduct.fillEmptyForm("", "", ""); // Using a more descriptive method name
        String errorMessage = purchaseProduct.getTxtInvalid();
        Assert.assertEquals(errorMessage, "Error: First Name is required");
        log.info("Negative purchase test passed with error message: {}", errorMessage);
    }
}
