package com.epam.testproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    protected WebDriver webDriver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}
