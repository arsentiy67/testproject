package com.epam.testproject.ui;

import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void firstTest() {
        log.info("WEB DRIVER " + webDriver);
        webDriver.get("https://github.com/");
    }

    @Test
    public void firstTest1() {
        log.info("WEB DRIVER " + webDriver);
        webDriver.get("https://github.com/");
    }

    @Test
    public void firstTest2() {
        log.info("WEB DRIVER " + webDriver);
        webDriver.get("https://github.com/");
    }
}
