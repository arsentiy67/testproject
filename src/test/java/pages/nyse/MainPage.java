package com.hackathon.testproject.pages.nyse;

import com.hackathon.testproject.pages.AbstractPage;
import core.web.iWebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage<MainPage> {

    @FindBy(id = "page-search")
    private iWebElement searchInput;

    @FindBy(id = "onetrust-accept-btn-handler")
    private iWebElement acceptAllCookiesBtn;

    public void search(String searchValue) {
        searchInput.setText(searchValue);
        searchInput.click();
    }

    public void acceptCookies() {
        if (acceptAllCookiesBtn.isDisplayed()) {
            acceptAllCookiesBtn.click();
        }
    }
}
