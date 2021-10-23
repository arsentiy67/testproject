package com.hackathon.testproject.site;

import com.hackathon.testproject.pages.nyse.MainPage;
import com.hackathon.testproject.pages.nyse.QuotePage;
import com.hackathon.testproject.pages.nyse.SearchPage;
import org.openqa.selenium.WebDriver;

public class NyseSite {

    public MainPage mainPage = new MainPage();
    public SearchPage searchPage = new SearchPage();
    public QuotePage quotePage = new QuotePage();

    public static final String URL = "https://www.nyse.com/";

    public NyseSite(WebDriver driver) {
        mainPage.init(driver);
        searchPage.init(driver);
        quotePage.init(driver);
    }
}
