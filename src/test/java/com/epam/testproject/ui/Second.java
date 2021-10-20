package com.epam.testproject.ui;

import org.testng.annotations.Test;

public class Second extends BaseTest {

    @Test
    public void secondTest() {
        log.info("WEB DRIVER " + webDriver);
        webDriver.get("https://github.com/");
    }
}
