import com.juaracoding.Utils;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        // Inisialisasi DriverSingleton dengan menggunakan browser yang diinginkan, misalnya Chrome
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
    }

    @AfterClass
    public void finish() {
        Utils.delay(5);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testValidLogin() {
        // Menggunakan metode loginuser di LoginPage dengan input valid
        loginPage.clearTextBoxes();
        loginPage.loginuser("standard_user", "secret_sauce");
        Assert.assertEquals(loginPage.getTxtDashboard(), "Products");  // Harus sesuai dengan teks yang muncul
        loginPage.DashboardLogout();
    }

    // Tes invalid login (opsional)
    @Test(priority = 2)
    public void testInvalidLogin() {
        loginPage.loginuser("invalidUser", "invalidPass");
        Assert.assertEquals(loginPage.getTxtInvalid(), "Epic sadface: Username and password do not match any user in this service");
    }

}
