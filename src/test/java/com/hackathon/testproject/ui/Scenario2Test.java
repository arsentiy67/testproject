package com.hackathon.testproject.ui;

import com.hackathon.testproject.steps.NyseSteps;
import org.testng.annotations.Test;
//import com.hackathon.testproject.pages.nyse.MainPage;

public class Scenario2Test extends BaseUITest{

//    private MainPage mainPage;

    @Test
    public void test() {
        NyseSteps.navigateToSite();

    }
}
