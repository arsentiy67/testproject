package ui;

import org.testng.annotations.Test;
import steps.GoogleSteps;

public class GoogleTest extends BaseUITest{

    @Test
    public void test() {
        GoogleSteps.navigateToSite();
    }
}
