package com.epam.testproject;

import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    @BeforeClass
    public void initDriver() {
        WebDriverManager.initWebDriver();
    }
}
