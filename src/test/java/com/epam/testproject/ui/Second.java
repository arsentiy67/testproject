package com.epam.testproject.ui;

import org.testng.annotations.Test;

public class Second extends BaseTest {

    @Test
    public void secondTest() {
        System.out.println("WEB DRIVER " + webDriver);
        webDriver.get("https://github.com/");
    }
}
