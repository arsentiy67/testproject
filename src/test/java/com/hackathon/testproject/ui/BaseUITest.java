package com.hackathon.testproject.ui;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.DriverFactory;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utils.logging.TestListener;
import utils.readers.PropertyReader;

@Listeners(TestListener.class)
public class BaseUITest {

    @BeforeClass(alwaysRun = true)
    protected void readProperties() throws Exception {
        PropertyReader.readProperties();
        DriverFactory.getDriver();
        setRestAssuredToIgnoreUnknownFields();
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown(ITestResult result) {
        if (driver() != null) {
            driver().quit();
        }
    }

    protected WebDriver driver() {
        return DriverFactory.getCurrentDriver();
    }

    private void setRestAssuredToIgnoreUnknownFields() {
        RestAssured.config = RestAssuredConfig.config()
                .objectMapperConfig(new ObjectMapperConfig().jackson2ObjectMapperFactory(
                        (cls, charset) -> {
                            ObjectMapper om = new ObjectMapper().findAndRegisterModules();
                            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                            return om;
                        }
                ));
    }
}
