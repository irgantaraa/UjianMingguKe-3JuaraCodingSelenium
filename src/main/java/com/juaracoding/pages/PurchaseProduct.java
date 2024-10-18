package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

public class PurchaseProduct {
    private WebDriver driver;
    private WebDriverWait wait;

    public PurchaseProduct() {
        this.driver = DriverSingleton.getDriver();
        initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement backpack;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement tshirt;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
    private WebElement onesie;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement bike;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    private WebElement jacket;

    @FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
    private WebElement redShirt;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement shoppingCart;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkout;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCode;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement complete;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    private WebElement errorMessage;


    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backToProducts;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement btnReactBurgerMenu;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement btnLogout;


    public void checkout() {
        backpack.click();
        tshirt.click();
        onesie.click();
        bike.click();
        jacket.click();
        redShirt.click();
        shoppingCart.click();
        checkout.click();
    }
    public void DashboardLogout() {
        this.btnReactBurgerMenu.click();
        this.btnLogout.click();
    }

    public void form(String firstName, String lastName, String postalCode) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);
        continueButton.click();
        finishButton.click(); // Consider adding a wait here if needed
        //backToProducts.click();
    }

    public String getTxtSuccesfull() {
        return complete.getText();
    }

    public void fillEmptyForm(String firstName, String lastName, String postalCode) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);
        continueButton.click(); // This should show the error if the fields are empty
    }

    public String getTxtInvalid() {
        return errorMessage.getText();
    }
}
