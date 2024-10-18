package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;


    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
        initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement btnlogin;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement txtDashboard;

    @FindBy(css = "h3[data-test='error']")
    private WebElement txtInvalid;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement btnReactBurgerMenu;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement btnLogout;

    // Method for login with provided username and password
    public void loginuser(String username, String password) {
        // Use the method parameters instead of literal strings
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnlogin.click();
    }

    public void DashboardLogout() {
        this.btnReactBurgerMenu.click();
        this.btnLogout.click();
    }

    // Method to get the dashboard text after a valid login
    public String getTxtDashboard() {
        return txtDashboard.getText();
    }

    // Method to get the error message or invalid login message
    public String getTxtInvalid() {
        return txtInvalid.getText();
    }

    public void clearTextBoxes() {
        username.clear();
        password.clear();
    }

   /* public String ImgCompanyBrandingDisplayed() {
        return imgCompanyBranding.isDisplayed();
    }*/
}
