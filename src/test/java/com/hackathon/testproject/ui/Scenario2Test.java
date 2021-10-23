package com.hackathon.testproject.ui;

import com.hackathon.testproject.site.NyseSite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Scenario2Test extends BaseUITest{

    private NyseSite nyseSite;

    @BeforeClass
    public void beforeClass() {
        nyseSite = new NyseSite(driver());
    }

    @Test
    public void test() {
        driver().navigate().to(NyseSite.URL);
        String searchText = "Epam";
        nyseSite.mainPage.search(searchText);
        nyseSite.mainPage.clickFirstSearchDropDownLink();

    }
}
