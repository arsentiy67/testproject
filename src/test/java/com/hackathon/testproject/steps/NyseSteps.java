package com.hackathon.testproject.steps;

import static com.hackathon.testproject.steps.BaseSteps.driver;

public class NyseSteps  {

    public static void navigateToSite() {
        driver().navigate().to("https://www.nyse.com/");
    }

}
