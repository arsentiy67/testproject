package com.epam.testproject;

import core.DriverFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

public class WebDriverManager {

    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static void initWebDriver() {
        WebDriver webDriver = createWebDriverInstance();
        webDriverThreadLocal.set(webDriver);
    }

    public static WebDriver getWebDriver() {
        return webDriverThreadLocal.get();
    }

    @SneakyThrows
    private static WebDriver createWebDriverInstance() {
        return DriverFactory.getDriver("chrome");
    }
}
