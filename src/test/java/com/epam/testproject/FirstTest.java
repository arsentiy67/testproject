package com.epam.testproject;

import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void firstTest() {
        webDriver.get("https://github.com/");
    }
}
