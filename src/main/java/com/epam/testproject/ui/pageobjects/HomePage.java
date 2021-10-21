package com.epam.testproject.ui.pageobjects;

import com.epam.testproject.ui.sections.AnotherSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends AbstractPage {

    private AnotherSection anotherSection;

    protected HomePage(WebDriver driver) {
        super(driver);
        anotherSection = new AnotherSection(driver);
    }

    @FindBy(id = "")
    private WebElement someElement;

    @FindBy(id = "")
    private List<WebElement> someElementsList;

    public void clickSomeElement() {
        someElement.click();
    }

    public void enterTextToSomeElementField() {
        someElement.sendKeys("");
    }

    public String getSomeElementText() {
        return someElement.getText();
    }

    public List<String> getHeaderElementsNames() {
        return someElementsList.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
