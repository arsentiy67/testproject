package com.hackathon.testproject.ui;

import com.hackathon.testproject.steps.GoogleSteps;
import org.testng.annotations.Test;

public class GoogleTest extends BaseUITest{

    @Test
    public void test() {
        GoogleSteps.navigateToSite();
    }
}
