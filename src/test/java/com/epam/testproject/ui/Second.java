package com.epam.testproject.ui;

import org.testng.annotations.Test;

public class Second extends BaseTest {

    @Test
    public void secondTest() {
        log.info("WEB DRIVER " + webDriver);
        webDriver.get("https://github.com/");
    }

    @Test
    public void secondTest1() {
        log.info("WEB DRIVER " + webDriver);
        webDriver.get("https://github.com/");
    }

    @Test
    public void secondTest2() {
        log.info("WEB DRIVER " + webDriver);
        webDriver.get("https://github.com/");
    }
}
