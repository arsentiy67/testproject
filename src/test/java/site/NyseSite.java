package site;

import org.openqa.selenium.WebDriver;
import pages.nyse.MainPage;
import pages.nyse.QuotePage;
import pages.nyse.SearchPage;

public class NyseSite {

    public MainPage mainPage = new MainPage();
    public SearchPage searchPage = new SearchPage();
    public QuotePage quotePage = new QuotePage();

    public static final String URL = "https://www.nyse.com/";

    public NyseSite(WebDriver driver) {
        mainPage.init();
        quotePage.init();
        searchPage.init();
    }
}
