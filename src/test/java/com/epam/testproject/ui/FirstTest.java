package com.epam.testproject.ui;

import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void firstTest() {
        log.info("WEB DRIVER " + webDriver);
        webDriver.get("https://github.com/");
    }
}
