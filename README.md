
# Selenium WebDriver Test Automation

## Description

This project is a test automation suite built using **Selenium WebDriver** and **TestNG** for testing e-commerce functionality and login processes. The tests include scenarios for both successful and unsuccessful product purchases on a demo e-commerce platform (SauceDemo), as well as basic login operations.

The project covers the following key features:
1. Performing valid login and verifying successful access to the dashboard.
2. Completing a successful product purchase.
3. Handling invalid product purchase attempts and checking for error messages when fields are left blank.
4. Logging out from the dashboard after successful tests.

## Prerequisites

- Java Development Kit (JDK) version 8 or higher
- Maven
- Chrome or any other browser supported by Selenium WebDriver
- An IDE (e.g., IntelliJ IDEA, Eclipse) for writing and running the tests

## Tools & Libraries

- **Selenium WebDriver**: For automating browser interaction.
- **TestNG**: For writing and executing test cases.
- **SLF4J**: Logging framework for debugging and tracking test flow.
- **WebDriverWait**: To manage time-based waits for web elements.
- **PageFactory**: For using the Page Object Model (POM) pattern in Selenium.

## Setup Instructions

### Clone the Repository

```bash
git clone https://github.com/irgantaraa/UjianMingguKe-3JuaraCodingSelenium/g.git
cd UjianMingguKe-3JuaraCodingSelenium/
```

### Install Dependencies

Ensure you have Maven installed. Run the following command to download all dependencies:

```bash
mvn clean install
```

### WebDriver Configuration

The project uses `DriverSingleton` to manage the WebDriver instance. The default browser is Chrome, but you can change it by modifying the `DriverSingleton.getInstance("chrome")` method.

## Running the Tests

### From Command Line

Run the tests using the Maven command:

```bash
mvn test
```

### From IDE

You can run the tests from an IDE (such as IntelliJ IDEA or Eclipse) by selecting the test classes (`LoginTest.java` and `PurchaseTest.java`) and running them.

### Test Cases

#### Login Test Cases

1. **Valid Login Test** (`testValidLogin`)
   - Logs in with valid credentials (`standard_user` / `secret_sauce`).
   - Asserts the presence of the "Dashboard" text upon successful login.

2. **Invalid Login Test** (`testInvalidLogin`)
   - Attempts login with invalid credentials.
   - Asserts the error message "Invalid credentials" is displayed.


#### Purchase Test Cases

1. **Successful Purchase Test** (`purchaseTest`)
   - Logs in with valid credentials (`standard_user` / `secret_sauce`).
   - Adds multiple products to the cart.
   - Proceeds to checkout and completes the purchase with valid input.
   - Verifies the success message: "Thank you for your order!"

2. **Negative Purchase Test** (`purchaseNegativeTest`)
   - Logs in with valid credentials.
   - Attempts to complete a purchase with empty form fields.
   - Verifies the error message: "Error: First Name is required."

### Browser Configuration

The default browser is Chrome, as specified in the `DriverSingleton`. If you need to change the browser, update the following method call:

```java
DriverSingleton.getInstance("chrome");  // Change "chrome" to "firefox" or other browser names
```

## Project Structure

### `LoginTest.java`
This class contains three test cases:
- **testValidLogin**: Tests successful login with valid credentials.
- **testInvalidLogin**: Tests invalid login with incorrect credentials.
- **testimagedisplayed**: Checks if the company branding image is displayed.

### `PurchaseTest.java`
This class contains two test cases:
- **purchaseTest**: Tests successful purchase flow from adding products to completing the checkout.
- **purchaseNegativeTest**: Tests invalid purchase attempts when required form fields are left empty.

### `LoginPage.java`
This class defines the methods and locators for interacting with the login page's elements:
- **loginuser**: Fills in the username and password fields and clicks login.
- **getTxtDashboard**: Returns the text "Dashboard" after successful login.
- **getTxtInvalid**: Returns the error message in case of an invalid login attempt.

### `PurchaseProduct.java`
This class manages the purchase process by interacting with product page elements:
- **checkout**: Adds products to the cart and proceeds to checkout.
- **form**: Fills out the checkout form with customer details.
- **getTxtSuccesfull**: Retrieves the success message after completing the purchase.
- **fillEmptyForm**: Submits an empty form to trigger the error message.
- **getTxtInvalid**: Retrieves the error message after form validation failure.

## Customizing Test Scenarios

You can add additional test scenarios by extending the test classes (`LoginTest` and `PurchaseTest`) or by adding more methods in `LoginPage` and `PurchaseProduct`.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

# Test Scenarios Google Sheet
# You can view the test scenarios documented in the following Google Sheet:
"View the test scenarios here: https://docs.google.com/spreadsheets/d/15163Jwcj73jElUpOVxPjHr_Py5em-9fWa60BbagRU_o/edit?gid=1763640593#gid=1763640593"

# Video Tutorial
# YouTube video tutorial for this project: 
"Watch the video tutorial: https://youtu.be/nOXQjUj_shs"
