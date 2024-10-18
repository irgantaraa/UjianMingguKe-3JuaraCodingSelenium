package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox implements DriverStrategy {

    @Override
    public WebDriver setStrategy() {
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");

        // You can configure FirefoxOptions if needed
        FirefoxOptions options = new FirefoxOptions();

        // Create a new FirefoxDriver with the specified options
        return new FirefoxDriver(options);
    }
}
