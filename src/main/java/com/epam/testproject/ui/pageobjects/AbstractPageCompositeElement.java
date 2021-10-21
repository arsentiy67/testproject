package com.epam.testproject.ui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageCompositeElement {
    protected WebDriver driver;

    public AbstractPageCompositeElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
