package com.epam.testproject.ui.sections;

import com.epam.testproject.ui.pageobjects.AbstractPageCompositeElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HeaderMenu extends AbstractPageCompositeElement {

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "")
    private WebElement someHeaderElement;

    @FindBy(id = "")
    private List<WebElement> someHeaderElementsList;

    public void clickSomeElement() {
        someHeaderElement.click();
    }

    public void enterTextToSomeElementField() {
        someHeaderElement.sendKeys("");
    }

    public String getSomeElementText() {
        return someHeaderElement.getText();
    }

    public List<String> getHeaderElementsNames() {
        return someHeaderElementsList.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
