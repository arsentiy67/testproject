package ui;

import org.testng.annotations.Test;
import steps.GoogleSteps;

public class Scenario2Test extends BaseUITest{

    @Test
    public void test() {
        GoogleSteps.navigateToSite();
    }
}
