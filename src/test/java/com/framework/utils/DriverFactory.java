package com.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver() {

        String browser = PropertiesReader.get("browser");
        String headless = PropertiesReader.get("headless");
        String maximize = PropertiesReader.get("maximize");

        if (browser == null || browser.isEmpty()) {
            browser = "chrome";
        }

        switch (browser.toLowerCase()) {

            case "firefox":
                FirefoxOptions ffOptions = new FirefoxOptions();

                if ("true".equalsIgnoreCase(headless)) {
                    ffOptions.addArguments("--headless");
                }

                driver.set(new FirefoxDriver(ffOptions));
                break;

            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();

                if ("true".equalsIgnoreCase(headless)) {
                    chromeOptions.addArguments("--headless=new");
                }

                driver.set(new ChromeDriver(chromeOptions));
                break;
        }

        // Maximize window if configured
        if ("true".equalsIgnoreCase(maximize)) {
            driver.get().manage().window().maximize();
        }

        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
