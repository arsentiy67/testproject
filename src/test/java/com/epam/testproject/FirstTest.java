package com.epam.testproject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.logging.VegaLogger;
import utils.properties.SystemProperties;

public class FirstTest extends BaseTest {

    private final WebDriver webDriver = WebDriverManager.getWebDriver();

    @Test
    public void firstTest() {
        VegaLogger.info(SystemProperties.BASE_URL);
        VegaLogger.info(webDriver.getCurrentUrl());
    }
}
