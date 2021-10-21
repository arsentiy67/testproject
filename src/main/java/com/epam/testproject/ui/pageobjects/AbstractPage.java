package com.epam.testproject.ui.pageobjects;

import com.epam.testproject.ui.sections.HeaderMenu;
import org.openqa.selenium.WebDriver;

public class AbstractPage extends AbstractPageCompositeElement {
    protected HeaderMenu headerMenu;

    protected AbstractPage(WebDriver driver) {
        super(driver);
        headerMenu = new HeaderMenu(driver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }
}
