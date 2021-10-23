package steps;

import core.DriverFactory;
import core.web.iWebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.logging.iLogger;

public class BaseSteps {

    protected static WebDriver driver() {
        return DriverFactory.getCurrentDriver();
    }

    public static String getUrl() {
        return driver().getCurrentUrl();
    }

    public static void refreshPage() {
        iLogger.info("Refresh page {}", getUrl());
        driver().navigate().refresh();
    }

    public static void screenshot() {
        iLogger.takeScreenshot();
    }

    protected static void clickOnText(String elementsText) {
        new iWebElement(driver(), elementsText, String.format("//*[text()='%s']", elementsText))
                .click();
    }

    protected static void validateTextIsPresented(String elementsText) {
        Assert.assertTrue(
                new iWebElement(driver(), elementsText,
                        String.format("//*[contains(text(),'%s')]", elementsText))
                        .isDisplayed(),
                String.format("Element with text %s is not visible", elementsText));
    }
}
